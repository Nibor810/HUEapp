package nl.arthurtech.hueapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by robin on 24-11-2017.
 */

public class LampRecyclerViewAdapter extends RecyclerView.Adapter<LampRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<LampItem> lamps;
    private LampDetailFragment fragment;

    public LampRecyclerViewAdapter(Context context, List<LampItem> lamps, LampDetailFragment fragment){
        this.context = context;
        this.lamps = lamps;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lamp_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view, context);
        viewHolder.setListener(fragment);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LampRecyclerViewAdapter.ViewHolder holder, int position) {
        LampItem lampItem = lamps.get(position);
        holder.lampID.setText(lampItem.getLampID());
        holder.lampColor.setColorFilter(lampItem.getLampColor());
    }

    @Override
    public int getItemCount() {
        return lamps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lampID;
        ImageView lampColor;
        private FragmentCallBack mCallback;

        public ViewHolder(View itemView, final Context ctx) {
            super(itemView);
            context = ctx;
            lampID = itemView.findViewById(R.id.textLampID);
            lampColor = itemView.findViewById(R.id.imageLampColor);

            itemView.setOnClickListener((View v)->{
                LampItem lampItem = lamps.get(getAdapterPosition());
                Log.i("RecyclerView","Klikopitem");
                mCallback.updateLampDetails(lampItem);
            });
        }

        public void setListener(FragmentCallBack callback){
            mCallback = callback;
        }

    }
}
