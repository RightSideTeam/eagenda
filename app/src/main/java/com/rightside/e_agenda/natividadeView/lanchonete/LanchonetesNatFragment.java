package com.rightside.e_agenda.natividadeView.lanchonete;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rightside.e_agenda.R;
import com.rightside.e_agenda.adapter.GerenciaLanchoneteNatividadeAdapter;
import com.rightside.e_agenda.modelo.GerenciaLanchoneteNatividade;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class LanchonetesNatFragment extends Fragment {

    private static String TAG = "lanchonetes";
    private GerenciaLanchoneteNatividadeAdapter lanchoneteAdapter;
    private ArrayList<GerenciaLanchoneteNatividade> lanchonetes;
    public LanchonetesNatFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gerencia_lanc_nat, container, false);

        RecyclerView recyclerViewLanchonetes = view.findViewById(R.id.recycler_lanchonetes);
        recyclerViewLanchonetes.setLayoutManager(new LinearLayoutManager(getContext()));

        lanchoneteAdapter = new GerenciaLanchoneteNatividadeAdapter((LanchoneteNatActivity) getActivity(), new ArrayList<GerenciaLanchoneteNatividade>());
        recyclerViewLanchonetes.setAdapter(lanchoneteAdapter);
        setHasOptionsMenu(true);
        return view;

    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.shared_config), Context.MODE_PRIVATE);
        String id = sharedPreferences.getString(getString(R.string.id), "");
        DatabaseReference myRef = database.getReference("lanchonetesNat").child(id);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lanchonetes = new ArrayList<>();
                for(DataSnapshot lanchonete: dataSnapshot.getChildren()){
                    lanchonetes.add(lanchonete.getValue(GerenciaLanchoneteNatividade.class));

                }
                lanchoneteAdapter.atualiza(lanchonetes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }



}