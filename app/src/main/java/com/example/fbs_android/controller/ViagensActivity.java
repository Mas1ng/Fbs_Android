package com.example.fbs_android.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.example.fbs_android.R;
import com.example.fbs_android.adapter.LvAdapterViagens;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.dto.ErrorDto;
import com.example.fbs_android.dto.Mapper;
import com.example.fbs_android.dto.ViagemListDto;
import com.example.fbs_android.helper.Response;
import com.example.fbs_android.helper.Utils;
import com.example.fbs_android.model.view.ViagemList;
import com.example.fbs_android.model.view.ViagemListItem;
import com.example.fbs_android.network.*;
import com.example.fbs_android.xml.XmlHandler;

import java.util.ArrayList;

public class ViagensActivity extends AppCompatActivity {
    ListView Viagens;
    ProgressBar pBar;
    ArrayList<ViagemListItem> viagens; // Crio um array de que tipo aqui?
    LvAdapterViagens adapter;
    ActivityResultLauncher<Intent> studentActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        getStudentsFromWS();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagem_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        pBar = (ProgressBar) findViewById(R.id.pBar);
        pBar.setVisibility(ProgressBar.INVISIBLE);

        lvViagens = (ListView) findViewById(R.id.asviagens);
        viagens = new ArrayList<ViagemListItem>(); //como é que o array de estudantes fica preenchido? e se é do tipo StudentListItem como pode ter os detalhes da data de nascimento?
        adapter = new LvAdapterViagens(this, R.layout.listview_viagens, viagens);
        lvViagens.setAdapter(adapter);

        registerForContextMenu(lvViagens);
        lvViagens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ViagensActivity.this, "Click: details", Toast.LENGTH_SHORT).show();
                ViagemListItem studentListItem = (ViagemListItem) adapter.getItem(i);
                Intent intent = new Intent(ViagensActivity.this, ItemViagemActivity.class);
                /*intent.putExtra(Utils.MODE,Utils.ACTIVITY_MODE_DETAILS); // que extra é este??
                intent.putExtra(Utils.ID, viagemListItem.getdataPartida());
                intent.putExtra(Utils.ID, viagemListItem.getdataChegada());
                intent.putExtra(Utils.ID, viagemListItem.getName());*/
                studentActivityLauncher.launch(intent);
            }
        });
        getStudentsFromWS();
    }

    private void setDataOnUi(ViagemList data) {
        adapter.setItems(data.getViagens());
        adapter.notifyDataSetChanged();
    }

    private void setErrorOnUi(String message) {
        Toast.makeText(ViagensActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void getStudentsFromWS() {
        pBar.setVisibility(ProgressBar.VISIBLE);
        String address = Utils.getWSAddress(this);
        String uri = address + "/students";
        final String body = "";
        new Thread() {
            public void run() {
                Response response = null;
                HttpRequest httpRequest = new HttpRequest(HttpRequestType.GET, uri, body);
                HttpResponse httpResponse = HttpConnection.makeRequest(httpRequest);
                switch (httpResponse.getStatus()) {
                    case HttpStatusCode.OK:
                        ViagemListDto dto = XmlHandler.deSerializeXML2ViagemListDto(httpResponse.getBody());
                        ViagemList data = Mapper.viagemListDto2ViagemList(dto);
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
                                    if (object instanceof ViagemList) {
                                        ViagemList data = (ViagemList) object;
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
                                    Toast.makeText(ViagensActivity.this, Utils.UNKNOWN_ACTION, Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                        pBar.setVisibility(ProgressBar.GONE);
                    }
                });
            }
        }.start();
    }

}
