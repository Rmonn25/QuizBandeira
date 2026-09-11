package com.example.quizbandeira;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RankingActivity extends AppCompatActivity {

    private TextView tvNomeUsuario;
    private TextView tvAcertos;
    private Button btnResponderNovamente;
    private Button btnTelaPrincipal;

    // 1. CORREÇÃO: Criamos a variável global aqui em cima
    private String nomeUsuario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ranking);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvNomeUsuario = findViewById(R.id.tvNomeUsuario);
        tvAcertos = findViewById(R.id.tvAcertos);
        btnResponderNovamente = findViewById(R.id.btnResponderNovamente);
        btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);

        // 2. CORREÇÃO: Usamos a variável global para receber o dado
        Intent intent = getIntent();
        nomeUsuario = intent.getStringExtra("NOME_USUARIO");
        int pontuacao = intent.getIntExtra("PONTUACAO_FINAL", 0);

        if (nomeUsuario == null) {
            nomeUsuario = "Jogador";
        }

        tvNomeUsuario.setText(nomeUsuario);
        tvAcertos.setText(String.valueOf(pontuacao));

        btnResponderNovamente.setOnClickListener(v -> {
            Intent intentVoltarQuiz = new Intent(RankingActivity.this, PerguntaActivity.class);
            // 3. CORREÇÃO: Como a variável é global, o Java não bloqueia o uso dela aqui!
            intentVoltarQuiz.putExtra("NOME_USUARIO", nomeUsuario);
            startActivity(intentVoltarQuiz);
            finish();
        });

        btnTelaPrincipal.setOnClickListener(v -> {
            Intent intentTelaInicial = new Intent(RankingActivity.this, MainActivity.class);
            intentTelaInicial.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intentTelaInicial);
            finish();
        });
    }
}