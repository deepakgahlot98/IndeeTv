package com.gahlot.indeetv.utils;

import android.content.Context;
import android.util.Log;

import com.gahlot.indeetv.model.ResponseDTO;
import com.gahlot.indeetv.model.TestDataDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String TAG = "Utils";


    public List<TestDataDTO> getResponse(Context context) {
        List<TestDataDTO> listData = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(readJSONFromAsset(context));
            JSONArray jArray = obj.getJSONArray("TestData");
            for (int i = 0; i < jArray.length(); ++i) {
                TestDataDTO testDataDTO = new TestDataDTO();
                testDataDTO.setId(jArray.getJSONObject(i).getString("id"));
                Log.i(TAG, "getResponse: " + jArray.getJSONObject(i).getString("id"));
                testDataDTO.setName(jArray.getJSONObject(i).getString("name"));
                testDataDTO.setPaymentPlan(jArray.getJSONObject(i).getString("payment_plan"));
                testDataDTO.setReleaseYear(jArray.getJSONObject(i).getString("release_year"));
                testDataDTO.setVideoDuration(jArray.getJSONObject(i).getString("video_duration"));
                testDataDTO.setType(jArray.getJSONObject(i).getString("type"));
                testDataDTO.setCreatedOn(jArray.getJSONObject(i).getString("created_on"));
                testDataDTO.setUpdatedOn(jArray.getJSONObject(i).getString("updated_on"));
                testDataDTO.setPosterLink(jArray.getJSONObject(i).getString("posterLink"));
                testDataDTO.setShortDescription(jArray.getJSONObject(i).getString("shortDescription"));
                testDataDTO.setDescription(jArray.getJSONObject(i).getString("description"));
                listData.add(testDataDTO);
            }
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        return listData;
    }

    public String readJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("TestJSON.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
