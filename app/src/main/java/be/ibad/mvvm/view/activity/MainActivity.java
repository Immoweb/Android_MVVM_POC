package be.ibad.mvvm.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import be.ibad.mvvm.R;
import be.ibad.mvvm.view.fragment.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, ListFragment.newInstance(), ListFragment.TAG)
                    .commit();
        }
    }
}
