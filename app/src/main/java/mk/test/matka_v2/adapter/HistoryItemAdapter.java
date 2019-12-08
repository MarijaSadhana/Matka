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
import mk.test.matka_v2.model.ImageItem;

public class HistoryItemAdapter extends RecyclerView.Adapter<HistoryItemAdapter.HistoryImageViewHolder> {

    private ArrayList<ImageItem> images;
    private LayoutInflater inflater;
    private ImageClickInterface historyClick;
    private Context context;

    public HistoryItemAdapter(Context context, ArrayList<ImageItem> images, ImageClickInterface historyClick){
        this.context = context;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
        this.historyClick = historyClick;
    }

    @NonNull
    @Override
    public HistoryImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_image, parent, false);
        return new HistoryImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryImageViewHolder holder, int position) {
        ImageItem image = images.get(position);
        holder.historyImage.setImageResource(image.getImage());
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class HistoryImageViewHolder extends RecyclerView.ViewHolder{
        ImageView historyImage;

        public HistoryImageViewHolder(@NonNull View itemView) {
            super(itemView);
            historyImage = itemView.findViewById(R.id.history_image);

            historyImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (historyClick != null){
                        historyClick.onImageClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
