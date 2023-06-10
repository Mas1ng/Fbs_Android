package com.example.fbs_android.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.R;
import com.example.fbs_android.adapter.LvAdapterBilhetes;
import com.example.fbs_android.dto.BilheteItemListDto;
import com.example.fbs_android.dto.BilheteListNumLugarDto;
import com.example.fbs_android.dto.ErrorDto;
import com.example.fbs_android.dto.Mapper;
import com.example.fbs_android.helper.Response;
import com.example.fbs_android.helper.Utils;
import com.example.fbs_android.model.Bilhete;
import com.example.fbs_android.model.BilheteList;
import com.example.fbs_android.model.view.ViagemListItem;
import com.example.fbs_android.network.*;
import com.example.fbs_android.xml.XmlHandler;

import java.util.ArrayList;

public class BilhetesItemActivity extends AppCompatActivity {
    ProgressBar pBar;
    ListView osbilhetes;
    ArrayList<Bilhete> bilhetes;
    LvAdapterBilhetes adapter;
    ActivityResultLauncher<Intent> studentActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        long cc = bundle.getLong("cc");
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            getBilhetesItemFromWS(cc);
                        }
                    }
                }
            });

    private void setErrorOnUi(String message) {
        Toast.makeText(BilhetesItemActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void setDataOnUi(BilheteList data) {
        adapter.setItems(data.getBilhetes());
        adapter.notifyDataSetChanged();
    }

    private void getBilhetesItemFromWS(long cc) {
        pBar.setVisibility(ProgressBar.VISIBLE);
        String address = Utils.getWSAddress(this);
        String uri = address + "/bilhetes" + "/" + cc;
        final String body = "";
        new Thread() {
            public void run() {
                Response response = null;
                HttpRequest httpRequest = new HttpRequest(HttpRequestType.GET, uri, body);
                HttpResponse httpResponse = HttpConnection.makeRequest(httpRequest);
                switch (httpResponse.getStatus()) {
                    case HttpStatusCode.OK:
                        BilheteItemListDto  dto = XmlHandler.deSerializeXML2BilheteItemListDto(httpResponse.getBody());
                        BilheteList data = Mapper.bilheteItemListDto2BilheteList(dto);
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
                                    if (object instanceof BilheteList) {
                                        BilheteList data = (BilheteList) object;
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
                                    Toast.makeText(BilhetesItemActivity.this, Utils.UNKNOWN_ACTION, Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                        pBar.setVisibility(ProgressBar.GONE);
                    }
                });
            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_viagem_main);
        Intent t = getIntent();
        String email = t.getStringExtra(Intent.EXTRA_TEXT);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        long cc = bundle.getLong("cc");
            pBar = (ProgressBar) findViewById(R.id.pBar);
            pBar.setVisibility(ProgressBar.INVISIBLE);

            osbilhetes = (ListView) findViewById(R.id.asviagens);
            bilhetes = new ArrayList<Bilhete>(); //como é que o array de estudantes fica preenchido? e se é do tipo StudentListItem como pode ter os detalhes da data de nascimento?
            adapter = new LvAdapterBilhetes(this, R.layout.listview_bilhetes, bilhetes);
            osbilhetes.setAdapter(adapter);
            osbilhetes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(BilhetesItemActivity.this, "Click: details", Toast.LENGTH_SHORT).show();
                    Bilhete items = (Bilhete) adapter.getItem(i);
                    String nomeViagem = items.getNomeViagem();
                    int numLugar = items.getNumLugar();
                    Intent intent = new Intent(BilhetesItemActivity.this, BilheteActivity.class);
                    Bundle extras = new Bundle();
                    extras.putString("mail", email);
                    extras.putString("nomeViagem",nomeViagem);
                    extras.putInt("numLugar", numLugar);
                    studentActivityLauncher.launch(intent);
                }
            });
            getBilhetesItemFromWS(cc);
    }
}
