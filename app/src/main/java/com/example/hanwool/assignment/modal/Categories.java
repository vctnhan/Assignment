package com.example.hanwool.assignment.modal;

import java.io.Serializable;

public class Categories implements Serializable {
    Integer catId;
    String cateName, cateImage;
    Integer totalWallpaper;

    public Categories(Integer catId, String cateName, String cateImage, Integer totalWallpaper) {
        this.catId = catId;
        this.cateName = cateName;
        this.cateImage = cateImage;
        this.totalWallpaper = totalWallpaper;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateImage() {
        return cateImage;
    }

    public void setCateImage(String cateImage) {
        this.cateImage = cateImage;
    }

    public Integer getTotalWallpaper() {
        return totalWallpaper;
    }

    public void setTotalWallpaper(Integer totalWallpaper) {
        this.totalWallpaper = totalWallpaper;
    }
}
