package com.example.app_developer;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText login_txtLogin, login_txtSenha;
    TextView login_recSenha, login_txtEmailView, login_txtSenhaView;
    Button login_btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        login_recSenha = (TextView) findViewById(R.id.login_recSenha);

        login_recSenha.setOnClickListener( this );

        // identificando
        login_btEntrar = (Button) findViewById(R.id.login_btEntrar);
        login_txtEmailView = (TextView) findViewById(R.id.login_txtEmailView);
        login_txtSenhaView = (TextView) findViewById(R.id.login_txtSenhaView);
        login_txtLogin = findViewById(R.id.login_txtLogin);
        login_txtSenha = findViewById(R.id.login_txtSenha);

        // ouve
        login_btEntrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String email = login_txtLogin.getText().toString();
        String senha = login_txtSenha.getText().toString();
        if (view.getId() == R.id.login_recSenha) {
            Intent telaRec = new Intent(this, RecuperarSenha.class);
            startActivity(telaRec);
        }
        if (view.getId() == R.id.login_btEntrar) {
            if (VerificarDados()) {
                Intent telaHome = new Intent(this, Home.class);
                Bundle parametros = new Bundle();
                parametros.putString("email", email);
                telaHome.putExtras(parametros);
                startActivity(telaHome);
                finish();
            }
        }
    }

    private boolean VerificarDados() {
        // pegando texto
        String email = login_txtLogin.getText().toString();
        String senha = login_txtSenha.getText().toString();
        limparCor();
        if (email.isEmpty()) {
            login_txtEmailView.setTextColor(0xAAFB2F41);
            Toast.makeText(getApplicationContext(), "O campo email deve ser preenchido!", Toast.LENGTH_LONG).show();
            return false;
        }

        if (senha.isEmpty()) {
            login_txtSenhaView.setTextColor(0xAAFB2F41);
            Toast.makeText(getApplicationContext(), "O campo senha deve ser preenchido!", Toast.LENGTH_LONG).show();
            return false;
        }

        // consultar senha e email
        BancoController bd = new BancoController(getBaseContext());
        Cursor dados = bd.PesquisarLogin(email, senha);

        if (dados.moveToFirst()) {
            return true;
        } else {
            String msg = "Email ou Senha inválida!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private void limparCor() {
        login_txtEmailView.setTextColor(0xFF000000);
        login_txtSenhaView.setTextColor(0xFF000000);
    }
}