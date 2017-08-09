package be.ibad.mvvm.data;

import be.ibad.mvvm.model.ResponseOpenData;
import retrofit2.Call;
import retrofit2.http.Query;

/**
 * Created by nvandamme on 14-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class FoodTruckRemoteDataSource implements FoodTruckService {

    FoodTruckService service = RetrofitHelper.newFoodTruckService();

    @Override
    public Call<ResponseOpenData> getAllFoodTruck(@Query("rows") int nbr) {
        return service.getAllFoodTruck(nbr);
    }

}
