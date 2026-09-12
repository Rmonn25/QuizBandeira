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
// ==========================================
// RANKING ACTIVITY
// ==========================================

// Responsável pela tela final do Quiz.

// 1. Exibir o nome do usuário.

// 2. Exibir a quantidade de acertos.

// 3. Criar o botão "RESPONDER NOVAMENTE".

// 4. Criar o botão "TELA PRINCIPAL".

// 5. Ao clicar em "RESPONDER NOVAMENTE",
//    voltar para a primeira pergunta.

// 6. Ao clicar em "TELA PRINCIPAL",
//    retornar para a tela inicial.

// A pontuação será recebida da lógica do Quiz.
// Não criar a lógica de pontuação nesta Activity.

public class RankingActivity extends AppCompatActivity {
    private TextView tvNomeUsuario;
    private TextView tvAcertos;
    private Button btnResponderNovamente;
    private Button btnTelaPrincipal;


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

        // Mapeamento dos componentes da tela
        tvNomeUsuario = findViewById(R.id.tvNomeUsuario);
        tvAcertos = findViewById(R.id.tvAcertos);
        btnResponderNovamente = findViewById(R.id.btnResponderNovamente);
        btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);

        // Recebimento da pontuação e nome do usuário repassados via Intent
        Intent intent = getIntent();
        String nome = intent.getStringExtra("NOME_USUARIO");
        int pontuacao = intent.getIntExtra("PONTUACAO", 0);

        // Exibição dos dados na interface
        if (nome != null) {
            tvNomeUsuario.setText(nome);
        }
        tvAcertos.setText(String.valueOf(pontuacao));

        // Ação do botão "RESPONDER NOVAMENTE": Direciona para a primeira pergunta do Quiz
        btnResponderNovamente.setOnClickListener(v -> {
            Intent intentQuiz = new Intent(RankingActivity.this, PerguntaActivity.class);
            intentQuiz.putExtra("NOME_USUARIO", nome);
            startActivity(intentQuiz);
            finish();
        });

        // Ação do botão "TELA PRINCIPAL": Retorna para a tela inicial do aplicativo
        btnTelaPrincipal.setOnClickListener(v -> {
            Intent intentHome = new Intent(RankingActivity.this, MainActivity.class);
            intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentHome);
            finish();
        });
    }
}