package com.rightside.e_agenda.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.rightside.e_agenda.R;

public class GerenciaLanchoneteUtils {

    public static void replace(FragmentActivity activity, Fragment fragment) {
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoGerenciaLanchonetes, fragment).commit();
    }



}