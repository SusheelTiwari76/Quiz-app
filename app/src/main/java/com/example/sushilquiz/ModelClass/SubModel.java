package com.example.sushilquiz.ModelClass;

public class SubModel {
    public String title, cetogory;
    String des;

    public SubModel() {

    }

    public SubModel(String title, String cetogory, String des) {
        this.title = title;
        this.cetogory = cetogory;
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCetogory() {
        return cetogory;
    }

    public void setCetogory(String cetogory) {
        this.cetogory = cetogory;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
