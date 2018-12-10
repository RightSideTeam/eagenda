package com.rightside.e_agenda.natividadeView.lanchonete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.rightside.e_agenda.R;
import com.rightside.e_agenda.modelo.GerenciaLanchoneteNatividade;

public class DetalhesLanchoneteNatActivity extends AppCompatActivity {


    private TextView txtViewNomeLanchonete;
    private TextView txtViewLocalLanchonete;
    private TextView txtViewTelefoneLanchonete;
    private TextView txtViewWppLanchonete;
    private TextView txtViewHorarioLanchonete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_lanchonete_nat);

        //TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        txtViewNomeLanchonete = findViewById(R.id.txt_detalhe_nome_empresa);
        txtViewLocalLanchonete = findViewById(R.id.txt_detalhe_local_empresa);
        txtViewTelefoneLanchonete = findViewById(R.id.txt_detalhe_telefone_empresa);
        txtViewWppLanchonete = findViewById(R.id.txt_detalhe_wpp_empresa);
        txtViewHorarioLanchonete = findViewById(R.id.txt_detalhe_horario_empresa);


        GerenciaLanchoneteNatividade lanchonete = (GerenciaLanchoneteNatividade) getIntent().getSerializableExtra("lanchonetesNat");

        txtViewNomeLanchonete.setText(lanchonete.getLanchoneteNome());
        txtViewLocalLanchonete.setText(lanchonete.getLanchoneteLocal());
        txtViewTelefoneLanchonete.setText(lanchonete.getLanchoneteTelefone());
        txtViewWppLanchonete.setText(lanchonete.getLanchoneteWhats());
        txtViewHorarioLanchonete.setText(lanchonete.getLanchoneteHorario());






    }


}