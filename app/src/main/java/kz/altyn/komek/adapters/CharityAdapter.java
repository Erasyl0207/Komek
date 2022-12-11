package kz.altyn.komek.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import kz.altyn.komek.R;
import kz.altyn.komek.models.Charity;
import kz.altyn.komek.models.Package;
import kz.altyn.komek.ui.activities.DonateMoney;
import kz.altyn.komek.ui.activities.DonatePackage;
import kz.altyn.komek.ui.activities.NewDonorReg;

public class CharityAdapter extends RecyclerView.Adapter<CharityViewHolder> {

    List<Charity> charities;
    Package aPackage;

    public CharityAdapter(List<Charity> charities, Package aPackage) {
        this.charities = charities;
        this.aPackage = aPackage;
    }

    @NonNull
    @Override
    public CharityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_charity, parent, false);
        return new CharityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharityViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        holder.title.setText(charities.get(position).getTitle());
        holder.address.setText(charities.get(position).getAddress());
        holder.yearOfFoundation.setText(charities.get(position).getYearOfFoundation());
        Glide.with(context)
                .setDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_flat))
                .load(charities.get(position).getLogo())
                .into(holder.logo);

        holder.itemView.setOnClickListener(view -> {
            //if (!isAuthenticated()) {
            //    unregisteredUser(context);
            //}
            Intent intent;
            if (aPackage != null) {
                intent = new Intent(context, DonatePackage.class);
                intent.putExtra("donateP", aPackage);
                intent.putExtra("1222", charities.get(position));
            } else {
                intent = new Intent(context, DonateMoney.class);
                intent.putExtra("charity", charities.get(position));
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });


    }

    private void unregisteredUser(Context context) {
        new MaterialDialog.Builder(context)
                .title("You are not registered as a Donor")
                .content("Become a Donor to Donate?")
                .positiveText("Yes")
                .negativeText("No")
                .canceledOnTouchOutside(false)
                .cancelable(false)
                .onPositive((dialog, which) -> context.startActivity(new Intent(context, NewDonorReg.class)))
                .onNegative((dialog1, which) -> {
                })
                .build().show();
    }

    @Override
    public int getItemCount() {
        return charities.size();
    }
}
