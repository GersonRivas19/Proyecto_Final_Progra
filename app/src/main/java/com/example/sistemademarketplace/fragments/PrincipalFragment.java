package com.example.sistemademarketplace.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.sistemademarketplace.AcercaDe;
import com.example.sistemademarketplace.Floating_Button;
import com.example.sistemademarketplace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class PrincipalFragment extends Fragment {

    View view;
    FloatingActionButton buttonFloating;

    Toolbar toolbar;

    public PrincipalFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_principal, container, false);
        buttonFloating = view.findViewById(R.id.FloatingButtonAgregar);

        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Bienvenido");
        setHasOptionsMenu(true);
        buttonFloating.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Floating();
            }
        });
        return view;
    }

    private void Floating() {
        Intent intent = new Intent(getContext(), Floating_Button.class);
        startActivity(intent);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.CerrarSesion) {

            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}


