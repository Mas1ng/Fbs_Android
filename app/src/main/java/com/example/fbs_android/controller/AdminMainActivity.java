package com.example.fbs_android.controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;

public class AdminMainActivity extends AppCompatActivity {
    TextView tv;
    Button viagens, bilhetes, clientes;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_main_activity);

        pb = findViewById(R.id.pBar);
        pb.setVisibility(ProgressBar.INVISIBLE);
        tv = findViewById(R.id.crudViagens);
        viagens = findViewById(R.id.addViagem);

        bilhetes = findViewById(R.id.listarViagem);

        clientes = findViewById(R.id.clientes);
    }
}
