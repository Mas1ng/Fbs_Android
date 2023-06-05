package com.example.fbs_android;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
/*import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;*/
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.controller.ClienteMainActivity;
import com.example.fbs_android.controller.LoginAdminActivity;
import com.example.fbs_android.controller.LoginClienteActivity;
import com.example.fbs_android.controller.SettingsActivity;
import com.example.fbs_android.dto.ErrorDto;
import com.example.fbs_android.dto.FbsDto;
import com.example.fbs_android.dto.Mapper;
import com.example.fbs_android.helper.Response;
import com.example.fbs_android.helper.Utils;
import com.example.fbs_android.model.Fbs;
import com.example.fbs_android.network.*;
import com.example.fbs_android.xml.XmlHandler;

import static androidx.core.content.ContextCompat.startActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btcliente, btadmin, btWsAddress;
    ProgressBar pb;
    private static final String TAG="MainActivity:";

    ActivityResultLauncher<Intent> settingsActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        getFBSInfoFromWS();
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);
        pb.setVisibility(ProgressBar.INVISIBLE);
        tv= findViewById(R.id.tvw);
       btcliente= findViewById(R.id.client);
       btcliente.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,"Login Clientes",Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(MainActivity.this, ClienteMainActivity.class);
               startActivity(intent);
           }
       });
        btadmin= findViewById(R.id.admin);
        btadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Login Admin",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LoginAdminActivity.class);
                startActivity(intent);
            }
        });
        btWsAddress = (Button) findViewById(R.id.btWsAddress);
        btWsAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Settings",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                settingsActivityLauncher.launch(intent);
            }
        });
        getFBSInfoFromWS();
    }
    private void setDataOnUi(Fbs data){
        tv.setText(data.getNome());
    }
    private void setErrorOnUi(String message){
        tv.setText(message);
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
    }
    private void getFBSInfoFromWS() {
        pb.setVisibility(ProgressBar.VISIBLE);
        String adress = Utils.getWSAddress(this);
        String uri = adress + "/fbs"; // é o segundo request mapping
        final String body = "";
        new Thread() {
            public void run() {
                Response response = null;
                HttpRequest httpRequest = new HttpRequest(HttpRequestType.GET, uri, body); // visto ser um método get o body vai vazio
                HttpResponse httpResponse = HttpConnection.makeRequest(httpRequest);
                switch (httpResponse.getStatus()) {
                    case HttpStatusCode.OK:
                        FbsDto dto = XmlHandler.deSerializeXML2FbsDto(httpResponse.getBody());
                        Fbs fbs = Mapper.fbsDto2Fbs(dto);
                        response = new Response ( HttpStatusCode.OK, fbs);
                        break;
                    case HttpStatusCode.Conflict:
                        ErrorDto error = XmlHandler.deSerializeXML2ErrorDto(httpResponse.getBody());
                        response = new Response(HttpStatusCode.Conflict, error.getMsg());
                        break;
                }
                final Response result = response;
                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        if(result!=null){
                            Object object = result.getBody();
                            switch(result.getStatus()){
                                case HttpStatusCode.OK:
                                    if(object instanceof Fbs){
                                        Fbs data = (Fbs)object;
                                        setDataOnUi(data);
                                    }
                                    break;

                                case  HttpStatusCode.Conflict:
                                    if(object instanceof String) {
                                        String message = (String) object;
                                        setErrorOnUi(message);
                                    }
                                    break;
                                default:
                                    Toast.makeText(MainActivity.this, Utils.UNKNOWN_ACTION,Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                        pb.setVisibility(ProgressBar.GONE);
                    }
               });
            }
        }.start();
    }
}