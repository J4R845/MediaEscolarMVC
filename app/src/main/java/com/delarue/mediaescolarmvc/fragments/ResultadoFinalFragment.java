package com.delarue.mediaescolarmvc.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.delarue.mediaescolarmvc.R;
import com.delarue.mediaescolarmvc.adapter.ResultadoFinalListAdapter;
import com.delarue.mediaescolarmvc.controller.MediaEscolarController;
import com.delarue.mediaescolarmvc.model.MediaEscolar;

import java.util.ArrayList;

public class ResultadoFinalFragment extends Fragment {

    ArrayList<MediaEscolar> dataSet;

    ListView listView;

    MediaEscolarController controller;


    View view;

    public ResultadoFinalFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_resultado_final, container, false);

        controller = new MediaEscolarController(getContext());

        listView = view.findViewById(R.id.listview);
        dataSet = controller.getAllResultadoFinal();
        ResultadoFinalListAdapter adapter =
                new ResultadoFinalListAdapter(dataSet, getContext());

        listView.setAdapter(adapter);

        // Click de uma linhs do ListView >
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MediaEscolar mediaEscolar = dataSet.get(position);

                Snackbar.make(view, mediaEscolar.getMateria() +
                        "\n" + mediaEscolar.getSituacao() +
                        " Média Final: " +
                        mediaEscolar.getMediaFinal(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });

        return view;
    }

    }

