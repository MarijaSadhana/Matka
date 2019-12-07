package mk.test.matka_v2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stfalcon.imageviewer.StfalconImageViewer;
import com.stfalcon.imageviewer.loader.ImageLoader;

import java.util.ArrayList;

import mk.test.matka_v2.R;
import mk.test.matka_v2.adapter.DetailsAdapter;
import mk.test.matka_v2.adapter.HistoryItemAdapter;
import mk.test.matka_v2.interfaces.HistoryClickInterface;
import mk.test.matka_v2.model.Exponent;
import mk.test.matka_v2.model.HistoryImage;

public class DetailsActivity extends AppCompatActivity implements HistoryClickInterface {

    private ImageView detailsCover;
    private RecyclerView detailsRecyclerView;
    private Exponent exponent;
    private DetailsAdapter adapter;
    private TextView exponentTitle, exponentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailsCover = findViewById(R.id.details_cover);
        detailsRecyclerView = findViewById(R.id.detailsRecyclerView);
        exponentTitle = findViewById(R.id.exponent_title);
        exponentDetails = findViewById(R.id.exponent_details);

        exponent = getIntent().getParcelableExtra("Exponent");
        detailsRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        String mDrawableName = exponent.getImages().get(0);
        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        detailsCover.setImageResource(resID);

        exponentTitle.setText(exponent.getTitle());
        exponentDetails.setText(exponent.getContent());

        adapter = new DetailsAdapter(this, exponent.getImages(),this);
        detailsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onImageClick(int position) {
        new StfalconImageViewer.Builder<>(this, exponent.getImages(), new ImageLoader<String>() {
            @Override
            public void loadImage(ImageView imageView, String drawableRes) {
                int resID = getResources().getIdentifier(drawableRes , "drawable", getPackageName());
                imageView.setImageResource(resID);
                imageView.setBackgroundColor(getResources().getColor(R.color.color_black_matka));
            }
        }).withStartPosition(position)
                .withImageMarginPixels(30)
                .show();
    }

    public void onBackClick(View view) {
        finish();
    }
}