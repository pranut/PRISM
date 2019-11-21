package com.example.prism.phy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.prism.LinearChartActivity;
import com.example.prism.R;
import com.example.prism.domain.Patient;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.PatientListHolder> {


    private ArrayList<Patient> mDataset;
    private Context context;


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class PatientListHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView patientName;
        public Button patientDetails;
        public Button patientMessage;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public PatientListHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            patientName = (TextView) itemView.findViewById(R.id.patient_name);
            patientMessage = (Button) itemView.findViewById(R.id.btnPatientMessage);
            patientDetails = (Button) itemView.findViewById(R.id.btnPatientDetails);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PatientListAdapter(ArrayList<Patient> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public PatientListAdapter.PatientListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.patient_list_item_view, parent, false);

        // Return a new holder instance
        PatientListHolder viewHolder = new PatientListHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(PatientListAdapter.PatientListHolder viewHolder, int position) {
        // Get the data model based on position
        final Patient patients = mDataset.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.patientName;
        textView.setText(patients.getName());
        Button reportButton = viewHolder.patientMessage;
        reportButton.setText("Message");
        reportButton.setEnabled(patients.isOnline());

        Button detailsButton = viewHolder.patientDetails;
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
