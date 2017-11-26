package com.example.sumitra.rssdetailreader;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class DetailedView extends AppCompatActivity {

    private TextView feedTitle=null;
    private TextView feedDate=null;
    private TextView feedDesc=null;
    Button showMore=null;
    RssFeedModel data=null;
    Intent intent=null;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        feedTitle= (TextView) findViewById(R.id.feedDetailedtitle);
        feedDate= (TextView) findViewById(R.id.feedDetailedDate);
        feedDesc= (TextView) findViewById(R.id.feedDetailedDescription);
        showMore= (Button) findViewById(R.id.SeeMore);

        //get data
        intent=getIntent();
        data= (RssFeedModel) getIntent().getExtras().getSerializable("FeedData");

        //match data
        feedTitle.setText(data.title);
        feedDesc.setText(data.description);
        feedDate.setText(getDate());

        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailedView.this,FeedWebView.class));
            }
        });

    }
    //get today's date
 @RequiresApi(api = Build.VERSION_CODES.N)
 public String getDate()
 {
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
     String currentDateandTime = sdf.format(new Date());
     return currentDateandTime;
 }


}
