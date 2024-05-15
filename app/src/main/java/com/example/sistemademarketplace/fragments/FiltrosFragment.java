package com.example.sistemademarketplace.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sistemademarketplace.Filtros_Busqueda;
import com.example.sistemademarketplace.R;


public class FiltrosFragment extends Fragment {

    View mView;
    LinearLayout nissan, bmw, toyota, honda, porsche, hyundai;



    public FiltrosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_filtros, container, false);

        nissan = mView.findViewById(R.id.filtroNissan);
        nissan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               BusquedaFiltros("Nissan");
            }
        });
        bmw = mView.findViewById(R.id.filtroBmw);
        bmw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusquedaFiltros("Bmw");
            }
        });
        toyota = mView.findViewById(R.id.filtroToyota);
        toyota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusquedaFiltros("Toyota");
            }
        });
        honda = mView.findViewById(R.id.filtroHonda);
        honda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusquedaFiltros("Honda");
            }
        });
        porsche = mView.findViewById(R.id.filtroPorsche);
        porsche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusquedaFiltros("Porsche");
            }
        });
        hyundai = mView.findViewById(R.id.filtroHyundai);
        hyundai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusquedaFiltros("Hyundai");
            }
        });

        return mView;
    }

    private void BusquedaFiltros(String categoria) {
        Intent intent = new Intent(getContext(), Filtros_Busqueda.class);
        intent.putExtra("categoria", categoria);
        startActivity(intent);
    }
}