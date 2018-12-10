package com.rightside.e_agenda.natividadeView.lanchonete;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rightside.e_agenda.utils.LanchoneteUtils;
import com.rightside.e_agenda.view.CidadeActivity;
import com.rightside.e_agenda.R;

public class LanchoneteNatActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanchonete_natividade);

        //TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        LanchoneteUtils.replace(LanchoneteNatActivity.this, new LanchonetesNatFragment());

    }

    @Override
    public void onBackPressed() {
        if (souAdmin()){


        }else{

        super.onBackPressed();
    }
    }

    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //Esconder um item do toolbar nessa activity
        menu.findItem(R.id.action_admin).setVisible(false);
        menu.findItem(R.id.action_contate).setVisible(false);
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
            AlertDialog.Builder alerta = new AlertDialog.Builder(LanchoneteNatActivity.this);
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
                            Intent chamatela = new Intent(LanchoneteNatActivity.this,CidadeActivity.class);
                            startActivity(chamatela);
                        }
                    });

            AlertDialog alertDialog = alerta.create();
            alertDialog.show();
        }



        if (id == R.id.action_add) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(LanchoneteNatActivity.this);
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
                            Intent chamatela = new Intent(LanchoneteNatActivity.this,CadastroLanchoneteNatActivity.class);
                            startActivity(chamatela);
                        }
                    });

            AlertDialog alertDialog = alerta.create();
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
         // notaAdapter.atualiza(BancoDeDados.getInstance().getDisciplinas());
    }

    public boolean souAdmin(){
        SharedPreferences editor = getSharedPreferences("preferencia", MODE_PRIVATE);
        return editor.getBoolean("isAdmin", false);
    }

}
