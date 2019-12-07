package mk.test.matka_v2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import mk.test.matka_v2.R;

public class WebViewActivity extends AppCompatActivity {
    public static final String URL_KEY = "URL_KEY";

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient());

        String url = getIntent().getStringExtra(URL_KEY);
        if (url != null){
            webView.loadUrl(url);
        }
    }
}
