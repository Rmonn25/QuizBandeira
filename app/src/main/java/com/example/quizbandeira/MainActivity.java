package com.example.quizbandeira;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

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

        // Desabilita o botão ao abrir e deixa ele 50% transparente
        btnIniciarQuiz.setEnabled(false);
        btnIniciarQuiz.setAlpha(0.5f);

        // Digitação no EditText do ususario
        txtNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean temTexto = !s.toString().trim().isEmpty();

                // Habilita ou desabilita o botão INICIAR
                btnIniciarQuiz.setEnabled(temTexto);

                // Efeito visual do botão INICIAR, 1.0f aceso e 0.5f apagado
                if (temTexto) {
                    btnIniciarQuiz.setAlpha(1.0f);
                } else {
                    btnIniciarQuiz.setAlpha(0.5f);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
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