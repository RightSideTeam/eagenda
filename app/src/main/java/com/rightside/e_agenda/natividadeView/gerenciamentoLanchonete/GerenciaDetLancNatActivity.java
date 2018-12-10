package com.rightside.e_agenda.natividadeView.gerenciamentoLanchonete;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rightside.e_agenda.R;
import com.rightside.e_agenda.modelo.GerenciaLanchoneteNatividade;
import com.rightside.e_agenda.natividadeView.lanchonete.CadastroLanchoneteNatActivity;

public class GerenciaDetLancNatActivity extends AppCompatActivity {

    private TextView editTextNomeLanchonete;
    private TextView editTextLocalLanchonete;
    private TextView editTextTelefoneLanchonete;
    private TextView editTextWppLanchonete;
    private TextView editTextHorarioLanchonete;
    private TextView editTextEmailLanchonete;
    private Button buttonAceitar;
    private GerenciaLanchoneteNatividade lanchoneteNatividade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerencia_det_lanc_nat);

        //TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        lanchoneteNatividade = (GerenciaLanchoneteNatividade) getIntent().getSerializableExtra("lanchonetesNat");

        editTextNomeLanchonete = findViewById(R.id.edit_gerencia_nome_lanchonete);
        editTextLocalLanchonete = findViewById(R.id.edit_gerencia_local_lanchonete);
        editTextTelefoneLanchonete = findViewById(R.id.edit_gerencia_telefone_lanchonete);
        editTextWppLanchonete = findViewById(R.id.edit_gerencia_wpp_lanchonete);
        editTextHorarioLanchonete = findViewById(R.id.edit_gerencia_hora_lanchonete);
        editTextEmailLanchonete = findViewById(R.id.edit_gerencia_email_lanchonete);


        GerenciaLanchoneteNatividade lanchonete = (GerenciaLanchoneteNatividade) getIntent().getSerializableExtra("gerenciaLanchoneteNat");


        buttonAceitar = findViewById(R.id.buttonAceitar);



        buttonAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (capturaDados()) {

                    SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_config), Context.MODE_PRIVATE);
                    String id = sharedPreferences.getString(getString(R.string.id), "");

                    DatabaseReference myRef = database.getReference("lanchonetesNat");
                    myRef.child(id).push().setValue(lanchoneteNatividade).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(GerenciaDetLancNatActivity.this);
                            alerta.setTitle("Avaliar lanchonete");
                            alerta.setMessage("Lanchonete adicionada com sucesso!");
                            alerta.setNeutralButton("VOLTAR", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                            alerta.show();
                        }
                    });


                }
            }
        });


        editTextNomeLanchonete.setText(lanchonete.getLanchoneteNome());
        editTextLocalLanchonete.setText(lanchonete.getLanchoneteLocal());
        editTextTelefoneLanchonete.setText(lanchonete.getLanchoneteTelefone());
        editTextWppLanchonete.setText(lanchonete.getLanchoneteWhats());
        editTextHorarioLanchonete.setText(lanchonete.getLanchoneteHorario());
        editTextEmailLanchonete.setText(lanchonete.getLanchoneteEmail());

    }

    public boolean capturaDados() {
        String nomeLanchonete = editTextNomeLanchonete.getText().toString();
        String localLanchonete = editTextLocalLanchonete.getText().toString();
        String telefoneLanchonete = editTextTelefoneLanchonete.getText().toString();
        String whatsLanchonete = editTextWppLanchonete.getText().toString();
        String horarioLanchonete = editTextHorarioLanchonete.getText().toString();
        String emailLanchonete = editTextEmailLanchonete.getText().toString();



        lanchoneteNatividade = new GerenciaLanchoneteNatividade();
        lanchoneteNatividade.setLanchoneteNome(nomeLanchonete);
        lanchoneteNatividade.setLanchoneteLocal(localLanchonete);
        lanchoneteNatividade.setLanchoneteTelefone(telefoneLanchonete);
        lanchoneteNatividade.setLanchoneteWhats(whatsLanchonete);
        lanchoneteNatividade.setLanchoneteHorario(horarioLanchonete);
        lanchoneteNatividade.setLanchoneteEmail(emailLanchonete);


        return true;
    }
}

