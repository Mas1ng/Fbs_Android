package com.example.fbs_android.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;

public class ClienteMainActivity extends AppCompatActivity {
    TextView tv;
    Button viagens, bilhetes, criticas;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente_main_activity);
        Intent t = getIntent();
        String email = t.getStringExtra(Intent.EXTRA_TEXT);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        long cc = bundle.getLong("cc");
            pb = findViewById(R.id.pBar);
            pb.setVisibility(ProgressBar.INVISIBLE);
            tv = findViewById(R.id.main);
            viagens = findViewById(R.id.viagem);
            viagens.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ClienteMainActivity.this, "Viagens", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ClienteMainActivity.this, ViagensActivity.class);
                    startActivity(intent);
                }
            });

            bilhetes = findViewById(R.id.bilhete);
            bilhetes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ClienteMainActivity.this, "Bilhetes do cliente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ClienteMainActivity.this, BilhetesItemActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT, email);
                    Bundle bundle = new Bundle();
                    bundle.putLong("cc", cc);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            criticas = findViewById(R.id.critica);
            viagens.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ClienteMainActivity.this, "Viagens", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ClienteMainActivity.this, CriticasMainActivity.class);
                    startActivity(intent);
                }
            });

    }
}
