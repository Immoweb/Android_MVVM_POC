package be.ibad.mvvm.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import be.ibad.mvvm.R;
import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.view.fragment.DetailFragment;

/**
 * Created by nvandamme on 13-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String MAP_TRANSITION_NAME = "MAP_TRANSITION_NAME";
    public static final String TITLE_TRANSITION_NAME = "TITLE_TRANSITION_NAME";
    public static final String SUBTITLE_TRANSITION_NAME = "SUBTITLE_TRANSITION_NAME";

    public static Intent getStartIntent(Context context, Record data) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_DATA, data);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        Record data = getIntent().getParcelableExtra(EXTRA_DATA);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance(data), DetailFragment.TAG)
                    .commit();
        }
    }

}
