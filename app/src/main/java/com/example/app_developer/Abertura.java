package com.example.app_developer;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Abertura extends AppCompatActivity implements View.OnClickListener {

    Button bt_aberturaSup, bt_popSupFechar, abertura_btEntrar, abertura_btCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abertura);
;

        abertura_btEntrar = findViewById(R.id.abertura_btEntrar);
        abertura_btEntrar.setOnClickListener(this);
        Button showPopupButton = findViewById(R.id.bt_aberturaSup);
        showPopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });

        // identificando
        abertura_btCad = (Button) findViewById(R.id.abertura_btCad);

        // ouve
        abertura_btCad.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        // PopUp
        if (view.getId() == R.id.bt_aberturaSup) {
            showPopup();
        }
        // Cadastro
        if (view.getId() == R.id.abertura_btCad) {
            Intent telaCad = new Intent(this, Cadastro.class);
            startActivity(telaCad);
        }
        // botão entrar (Login)
        if (view.getId() == R.id.abertura_btEntrar) {
            Intent telaLogin = new Intent(this, Login.class);
            startActivity(telaLogin);
        }
    }

    public void showPopup() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_sup, null);

        final PopupWindow popupWindow = new PopupWindow(popupView,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                true);

        popupWindow.showAtLocation(findViewById(android.R.id.content), Gravity.CENTER, 0, 0);

        Button btnClose = popupView.findViewById(R.id.bt_popSupFechar);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
    }
}