package com.rightside.e_agenda.natividadeView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rightside.e_agenda.natividadeView.gerenciamentoLanchonete.GerenciaDetLancNatActivity;
import com.rightside.e_agenda.natividadeView.gerenciamentoLanchonete.GerenciaLancNatActivity;
import com.rightside.e_agenda.natividadeView.lanchonete.LanchoneteNatActivity;
import com.rightside.e_agenda.natividadeView.farmacia.FarmaciaNatActivity;
import com.rightside.e_agenda.natividadeView.pizzaria.PizzariaNatActivity;
import com.rightside.e_agenda.view.CidadeActivity;
import com.rightside.e_agenda.R;
import com.rightside.e_agenda.view.ContateActivity;

public class SegmentosNatActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segmentos_natividade);

        //TOOLBAR//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //BOTOES
        Button botaoLanchonete = (Button) findViewById(R.id.buttonLanchonetes);
        Button botaoFarmacias = (Button) findViewById(R.id.buttonFarmacias);
        Button botaoPizzarias = (Button) findViewById(R.id.buttonPizzarias);


        //BOTÃO LANCHONETE
        botaoLanchonete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SegmentosNatActivity.this,LanchoneteNatActivity.class));

            }
        });

        //BOTÃO PIZZARIA
        botaoPizzarias.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(SegmentosNatActivity.this);
                alerta.setTitle("ATENÇÃO");
                alerta.setMessage("Essa categoria estará liberada em breve!");
                alerta.setNeutralButton("VOLTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alerta.show();

            }
        });

        //BOTÃO FARMACIA
        botaoFarmacias.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(SegmentosNatActivity.this);
                alerta.setTitle("ATENÇÃO");
                alerta.setMessage("Essa categoria estará liberada em breve!");
                alerta.setNeutralButton("VOLTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alerta.show();

            }
        });



    }




    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //Esconder um item do toolbar nessa activity
        menu.findItem(R.id.action_add).setVisible(false);
        return true;
    }

    //OPÇÕES DOS ITENS DO MENU//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_volteascidades) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(SegmentosNatActivity.this);
            alerta.setTitle("Aviso");
            alerta  .setIcon(R.drawable.ic_aviso)
                    .setMessage("Escolher outra cidade?")
                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Intent chamatela = new Intent(SegmentosNatActivity.this,CidadeActivity.class);
                            startActivity(chamatela);
                        }
                    });

            AlertDialog alertDialog = alerta.create();
            alertDialog.show();

        }

        if (id == R.id.action_admin) {
            Intent intent = new Intent(this, LoginAdminActivity.class);
            startActivity(intent);

        }

        if (id == R.id.action_contate){
            Intent intent = new Intent(SegmentosNatActivity.this, ContateActivity.class);
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }






    //SE APERTAR VOLTAR ABRE ALERT DIALOG
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alerta = new AlertDialog.Builder(SegmentosNatActivity.this);
        alerta.setTitle("Aviso");
        alerta  .setIcon(R.drawable.ic_aviso)
                .setMessage("Escolher outra cidade?")
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent chamatela = new Intent(SegmentosNatActivity.this,CidadeActivity.class);
                        startActivity(chamatela);
                    }
                });

        AlertDialog alertDialog = alerta.create();
        alertDialog.show();




    }
}
