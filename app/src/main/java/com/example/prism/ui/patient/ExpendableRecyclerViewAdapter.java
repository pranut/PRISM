package com.example.prism.ui.patient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.prism.R;
import com.example.prism.databinding.WreportItemExpandBinding;
import com.example.prism.model.Routine;
import com.example.prism.ui.custom.Animations;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ExpendableRecyclerViewAdapter extends RecyclerView.Adapter<ExpendableRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Routine> routineList;

    public ExpendableRecyclerViewAdapter(Context context, List<Routine> list) {
        this.context = context;
        this.routineList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.wreport_item_expand, null);
        WreportItemExpandBinding bi = DataBindingUtil.bind(view);
        return new ViewHolder(bi);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {

        final Routine routine = routineList.get(i);
        if (routine != null) {

            holder.bi.name.setText(routine.getName());

            //Picasso.get().load(routineList.get(i).getImage()).into(holder.bi.image);

            holder.bi.txvBrief.setText(routine.getDescription());
            holder.bi.txvStatus.setText(routine.status);

//            holder.bi.txvBrief.setText(routineList.get(i).getDescription());

            Spinner spnDataResolution = holder.bi.spnShareLevel;
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                    R.array.date_presets, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spnDataResolution.setAdapter(adapter);

            holder.bi.btnViewData.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(context, DataViewerActivity.class);
                            myIntent.putExtra("ROUTINE", routine);
                            context.startActivity(myIntent);
                        }
                    }
            );

            holder.bi.viewMoreBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean show = toggleLayout(!routineList.get(i).isExpanded(), v, holder.bi.layoutExpand);
                    routineList.get(i).setExpanded(show);
                }
            });

        }


    }

    private boolean toggleLayout(boolean isExpanded, View v, ConstraintLayout constraintLayout) {
        Animations.toggleArrow(v, isExpanded);
        if (isExpanded) {
            Animations.expand(constraintLayout);
        } else {
            Animations.collapse(constraintLayout);
        }
        return isExpanded;
    }

    @Override
    public int getItemCount() {
        return routineList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        WreportItemExpandBinding bi;

        public ViewHolder(@NonNull WreportItemExpandBinding itemView) {
            super(itemView.getRoot());
            bi = itemView;
        }
    }

}
