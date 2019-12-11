package com.example.prism.ui.patient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.prism.R;
import com.example.prism.databinding.ListItemRoutinesBinding;
import com.example.prism.model.Routine;
import com.example.prism.model.Routines;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RoutinesListAdapter extends RecyclerView.Adapter<RoutinesListAdapter.ViewHolder> {

    private Routines routines;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RoutinesListAdapter(Routines myDataset, Context context) {
        routines = myDataset;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_routines, null);
        ListItemRoutinesBinding bi = DataBindingUtil.bind(view);
        return new ViewHolder(bi);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Routine routine = routines.rList.get(position);

        holder.bi.txtItemName.setText(routine.getName());

        holder.bi.txtItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                Intent myIntent = new Intent(context, KneeExercise.class);
                context.startActivity(myIntent);
            }
        });

        Button btnReport = holder.bi.btnRoutineReport;

        btnReport.setText(routine.isOnline() ? "Record" : "Complete");
        btnReport.setEnabled(routine.isOnline());

        if (routine.getRoutineID() == 77){
            btnReport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, PainReport.class);
                    context.startActivity(myIntent);
                }
            });
        }

        Button btnData = holder.bi.btnData;
        btnData.setText("Data");
        btnData.setEnabled(true);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, DataViewerActivity.class);
                myIntent.putExtra("ROUTINE", routine);
                context.startActivity(myIntent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return routines.rList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ListItemRoutinesBinding bi;
        public ViewHolder(@NonNull ListItemRoutinesBinding itemView) {
            super(itemView.getRoot());
            bi = itemView;
        }
    }
}
