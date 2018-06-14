package com.example.kangjh_mac.livedatapractice.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.kangjh_mac.livedatapractice.RetrofitApi;
import com.example.kangjh_mac.livedatapractice.model.StoreInfo;

import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.kangjh_mac.livedatapractice.common.Config.BASE_URL;

public class RetrofitRepository {

    private static MutableLiveData<StoreInfo> data = new MutableLiveData<>();

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .callbackExecutor(Executors.newSingleThreadExecutor())
                    .build();
        }

        return retrofit;
    }

    public static LiveData<StoreInfo> getIntData() {
        return data;
    }


    public static void getStoreInfo() {

        Call<StoreInfo> call =  getRetrofitClient().create(RetrofitApi.class).getStoreInfo();

        call.enqueue(new Callback<StoreInfo>() {
            @Override
            public void onResponse(Call<StoreInfo> call, Response<StoreInfo> response) {
                StoreInfo si = response.body();
                data.postValue(si);
            }

            @Override
            public void onFailure(Call<StoreInfo> call, Throwable t) {
                Log.e("", "Error RETROFIT");
            }
        });
    }

}
