package com.example.sumitra.rssdetailreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import static com.example.sumitra.rssdetailreader.MainActivity.url;

public class FeedWebView extends AppCompatActivity {

    WebView myWebView;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_web_view);

        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl(url.toString());

        webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
