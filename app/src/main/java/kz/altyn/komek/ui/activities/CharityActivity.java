package kz.altyn.komek.ui.activities;import android.os.Bundle;import android.view.MenuItem;import android.widget.TextView;import android.widget.Toast;import androidx.annotation.NonNull;import androidx.annotation.Nullable;import androidx.appcompat.app.AppCompatActivity;import androidx.appcompat.widget.Toolbar;import androidx.recyclerview.widget.LinearLayoutManager;import androidx.recyclerview.widget.RecyclerView;import kz.altyn.komek.R;import kz.altyn.komek.adapters.DonationAdapter;import kz.altyn.komek.models.Charity;import kz.altyn.komek.models.Donation;import com.bumptech.glide.Glide;import com.bumptech.glide.request.RequestOptions;import com.google.firebase.auth.FirebaseAuth;import com.google.firebase.database.ChildEventListener;import com.google.firebase.database.DataSnapshot;import com.google.firebase.database.DatabaseError;import com.google.firebase.database.FirebaseDatabase;import java.util.ArrayList;import java.util.List;import java.util.Objects;import de.hdodenhof.circleimageview.CircleImageView;public class CharityActivity extends AppCompatActivity {    private Charity charity;    private List<Donation> donationList = new ArrayList<>();    private TextView nameTv;    private TextView addressTv;    private TextView numberTv;    private TextView summeryTv;    private TextView dateTv;    private RecyclerView recyclerView;    private LinearLayoutManager layoutManager;    private DonationAdapter donationAdapter;    private CircleImageView logo;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_charity);        initUi();//        CardView donate = findViewById(R.id.cardView3);        FirebaseDatabase.getInstance().getReference().child("Charities").orderByKey().equalTo(FirebaseAuth.getInstance().getUid()).addChildEventListener(new ChildEventListener() {            @Override            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {                charity = snapshot.getValue(Charity.class);                try {                    nameTv.setText(charity.getTitle());                    addressTv.setText(charity.getAddress());                    summeryTv.setText(charity.getDescription());                    dateTv.setText(charity.getYearOfFoundation());                    Glide.with(getApplicationContext())                            .setDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_flat))                            .load(charity.getLogo())                            .into(logo);                } catch (NullPointerException j) {                    Toast.makeText(CharityActivity.this, "Null", Toast.LENGTH_SHORT).show();                }            }            @Override            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {            }            @Override            public void onChildRemoved(@NonNull DataSnapshot snapshot) {            }            @Override            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {            }            @Override            public void onCancelled(@NonNull DatabaseError error) {            }        });        recyclerView = findViewById(R.id.recyclerView2);        layoutManager = new LinearLayoutManager(getApplicationContext());        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));        recyclerView.setLayoutManager(layoutManager);        recyclerView.setHasFixedSize(true);        FirebaseDatabase.getInstance().getReference().child("Charities").child(FirebaseAuth.getInstance().getUid()).child("Donations").addChildEventListener(new ChildEventListener() {            @Override            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {                Donation don = snapshot.getValue(Donation.class);                donationList.add(don);                donationAdapter = new DonationAdapter(donationList, getApplicationContext());                recyclerView.setAdapter(donationAdapter);                donationAdapter.notifyDataSetChanged();            }            @Override            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {            }            @Override            public void onChildRemoved(@NonNull DataSnapshot snapshot) {            }            @Override            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {            }            @Override            public void onCancelled(@NonNull DatabaseError error) {            }        });    }    private void initUi() {        Toolbar toolbar = findViewById(R.id.toolbar);        setSupportActionBar(toolbar);        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);        getSupportActionBar().setDisplayShowHomeEnabled(true);        nameTv = findViewById(R.id.title_charity_money);        addressTv = findViewById(R.id.address_money);        summeryTv = findViewById(R.id.description_money);        dateTv = findViewById(R.id.year_of_foundation_money);        numberTv = findViewById(R.id.addressCha4);        logo = findViewById(R.id.textView6);    }    @Override    public boolean onOptionsItemSelected(MenuItem item) {        switch (item.getItemId()) {            case android.R.id.home:                onBackPressed();                return true;        }        return super.onOptionsItemSelected(item);    }}