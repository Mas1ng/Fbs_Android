package com.example.fbs_android.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;
import kotlin.OptionalExpectation;

public class RegistarClienteActivity extends AppCompatActivity {
    TextView nomeRegistar, ccRegistar,emailRegistar,passRegistar;
    View dataBirthday;
    Button btnRegistarC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_cliente_main);

        nomeRegistar = findViewById(R.id.nomeRegistar);
        ccRegistar = findViewById(R.id.ccRegistar);
        emailRegistar = findViewById(R.id.emailRegistar);
        passRegistar = findViewById(R.id.passRegistar);



    }

}
