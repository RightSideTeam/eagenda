package com.rightside.e_agenda.natividadeView.lanchonete;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rightside.e_agenda.R;
import com.rightside.e_agenda.modelo.GerenciaLanchoneteNatividade;

public class CadastroLanchoneteNatActivity extends AppCompatActivity {

    private EditText editNomeLanchonete;
    private EditText editTextLocalLanchoente;
    private EditText editTextTeleofone;
    private EditText editTextWhats;
    private EditText editTextHorario;
    private EditText editTextEmail;
    private Button buttonSalvar;
    private GerenciaLanchoneteNatividade lanchoneteNatividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_lanchonete_nat);

        //TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        lanchoneteNatividade = (GerenciaLanchoneteNatividade) getIntent().getSerializableExtra("lanchoneteNat");


        editNomeLanchonete = findViewById(R.id.edit_text_nome_lanchoente);
        editTextLocalLanchoente = findViewById(R.id.edit_text_local_Lanchonete);
        editTextTeleofone = findViewById(R.id.edit_text_telefone_Lanchonete);
        editTextWhats = findViewById(R.id.edit_text_whats_Lanchonete);
        editTextHorario = findViewById(R.id.edit_text_horario_Lanchonete);
        editTextEmail = findViewById(R.id.edit_text_email_Lanchonete);

        //criar mascara para campo telefone, horario e whatsapp
        SimpleMaskFormatter smfTelefone = new SimpleMaskFormatter("(NN)NNNN-NNNN");
        MaskTextWatcher mtwTelelfone = new MaskTextWatcher(editTextTeleofone, smfTelefone);
        editTextTeleofone.addTextChangedListener(mtwTelelfone);

        SimpleMaskFormatter smfWhats = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtwWhats = new MaskTextWatcher(editTextWhats, smfWhats);
        editTextWhats.addTextChangedListener(mtwWhats);

        SimpleMaskFormatter smfHorario = new SimpleMaskFormatter("NN:NN");
        MaskTextWatcher mtwHorario = new MaskTextWatcher(editTextHorario, smfHorario);
        editTextHorario.addTextChangedListener(mtwHorario);


        // fim da mascara


        buttonSalvar = findViewById(R.id.button_salvarLanchonete);

        if(lanchoneteNatividade != null){
            editNomeLanchonete.setText(lanchoneteNatividade.getLanchoneteNome());
        }

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(capturaDados()){

                    SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_config), Context.MODE_PRIVATE);
                    String id = sharedPreferences.getString(getString(R.string.id), "");

                    DatabaseReference myRef = database.getReference("gerenciaLanchoneteNat");
                    myRef.child(id).push().setValue(lanchoneteNatividade).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastroLanchoneteNatActivity.this);
                            alerta.setTitle("Adicionar lanchonete");
                            alerta.setMessage("Obrigado pela sugestão! Sua lanchonete será avaliada!");
                            alerta.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
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
    }

    public boolean capturaDados(){
        String nomeLanchonete = editNomeLanchonete.getText().toString();
        String localLanchonete = editTextLocalLanchoente.getText().toString();
        String telefoneLanchonete = editTextTeleofone.getText().toString();
        String whatsLanchonete = editTextWhats.getText().toString();
        String horarioLanchonete = editTextHorario.getText().toString();
        String emailLanchonete = editTextEmail.getText().toString();


        if(nomeLanchonete.isEmpty()){
            editNomeLanchonete.setError("Campo em branco!");
            return false;
        }

        if(localLanchonete.isEmpty()){
            editTextLocalLanchoente.setError("Campo em branco!");
            return false;
        }

        if(telefoneLanchonete.isEmpty()){
            editTextTeleofone.setError("Campo em branco!");
            return false;
        }

        if(horarioLanchonete.isEmpty()){
            editTextHorario.setError("Campo em branco!");
            return false;
        }

        if(emailLanchonete.isEmpty()){
            editTextEmail.setError("Campo em branco!");
            return false;
        }


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
