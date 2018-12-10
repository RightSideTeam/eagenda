package com.rightside.e_agenda.natividadeView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rightside.e_agenda.R;
import com.rightside.e_agenda.natividadeView.farmacia.FarmaciaNatActivity;
import com.rightside.e_agenda.natividadeView.gerenciamentoLanchonete.GerenciaLancNatActivity;
import com.rightside.e_agenda.natividadeView.lanchonete.LanchoneteNatActivity;
import com.rightside.e_agenda.natividadeView.pizzaria.PizzariaNatActivity;

public class GerenciaSegmentosNatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerencia_segmentos);

        //TOOLBAR//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //BOTOES
        Button botaoLanchonete = (Button) findViewById(R.id.buttonGerenciaLanchonetes);
        Button botaoFarmacias = (Button) findViewById(R.id.buttonGerenciaFarmacias);
        Button botaoPizzarias = (Button) findViewById(R.id.buttonGerenciaPizzarias);


        //BOTÃO LANCHONETE
        botaoLanchonete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GerenciaSegmentosNatActivity.this, GerenciaLancNatActivity.class));


            }
        });



        //BOTÃO PIZZARIA (so botar a activity no class)
       // botaoPizzarias.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View v) {
         //       startActivity(new Intent(GerenciaSegmentosNatActivity.this, .class));

           // }
       // });

        //BOTÃO FARMACIA
        //botaoFarmacias.setOnClickListener(new View.OnClickListener() {
       //     @Override
         //   public void onClick(View v) {
         //       startActivity(new Intent(GerenciaSegmentosNatActivity.this, .class));

         //   }
       // });


    }

    public void onBackPressed () {
        if (souAdmin()) {

            AlertDialog.Builder alerta = new AlertDialog.Builder(GerenciaSegmentosNatActivity.this);
            alerta.setTitle("Aviso");
            alerta  .setIcon(R.drawable.ic_aviso)
                    .setMessage("Deseja sair?")
                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            SharedPreferences.Editor editor = getSharedPreferences("preferencia", MODE_PRIVATE).edit();
                            editor.putBoolean("isAdmin", false);
                            editor.apply();

                            finish();

                            Intent intent = new Intent(GerenciaSegmentosNatActivity.this, SegmentosNatActivity.class);
                            startActivity(intent);

                        }
                    });

            AlertDialog alertDialog = alerta.create();
            alertDialog.show();


        } else {

            super.onBackPressed();
        }

    }

    public boolean souAdmin () {
        SharedPreferences editor = getSharedPreferences("preferencia", MODE_PRIVATE);
        return editor.getBoolean("isAdmin", false);
    }
}