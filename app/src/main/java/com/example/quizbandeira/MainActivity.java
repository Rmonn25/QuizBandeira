package com.example.quizbandeira;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDelegate;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private Button btnIniciarQuiz;
    private Button btnSair;

    @Override
protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO
        );

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vinculação dos componentes
        txtNome = findViewById(R.id.txtNome);
        btnIniciarQuiz = findViewById(R.id.btnIniciarQuiz);
        btnSair = findViewById(R.id.btnSair);

// Ao abrir a tela, o botão começa desabilitado
        btnIniciarQuiz.setEnabled(false);

// Verifica enquanto o usuário digita o nome
        txtNome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Verifica se existe algum texto no campo
                boolean temTexto = !s.toString().trim().isEmpty();

                // Habilita ou desabilita o botão
                btnIniciarQuiz.setEnabled(temTexto);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Botão INICIAR QUIZ, leva para o PerguntaActivity
        btnIniciarQuiz.setOnClickListener(v -> {
            String nomeDigitado = txtNome.getText().toString().trim();

            Intent intent = new Intent(MainActivity.this, PerguntaActivity.class);
            intent.putExtra("NOME_USUARIO", nomeDigitado);
            startActivity(intent);
            finish();
        });

        // Botão SAIR, encerra o app
        btnSair.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}