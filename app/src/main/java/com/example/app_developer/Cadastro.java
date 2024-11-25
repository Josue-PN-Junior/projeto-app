package com.example.app_developer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro extends AppCompatActivity implements View.OnClickListener{
    private PopUP PopUP3, PopUP4;
    Button bt_CadONGS, bt_CadPopUp, bt_CadCriar;
    CheckBox cad_termos;
    EditText cad_txtNome, cad_txtSobrenome, cad_txtEmail, cad_txtCPF, cad_txtTelefone, cad_txtSenha, cad_txtSenha2;

    String txtNome, txtSobrenome, txtEmail, txtCPF, txtTelefone, txtSenha, txtSenha2;
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

        // ================== PopUp
        // classe
        PopUP3 = new PopUP(this, 0);
        PopUP4 = new PopUP(this, 1);

        // indetificando
        bt_CadONGS = (Button) findViewById(R.id.bt_CadONGS);
        bt_CadPopUp = (Button) findViewById(R.id.bt_CadPopUp);


        // Ouve
        bt_CadPopUp.setOnClickListener(this);

        // ===================== Cadastro

        // indentificando
        cad_txtNome = (EditText) findViewById(R.id.cad_txtNome);
        cad_txtSobrenome = (EditText) findViewById(R.id.cad_txtSobreNome);
        cad_txtEmail = (EditText) findViewById(R.id.cad_txtEmail);
        cad_txtCPF = (EditText) findViewById(R.id.cad_txtCPF);
        cad_txtTelefone = (EditText) findViewById(R.id.cad_txtTelefone);
        cad_txtSenha = (EditText) findViewById(R.id.cad_txtSenha);
        cad_txtSenha2 = (EditText) findViewById(R.id.cad_txtSenha2);

        cad_termos = (CheckBox) findViewById(R.id.cad_termos);

        bt_CadCriar = (Button) findViewById(R.id.bt_CadCriar);

        // ouve
        bt_CadCriar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_CadPopUp) {
            PopUP3.showPop(this);
        }
        //cadastro
        if (view.getId() == R.id.bt_CadCriar) {

            Boolean erro = false;

            txtNome = cad_txtNome.getText().toString();
            txtSobrenome = cad_txtSobrenome.getText().toString();
            txtEmail = cad_txtEmail.getText().toString();
            txtCPF = cad_txtCPF.getText().toString();
            txtTelefone = cad_txtTelefone.getText().toString();
            txtSenha = cad_txtSenha.getText().toString();
            txtSenha2 = cad_txtSenha2.getText().toString();

            erro = VerificarDados();

            if (!erro) {
               BancoController bd = new BancoController(getBaseContext());
               String resultado;

               resultado = bd.gravarUsuario(txtNome, txtSobrenome, txtEmail, txtCPF, txtTelefone, txtSenha);

               if (resultado.equals("0")) {
                   resultado = "Erro ao tentar efetuar o cadastro!";
               } else {
                   resultado = "Cadastro realizado com sucesso!";
                   PopUP4.showPop(this);
                   new Handler().postDelayed(() -> {
                       Intent telaAbertura = new Intent(this, Abertura.class);
                       startActivity(telaAbertura);
                       finish();
                   }, 3000);

               }
               Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        }
    }

    private Boolean VerificarDados() {
        // limpar antes
        LimparCor();
        // verificando
        // nome
        if (txtNome.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Atenção - O campo Nome deve ser preenchido!",
                    Toast.LENGTH_LONG).show();
            cad_txtNome.setTextColor(0xAAFB2F41);
            cad_txtNome.setHintTextColor(0xAAFB2F41);
            return true;
        }
        // sobrenome
        if (txtSobrenome.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Atenção - O campo Sobrenome deve ser preenchido!",
                    Toast.LENGTH_LONG).show();
            cad_txtSobrenome.setTextColor(0xAAFB2F41);
            cad_txtSobrenome.setHintTextColor(0xAAFB2F41);
            return true;
        }

        // email
        if (txtEmail.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Atenção - O campo Email deve ser preenchido!",
                    Toast.LENGTH_LONG).show();
            cad_txtEmail.setTextColor(0xAAFB2F41);
            cad_txtEmail.setHintTextColor(0xAAFB2F41);
            return true;
        }

        // email
        if (txtCPF.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Atenção - O campo CPF deve ser preenchido!",
                    Toast.LENGTH_LONG).show();
            cad_txtCPF.setTextColor(0xAAFB2F41);
            cad_txtCPF.setHintTextColor(0xAAFB2F41);
            return true;
        } else if (txtCPF.length() < 11) {
            Toast.makeText(getApplicationContext(), "Atenção - O campo CPF deve ser preenchido coretamente!",
                    Toast.LENGTH_LONG).show();
            cad_txtCPF.setTextColor(0xAAFB2F41);
            cad_txtCPF.setHintTextColor(0xAAFB2F41);
            return true;
        }

        // telefone
        if (txtTelefone.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Atenção - O campo Telefone deve ser preenchido!",
                    Toast.LENGTH_LONG).show();
            cad_txtTelefone.setTextColor(0xAAFB2F41);
            cad_txtTelefone.setHintTextColor(0xAAFB2F41);
            return true;
        }

        // senha
        if (txtSenha.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Atenção - O campo Senha deve ser preenchido!",
                    Toast.LENGTH_LONG).show();
            cad_txtSenha.setTextColor(0xAAFB2F41);
            cad_txtSenha.setHintTextColor(0xAAFB2F41);
            return true;
        }

        // confirmar senha
        if (!txtSenha.equals(txtSenha2)) {
            Toast.makeText(getApplicationContext(), "Atenção - As senhas devem ser iguai!",
                    Toast.LENGTH_LONG).show();
            cad_txtSenha2.setTextColor(0xAAFB2F41);
            cad_txtSenha2.setHintTextColor(0xAAFB2F41);
            return true;
        }

        if (!cad_termos.isChecked()) {
            Toast.makeText(getApplicationContext(), "Atenção - Leia e concorde com os termos de uso.",
                    Toast.LENGTH_LONG).show();
            return true;
        }

        // se tudo certo!
        return false;
    }

    private void LimparCor() {
        cad_txtNome.setTextColor(0xFF000000);
        cad_txtNome.setHintTextColor(0xFFFFFFFF);

        cad_txtSobrenome.setTextColor(0xFF000000);
        cad_txtSobrenome.setHintTextColor(0xFFFFFFFF);

        cad_txtEmail.setTextColor(0xFF000000);
        cad_txtEmail.setHintTextColor(0xFFFFFFFF);

        cad_txtCPF.setTextColor(0xFF000000);
        cad_txtCPF.setHintTextColor(0xFFFFFFFF);

        cad_txtTelefone.setTextColor(0xFF000000);
        cad_txtTelefone.setHintTextColor(0xFFFFFFFF);

        cad_txtSenha.setTextColor(0xFF000000);
        cad_txtSenha.setHintTextColor(0xFFFFFFFF);

        cad_txtSenha2.setTextColor(0xFF000000);
        cad_txtSenha2.setHintTextColor(0xFFFFFFFF);
    }
}