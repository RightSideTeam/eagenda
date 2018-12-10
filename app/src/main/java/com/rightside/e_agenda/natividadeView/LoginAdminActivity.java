package com.rightside.e_agenda.natividadeView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.rightside.e_agenda.R;
import com.rightside.e_agenda.modelo.GerenciaLanchoneteNatividade;

public class LoginAdminActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        //TOOLBAR//
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        final EditText edusuario = (EditText) findViewById(R.id.usuarioLogin);
        final EditText edsenha = (EditText) findViewById(R.id.senhaLogin);

        Button fazerLogin = (Button) findViewById(R.id.buttonLogin);

        fazerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = edusuario.getText().toString();
                final String password = edsenha.getText().toString();

                if (username.equals("admin")&&password.equals("12345")){
                    alert("Login realizado com sucesso");
                    SharedPreferences.Editor editor = getSharedPreferences("preferencia", MODE_PRIVATE).edit();
                    editor.putBoolean("isAdmin", true);
                    editor.apply();

                    Intent intent = new Intent(LoginAdminActivity.this, GerenciaSegmentosNatActivity.class);
                    startActivity(intent);

                }else {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(LoginAdminActivity.this);
                    alerta.setTitle("ATENÇÃO");
                    alerta.setIcon(R.drawable.ic_aviso)
                            .setMessage("Você não é um administrador!")
                            .setNegativeButton("VOLTAR", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                }
                            });

                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();

                }

            }

        });

}

    private void  alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
