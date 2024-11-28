package com.example.app_developer;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class VagasPesquisa extends AppCompatActivity {

    private EditText editTextLocalizacao, editTextFuncao,
            editTextCodigo;
    private LinearLayout vaga1, vaga2, vaga3;
    private Button btnCandidatar1, btnCandidatar2, btnCandidatar3;
    private Button btnMostrarFiltros, btnAplicarFiltro;
    private LinearLayout layoutFiltros;
    private ScrollView scrollViewVagas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vagas_pesquisa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            // componentes - Id ́s

            editTextLocalizacao =
                    findViewById(R.id.editTextLocalizacao);
            editTextFuncao = findViewById(R.id.editTextFuncao);
            editTextCodigo = findViewById(R.id.editTextCodigo);
            btnCandidatar1 = findViewById(R.id.btnCandidatar1);
            btnCandidatar2 = findViewById(R.id.btnCandidatar2);
            btnCandidatar3 = findViewById(R.id.btnCandidatar3);
            btnMostrarFiltros = findViewById(R.id.btnMostrarFiltros);
            btnAplicarFiltro = findViewById(R.id.btnAplicarFiltro);
            layoutFiltros = findViewById(R.id.layoutFiltros);
            scrollViewVagas = findViewById(R.id.scrollViewVagas);
            vaga1 = findViewById(R.id.vaga1);
            vaga2 = findViewById(R.id.vaga2);
            vaga3 = findViewById(R.id.vaga3);

            // Mostrar/Esconder os filtros
            btnMostrarFiltros.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (layoutFiltros.getVisibility() == View.GONE) {
                         layoutFiltros.setVisibility(View.VISIBLE);
                         btnMostrarFiltros.setText("Ocultar Filtros");
                     } else {
                         layoutFiltros.setVisibility(View.GONE);
                         btnMostrarFiltros.setText("Exibir Filtros");
                     }
                 }
             });
            // Aplicar filtro
        btnAplicarFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aplicarFiltros();
                Toast.makeText(VagasPesquisa.this, "Filtros aplicados com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });

        // botões de candidatura
        btnCandidatar1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  toggleCandidatura(btnCandidatar1);
              }

          });
        btnCandidatar2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  toggleCandidatura(btnCandidatar2);
              }
          });
        btnCandidatar3.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  toggleCandidatura(btnCandidatar3);
              }
          });
    }
    private void toggleCandidatura(Button btn) {
    // "Me Candidatar" para "Cancelar Inscrição" (ao clicar)
        if (btn.getText().toString().equals("Me Candidatar")) {
            btn.setText("Cancelar Inscrição");
            Toast.makeText(VagasPesquisa.this, "Você se candidatou!",

                    Toast.LENGTH_SHORT).show();
        } else {
            btn.setText("Me Candidatar");
            Toast.makeText(VagasPesquisa.this, "Você cancelou a inscrição.", Toast.LENGTH_SHORT).show();
        }
    }
    private void aplicarFiltros() {
        String localizacao =
                editTextLocalizacao.getText().toString();
        String funcao = editTextFuncao.getText().toString();
        String codigo = editTextCodigo.getText().toString();
    // Exibir ou ocultar as vagas com base nos filtros aplicado
        boolean filtroLocalizacao = TextUtils.isEmpty(localizacao);
        boolean filtroFuncao = TextUtils.isEmpty(funcao);
        boolean filtroCodigo = TextUtils.isEmpty(codigo);
    // Vaga 1
        if (!filtroLocalizacao && !"São Paulo - SP".contains(localizacao)) {

        vaga1.setVisibility(View.GONE);

            } else if (!filtroFuncao && !"Distribuição de Alimentos".contains(funcao)) {

                    vaga1.setVisibility(View.GONE);
        } else if (!filtroCodigo && !"12345".contains(codigo)) {
                vaga1.setVisibility(View.GONE);
        } else {
                vaga1.setVisibility(View.VISIBLE);
        }
        // Vaga 2
                if (!filtroLocalizacao && !"São Paulo".contains(localizacao)) {

                vaga2.setVisibility(View.GONE);
        } else if (!filtroFuncao && !"Distribuição de Roupas".contains(funcao)) {

                vaga2.setVisibility(View.GONE);
        } else if (!filtroCodigo && !"12346".contains(codigo)) {
                vaga2.setVisibility(View.GONE);
        } else {
                vaga2.setVisibility(View.VISIBLE);
        }
        // Vaga 3
                if (!filtroLocalizacao && !"São Paulo - SP".contains(localizacao)) {

                vaga3.setVisibility(View.GONE);
        } else if (!filtroFuncao && !"Distribuição de Alimentos".contains(funcao)) {

                vaga3.setVisibility(View.GONE);
        } else if (!filtroCodigo && !"12347".contains(codigo)) {
                vaga3.setVisibility(View.GONE);
        } else {
                vaga3.setVisibility(View.VISIBLE);
        }
                }
}