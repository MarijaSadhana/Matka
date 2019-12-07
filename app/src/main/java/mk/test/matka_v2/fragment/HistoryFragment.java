package mk.test.matka_v2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stfalcon.imageviewer.StfalconImageViewer;
import com.stfalcon.imageviewer.loader.ImageLoader;

import java.util.ArrayList;

import mk.test.matka_v2.R;
import mk.test.matka_v2.adapter.HistoryItemAdapter;
import mk.test.matka_v2.interfaces.HistoryClickInterface;
import mk.test.matka_v2.model.HistoryImage;

public class HistoryFragment extends Fragment implements HistoryClickInterface {
    public static final String TAG = HistoryFragment.class.getSimpleName();

    private ArrayList<HistoryImage> images = new ArrayList<>();
    private RecyclerView imagesRecyclerView;
    private HistoryItemAdapter adapter;

    private ImageView historyCover;

    public HistoryFragment(){}

    public static HistoryFragment newInstance(){
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        historyCover = view.findViewById(R.id.history_cover);

        imagesRecyclerView = view.findViewById(R.id.historyRecyclerView);
        loadImages();
        adapter = new HistoryItemAdapter(getActivity(), images, this);
        imagesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        imagesRecyclerView.setAdapter(adapter);

        historyCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] RESOURCES = new Integer[]{R.drawable.history_cover};

                new StfalconImageViewer.Builder<>(getActivity(), RESOURCES, new ImageLoader<Integer>() {
                    @Override
                    public void loadImage(ImageView imageView, Integer drawableRes) {
                        imageView.setImageResource(drawableRes);
                        imageView.setBackgroundColor(getResources().getColor(R.color.color_black_matka));
                    }
                }).show();
            }
        });
    }

    @Override
    public void onImageClick(int position) {
        new StfalconImageViewer.Builder<>(getActivity(), images, new ImageLoader<HistoryImage>() {
            @Override
            public void loadImage(ImageView imageView, HistoryImage drawableRes) {
                imageView.setImageResource(drawableRes.getImage());
                imageView.setBackgroundColor(getResources().getColor(R.color.color_black_matka));
            }
        }).withStartPosition(position)
                .withImageMarginPixels(30)
                .show();
    }

    private void loadImages(){

        HistoryImage hi1 = new HistoryImage(R.drawable.history_rv1);
        HistoryImage hi2 = new HistoryImage(R.drawable.history_rv2);
        HistoryImage hi3 = new HistoryImage(R.drawable.history_rv3);
        HistoryImage hi4 = new HistoryImage(R.drawable.history_rv4);
        HistoryImage hi5 = new HistoryImage(R.drawable.history_cover);

        images.add(hi1);
        images.add(hi2);
        images.add(hi3);
        images.add(hi4);
        images.add(hi5);
    }
}
