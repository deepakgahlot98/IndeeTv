package com.gahlot.indeetv.utils;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.gahlot.indeetv.model.TestDataDTO;
import java.util.List;

public class DataRepository {

    private static final String TAG = "DataRepository";
    private static DataRepository dataRepository;
    private static Context context;

    public static DataRepository getInstance(){
        if (dataRepository == null){
            dataRepository = new DataRepository(context);
        }
        return dataRepository;
    }

    public DataRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<TestDataDTO>> getCategory() {
        final Utils utils = new Utils();
        final MutableLiveData<List<TestDataDTO>> data = new MutableLiveData<>();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                data.postValue(utils.getResponse(context));
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        return data;
    }
}
