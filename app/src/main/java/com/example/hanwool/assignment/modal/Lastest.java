package com.example.hanwool.assignment.modal;

import java.io.Serializable;

public class Lastest implements Serializable {

    private String imgLastest;
    private Integer view;

    public Lastest(String imgLastest, Integer view) {
        this.imgLastest = imgLastest;
        this.view = view;
    }

    public String getImgLastest() {
        return imgLastest;
    }

    public void setImgLastest(String imgLastest) {
        this.imgLastest = imgLastest;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }
}
