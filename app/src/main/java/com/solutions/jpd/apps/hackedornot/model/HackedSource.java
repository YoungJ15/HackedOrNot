package com.solutions.jpd.apps.hackedornot.model;

/**
 * Created by Josermando Peralta on 10/26/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HackedSource implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("verified")
    @Expose
    private Boolean isVrf;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_leaked")
    @Expose
    private String dateLeaked;
    @SerializedName("emails_count")
    @Expose
    private Integer emailsCount;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("source_url")
    @Expose
    private String sourceUrl;
    @SerializedName("source_lines")
    @Expose
    private Integer sourceLines;
    @SerializedName("source_size")
    @Expose
    private Long sourceSize;
    @SerializedName("source_network")
    @Expose
    private String sourceNetwork;
    @SerializedName("source_provider")
    @Expose
    private String sourceProvider;

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The isVrf
     */
    public Boolean getIsVrf() {
        return isVrf;
    }

    /**
     *
     * @param isVrf
     * The is_vrf
     */
    public void setIsVrf(Boolean isVrf) {
        this.isVrf = isVrf;
    }

    /**
     *
     * @return
     * The dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     *
     * @param dateCreated
     * The date_created
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     *
     * @return
     * The dateLeaked
     */
    public String getDateLeaked() {
        return dateLeaked;
    }

    /**
     *
     * @param dateLeaked
     * The date_leaked
     */
    public void setDateLeaked(String dateLeaked) {
        this.dateLeaked = dateLeaked;
    }

    /**
     *
     * @return
     * The emailsCount
     */
    public Integer getEmailsCount() {
        return emailsCount;
    }

    /**
     *
     * @param emailsCount
     * The emails_count
     */
    public void setEmailsCount(Integer emailsCount) {
        this.emailsCount = emailsCount;
    }

    /**
     *
     * @return
     * The details
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * @param details
     * The details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     *
     * @return
     * The sourceUrl
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     *
     * @param sourceUrl
     * The source_url
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    /**
     *
     * @return
     * The sourceLines
     */
    public Integer getSourceLines() {
        return sourceLines;
    }

    /**
     *
     * @param sourceLines
     * The source_lines
     */
    public void setSourceLines(Integer sourceLines) {
        this.sourceLines = sourceLines;
    }

    /**
     *
     * @return
     * The sourceSize
     */
    public Long getSourceSize() {
        return sourceSize;
    }

    /**
     *
     * @param sourceSize
     * The source_size
     */
    public void setSourceSize(Long sourceSize) {
        this.sourceSize = sourceSize;
    }

    /**
     *
     * @return
     * The sourceNetwork
     */
    public String getSourceNetwork() {
        return sourceNetwork;
    }

    /**
     *
     * @param sourceNetwork
     * The source_network
     */
    public void setSourceNetwork(String sourceNetwork) {
        this.sourceNetwork = sourceNetwork;
    }

    /**
     *
     * @return
     * The sourceProvider
     */
    public String getSourceProvider() {
        return sourceProvider;
    }

    /**
     *
     * @param sourceProvider
     * The source_provider
     */
    public void setSourceProvider(String sourceProvider) {
        this.sourceProvider = sourceProvider;
    }

}

