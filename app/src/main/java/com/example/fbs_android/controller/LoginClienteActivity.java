package com.example.fbs_android.controller;

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
import com.example.fbs_android.model.view.ClienteList;
import com.example.fbs_android.network.*;
import com.example.fbs_android.xml.XmlHandler;

public class LoginClienteActivity extends AppCompatActivity {
    EditText mail, pass;
    Button btnLoginC;
    ProgressBar pb;
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_cliente_main);
    pb=findViewById(R.id.pb);
    mail=findViewById(R.id.email);
    pass=findViewById(R.id.pass);
    String email= mail.toString();
    String passe = pass.toString();
    getClienteFromWs(email,passe);
    btnLoginC= findViewById(R.id.btnLoginC);
    btnLoginC.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(LoginClienteActivity.this,"Menu Clientes",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginClienteActivity.this, ClienteMainActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, mail.toString());
            long cc = getCCFromClienteFromWs( mail.toString());
            Bundle bundle = new Bundle();
            bundle.putLong("cc", cc);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    });
    }
    public void getClienteFromWs(String email, String pass){
        pb.setVisibility(ProgressBar.VISIBLE);
        String adress = Utils.getWSAddress(this);
        String uri = adress+"/students"+"/"+email;
        final String body ="";
        new Thread() {
            public void run() {
                Response response = null;
                HttpRequest httpRequest = new HttpRequest(HttpRequestType.GET,uri,body);
                HttpResponse httpResponse = HttpConnection.makeRequest(httpRequest);
                switch (httpResponse.getStatus()){
                    case  HttpStatusCode.OK:
                        ClienteDto dto = XmlHandler.deSerializeXML2ClienteDto(httpResponse.getBody());
                        Cliente data = Mapper.clienteDto2Cliente(dto);
                        String passV = data.getPass();
                        long cc = data.getCc();
                        if(passV.equals(pass))
                        {
                            response = new Response(HttpStatusCode.OK, data);
                        }
                        else{
                            ErrorDto error = XmlHandler.deSerializeXML2ErrorDto(httpResponse.getBody());
                            response = new Response(HttpStatusCode.Conflict, error.getMsg());
                        }
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
                                    if(object instanceof Cliente) {
                                        Cliente data = (Cliente)object;
                                    }
                                    break;
                                case  HttpStatusCode.Conflict:
                                    if(object instanceof String) {
                                        String message = (String) object;
                                        setErrorOnUi(message);
                                    }
                                    break;
                                default:
                                    Toast.makeText(LoginClienteActivity.this, Utils.UNKNOWN_ACTION,Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                        pb.setVisibility(ProgressBar.GONE);
                    }
                });
            }
        }.start();
    }
    public long getCCFromClienteFromWs(String email){
        String adress = Utils.getWSAddress(this);
        String uri = adress+"/students"+"/"+email;
        final String body ="";
        Response response = null;
        HttpRequest httpRequest = new HttpRequest(HttpRequestType.GET,uri,body);
        HttpResponse httpResponse = HttpConnection.makeRequest(httpRequest);
        ClienteDto dto = XmlHandler.deSerializeXML2ClienteDto(httpResponse.getBody());
        Cliente data = Mapper.clienteDto2Cliente(dto);
        long cc = data.getCc();
        return cc;
    }
    private void setErrorOnUi(String message){
        Toast.makeText(LoginClienteActivity.this,message,Toast.LENGTH_LONG).show();
    }
}

