package com.example.sistemademarketplace.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sistemademarketplace.EditarPerfil;
import com.example.sistemademarketplace.R;


public class PerfilFragment extends Fragment {

    LinearLayout editarPerfil;
    View mView;




    public PerfilFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_perfil, container, false);
        editarPerfil = mView.findViewById(R.id.EditarPerfil);
        editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditarPerfil();
            }
        });

        return mView;
    }
    private void EditarPerfil() {
        Intent intent = new Intent(getContext(), EditarPerfil.class);
        startActivity(intent);
    }
}