package be.ibad.mvvm.data;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nvandamme on 12-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class RetrofitHelper {

    public static FoodTruckService newFoodTruckService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(FoodTruckService.ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();

        return restAdapter.create(FoodTruckService.class);
    }

}
