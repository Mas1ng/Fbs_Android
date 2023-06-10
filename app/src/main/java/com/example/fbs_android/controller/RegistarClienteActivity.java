package com.example.fbs_android.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;
import com.example.fbs_android.dto.ClienteDto;
import com.example.fbs_android.dto.ClienteListDto;
import com.example.fbs_android.dto.ErrorDto;
import com.example.fbs_android.dto.Mapper;
import com.example.fbs_android.helper.Response;
import com.example.fbs_android.helper.Utils;
import com.example.fbs_android.model.Cliente;
import com.example.fbs_android.model.Data;
import com.example.fbs_android.model.Fbs;
import com.example.fbs_android.model.view.ClienteList;
import com.example.fbs_android.network.*;
import com.example.fbs_android.xml.XmlHandler;

public class RegistarClienteActivity extends AppCompatActivity {
    ProgressBar pbar;
    TextView nomeRegistar, ccRegistar,emailRegistar,passRegistar;
    DatePicker dataBirthday;
    Button btnRegistarC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main_cliente);

        nomeRegistar = findViewById(R.id.nomeRegistar);
        ccRegistar = findViewById(R.id.ccRegistar);
        emailRegistar = findViewById(R.id.emailRegistar);
        passRegistar = findViewById(R.id.iniciarSessaoPass);

        dataBirthday = (DatePicker) findViewById(R.id.dataBirthday);

        btnRegistarC = findViewById(R.id.btnLoginC);
        btnRegistarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exceptionMessage = "";
                boolean exception = false;

                String nome;
                String email;
                String pass;
                long cc;
                Data data = null;
                try {
                    nome = nomeRegistar.getText().toString();
                    cc = Long.parseLong(ccRegistar.getText().toString());
                    email = emailRegistar.getText().toString();
                    pass = passRegistar.getText().toString();
                    data = new Data(dataBirthday.getDayOfMonth(), dataBirthday.getMonth(), dataBirthday.getYear());
                    Cliente cliente = new Cliente(email, nome, data,cc,pass);
                    postCliente2WS(cliente);
                }catch (Exception e){
                    exceptionMessage = e.getMessage();
                    exception = true;
                    Toast.makeText(RegistarClienteActivity.this,"Dados errados, tenta te registar de novo.",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistarClienteActivity.this, LoginRegisterActivity.class);
                    startActivity(intent);
                }

                if(exception == false) {
                    Intent intent = new Intent();
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                    Toast.makeText(RegistarClienteActivity.this,"Inciar Sessão",Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(RegistarClienteActivity.this, LoginClienteActivity.class);
                    startActivity(intent2);
                }else{
                    Toast.makeText(RegistarClienteActivity.this,exceptionMessage,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setErrorOnUi(String message) {
        Toast.makeText(RegistarClienteActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void postCliente2WS(Cliente cliente) {
        String address = Utils.getWSAddress(this);
        String uri = address + "/clientes";
        ClienteDto dto = Mapper.cliente2ClienteDto(cliente);
        final String body = XmlHandler.serializeClienteDto2XML(dto);

        new Thread() {
            public void run() {
                Response response = null;
                HttpRequest httpRequest = new HttpRequest(HttpRequestType.POST, uri, body);
                HttpResponse httpResponse = HttpConnection.makeRequest(httpRequest);
                switch (httpResponse.getStatus()) {
                    case HttpStatusCode.Created:
                        response = new Response(HttpStatusCode.Created, null);
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
                                case HttpStatusCode.Created:
                                    //there is nothing to do
                                    break;
                                case HttpStatusCode.Conflict:
                                    if (object instanceof String) {
                                        String message = (String) object;
                                        setErrorOnUi(message);
                                    }
                                    break;
                                default:
                                    setErrorOnUi(Utils.UNKNOWN_ACTION);
                                    break;
                            }
                        }
                    }
                });
             }
        }.start();
    }

    private void getClientesFromWS(){
        pbar.setVisibility(ProgressBar.VISIBLE);
        String address = Utils.getWSAddress(this);
        String uri = address+"/clientes";
        final String body="";
        new Thread() {
            public void run() {
                Response response = null;
                HttpRequest httpRequest = new HttpRequest(HttpRequestType.GET,uri,body);
                HttpResponse httpResponse = HttpConnection.makeRequest(httpRequest);
                switch (httpResponse.getStatus()){
                    case  HttpStatusCode.OK:
                        ClienteListDto dto = XmlHandler.deSerializeXML2ClienteListDto(httpResponse.getBody());
                        ClienteList data = Mapper.clienteListDto2ClienteList(dto);
                        response = new Response(HttpStatusCode.OK, data);
                        break;
                    case  HttpStatusCode.Conflict:
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
                            switch (result.getStatus()){
                                case  HttpStatusCode.OK:
                                    if(object instanceof ClienteList) {
                                        ClienteList data = (ClienteList)object;
                                        //setDataOnUi(data);
                                    }
                                    break;
                                case  HttpStatusCode.Conflict:
                                    if(object instanceof String) {
                                        String message = (String) object;
                                        setErrorOnUi(message);
                                    }
                                    break;
                                default:
                                    Toast.makeText(RegistarClienteActivity.this, Utils.UNKNOWN_ACTION,Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                    }
                });
            }
        }.start();
    }

}
