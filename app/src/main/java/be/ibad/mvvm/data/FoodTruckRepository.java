package be.ibad.mvvm.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.model.ResponseOpenData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nvandamme on 24-07-17.
 * All right reserved for Immoweb Android_MVVM_POC
 */

public class FoodTruckRepository implements FoodTruckDataSource {

    private static FoodTruckRepository sInstance = null;
    private final FoodTruckService mDataSource;
    private ArrayList<Record> mRecords = null;

    private FoodTruckRepository(FoodTruckService dataSource) {
        mDataSource = dataSource;
    }

    public static FoodTruckRepository getInstance() {
        if (sInstance == null) {
            sInstance = new FoodTruckRepository(new FoodTruckRemoteDataSource());
        }
        return sInstance;
    }

    @Override
    public void getAllFoodTruck(@NonNull final LoadFoodTruckCallback callback) {
        if (mRecords == null) {
            mDataSource.getAllFoodTruck(500).enqueue(new Callback<ResponseOpenData>() {
                @Override
                public void onResponse(Call<ResponseOpenData> call, Response<ResponseOpenData> response) {
                    if (response.isSuccessful()) {
                        mRecords = response.body().getRecords();
                        callback.onTasksLoaded(mRecords);
                    } else {
                        callback.onDataNotAvailable();
                    }
                }

                @Override
                public void onFailure(Call<ResponseOpenData> call, Throwable t) {
                    callback.onDataNotAvailable();
                }
            });
        } else {
            callback.onTasksLoaded(mRecords);
        }
    }
}
