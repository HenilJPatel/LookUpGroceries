package com.example.lookupgroceries;

public class Coupon {
    private String CouponName;
    private String CouponDesc;
    private String CouponValid;
    private String Chain;
    private String Store;

    public  Coupon(){

    }

    public Coupon(String couponName, String couponDesc, String couponValid, String chain, String store) {
        CouponName = couponName;
        CouponDesc = couponDesc;
        CouponValid = couponValid;
        Chain = chain;
        Store = store;
    }

    public String getCouponName() {
        return CouponName;
    }

    public void setCouponName(String couponName) {
        CouponName = couponName;
    }

    public String getCouponDesc() {
        return CouponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        CouponDesc = couponDesc;
    }

    public String getCouponValid() {
        return CouponValid;
    }

    public void setCouponValid(String couponValid) {
        CouponValid = couponValid;
    }

    public String getChain() {
        return Chain;
    }

    public void setChainID(String chain) {
        Chain = chain;
    }

    public String  getStore() {
        return Store;
    }

    public void setStoreID(String store) {
        Store = store;
    }
}
