package be.ibad.mvvm;

import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Assert;

import be.ibad.mvvm.data.FoodTruckService;
import be.ibad.mvvm.model.ResponseOpenData;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

/**
 * Created by nvandamme on 13-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class RecordViewModelTest extends InstrumentationTestCase {
    private MockRetrofit mockRetrofit;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.com")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NetworkBehavior behavior = NetworkBehavior.create();
        mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build();
    }

    @SmallTest
    public void testNbrHitsRetrieval() throws Exception {
        BehaviorDelegate<FoodTruckService> delegate = mockRetrofit.create(FoodTruckService.class);
        FoodTruckService mockQodService = new MockFoodTruckService(delegate, getInstrumentation().getContext());

        int NBR_ROW = 100;
        //Actual Test
        Call<ResponseOpenData> quote = mockQodService.getAllFoodTruck(NBR_ROW);
        Response<ResponseOpenData> openDataResponse = quote.execute();

        //Asserting response
        Assert.assertTrue(openDataResponse.isSuccessful());
        Assert.assertTrue(openDataResponse.body().getRecords() != null);
        Assert.assertEquals(18, openDataResponse.body().getNhits());
        Assert.assertEquals(NBR_ROW, openDataResponse.body().getParameters().getRows());
        Assert.assertEquals("Data set check", "bxl_food_trucks", openDataResponse.body().getParameters().getDataset().get(0));
    }


}
