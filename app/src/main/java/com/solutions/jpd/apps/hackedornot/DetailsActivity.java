package com.solutions.jpd.apps.hackedornot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.solutions.jpd.apps.hackedornot.model.HackedSource;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private TextView titleTV, authorTV, verifiedTV, dateCreatedTV, dateLeakedTV, emailsCountTV, detailsTV, sourceURLTV, sourceLinesTV, sourceSizeTV, networkTV, providerTV;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        initViews();
        intent = getIntent();
        getIntentData(intent.getStringExtra("POSITION"));
    }

    protected void getIntentData(String position){

        List<HackedSource> source = (List<HackedSource>) intent.getSerializableExtra("HACKED_LIST");
        titleTV.setText(source.get(Integer.parseInt(position)).getTitle());
        authorTV.setText(source.get(Integer.parseInt(position)).getAuthor());
        verifiedTV.setText(source.get(Integer.parseInt(position)).getIsVrf().toString());
        dateCreatedTV.setText(source.get(Integer.parseInt(position)).getDateCreated());
        dateLeakedTV.setText(source.get(Integer.parseInt(position)).getDateLeaked());
        emailsCountTV.setText(source.get(Integer.parseInt(position)).getEmailsCount().toString());
        detailsTV.setText(source.get(Integer.parseInt(position)).getDetails());
        sourceURLTV.setText(source.get(Integer.parseInt(position)).getSourceUrl());
        sourceLinesTV.setText(source.get(Integer.parseInt(position)).getSourceLines().toString());
        sourceSizeTV.setText(source.get(Integer.parseInt(position)).getSourceSize().toString());
        networkTV.setText(source.get(Integer.parseInt(position)).getSourceNetwork());
        providerTV.setText(source.get(Integer.parseInt(position)).getSourceProvider());
    }

    private void initViews(){
        titleTV = (TextView) findViewById(R.id.title);
        authorTV = (TextView) findViewById(R.id.author);
        verifiedTV = (TextView) findViewById(R.id.verified);
        dateCreatedTV = (TextView) findViewById(R.id.created);
        dateLeakedTV = (TextView) findViewById(R.id.leaked);
        emailsCountTV = (TextView) findViewById(R.id.emails);
        detailsTV = (TextView) findViewById(R.id.details);
        sourceURLTV = (TextView) findViewById(R.id.url);
        sourceLinesTV = (TextView) findViewById(R.id.lines);
        sourceSizeTV = (TextView) findViewById(R.id.size);
        networkTV = (TextView) findViewById(R.id.network);
        providerTV = (TextView) findViewById(R.id.provider);
    }

}
