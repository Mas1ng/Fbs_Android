package com.example.fbs_android.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;

public class LoginClienteActivity extends AppCompatActivity {
    TextView tv;
    Button bt;

    ProgressBar pb;
    EditText passe, mail;
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_cliente_main);

    pb=findViewById(R.id.pb);
    pb.setVisibility(ProgressBar.INVISIBLE);
    tv= findViewById(R.id.tv);
    mail= findViewById(R.id.nomeRegistar);
    passe=findViewById(R.id.passRegistar);
    bt=findViewById(R.id.btnRegistarC);
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
