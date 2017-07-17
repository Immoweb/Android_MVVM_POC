package be.ibad.mvvm.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.ibad.mvvm.R;
import be.ibad.mvvm.databinding.FragmentDetailBinding;
import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.view.activity.DetailActivity;
import be.ibad.mvvm.viewModel.RecordViewModel;

/**
 * Created by nvandamme on 13-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class DetailFragment extends Fragment {

    public static final String TAG = DetailFragment.class.getCanonicalName();
    private static final String ARG_DATA = "ARG_DATA";
    private Record mRecord;

    public static DetailFragment newInstance(Record data) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_DATA, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecord = getArguments().getParcelable(ARG_DATA);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        binding.setViewModel(new RecordViewModel(getContext(), mRecord));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewCompat.setTransitionName(view.findViewById(R.id.map), DetailActivity.MAP_TRANSITION_NAME);
        ViewCompat.setTransitionName(view.findViewById(R.id.text_street), DetailActivity.TITLE_TRANSITION_NAME);
        ViewCompat.setTransitionName(view.findViewById(R.id.text_food_truck_name), DetailActivity.SUBTITLE_TRANSITION_NAME);
    }
}
