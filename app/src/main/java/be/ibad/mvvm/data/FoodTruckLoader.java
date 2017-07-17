package be.ibad.mvvm.data;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.model.ResponseOpenData;
import retrofit2.Response;

/**
 * Created by nvandamme on 13-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class FoodTruckLoader extends AbstractAsyncTaskLoader<ArrayList<Record>> {

    public FoodTruckLoader(Context context) {
        super(context);
    }

    @Override
    public ArrayList<Record> loadInBackground() {
        try {
            FoodTruckService service = new FoodTruckReomteDataSource();
            Response<ResponseOpenData> response = service.getAllFoodTruck(500).execute();
            if (response.isSuccessful()) {
                return response.body().getRecords();
            } else {
                //TODO Error
            }
        } catch (IOException e) {
            e.printStackTrace();
            //TODO Error
        }
        return null;
    }
}
