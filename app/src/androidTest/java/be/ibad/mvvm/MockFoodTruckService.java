package be.ibad.mvvm;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

import be.ibad.mvvm.data.FoodTruckService;
import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.model.ResponseOpenData;
import retrofit2.Call;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;

/**
 * Created by nvandamme on 08-08-17.
 * All right reserved for Immoweb Android_MVVM_POC
 */

public class MockFoodTruckService implements FoodTruckService {

    private final BehaviorDelegate<FoodTruckService> delegate;
    private final Context context;

    public MockFoodTruckService(BehaviorDelegate<FoodTruckService> service, Context context) {
        this.delegate = service;
        this.context = context;
    }

    @Override
    public Call<ResponseOpenData> getAllFoodTruck(int nbr) {
        Gson gson = new GsonBuilder().create();
        String json;
        try {
            json = RestServiceTestHelper.getStringFromFile(context, "response.json");
        } catch (Exception e) {
            e.printStackTrace();
            return Calls.failure((IOException) e);
        }
        ResponseOpenData responseOpenData = gson.fromJson(json, ResponseOpenData.class);
        responseOpenData.getParameters().setRows(nbr);
        ArrayList<Record> records = new ArrayList<>();
        responseOpenData.setRecords(records);
        return delegate.returningResponse(responseOpenData).getAllFoodTruck(nbr);
    }

}
