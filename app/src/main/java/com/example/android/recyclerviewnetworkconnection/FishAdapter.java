package com.example.android.recyclerviewnetworkconnection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Francislainy on 26/07/2017.
 */

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.ViewHolder> {

    private List<Fish> mFishList;
    private Context mContext;

    public FishAdapter(Context context, List<Fish> fishList) {
        this.mFishList = fishList;
        this.mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public FishAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fish_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FishAdapter.ViewHolder holder, int position) {
        Fish fish = mFishList.get(position);
        TextView fish_name = holder.fish_name;
        fish_name.setText(fish.getFish_name());
    }

    @Override
    public int getItemCount() {
        return mFishList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView fish_name;

        public ViewHolder(View itemView) {
            super(itemView);

            fish_name = (TextView) itemView.findViewById(R.id.textFishName);
        }
    }

}
