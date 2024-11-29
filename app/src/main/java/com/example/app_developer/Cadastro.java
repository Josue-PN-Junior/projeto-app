package com.example.app_developer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro extends AppCompatActivity implements View.OnClickListener{
    private PopUP PopUP3;
    Button bt_CadONGS, bt_CadPopUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // classe
        PopUP3 = new PopUP(this);

        // indetificando
        bt_CadONGS = (Button) findViewById(R.id.bt_CadONGS);
        bt_CadPopUp = (Button) findViewById(R.id.bt_CadPopUp);


        // Ouve
        bt_CadPopUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_CadPopUp) {
            PopUP3.showPop(this);
        }
    }
}