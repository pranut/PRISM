package com.example.prism.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.prism.LinearChartActivity;
import com.example.prism.PainReport;
import com.example.prism.R;
import com.example.prism.domain.Routines;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class RoutinesListAdapter extends RecyclerView.Adapter<RoutinesListAdapter.RoutinesViewHolder> {


    private ArrayList<Routines> mDataset;
    private Context context;


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class RoutinesViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button detailButton;
        public Button reportButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public RoutinesViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            reportButton = (Button) itemView.findViewById(R.id.btnRoutineReport);
            detailButton = (Button) itemView.findViewById(R.id.btnRoutineDetails);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RoutinesListAdapter(ArrayList<Routines> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public RoutinesListAdapter.RoutinesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.textview, parent, false);

        // Return a new holder instance
        RoutinesViewHolder viewHolder = new RoutinesViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(RoutinesListAdapter.RoutinesViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Routines routines = mDataset.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(routines.getName());
        Button reportButton = viewHolder.reportButton;
        reportButton.setText(routines.isOnline() ? "Report" : "Complete");
        reportButton.setEnabled(routines.isOnline());

        if (routines.getRoutineType() == 77){
            reportButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, PainReport.class);
                    context.startActivity(myIntent);
                }
            });
        }

        Button detailsButton = viewHolder.detailButton;
        detailsButton.setText("Details");
        detailsButton.setEnabled(true);


        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, LinearChartActivity.class);
                context.startActivity(myIntent);
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
