package com.example.quizbandeira;

public class Perguntas {

    public static Pergunta[] obterPerguntas() {
        return new Pergunta[] {
                // Pergunta 1 - ALBÂNIA
                new Pergunta(
                        R.drawable.albania,
                        "Montenegro",
                        "Albânia",
                        "Sérvia",
                        "Croácia",
                        "Albânia"
                ),

                // Pergunta 2 - Brasil
                new Pergunta(
                        R.drawable.brasil,
                        "Brasil",
                        "Argentina",
                        "Colômbia",
                        "México",
                        "Brasil"
                ),

                // Pergunta 3 - Colombia
                new Pergunta(
                        R.drawable.colombia,
                        "Venezuela",
                        "Equador",
                        "Colômbia",
                        "Bolívia",
                        "Colômbia"
                ),

                // Pergunta 4 - Djibuti
                new Pergunta(
                        R.drawable.djibuti,
                        "Djibuti",
                        "Somália",
                        "Eritreia",
                        "Sudão",
                        "Djibuti"
                ),

                // Pergunta 5 - Egito
                new Pergunta(
                        R.drawable.egito,
                        "Egito",
                        "Iraque",
                        "Síria",
                        "Jordânia",
                        "Egito"
                ),

                // Pergunta 6 - Finlândia
                new Pergunta(
                        R.drawable.finlandia,
                        "Suécia",
                        "Noruega",
                        "Finlândia",
                        "Islândia",
                        "Finlândia"
                ),

                // Pergunta 7 - Georgia
                new Pergunta(
                        R.drawable.georgia,
                        "Geórgia",
                        "Inglaterra",
                        "Dinamarca",
                        "Suíça",
                        "Geórgia"
                ),

                // Pergunta 8 - Haiti
                new Pergunta(
                        R.drawable.haiti,
                        "Haiti",
                        "República Dominicana",
                        "Cuba",
                        "Jamaica",
                        "Haiti"
                ),

                // Pergunta 9 - Índia
                new Pergunta(
                        R.drawable.india,
                        "Índia",
                        "Paquistão",
                        "Bangladesh",
                        "Nepal",
                        "Índia"
                ),

                // Pergunta 10 - Japão
                new Pergunta(
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