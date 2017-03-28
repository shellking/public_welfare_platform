package com.ym.PWP.module.model.bean;

import java.io.Serializable;

/**
 * Created by Shellking on 2017/3/26.
 */

public class EventInfo implements Serializable {

    private String eventname;//活动名称
    private String type;//活动类型
    private String Tag;//标签
    private String dealine;//截止时间
    private String releasetime;//发布时间
    private String location;//地点
    private String summery;//概述
    private int ceiling;//报名人数上限
    private String releaser;//发布者（昵称）
    private String adpicture;//海报

    public String getAdpicture() {
        return adpicture;
    }

    public void setAdpicture(String adpicture) {
        this.adpicture = adpicture;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getDealine() {
        return dealine;
    }

    public void setDealine(String dealine) {
        this.dealine = dealine;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public int getCeiling() {
        return ceiling;
    }

    public void setCeiling(int ceiling) {
        this.ceiling = ceiling;
    }

    public String getReleaser() {
        return releaser;
    }

    public void setReleaser(String releaser) {
        this.releaser = releaser;
    }

    public String getRelaeaserUID() {
        return relaeaserUID;
    }

    public void setRelaeaserUID(String relaeaserUID) {
        this.relaeaserUID = relaeaserUID;
    }

    private String relaeaserUID;//发布者的userId
}
