package com.example.fbs_android.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;

public class LoginClienteActivity extends AppCompatActivity {
    TextView iniciarSessaoEmail,iniciarSessaoPass;
    Button btnLoginC;

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_cliente_main);


    bt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(LoginClienteActivity.this,"Menu Clientes",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginClienteActivity.this, ClienteMainActivity.class);
            startActivity(intent);
        }
    });

}
}
