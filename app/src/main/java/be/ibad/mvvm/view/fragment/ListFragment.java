package be.ibad.mvvm.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import be.ibad.mvvm.R;
import be.ibad.mvvm.data.FoodTruckDataSource;
import be.ibad.mvvm.data.FoodTruckRepository;
import be.ibad.mvvm.databinding.FragmentListBinding;
import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.view.adapter.FoodTruckAdapter;

/**
 * Created by nvandamme on 12-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class ListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = ListFragment.class.getCanonicalName();
    private FoodTruckAdapter mAdapter;
    private FragmentListBinding mBinding;
    private FoodTruckDataSource.LoadFoodTruckCallback mLoadFoodTruckCallback =
            new FoodTruckDataSource.LoadFoodTruckCallback() {
                @Override
                public void onTasksLoaded(List<Record> records) {
                    mAdapter.setData(records);
                    showHideLoadingViews(false);
                }

                @Override
                public void onDataNotAvailable(String s) {
                    Toast.makeText(getContext(), "Error " + s, Toast.LENGTH_SHORT).show();
                    showHideLoadingViews(false);
                }
            };

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new FoodTruckAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.swipeContainer.setOnRefreshListener(this);
        mBinding.swipeContainer.setColorSchemeResources(R.color.colorAccent);

        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), getContext().getResources().getInteger(R.integer.nbr_column)));
        mBinding.recyclerView.hasFixedSize();
        mBinding.recyclerView.setAdapter(mAdapter);

        onRefresh();
    }

    private void showHideLoadingViews(boolean show) {
        mBinding.progressIndicator.setVisibility(show ? View.VISIBLE : View.GONE);
        mBinding.swipeContainer.setRefreshing(show);
    }

    @Override
    public void onRefresh() {
        showHideLoadingViews(true);
        FoodTruckRepository
                .getInstance()
                .getAllFoodTruck(100, mLoadFoodTruckCallback);
    }
}
