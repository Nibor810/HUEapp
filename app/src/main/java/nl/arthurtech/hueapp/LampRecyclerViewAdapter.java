package nl.arthurtech.hueapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by robin on 24-11-2017.
 */

public class LampRecyclerViewAdapter extends RecyclerView.Adapter<LampRecyclerViewAdapter.ViewHolder> {

    public LampRecyclerViewAdapter(Context context, List<LampItem> lamps){

    }

    @Override
    public LampRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(LampRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
