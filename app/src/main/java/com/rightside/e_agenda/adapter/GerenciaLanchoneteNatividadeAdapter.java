package com.rightside.e_agenda.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.rightside.e_agenda.R;
import com.rightside.e_agenda.modelo.GerenciaLanchoneteNatividade;
import com.rightside.e_agenda.natividadeView.gerenciamentoLanchonete.GerenciaDetLancNatActivity;
import com.rightside.e_agenda.natividadeView.gerenciamentoLanchonete.GerenciaLancNatActivity;
import com.rightside.e_agenda.natividadeView.lanchonete.DetalhesLanchoneteNatActivity;
import com.rightside.e_agenda.natividadeView.lanchonete.LanchoneteNatActivity;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class GerenciaLanchoneteNatividadeAdapter extends RecyclerView.Adapter<GerenciaLanchoneteNatividadeAdapter.LanchoneteViewHolder>{

    private ArrayList<GerenciaLanchoneteNatividade> lanchonetesNat;
    private Activity context;



    public GerenciaLanchoneteNatividadeAdapter(Activity context, ArrayList<GerenciaLanchoneteNatividade> lanchonetesDaActivity) {
        this.lanchonetesNat = lanchonetesDaActivity;
        this.context = context;

    }







    @Override
    public LanchoneteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_empresas, parent, false);
        return new LanchoneteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LanchoneteViewHolder holder, int position) {

        final GerenciaLanchoneteNatividade lanchoneteNat = lanchonetesNat.get(position);



        holder.textViewNomeDaLanchonete.setText(lanchoneteNat.getLanchoneteNome());
        holder.textViewLocalLanchonete.setText(lanchoneteNat.getLanchoneteLocal());



        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                if(souAdmin()){
                    Intent it = new Intent(context, GerenciaDetLancNatActivity.class);
                    it.putExtra("gerenciaLanchoneteNat", lanchoneteNat);
                    context.startActivity(it);


                }else{
                    Intent it = new Intent(context, DetalhesLanchoneteNatActivity.class);
                    it.putExtra("lanchonetesNat", lanchoneteNat);
                    context.startActivity(it);
                }

            }

        });


    }



    public boolean souAdmin(){
        SharedPreferences editor = context.getSharedPreferences("preferencia", MODE_PRIVATE);
        return editor.getBoolean("isAdmin", false);
    }

    @Override
    public int getItemCount() {
        return lanchonetesNat.size();
    }

    public void atualiza(ArrayList<GerenciaLanchoneteNatividade> lanchonetesNat) {
        this.lanchonetesNat = lanchonetesNat;
        notifyDataSetChanged();
    }

    public class LanchoneteViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewNomeDaLanchonete;
        private TextView textViewLocalLanchonete;

        public LanchoneteViewHolder(View itemView) {
            super(itemView);

            textViewNomeDaLanchonete = itemView.findViewById(R.id.text_view_nome_da_empresa);
            textViewLocalLanchonete = itemView.findViewById(R.id.text_view_endereco_empresa);
        }



    }



}