package com.example.kangjh_mac.livedatapractice.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.kangjh_mac.livedatapractice.RetrofitApi;
import com.example.kangjh_mac.livedatapractice.model.Coupon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.kangjh_mac.livedatapractice.common.Config.BASE_URL;

public class CouponRepository {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public Coupon getTopCoupon() {

        final Coupon coupon = new Coupon();

        getRetrofitClient().create(RetrofitApi.class).getTopCoupon().enqueue(new Callback<Coupon>() {
            @Override
            public void onResponse(Call<Coupon> call, Response<Coupon> response) {
                Coupon cpn = response.body();

                coupon.setStore(cpn.getStore());
                coupon.setCoupon(cpn.getCoupon());
                coupon.setCouponCode(cpn.getCouponCode());
            }

            @Override
            public void onFailure(Call<Coupon> call, Throwable t) {

            }
        });

        return coupon;
    }

    public LiveData<Coupon> getTopCouponLive() {
        final MutableLiveData<Coupon> coupon = new MutableLiveData<>();

        getRetrofitClient().create(RetrofitApi.class).getTopCoupon().enqueue(new Callback<Coupon>() {
            @Override
            public void onResponse(Call<Coupon> call, Response<Coupon> response) {
                Coupon cpn =response.body();
                coupon.setValue(cpn);
            }

            @Override
            public void onFailure(Call<Coupon> call, Throwable t) {

            }
        });

        return coupon;
    }
}
