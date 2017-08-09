package be.ibad.mvvm.data;

import java.util.List;

import be.ibad.mvvm.model.Record;

/**
 * Created by nvandamme on 24-07-17.
 * All right reserved for Immoweb Android_MVVM_POC
 */

public interface FoodTruckDataSource {

    void getAllFoodTruck(LoadFoodTruckCallback callback);

    interface LoadFoodTruckCallback {

        void onTasksLoaded(List<Record> records);

        void onDataNotAvailable();
    }

}
