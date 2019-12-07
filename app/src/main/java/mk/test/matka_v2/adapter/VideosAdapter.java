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
import mk.test.matka_v2.interfaces.VideoClickInterface;
import mk.test.matka_v2.model.Exponent;
import mk.test.matka_v2.model.Video;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideosViewHolder> {

    private ArrayList<Video> videos;
    private LayoutInflater inflater;
    private VideoClickInterface videoClick;
    private Context context;

    public VideosAdapter(Context context, ArrayList<Video> videos, VideoClickInterface videoClick){
        this.context = context;
        this.videos = videos;
        this.inflater = LayoutInflater.from(context);
        this.videoClick = videoClick;
    }

    @NonNull
    @Override
    public VideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.video_item, parent, false);
        return new VideosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VideosViewHolder holder, int position) {
        Video video = videos.get(position);

        holder.exponentTitle.setText(video.getTitle());

        int resID = context.getResources().getIdentifier(video.getCover() , "drawable", context.getPackageName());
        holder.exponentCover.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class VideosViewHolder extends RecyclerView.ViewHolder{
        ImageView exponentCover;
        TextView exponentTitle;

        public VideosViewHolder(@NonNull View itemView) {
            super(itemView);

            exponentCover = itemView.findViewById(R.id.exponent_cover);
            exponentTitle = itemView.findViewById(R.id.exponent_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (videoClick != null){
                        videoClick.onVideoClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
