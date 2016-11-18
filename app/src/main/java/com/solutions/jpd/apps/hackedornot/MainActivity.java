package com.solutions.jpd.apps.hackedornot;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;
import com.solutions.jpd.apps.hackedornot.adapter.MyHackedDataAdapter;
import com.solutions.jpd.apps.hackedornot.model.HackedList;
import com.solutions.jpd.apps.hackedornot.model.HackedSource;
import com.solutions.jpd.apps.hackedornot.retrofit.endpoint.ApiService;
import com.solutions.jpd.apps.hackedornot.util.CheckNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private LinearLayout emptyView;
    private List<HackedSource> dataSource;
    private MyHackedDataAdapter adapter;
    public NativeExpressAdView adview;
    private InterstitialAd mInterstitialAd;
    private static Bundle mBundleRecyclerViewState;
    private final String KEY_RECYCLER_STATE = "recycler_state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        Log.d(TAG, "after call.enqueue: ");
        loadNativeAdView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(!CheckNetwork.isInternetAvailable(this)) {
            Toast.makeText(this, R.string.no_connection, Toast.LENGTH_SHORT).show();
        }
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6482688051062241/2073544015");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }
        });
        requestInterstitial();

    }

    private void requestInterstitial(){
        AdRequest interstitialAdRequest = new AdRequest.Builder().addTestDevice("E3E4253CB2F3CB3CC2E697C997236F0E").build();
        mInterstitialAd.loadAd(interstitialAdRequest);
    }

    private void loadNativeAdView(){
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("E3E4253CB2F3CB3CC2E697C997236F0E")
                .build();
        adview.loadAd(adRequest);
    }

    private void initViews(){
        emptyView = (LinearLayout) findViewById(R.id.empty_view);
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adview = (NativeExpressAdView) findViewById(R.id.native_adview);
        loadJSON(getIntentData());
    }

    private void loadJSON(String param){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(getString(R.string.base_url)).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService request = retrofit.create(ApiService.class);
        Call<HackedList> call = request.getMyJSON(param);
        call.enqueue(new Callback<HackedList>() {
            @Override
            public void onResponse(Call<HackedList> call, Response<HackedList> response) {

                HackedList jsonResponse = response.body();
                Log.d(TAG, "onResponse: ");
                if(jsonResponse.getStatus().equalsIgnoreCase("found")){
                    dataSource = jsonResponse.getData();
                    adapter = new MyHackedDataAdapter(dataSource);
                    recyclerView.setAdapter(adapter);
                }
                else{
                    recyclerView.setVisibility(RecyclerView.GONE);
                    emptyView.setVisibility(RecyclerView.VISIBLE);
                    adview.setVisibility(RecyclerView.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<HackedList> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    private String getIntentData(){
        Intent intent = getIntent();
        String emailParam = intent.getStringExtra("EMAIL");
        return emailParam;
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        // save RecyclerView state
        mBundleRecyclerViewState = new Bundle();
        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(KEY_RECYCLER_STATE, listState);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        // restore RecyclerView state
        if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
        }
    }


}
