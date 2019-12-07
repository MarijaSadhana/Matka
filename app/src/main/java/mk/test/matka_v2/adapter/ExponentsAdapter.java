package mk.test.matka_v2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mk.test.matka_v2.R;
import mk.test.matka_v2.interfaces.ExponentClickInterface;
import mk.test.matka_v2.model.Exponent;

public class ExponentsAdapter extends RecyclerView.Adapter<ExponentsAdapter.ExponentsViewHolder> {

    private ArrayList<Exponent> exponents;
    private LayoutInflater inflater;
    private ExponentClickInterface exponentClick;
    private Context context;

    public ExponentsAdapter(Context context, ArrayList<Exponent> exponents, ExponentClickInterface exponentClick){
        this.context = context;
        this.exponents = exponents;
        this.inflater = LayoutInflater.from(context);
        this.exponentClick = exponentClick;
    }

    @NonNull
    @Override
    public ExponentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.exponent_item, parent, false);
        return new ExponentsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExponentsViewHolder holder, int position) {
        Exponent exponent = exponents.get(position);

        holder.exponentTitle.setText(exponent.getTitle());

        int imageId = context.getResources().getIdentifier(exponent.getImages().get(0),"drawable", context.getPackageName());
        holder.exponentCover.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return exponents.size();
    }

    public class ExponentsViewHolder extends RecyclerView.ViewHolder{
        ImageView exponentCover;
        TextView exponentTitle;

        public ExponentsViewHolder(@NonNull View itemView) {
            super(itemView);

            exponentCover = itemView.findViewById(R.id.exponent_cover);
            exponentTitle = itemView.findViewById(R.id.exponent_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (exponentClick != null){
                        exponentClick.onExponentClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}