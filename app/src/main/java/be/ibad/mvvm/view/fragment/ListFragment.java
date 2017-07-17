package be.ibad.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import be.ibad.mvvm.R;
import be.ibad.mvvm.data.FoodTruckLoader;
import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.view.adapter.FoodTruckAdapter;

/**
 * Created by nvandamme on 12-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class ListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = ListFragment.class.getCanonicalName();
    private static final int LOADER_ID = 42;
    private FoodTruckAdapter mAdapter;
    private ProgressBar mProgressBar;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private LoaderManager.LoaderCallbacks<ArrayList<Record>> mFoodLoaderCallBak = new LoaderManager.LoaderCallbacks<ArrayList<Record>>() {
        @Override
        public Loader<ArrayList<Record>> onCreateLoader(int id, Bundle args) {
            return new FoodTruckLoader(getContext());
        }

        @Override
        public void onLoadFinished(Loader<ArrayList<Record>> loader, ArrayList<Record> data) {
            showHideLoadingViews(false);
            mAdapter.setData(data);
        }

        @Override
        public void onLoaderReset(Loader<ArrayList<Record>> loader) {
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
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mProgressBar = view.findViewById(R.id.progress_indicator);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(mAdapter);

        getLoaderManager().initLoader(LOADER_ID, null, mFoodLoaderCallBak);
    }

    private void showHideLoadingViews(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        mSwipeRefreshLayout.setRefreshing(show);
    }

    @Override
    public void onRefresh() {
        showHideLoadingViews(true);
        getLoaderManager().initLoader(LOADER_ID, null, mFoodLoaderCallBak);
    }
}
