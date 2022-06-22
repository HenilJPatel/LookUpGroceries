package com.example.lookupgroceries;

public class MyListData {
    private String description;
    private int imgId;
    public MyListData(String description, int imgId) {
        this.description = description;
        this.imgId = imgId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
    public MyListData[] setData(){
        MyListData[] m=new MyListData[]{
                new MyListData("25OFF",R.drawable.ic_baseline_local_offer_24),
                new MyListData("DIWALI25",R.drawable.ic_baseline_local_offer_24),
        };
        final MyListData[] m1 = m;
        return m1;
    }
}
