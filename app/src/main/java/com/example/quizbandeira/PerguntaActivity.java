package com.example.quizbandeira;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// ==========================================
// PERGUNTA ACTIVITY
// ==========================================

// Responsável: telas das perguntas e navegação entre elas.

// 1. Criar a tela da pergunta.

// 2. Exibir o título "Que país é este?".

// 3. Exibir a imagem da bandeira.

// 4. Exibir as 4 alternativas usando RadioButton.

// 5. Criar o botão "RESPONDER".

// 6. Habilitar o botão RESPONDER após selecionar uma alternativa.

// 7. Ao clicar em RESPONDER, passar para a próxima pergunta.

// 8. Controlar a sequência das 10 perguntas.

// 9. Após a última pergunta, encaminhar para o Ranking.

// NÃO é responsabilidade desta parte:
// - Criar a lógica de pontuação.
// - Contabilizar acertos.
// - Desenvolver a tela de Ranking.

public class PerguntaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

