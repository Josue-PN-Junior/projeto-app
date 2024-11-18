package com.example.app_developer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlterarSenha extends AppCompatActivity implements View.OnClickListener {
    private PopUP PopUP2;
    Button bt_AltSenhaSup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alterar_senha);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // classe
        PopUP2 = new PopUP(this);

        // indetificando
        bt_AltSenhaSup = (Button) findViewById(R.id.bt_AltSenhaSup);

        // ouve
        bt_AltSenhaSup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_AltSenhaSup) {
            PopUP2.showPop(this);
        }
    }
}