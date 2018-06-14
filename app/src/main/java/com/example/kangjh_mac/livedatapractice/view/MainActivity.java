package com.example.kangjh_mac.livedatapractice.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kangjh_mac.livedatapractice.R;
import com.example.kangjh_mac.livedatapractice.repo.RetrofitRepository;
import com.example.kangjh_mac.livedatapractice.viewmodel.CouponViewModel;

public class MainActivity extends AppCompatActivity {

    private CouponViewModel couponViewModel;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.time_t);

        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel.class);
//        couponViewModel.getCoupon();

        couponViewModel.getLiveCoupon().observe(this, coupon -> {
            tv.setText("" + coupon.getCoupon() + " " + coupon.getCouponCode());
        });

//        RetrofitRepository.getIntData().observe(this, storeInfo -> {
//            ((TextView)findViewById(R.id.time_t)).setText(String.valueOf(storeInfo.getStore()));
//        });
    }
//
//    public void getTime(View v) {
//
//        //        RetrofitRepository.getStoreInfo();
//
//        String coupon = couponViewModel.getCoupon().getStore() + " "
//                + couponViewModel.getCoupon().getCoupon() + " "
//                + couponViewModel.getCoupon().getCouponCode();
//
//        tv.setText(coupon);
//
//    }
}
