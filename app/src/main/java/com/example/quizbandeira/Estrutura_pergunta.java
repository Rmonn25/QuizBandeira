package com.example.quizbandeira;

public class Estrutura_pergunta {

     // Nome da imagem da bandeira
    private int bandeira;

    // Quatro alternativas de pergunta
    private string alternativa1;
    private string alternativa2;
    private string alternativa3;
    private string alternativa4;

    // Alternativa correta
    private String respostaCorreta;

    // Construtor da pergunta
    public Pergunta(int bandeira,
                    String alternativa1,
                    String alternativa2,
                    String alternativa3,
                    String alternativa4,
                    String respostaCorreta){

        this.bandeira = bandeira;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
        this.respostaCorreta = respostaCorreta;
    }

    // Retorna a imagem da bandeira
    public int getBandeira() {
        return bandeira;
    }

    // Retorna a alternativa 1
    public String getAlternativa1() {
        return alternativa1;
    }

    // Retorna a alternativa 2
    public String getAlternativa2() {
        return alternativa2;
    }

    // Retorna a alternativa 3
    public String getAlternativa3() {
        return alternativa3;
    }

    // Retorna a alternativa 4
    public String getAlternativa4() {
        return alternativa4;
    }

    // Retorna a resposta correta
    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}

