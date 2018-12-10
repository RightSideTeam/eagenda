package com.rightside.e_agenda.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rightside.e_agenda.R;
import com.rightside.e_agenda.natividadeView.SegmentosNatActivity;

public class CidadeActivity extends AppCompatActivity {


    Spinner cidades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidade);


        //MUDAR FONTE//
        TextView txt_resultado = (TextView) findViewById(R.id.confirmarcidade);
        TextView txt_resultado2 = (Button) findViewById(R.id.buttonConfirmar);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/century_gothic.ttf");
        txt_resultado.setTypeface( font );
        txt_resultado2.setTypeface(font);


        //SPINNNER DE ESCOLHA DE CIDADES//
        cidades = (Spinner) findViewById(R.id.spinnerCidade);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinnernomecidades, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        cidades.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);
        cidades.setAdapter(adapter);


        //BOTÃO PARA CONFIRMAR A ESCOLHA DA CIDADE//
        Button confirme = (Button) findViewById(R.id.buttonConfirmar);
        confirme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (cidades.getSelectedItemPosition()){
                    case 0:
                        Intent chamatela = new Intent(CidadeActivity.this,SegmentosNatActivity.class);
                        startActivity(chamatela);
                        break;

                    case 1:
                        Toast.makeText(getApplicationContext(), "Essa cidade ainda não está disponivel", Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });

    }

    //SE APERTAR VOLTAR FECHA  O APP
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

}