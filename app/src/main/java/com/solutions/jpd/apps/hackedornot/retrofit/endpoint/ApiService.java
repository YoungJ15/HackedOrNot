package com.solutions.jpd.apps.hackedornot.retrofit.endpoint;

import com.solutions.jpd.apps.hackedornot.model.HackedList;
import com.solutions.jpd.apps.hackedornot.retrofit.json.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Josermando Peralta on 10/26/2016.
 */
public interface ApiService {
    @GET("/api?")
    Call<HackedList> getMyJSON(@Query("q") String email);
}
