package com.rightside.e_agenda.natividadeView.gerenciamentoLanchonete;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.rightside.e_agenda.R;
import com.rightside.e_agenda.natividadeView.lanchonete.LanchoneteNatActivity;
import com.rightside.e_agenda.utils.GerenciaLanchoneteUtils;
import com.rightside.e_agenda.view.CidadeActivity;

public class GerenciaLancNatActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerencia_lanc_nat);

        //TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GerenciaLanchoneteUtils.replace(GerenciaLancNatActivity.this, new GerenciaLancNatFragment());


        }


    }