package com.example.app_developer;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class PopUP {
    private PopupWindow popupWindow;
    private View popupView;

    public PopUP(Context context, Integer num) {

        if (context instanceof AlterarSenha || context instanceof RecuperarSenha) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            popupView = inflater.inflate(R.layout.popup_sup, null);
        } else if (context instanceof Cadastro) {
            if (num == 0) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                popupView = inflater.inflate(R.layout.popup_termos, null);
            } else {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                popupView = inflater.inflate(R.layout.popup_cadastrado, null);

            }

        }

        popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);


        Button bt_popSupFechar = popupView.findViewById(R.id.bt_popSupFechar);
        bt_popSupFechar.setOnClickListener(view -> dismiss());



    }

    public void dismiss() {
        popupWindow.dismiss();
    }

    public void showPop(Activity activity) {
        popupWindow.showAtLocation(activity.findViewById(android.R.id.content),
                Gravity.CENTER,
                0, 0);
    }

}
