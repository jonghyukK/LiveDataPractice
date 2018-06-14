package com.example.kangjh_mac.livedatapractice.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.Date;

public class DataRepository {

    private static MutableLiveData<Long> data = new MutableLiveData<>();

    public static LiveData<Long> getData() {
        data.setValue(new Date().getTime());
        return data;
    }
}
