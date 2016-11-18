package com.solutions.jpd.apps.hackedornot.model;

/**
 * Created by Josermando Peralta on 10/26/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HackedList {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("data")
    @Expose
    private ArrayList<HackedSource> data = new ArrayList<HackedSource>();


    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The query
     */
    public String getQuery() {
        return query;
    }

    /**
     *
     * @param query
     * The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     *
     * @return
     * The results
     */
    public Integer getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(Integer results) {
        this.results = results;
    }

    /**
     *
     * @return
     * The data
     */
    public List<HackedSource> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(ArrayList<HackedSource> data) {
        this.data = data;
    }

}