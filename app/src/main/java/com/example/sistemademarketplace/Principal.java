package com.example.sistemademarketplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.sistemademarketplace.fragments.ChatsFragment;
import com.example.sistemademarketplace.fragments.FiltrosFragment;
import com.example.sistemademarketplace.fragments.IAFragment;
import com.example.sistemademarketplace.fragments.PerfilFragment;
import com.example.sistemademarketplace.fragments.PrincipalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Principal extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(new PrincipalFragment());


    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if (item.getItemId() == R.id.navigation_principal) {

                        openFragment(new PrincipalFragment());

                    } else if (item.getItemId() == R.id.navigation_filtros) {
                        openFragment(new FiltrosFragment());

                    }else if(item.getItemId() == R.id.navigation_IA) {
                        openFragment(new IAFragment());

                    } else if (item.getItemId() == R.id.navigation_chats) {

                        openFragment(new ChatsFragment());

                    } else if (item.getItemId() == R.id.navigation_perfil) {

                        openFragment(new PerfilFragment());

                    }
                    return true;
                }
            };
}