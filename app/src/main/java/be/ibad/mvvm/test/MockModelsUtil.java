package be.ibad.mvvm.test;

import java.util.ArrayList;

import be.ibad.mvvm.model.FoodTruckPlace;
import be.ibad.mvvm.model.Geometry;
import be.ibad.mvvm.model.Record;

/**
 * Created by nvandamme on 14-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class MockModelsUtil {

    public static Record createMockFoodTruck() {
        Record record = new Record();
        record.setDatasetid("bxl_food_trucks");
        record.setRecordid("10896a6f5df13590cc203406c17e387776a3c155");
        Geometry geo = new Geometry();
        geo.setType("Point");
        ArrayList<Double> coordonates = new ArrayList<Double>(2) {{
            add(4.35769647359848);
            add(50.8477831991208);
        }};
        geo.setCoordinates(coordonates);
        record.setGeometry(geo);

        FoodTruckPlace foodTruck = new FoodTruckPlace();
        foodTruck.setCoordonneesWgs84(coordonates);
        foodTruck.setEmplacement("Boulevard de l'Impératrice");

        foodTruck.setMonday("Loving Hut");
        foodTruck.setLundi("Loving Hut");
        foodTruck.setMaandag("Loving Hut");

        foodTruck.setTuesday("Pim Coffee On The Go");
        foodTruck.setMardi("Pim Coffee On The Go");
        foodTruck.setDinsdag("Pim Coffee On The Go");

        foodTruck.setWednesday("Pim Coffee On The Go");
        foodTruck.setMercredi("Pim Coffee On The Go");
        foodTruck.setWoensdag("Pim Coffee On The Go");

        foodTruck.setThursday("Chang Noi");
        foodTruck.setJeudi("Chang Noi");
        foodTruck.setDonderdag("Chang Noi");

        foodTruck.setFriday("Non Solo Tiramisu");
        foodTruck.setVendredi("Non Solo Tiramisu");
        foodTruck.setVrijdag("Non Solo Tiramisu");

        record.setFields(foodTruck);

        return record;
    }
}
