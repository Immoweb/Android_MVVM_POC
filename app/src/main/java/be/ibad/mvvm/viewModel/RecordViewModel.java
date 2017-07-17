package be.ibad.mvvm.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Locale;

import be.ibad.mvvm.R;
import be.ibad.mvvm.model.FoodTruckPlace;
import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.view.activity.DetailActivity;


/**
 * Created by nvandamme on 13-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class RecordViewModel extends BaseObservable {

    private static final String STATIC_MAPS_IMAGE_SIZED_URL = "https://maps.googleapis.com/maps/api/staticmap?center=%1$s&zoom=18&size=640x320&markers=color:blue%%7C%2$s";
    private final Context mContext;
    private final Record mRecord;

    public RecordViewModel(Context context, Record record) {
        mContext = context;
        mRecord = record;
    }

    @BindingAdapter({"bind:staticMapUrl"})
    public static void loadImage(final ImageView view, final String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    private FoodTruckPlace getdata() {
        return mRecord.getFields();
    }

    public String getEmplacement() {
        return getdata().getEmplacement();
    }

    public String getFoodTruck() {
        String foodTruckName = "No food truck today";
        switch (Calendar.getInstance(Locale.US).get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                if (!TextUtils.isEmpty(getdata().getLundi())) {
                    foodTruckName = getdata().getLundi();
                }
                break;
            case Calendar.TUESDAY:
                if (!TextUtils.isEmpty(getdata().getMardi())) {
                    foodTruckName = getdata().getMardi();
                }
                break;
            case Calendar.WEDNESDAY:
                if (!TextUtils.isEmpty(getdata().getMercredi())) {
                    foodTruckName = getdata().getMercredi();
                }
                break;
            case Calendar.THURSDAY:
                if (!TextUtils.isEmpty(getdata().getJeudi())) {
                    foodTruckName = getdata().getJeudi();
                }
                break;
            case Calendar.FRIDAY:
                if (!TextUtils.isEmpty(getdata().getVendredi())) {
                    foodTruckName = getdata().getVendredi();
                }
                break;
            case Calendar.SATURDAY:
                if (!TextUtils.isEmpty(getdata().getSamedi())) {
                    foodTruckName = getdata().getSamedi();
                }
                break;
        }
        return foodTruckName;
    }

    public String getImageUrl() {
        double lat = getdata().getCoordonneesWgs84().get(0);
        double lng = getdata().getCoordonneesWgs84().get(1);
        String urlCoordinates = lat + "," + lng;
        return String.format(STATIC_MAPS_IMAGE_SIZED_URL, urlCoordinates, urlCoordinates);
    }

    public View.OnClickListener onClickCard() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDetailWithTransition(view);
            }
        };
    }

    private void launchDetailWithTransition(View view) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_DATA, mRecord);
        View v = view.findViewById(R.id.map);
        View title = view.findViewById(R.id.text_street);
        View subTitle = view.findViewById(R.id.text_food_truck_name);

        if (v != null) {
            ActivityOptionsCompat options;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ViewCompat.setTransitionName(v, DetailActivity.MAP_TRANSITION_NAME);
                ViewCompat.setTransitionName(title, DetailActivity.TITLE_TRANSITION_NAME);
                ViewCompat.setTransitionName(subTitle, DetailActivity.SUBTITLE_TRANSITION_NAME);

                options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext,
                        Pair.create(v, ViewCompat.getTransitionName(v)),
                        Pair.create(title, ViewCompat.getTransitionName(title)),
                        Pair.create(subTitle, ViewCompat.getTransitionName(subTitle)));
            } else {
                options = ActivityOptionsCompat.makeScaleUpAnimation(v, 0, 0, v.getWidth(), v.getHeight());
            }
            ActivityCompat.startActivity(mContext, intent, options.toBundle());
        } else {
            mContext.startActivity(intent);
        }
    }

}
