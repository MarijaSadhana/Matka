package mk.test.matka_v2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import mk.test.matka_v2.R;
import mk.test.matka_v2.activity.ExhibitionActivity;

public class MainActivity extends AppCompatActivity {

    VideoView splashVideo;
    Button continueButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashVideo = findViewById(R.id.splashVideo);
        continueButton = findViewById(R.id.splashButtonContinue);

        splashVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                splashVideo.start();
            }
        });
        splashVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0,0);
            }
        });
        String path = "android.resource://" + getPackageName() + "/" + R.raw.splash;
        splashVideo.setVideoURI(Uri.parse(path));
        splashVideo.start();
    }

    public void onContinueClick(View view) {
        Intent intent = new Intent(this, ExhibitionActivity.class);
        startActivity(intent);
        finish();
    }
}
