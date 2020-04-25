package com.gahlot.indeetv.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gahlot.indeetv.model.TestDataDTO;
import com.gahlot.indeetv.utils.DataRepository;

import java.util.List;

public class CustomViewModel extends AndroidViewModel {

    private DataRepository dataRepository;

    public CustomViewModel(@NonNull Application application) {
        super(application);
        dataRepository= new DataRepository(application);
    }

    public LiveData<List<TestDataDTO>> getCategoriesData() {
        return dataRepository.getCategory();
    }
}
