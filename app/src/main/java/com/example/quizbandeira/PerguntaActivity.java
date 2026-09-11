package com.example.quizbandeira;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PerguntaActivity extends AppCompatActivity {

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

    private TextView txtNumeroPergunta;
    private TextView txtTitulo;

    private ImageView imgBandeira;

    private RadioGroup radioGroupAlternativas;

    private RadioButton radioAlternativa1;
    private RadioButton radioAlternativa2;
    private RadioButton radioAlternativa3;
    private RadioButton radioAlternativa4;

    private Button btnResponder;

    // Todas as perguntas do Quiz
    private Estrutura_pergunta[] perguntas;

    // Índice da pergunta atual
    private int perguntaAtual = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_pergunta);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
                                    WindowInsetsCompat.Type.systemBars()
                            );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );


        // ==========================================
        // LOCALIZAR OS COMPONENTES
        // ==========================================

        txtNumeroPergunta =
                findViewById(R.id.txtNumeroPergunta);

        txtTitulo =
                findViewById(R.id.txtTitulo);

        imgBandeira =
                findViewById(R.id.imgBandeira);

        radioGroupAlternativas =
                findViewById(R.id.radioGroupAlternativas);

        radioAlternativa1 =
                findViewById(R.id.radioAlternativa1);

        radioAlternativa2 =
                findViewById(R.id.radioAlternativa2);

        radioAlternativa3 =
                findViewById(R.id.radioAlternativa3);

        radioAlternativa4 =
                findViewById(R.id.radioAlternativa4);

        btnResponder =
                findViewById(R.id.btnResponder);


        // ==========================================
        // CARREGAR AS PERGUNTAS
        // ==========================================

        perguntas = Perguntas.obterPerguntas();


        // ==========================================
        // MOSTRAR A PRIMEIRA PERGUNTA
        // ==========================================

        mostrarPergunta();


        // ==========================================
        // HABILITAR RESPONDER
        // QUANDO ESCOLHER UMA ALTERNATIVA
        // ==========================================

        radioGroupAlternativas.setOnCheckedChangeListener(
                (group, checkedId) -> {

                    if (checkedId != -1) {

                        btnResponder.setEnabled(true);

                    } else {

                        btnResponder.setEnabled(false);

                    }
                }
        );


        // ==========================================
        // BOTÃO RESPONDER
        // ==========================================

        btnResponder.setOnClickListener(v -> {

            proximaPergunta();

        });

    }


    // ==========================================
    // MOSTRAR PERGUNTA ATUAL
    // ==========================================

    private void mostrarPergunta() {

        Estrutura_pergunta pergunta =
                perguntas[perguntaAtual];


        // Número da pergunta

        txtNumeroPergunta.setText(
                "Pergunta "
                        + (perguntaAtual + 1)
                        + " de "
                        + perguntas.length
        );


        // Título

        txtTitulo.setText(
                "Que país é este?"
        );


        // Bandeira

        imgBandeira.setImageResource(
                pergunta.getBandeira()
        );


        // Alternativas

        radioAlternativa1.setText(
                pergunta.getAlternativa1()
        );

        radioAlternativa2.setText(
                pergunta.getAlternativa2()
        );

        radioAlternativa3.setText(
                pergunta.getAlternativa3()
        );

        radioAlternativa4.setText(
                pergunta.getAlternativa4()
        );


        // Limpa a seleção anterior

        radioGroupAlternativas.clearCheck();


        // Desabilita o botão novamente

        btnResponder.setEnabled(false);

    }


    // ==========================================
    // IR PARA A PRÓXIMA PERGUNTA
    // ==========================================

    private void proximaPergunta() {

        perguntaAtual++;


        // Se ainda existem perguntas

        if (perguntaAtual < perguntas.length) {

            mostrarPergunta();

        }

        // Se terminou as 10 perguntas

        else {

            Intent intent =
                    new Intent(
                            PerguntaActivity.this,
                            RankingActivity.class
                    );

            startActivity(intent);

            finish();

        }

    }


    // ==========================================
    // BOTÃO VOLTAR DO CELULAR
    // ==========================================

    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {

        // O PDF determina que, ao voltar,
        // o usuário deve retornar à tela inicial
        // e recomeçar o Quiz.

        super.onBackPressed();
        Intent intent =
                new Intent(
                        PerguntaActivity.this,
                        MainActivity.class
                );

        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP
        );

        startActivity(intent);

        finish();

    }

}