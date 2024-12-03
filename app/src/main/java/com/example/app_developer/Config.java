package com.example.app_developer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Config extends AppCompatActivity {

    private TextView userName, userPhone, userEmail;
    private Button btnAlterarDados, btnNotificacoes, btnLocalizacao, btnPermissoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_config);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa as Views
        userName = findViewById(R.id.user_name);
        userPhone = findViewById(R.id.user_phone);
        userEmail = findViewById(R.id.user_email);

        btnAlterarDados = findViewById(R.id.btn_alterar_dados);
        btnNotificacoes = findViewById(R.id.btn_notificacoes);
        btnLocalizacao = findViewById(R.id.btn_localizacao);
        btnPermissoes = findViewById(R.id.btn_permissoes);

        // Ação para o botão "Alterar dados cadastrais"
        btnAlterarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog();
            }
        });

        // Ação para o botão "Notificações"
        btnNotificacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotificationDialog();
            }
        });

        // Ação para o botão "Localização"
        btnLocalizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocationDialog();
            }
        });

        // Ação para o botão "Permissões"
        btnPermissoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog("Configurações de Permissões", "Aqui você pode configurar as permissões do app.");
            }
        });
    }

    // Método para exibir o AlertDialog de edição dos dados cadastrais
    private void showEditDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_edit_data, null);

        EditText editTextName = dialogView.findViewById(R.id.edit_text_name);
        EditText editTextPhone = dialogView.findViewById(R.id.edit_text_phone);
        EditText editTextEmail = dialogView.findViewById(R.id.edit_text_email);

        editTextName.setText(userName.getText().toString());
        editTextPhone.setText(userPhone.getText().toString());
        editTextEmail.setText(userEmail.getText().toString());

        AlertDialog.Builder builder = new AlertDialog.Builder(Config.this);
        builder.setTitle("Alterar Dados Cadastrais")
                .setView(dialogView)
                .setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newName = editTextName.getText().toString();
                        String newPhone = editTextPhone.getText().toString();
                        String newEmail = editTextEmail.getText().toString();

                        userName.setText(newName);
                        userPhone.setText(newPhone);
                        userEmail.setText(newEmail);
                    }
                })
                .setNegativeButton("Cancelar", null);

        builder.create().show();
    }

    // Método para exibir o Dialog de configurações de Notificação
    private void showNotificationDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_notificacoes, null);

        Switch switchNotificacoes = dialogView.findViewById(R.id.switch_notificacoes);
        SeekBar seekBarVolume = dialogView.findViewById(R.id.seekbar_volume);
        TextView volumeValue = dialogView.findViewById(R.id.volume_value);

        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                volumeValue.setText("Volume: " + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(Config.this);
        builder.setTitle("Configurações de Notificação")
                .setView(dialogView)
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean isNotificationsEnabled = switchNotificacoes.isChecked();
                        int notificationVolume = seekBarVolume.getProgress();

                        String status = isNotificationsEnabled ? "Ativado" : "Desativado";
                        showSimpleDialog("Configurações Salvas", "Notificações " + status + ". Volume da notificação: " + notificationVolume + "%");
                    }
                })
                .setNegativeButton("Cancelar", null);

        builder.create().show();
    }

    // Método para exibir o Dialog de configuração de Localização
    private void showLocationDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_localizacao, null);

        Switch switchLocalizacao = dialogView.findViewById(R.id.switch_localizacao);
        RadioGroup radioGroupLocalizacao = dialogView.findViewById(R.id.radio_group_localizacao);
        TextView textoMetodoLocalizacao = dialogView.findViewById(R.id.texto_metodo_localizacao);

        radioGroupLocalizacao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                if (selectedRadioButton != null) {
                    String metodo = selectedRadioButton.getText().toString();
                    textoMetodoLocalizacao.setText("Método de localização: " + metodo);
                }
            }
        });

        textoMetodoLocalizacao.setText("Método de localização: Automático");

        AlertDialog.Builder builder = new AlertDialog.Builder(Config.this);
        builder.setTitle("Configurações de Localização")
                .setView(dialogView)
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean isLocationEnabled = switchLocalizacao.isChecked();
                        int selectedMethodId = radioGroupLocalizacao.getCheckedRadioButtonId();
                        RadioButton selectedMethodButton = findViewById(selectedMethodId);
                        String selectedMethod = selectedMethodButton != null ? selectedMethodButton.getText().toString() : "Automático";

                        String locationStatus = isLocationEnabled ? "Ativada" : "Desativada";
                        showSimpleDialog("Configurações Salvas", "Localização " + locationStatus + ". Método de localização: " + selectedMethod);
                    }
                })
                .setNegativeButton("Cancelar", null);

        builder.create().show();
    }

    // Método para exibir um AlertDialog simples
    private void showSimpleDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Config.this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .create()
                .show();
    }

}

