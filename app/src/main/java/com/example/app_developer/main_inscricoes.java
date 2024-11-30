package com.example.app_developer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class main_inscricoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_inscricoes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageViewHome = findViewById(R.id.imageView5);

        // Configurar o clique para a Home
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(main_inscricoes.this, Home.class);
                startActivity(intent);  // Inicia a Home
            }
        });


        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewVagas = findViewById(R.id.imageView14);

        // Configurar o clique para VagasVoluntarios
        imageViewVagas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, VagasVoluntarios.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewEngrenagem = findViewById(R.id.imageView17);

        // Configurar o clique para VagasVoluntarios
        imageViewEngrenagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, Config.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        ImageView imageViewLupa = findViewById(R.id.imageView);

        // Configurar o clique para VagasVoluntarios
        imageViewLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, VagasPesquisa.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        ImageView imageViewIcone = findViewById(R.id.imageView7);

        imageViewIcone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, Home.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });


        TextView textViewAtividadesDetalahemento1 = findViewById(R.id.textView11);

        // Configurar o clique para VagasVoluntarios
        textViewAtividadesDetalahemento1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, activity_atividadesrealizadasdetalhes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });


        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        TextView textViewAtividadesDetalahemento2 = findViewById(R.id.textView15);

        // Configurar o clique para VagasVoluntarios
        textViewAtividadesDetalahemento2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, activity_atividadesrealizadasdetalhes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        TextView textViewAtividadesRealizadas = findViewById(R.id.textView5);

        // Configurar o clique para VagasVoluntarios
        textViewAtividadesRealizadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, MainActivityAtividadesRealizadas.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        // Encontrar o ImageView para VagasVoluntarios (imageView9)
        TextView textViewInscricoes = findViewById(R.id.textView9);

        // Configurar o clique para VagasVoluntarios
        textViewInscricoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, main_inscricoes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewDescricao = findViewById(R.id.textView4);

        // Configurar o clique para VagasVoluntarios
        textViewDescricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(main_inscricoes.this, MainPerfilVoluntarioActivity.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });


        // Botão "Cancelar Vaga" 3
        Button button3 = findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelDialog(); // Chama o método para mostrar o diálogo
            }
        });

        // Botão "Cancelar Vaga" 4
        Button button4 = findViewById(R.id.button2);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelDialog(); // Chama o método para mostrar o diálogo
            }
        });
    }

    // Método para exibir o AlertDialog de confirmação
    private void showCancelDialog() {
        // Criação do AlertDialog
        new AlertDialog.Builder(this)
                .setMessage("Deseja cancelar a vaga?")
                .setCancelable(false) // Para evitar que o usuário feche clicando fora
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Aqui você pode colocar a ação a ser tomada ao clicar em SIM
                        // Exemplo: cancelar a vaga
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Ação ao clicar em NÃO, não faz nada
                        dialog.dismiss();
                    }
                })
                .create()
                .show(); // Exibe o AlertDialog
    }
    }
