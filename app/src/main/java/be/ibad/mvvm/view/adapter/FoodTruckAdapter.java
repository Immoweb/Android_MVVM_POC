package be.ibad.mvvm.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import be.ibad.mvvm.R;
import be.ibad.mvvm.databinding.ItemFoodTruckBinding;
import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.viewModel.RecordViewModel;

/**
 * Created by nvandamme on 12-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class FoodTruckAdapter extends RecyclerView.Adapter<FoodTruckAdapter.FoodTruckHolder> {

    private ArrayList<Record> mRecords;

    @Override
    public FoodTruckAdapter.FoodTruckHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFoodTruckBinding postBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_food_truck,
                parent,
                false);
        return new FoodTruckHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(FoodTruckAdapter.FoodTruckHolder holder, int position) {
        ItemFoodTruckBinding itemFoodTruckBinding = holder.binding;
        itemFoodTruckBinding.setViewModel(new RecordViewModel(holder.itemView.getContext(), mRecords.get(position)));
    }

    @Override
    public int getItemCount() {
        return mRecords == null ? 0 : mRecords.size();
    }

    public void setData(ArrayList<Record> mRecords) {
        this.mRecords = mRecords;
        notifyDataSetChanged();
    }

    class FoodTruckHolder extends RecyclerView.ViewHolder {
        private ItemFoodTruckBinding binding;

        FoodTruckHolder(ItemFoodTruckBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
    }

}
