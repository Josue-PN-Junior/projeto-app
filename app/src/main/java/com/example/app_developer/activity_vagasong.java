package com.example.app_developer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class activity_vagasong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vagasong); // Certifique-se de que o layout seja o correto

        ImageView imageViewSeta = findViewById(R.id.imageView7);

        // Configurar o clique para VagasVoluntarios
        imageViewSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(activity_vagasong.this, VagasPesquisa.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        ImageView imageViewform = findViewById(R.id.imageView25);

        // Configurar o clique para a Home
        imageViewform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a Home (Home.java)
                Intent intent = new Intent(activity_vagasong.this, formularioong.class);
                startActivity(intent);  // Inicia a Home
            }
        });

        TextView textViewAtividadesRealizadasVoluntario = findViewById(R.id.textView28);


        textViewAtividadesRealizadasVoluntario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(activity_vagasong.this, atividadesrealizadasdetalhes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewAtividadesRealizadasVoluntario2 = findViewById(R.id.textView29);


        textViewAtividadesRealizadasVoluntario2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(activity_vagasong.this, atividadesrealizadasdetalhes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });

        TextView textViewAtividadesRealizadasVoluntario3 = findViewById(R.id.textView34);


        textViewAtividadesRealizadasVoluntario3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar a Intent para abrir a VagasVoluntariosActivity
                Intent intent = new Intent(activity_vagasong.this, atividadesrealizadasdetalhes.class);
                startActivity(intent);  // Inicia a nova Activity
            }
        });



        // Botão "Cancelar Vaga" 3
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelDialog(); // Chama o método para mostrar o diálogo
            }
        });

        // Botão "Cancelar Vaga" 4
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelDialog(); // Chama o método para mostrar o diálogo
            }
        });

        // Botão "Cancelar Vaga" 5
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
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
