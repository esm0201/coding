package com.ldm.customlayout;

public class CustomModel {
    private int imgPath;
    private String name;
    private String tel;

    public CustomModel(int imgPath, String name, String tel) {
        this.imgPath = imgPath;
        this.name = name;
        this.tel = tel;
    }

    public int getImgPath() {
        return imgPath;
    }

    public void setImgPath(int imgPath) {
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
