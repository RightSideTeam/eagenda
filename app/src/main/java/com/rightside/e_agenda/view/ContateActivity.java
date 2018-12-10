package com.rightside.e_agenda.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rightside.e_agenda.R;

public class ContateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contate);

        //TOOLBAR//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void  browserurl (View view){
        Intent browserIntent = new Intent(Intent.ACTION_SEND);
        browserIntent.setType("text/plain");
        browserIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "gsmh23@gmail.com" });
       //titulo browserIntent.putExtra(Intent.EXTRA_SUBJECT, "E-agenda");
        startActivity(browserIntent);
    }

    public void  whats (View view){
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.setAction(Intent.ACTION_VIEW);
        sendIntent.setPackage("com.whatsapp");
        String url = "https://api.whatsapp.com/send?phone=" + "5522999954977" + "&text=" + "Olá, vim pelo app do e-Agenda!";
        sendIntent.setData(Uri.parse(url));
        startActivity(sendIntent);
    }
}
