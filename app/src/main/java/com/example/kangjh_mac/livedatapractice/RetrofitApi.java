package com.example.kangjh_mac.livedatapractice;

import com.example.kangjh_mac.livedatapractice.model.Coupon;
import com.example.kangjh_mac.livedatapractice.model.StoreInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("storeOffers/")
    Call<StoreInfo> getStoreInfo();

    @GET("topCoupon/")
    Call<Coupon> getTopCoupon();

}
