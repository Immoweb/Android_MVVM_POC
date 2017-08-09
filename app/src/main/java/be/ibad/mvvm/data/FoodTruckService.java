package be.ibad.mvvm.data;

import be.ibad.mvvm.model.ResponseOpenData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nvandamme on 12-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public interface FoodTruckService {

    String ENDPOINT = "https://opendata.bruxelles.be/api/records/1.0/";

    @GET("search?dataset=bxl_food_trucks")
    Call<ResponseOpenData> getAllFoodTruck(@Query("rows") int nbr);

}
