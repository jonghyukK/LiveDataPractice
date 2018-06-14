package com.example.kangjh_mac.livedatapractice.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.kangjh_mac.livedatapractice.repo.CouponRepository;
import com.example.kangjh_mac.livedatapractice.model.Coupon;

public class CouponViewModel extends ViewModel {

//    private Coupon coupon;
    private LiveData<Coupon> liveCoupon;
    private CouponRepository couponRepository = new CouponRepository();

//    public Coupon getCoupon() {
//        if (coupon == null) {
//            coupon = couponRepository.getTopCoupon();
//        }
//        return coupon;
//    }

    public LiveData<Coupon> getLiveCoupon() {
        if (liveCoupon == null ) {
            liveCoupon = couponRepository.getTopCouponLive();
        }
        return liveCoupon;
    }
}
