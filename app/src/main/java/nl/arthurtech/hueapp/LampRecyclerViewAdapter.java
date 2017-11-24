package nl.arthurtech.hueapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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

    public LampRecyclerViewAdapter(Context context, List<LampItem> lamps){
        this.context = context;
        this.lamps = lamps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lamp_row,parent,false);
        return new ViewHolder(view, context);
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

        public ViewHolder(View itemView, final Context ctx) {
            super(itemView);
            context = ctx;
            lampID = itemView.findViewById(R.id.textLampID);
            lampColor = itemView.findViewById(R.id.imageLampColor);

            itemView.setOnClickListener((View v)->{
                //TODO: Laat de fragment omhoog komen
                LampItem lampItem = lamps.get(getAdapterPosition());
                //Intent intent = new Intent(context,);
                //intent.putExtra("lamp",lampItem);
                //startActivity(intent);
            });
        }

    }
}
