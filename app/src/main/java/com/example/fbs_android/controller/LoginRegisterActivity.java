package com.example.fbs_android.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;

public class LoginRegisterActivity extends AppCompatActivity {

    Button btnIniciarSessao, btnRegistar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register_cliente_activity);

        btnIniciarSessao = findViewById(R.id.btnIniciarSessao);
        btnIniciarSessao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginRegisterActivity.this,"Inciar Sessão",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginRegisterActivity.this, LoginClienteActivity.class);
                startActivity(intent);
            }
        });
        btnRegistar = findViewById(R.id.btnRegistar);
        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginRegisterActivity.this,"Registar",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginRegisterActivity.this, RegistarClienteActivity.class);
                startActivity(intent);
            }
        });
    }
}
