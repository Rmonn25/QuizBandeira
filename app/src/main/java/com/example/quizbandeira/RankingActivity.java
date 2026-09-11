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

    }

}