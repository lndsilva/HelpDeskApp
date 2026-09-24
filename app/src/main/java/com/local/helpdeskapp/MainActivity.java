package com.local.helpdeskapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new fragment_chamados())
                    .commit();
        }

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selecionado = null;
            if (item.getItemId() == R.id.nav_chamados) {
                selecionado = new fragment_chamados();
            } else if (item.getItemId() == R.id.nav_novo) {

                selecionado = new Fragment();
            }

            if (selecionado != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selecionado)
                        .commit();
            }
            return true;
        });



    }
}