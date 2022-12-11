package kz.altyn.komek.ui.activities;import android.annotation.SuppressLint;import android.app.ProgressDialog;import android.os.Bundle;import android.text.Editable;import android.text.TextWatcher;import android.view.MenuItem;import android.widget.EditText;import android.widget.ImageView;import android.widget.TextView;import android.widget.Toast;import androidx.appcompat.app.AppCompatActivity;import androidx.cardview.widget.CardView;import androidx.recyclerview.widget.LinearLayoutManager;import androidx.recyclerview.widget.RecyclerView;import kz.altyn.komek.R;import kz.altyn.komek.adapters.ProductAdapter;import kz.altyn.komek.models.Charity;import kz.altyn.komek.models.Package;import kz.altyn.komek.models.Product;import com.bumptech.glide.Glide;import com.bumptech.glide.request.RequestOptions;import java.util.List;public class DonatePackage extends AppCompatActivity {    static TextView TotalPackageTV;    static TextView desTv;    static TextView priceTv;    static Package packages;    static int pacC = 1;    List<Product> productList;    TextView nameTV;    ImageView logo;    ImageView logo22;    CardView donate;    Charity charity;    EditText pacCount;    TextView titleCharityTextView;    TextView addressTextView;    TextView numberTextView;    TextView descriptionTextView;    TextView yearOfFoundationTextView;    ProgressDialog mDialog;    private RecyclerView recyclerView;    private RecyclerView.LayoutManager layoutManager;    private ProductAdapter productAdapter;    @SuppressLint("SetTextI18n")    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_donate_package);        initUi();        initPackage();        productList = packages.getProductList();        //final SqlDonor sqlDonor = new SqlDonor(getApplicationContext());        donate.setOnClickListener(view -> {            mDialog.show();            //Cursor rs = null;            String donorName = "", donorNum = "", donorAddress = "";            try {                //rs = sqlDonor.getData(1);                //rs.moveToFirst();                //donorName = rs.getString(rs.getColumnIndex(SqlDonor.CONTACTS_COLUMN_NAME));                //donorNum = rs.getString(rs.getColumnIndex(SqlDonor.CONTACTS_COLUMN_NUMBER));                //donorAddress = rs.getString(rs.getColumnIndex(SqlDonor.CONTACTS_COLUMN_ADDRESS));            } catch (RuntimeException g) {            }            if (!(pacC == 0)) {                //startBkashPayment(donorNum, charity.getNumber(), 0, charity.getId(), donorName, donorAddress);            } else {                Toast.makeText(DonatePackage.this, "Enter how many...", Toast.LENGTH_SHORT).show();                mDialog.dismiss();            }        });        nameTV.setText(packages.getName());        logo.setImageResource(packages.getLogo());        desTv.setText(packages.getShortDes());        priceTv.setText("Kómek qorabynyń baǵasy: KZT " + packages.getTotalPrice());        pacCount.setText("1");        TotalPackageTV.setText("Tolyq sýmma: KZT " + pacC * packages.getTotalPrice());        titleCharityTextView.setText(charity.getTitle());        Glide.with(getApplicationContext()).setDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_flat)).load(charity.getLogo()).into(logo22);        addressTextView.setText(charity.getAddress());        yearOfFoundationTextView.setText(charity.getYearOfFoundation());        for (int i = 0; i < productList.size(); i++) {            productAdapter = new ProductAdapter(productList, getApplicationContext());            recyclerView.setAdapter(productAdapter);            productAdapter.notifyDataSetChanged();        }        pacCount.addTextChangedListener(new TextWatcher() {            public void onTextChanged(CharSequence s, int start, int before, int count) {                //do your work here                try {                    if (Integer.parseInt(s.toString()) < 0) {                        Toast.makeText(DonatePackage.this, "Can't input negative value", Toast.LENGTH_SHORT).show();                    } else {                        pacC = Integer.parseInt(s.toString());                        TotalPackageTV.setText("Tolyq sýmma: KZT " + pacC * packages.getTotalPrice());                    }                } catch (Exception uh) {                }            }            public void beforeTextChanged(CharSequence s, int start, int count, int after) {            }            public void afterTextChanged(Editable s) {            }        });    }    private void initUi() {        nameTV = findViewById(R.id.title_charity_money);        desTv = findViewById(R.id.description_money);        priceTv = findViewById(R.id.money500);        logo = findViewById(R.id.textView6);        donate = findViewById(R.id.donate_money);        recyclerView = findViewById(R.id.recyclerView2);        mDialog = new ProgressDialog(this);        mDialog.setMessage("Please wait..");        mDialog.setIndeterminate(true);        mDialog.setCancelable(false);        mDialog.setCanceledOnTouchOutside(false);        logo22 = findViewById(R.id.textView19);        titleCharityTextView = findViewById(R.id.title_charity_donate);        addressTextView = findViewById(R.id.address_charity_donate);        yearOfFoundationTextView = findViewById(R.id.year_of_foundation_charity_donate);    }    private void initPackage() {        layoutManager = new LinearLayoutManager(getApplicationContext());        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));        recyclerView.setLayoutManager(layoutManager);        recyclerView.setHasFixedSize(true);        packages = (Package) getIntent().getSerializableExtra("donateP");        TotalPackageTV = findViewById(R.id.money);        pacCount = findViewById(R.id.age_name);        charity = (Charity) getIntent().getSerializableExtra("1222");    }    @SuppressLint("SetTextI18n")    public static void updatePackage(Product product, int position) {        packages.getProductList().set(position, product);        StringBuilder des = new StringBuilder();        for (int i = 0; i < 4; i++) {            des.append(packages.getProductList().get(i).getName())                    .append(" ").append(packages.getProductList().get(i).getQuantity()).append(" ")                    .append(packages.getProductList().get(i).getUnit())                    .append(", ");        }        packages.setShortDes(des.toString());        priceTv.setText("Kómek qorabynyń baǵasy: KZT " + packages.getTotalPrice());        desTv.setText(packages.getShortDes());        if (pacC != 0) {            TotalPackageTV.setText("Tolyq sýmma: KZT " + pacC * packages.getTotalPrice());        }    }    @Override    public boolean onOptionsItemSelected(MenuItem item) {        switch (item.getItemId()) {            case android.R.id.home:                onBackPressed();                return true;        }        return super.onOptionsItemSelected(item);    }    @Override    protected void onResume() {        super.onResume();        productList = packages.getProductList();        for (int i = 0; i < productList.size(); i++) {            productAdapter = new ProductAdapter(productList, getApplicationContext());            recyclerView.setAdapter(productAdapter);            productAdapter.notifyDataSetChanged();        }    }}