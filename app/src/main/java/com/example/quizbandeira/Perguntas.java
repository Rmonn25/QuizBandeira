package com.example.quizbandeira;

public class Perguntas {

    public static Estrutura_pergunta[] obterPerguntas() {
        return new Estrutura_pergunta[] {
                // Pergunta 1 - ALBÂNIA
                new Estrutura_pergunta(
                        R.drawable.albania,
                        "Montenegro",
                        "Albânia",
                        "Sérvia",
                        "Croácia",
                        "Albânia"
                ),

                // Pergunta 2 - Brasil
                new Estrutura_pergunta(
                        R.drawable.brasil,
                        "Brasil",
                        "Argentina",
                        "Colômbia",
                        "México",
                        "Brasil"
                ),

                // Pergunta 3 - Colombia
                new Estrutura_pergunta(
                        R.drawable.colombia,
                        "Venezuela",
                        "Equador",
                        "Colômbia",
                        "Bolívia",
                        "Colômbia"
                ),

                // Pergunta 4 - Djibuti
                new Estrutura_pergunta(
                        R.drawable.djibuti,
                        "Djibuti",
                        "Somália",
                        "Eritreia",
                        "Sudão",
                        "Djibuti"
                ),

                // Pergunta 5 - Egito
                new Estrutura_pergunta(
                        R.drawable.egito,
                        "Egito",
                        "Iraque",
                        "Síria",
                        "Jordânia",
                        "Egito"
                ),

                // Pergunta 6 - Finlândia
                new Estrutura_pergunta(
                        R.drawable.finlandia,
                        "Suécia",
                        "Noruega",
                        "Finlândia",
                        "Islândia",
                        "Finlândia"
                ),

                // Pergunta 7 - Georgia
                new Estrutura_pergunta(
                        R.drawable.georgia,
                        "Geórgia",
                        "Inglaterra",
                        "Dinamarca",
                        "Suíça",
                        "Geórgia"
                ),

                // Pergunta 8 - Haiti
                new Estrutura_pergunta(
                        R.drawable.haiti,
                        "Haiti",
                        "República Dominicana",
                        "Cuba",
                        "Jamaica",
                        "Haiti"
                ),

                // Pergunta 9 - Índia
                new Estrutura_pergunta(
                        R.drawable.india,
                        "Índia",
                        "Paquistão",
                        "Bangladesh",
                        "Nepal",
                        "Índia"
                ),

                // Pergunta 10 - Japão
                new Estrutura_pergunta(
                        R.drawable.japao,
                        "China",
                        "Japão",
                        "Coreia do Sul",
                        "Índia",
                        "Japão"
                )
        };
    }
}