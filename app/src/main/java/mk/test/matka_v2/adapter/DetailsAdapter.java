package mk.test.matka_v2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mk.test.matka_v2.R;
import mk.test.matka_v2.interfaces.ImageClickInterface;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {

    private ArrayList<String> exponentImages = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;
    private ImageClickInterface detailsClickInterface;

    public DetailsAdapter(Context context, ArrayList<String> exponentImages, ImageClickInterface detailsClickInterface){
        this.context = context;
        this.exponentImages = exponentImages;
        this.inflater = LayoutInflater.from(context);
        this.detailsClickInterface = detailsClickInterface;
    }


    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_image, parent, false);
        return new DetailsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        String image = exponentImages.get(position);

        int resID = context.getResources().getIdentifier(image , "drawable", context.getPackageName());
        holder.exponentImage.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return exponentImages.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder{
        ImageView exponentImage;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            exponentImage = itemView.findViewById(R.id.history_image);

            exponentImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (detailsClickInterface != null){
                        detailsClickInterface.onImageClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
