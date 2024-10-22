package com.ese.app1;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.*;
import com.ese.app1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView
                = findViewById(R.id.botmenu);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menuInicio);
    }

    fragmentInicio fragmentinicio = new fragmentInicio();
    fragmentAgregar fragmentagregar = new fragmentAgregar();
    fragmentPerfil fragmentperfil = new fragmentPerfil();
    fragmentBuscar fragmentbuscar = new fragmentBuscar();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.menuInicio) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framed, fragmentinicio)
                    .commit();
            return true;
        } else if (itemId == R.id.menuAgregar) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framed, fragmentagregar)
                    .commit();
            return true;
        } else if (itemId == R.id.menuPerfil) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framed, fragmentperfil)
                    .commit();
            return true;
        } else if (itemId == R.id.menuBuscar) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framed, fragmentbuscar)
                    .commit();
            return true;
        }
            return false;
        }

    }

