package com.example.fbs_android.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;

public class ItemViagemActivity extends AppCompatActivity {
    Button btAdd, btCancel;
    ProgressBar pBar;
    TextView nome, titulo, dataC, dataP, companhia, cidadeC, cidadeP, horaP, horaC, tipoLugar;
    EditText tipoL;
    ActivityResultLauncher<Intent> settingsActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //getFBSInfoFromWS();
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_viagem_layout);
        pBar = findViewById(R.id.pBar);
        pBar.setVisibility(ProgressBar.INVISIBLE);
        titulo= findViewById(R.id.titulo);
        nome= findViewById(R.id.tvName);
        dataC= findViewById(R.id.tvdataC);
        dataP= findViewById(R.id.dataP);
        companhia= findViewById(R.id.tvCompanhia);
        cidadeC= findViewById(R.id.tvCidadeC);
        cidadeP= findViewById(R.id.tvCidadeP);
        horaP= findViewById(R.id.tvhoraP);
        horaC= findViewById(R.id.tvhoraC);
        btAdd= findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItemViagemActivity.this, "Comprar Viagem", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ItemViagemActivity.this, ComprarViagemActivity.class);
                startActivity(intent);
            }
        });
        btCancel= findViewById(R.id.btCancel);



    }
}
