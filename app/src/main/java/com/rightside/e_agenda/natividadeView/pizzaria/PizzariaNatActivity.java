package com.rightside.e_agenda.natividadeView.pizzaria;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rightside.e_agenda.natividadeView.lanchonete.CadastroLanchoneteNatActivity;
import com.rightside.e_agenda.view.CidadeActivity;
import com.rightside.e_agenda.R;

public class PizzariaNatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzaria_natividade);

        //TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }











    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //Esconder um item do toolbar nessa activity
        menu.findItem(R.id.action_admin).setVisible(false);
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
            AlertDialog.Builder alerta = new AlertDialog.Builder(PizzariaNatActivity.this);
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
                            Intent chamatela = new Intent(PizzariaNatActivity.this,CadastroLanchoneteNatActivity.class);
                            startActivity(chamatela);
                        }
                    });

            AlertDialog alertDialog = alerta.create();
            alertDialog.show();
        }


        if (id == R.id.action_add) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(PizzariaNatActivity.this);
            alerta.setTitle("Aviso");
            alerta  .setIcon(R.drawable.ic_aviso)
                    .setMessage("Você tem uma empresa que não está no app e quer adiciona-la?")
                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Intent chamatela = new Intent(PizzariaNatActivity.this,CidadeActivity.class);
                            startActivity(chamatela);
                        }
                    });

            AlertDialog alertDialog = alerta.create();
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

}


