package mk.test.matka_v2.fragment;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import mk.test.matka_v2.R;
import mk.test.matka_v2.adapter.VideosAdapter;
import mk.test.matka_v2.interfaces.VideoClickInterface;
import mk.test.matka_v2.model.Exponent;
import mk.test.matka_v2.model.ExponentResponse;
import mk.test.matka_v2.model.Video;
import mk.test.matka_v2.model.VideosResponse;

public class VideosFragment extends Fragment implements VideoClickInterface {
    public static final String TAG = VideosFragment.class.getSimpleName();

    private RecyclerView videosRecyclerView;
    private VideosAdapter adapter;
    private ImageView videosCover;
    private ArrayList<Video> videos = new ArrayList<>();

    Gson gson;

    public VideosFragment(){}

    public static VideosFragment newInstance(){
        return new VideosFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        videosRecyclerView = view.findViewById(R.id.videos_recycler_view);
        videosCover = view.findViewById(R.id.videos_cover);

        gson = new Gson();


        videosCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoId = "qwkQVShCklw";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
                intent.putExtra("VIDEO_ID", videoId);
                intent.putExtra("force_fullscreen",true);
                startActivity(intent);
            }
        });
        generateVideos();

        adapter = new VideosAdapter(getActivity(), videos, this);
        videosRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2,
                GridLayoutManager.HORIZONTAL, false));
        videosRecyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos, container, false);
    }
    private void generateVideos() {
        String json = loadJSONFromAsset();

        VideosResponse videosResponse = gson.fromJson(json, VideosResponse.class);
        videos = videosResponse.getVideos();
    }

    @Override
    public void onVideoClick(int position) {
        String videoId = videos.get(position).getVideo_id();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
        intent.putExtra("VIDEO_ID", videoId);
        //intent.putExtra("force_fullscreen",true);
        startActivity(intent);
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getActivity().getAssets().open("videosJson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
