package com.example.fbs_android.controller;

import com.example.fbs_android.adapter.LvAdapterViagens;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fbs_android.model.view.ViagemListItem;

import java.util.ArrayList;

public class ViagensActivity extends AppCompatActivity {
    ListView Viagens;
    ProgressBar pBar;
    ArrayList<ViagemListItem> viagens; // Crio um array de que tipo aqui?
    LvAdapterViagens adapter;


}
