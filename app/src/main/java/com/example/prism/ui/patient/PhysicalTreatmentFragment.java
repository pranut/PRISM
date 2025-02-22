package com.example.prism.ui.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prism.R;
import com.example.prism.model.Routine;
import com.example.prism.model.Routines;

import java.util.ArrayList;

public class PhysicalTreatmentFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Routines routines;

    public PhysicalTreatmentFragment(){}
    public PhysicalTreatmentFragment(Routines routines){

        this.routines = routines;

    }

    public static PhysicalTreatmentFragment newInstance(Routines routines) {
        PhysicalTreatmentFragment fragment = new PhysicalTreatmentFragment(routines);

        Bundle bundle = new Bundle();
        bundle.putParcelable("Routines", routines);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            this.routines = bundle.getParcelable("Routines");
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_screen_patient, container, false);

        recyclerView = root.findViewById(R.id.rcv_routines);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        // recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

//        // Initialize contacts
//        routines = Routine.createRoutinesList(20);

        // Create adapter passing in the sample user data
        RoutinesListAdapter adapter = new RoutinesListAdapter(routines, container.getContext());

        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);

        // Set layout manager to position the items
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);

        return root;
    }
}