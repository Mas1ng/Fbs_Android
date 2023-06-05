package com.example.fbs_android.controller;

import adapter.LvAdapterViagens;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.MainActivity;
import com.example.fbs_android.dto.ErrorDto;
import com.example.fbs_android.dto.Mapper;
import com.example.fbs_android.dto.ViagemListDto;
import com.example.fbs_android.helper.Response;
import com.example.fbs_android.helper.Utils;
import com.example.fbs_android.model.Fbs;
import com.example.fbs_android.model.Viagem;
import com.example.fbs_android.model.view.ViagemList;
import com.example.fbs_android.model.view.ViagemListItem;
import com.example.fbs_android.network.*;
import com.example.fbs_android.xml.XmlHandler;
import androidx.activity.result.ActivityResultLauncher;

import java.util.ArrayList;

public class ViagensActivity extends AppCompatActivity {
    ListView Viagens;
    ProgressBar pBar;
    ArrayList<ViagemListItem> viagens; // Crio um array de que tipo aqui?
    LvAdapterViagens adapter;


}
