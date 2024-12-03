package com.example.app_developer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecuperarSenha extends AppCompatActivity implements View.OnClickListener {
    private PopUP PopUP;
    Button bt_RecSenhaSup, bt_RecSenhaVerCod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recuperar_senha);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // classe
        PopUP = new PopUP(this, 0);

        // indetificar
        bt_RecSenhaSup = (Button) findViewById(R.id.bt_RecSenhaSup);


        // Ouve
        bt_RecSenhaSup.setOnClickListener(this);

        // Indentificar
        bt_RecSenhaVerCod = (Button) findViewById(R.id.bt_RecSenhaVerCod);

        // Ouve
        bt_RecSenhaVerCod.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_RecSenhaSup) {
            PopUP.showPop(this);
        }
        if (view.getId() == R.id.bt_RecSenhaVerCod) {
            Intent telaAltSenha = new Intent(this, AlterarSenha.class);
            startActivity(telaAltSenha);
        }
    }
}