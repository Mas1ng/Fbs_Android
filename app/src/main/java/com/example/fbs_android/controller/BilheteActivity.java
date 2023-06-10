package com.example.fbs_android.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;
import com.example.fbs_android.dto.*;
import com.example.fbs_android.helper.Response;
import com.example.fbs_android.helper.Utils;
import com.example.fbs_android.model.Bilhete;
import com.example.fbs_android.model.BilheteList;
import com.example.fbs_android.model.NumLugarNomeViagem;
import com.example.fbs_android.network.*;
import com.example.fbs_android.xml.XmlHandler;

public class BilheteActivity extends AppCompatActivity {
    ProgressBar pBar;
    EditText etNome, etCC, etTBilhete, etTPassageiro, etPreco, etNumLugar, etExtras;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilhete);
        Intent t = getIntent();
        Bundle extras = t.getExtras();
        String nomeViagem = extras.getString("nomeViagem");
        String email = extras.getString("email");
        int numLugar = extras.getInt("numLugar");
        pBar= findViewById(R.id.pBar);
        etNome=findViewById(R.id.etNome);
        etTBilhete=findViewById(R.id.etTBilhete);
        etTPassageiro=findViewById(R.id.etTPassageiro);
        etPreco=findViewById(R.id.etPreco);
        etNumLugar=findViewById(R.id.etNumLugar);
        etExtras=findViewById(R.id.etExtras);
        NumLugarNomeViagem n= new NumLugarNomeViagem(numLugar, nomeViagem);
        getBilheteFromWS(email, n);

    }

    private void getBilheteFromWS(String email, NumLugarNomeViagem arg) {
        pBar.setVisibility(ProgressBar.VISIBLE);
        String address = Utils.getWSAddress(this);
        String uri = address + "/bilhetes" + "/" + email;
        NumLugarNomeViagemDto dto = Mapper.numLugarNomeviagem2NumLugarNomeViagemDto(arg);
        final String body = XmlHandler.serializeNumLugarNomeViagemDto2XML(dto);// neste vou ter de mandar um body do tipo NumLugarNomeViagemDto
        new Thread() {
            public void run() {
                Response response = null;
                HttpRequest httpRequest = new HttpRequest(HttpRequestType.GET, uri, body);
                HttpResponse httpResponse = HttpConnection.makeRequest(httpRequest);
                switch (httpResponse.getStatus()) {
                    case HttpStatusCode.OK:
                        BilheteNumLugarDto dto = XmlHandler.deSerializeXML2BilheteNumLugarDto(httpResponse.getBody());
                        Bilhete data = Mapper.bilheteNumLugarDto2Bilhete(dto);
                        response = new Response(HttpStatusCode.OK, data);
                        break;
                    case HttpStatusCode.Conflict:
                        ErrorDto error = XmlHandler.deSerializeXML2ErrorDto(httpResponse.getBody());
                        response = new Response(HttpStatusCode.Conflict, error.getMsg());
                        break;
                }
                final Response result = response;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null) {
                            Object object = result.getBody();
                            switch (result.getStatus()) {
                                case HttpStatusCode.OK:
                                    if (object instanceof Bilhete) {
                                        Bilhete data = (Bilhete) object;
                                        setDataOnUi(data);
                                    }
                                    break;
                                case HttpStatusCode.Conflict:
                                    if (object instanceof String) {
                                        String message = (String) object;
                                        setErrorOnUi(message);
                                    }
                                    break;
                                default:
                                    Toast.makeText(BilheteActivity.this, Utils.UNKNOWN_ACTION, Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                        pBar.setVisibility(ProgressBar.GONE);
                    }
                });
            }
        }.start();
    }
    private void setErrorOnUi(String message) {
        Toast.makeText(BilheteActivity.this, message, Toast.LENGTH_LONG).show();
    }
    private void setDataOnUi(Bilhete b){

    }

}
