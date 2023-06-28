//Grupo: Gabriel Silveira, Daniel Machado, Lívia Pessanha, Matheus Rocha, Gabriel Fraga
package br.edu.iff.lista1;

import java.util.Random;

public class Exercicio1 {
    private static final int linhas = 4;
    private static final int colunas = 5;

    private static int[][] gerarMatriz(){
        int[][] matriz = new int[linhas][colunas];
        Random random = new Random();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = random.nextInt(1, 20);
            }
        }

        return matriz;
    }

    private static int menorValor_SomatorioColunas(int[][] matriz){
        int menorValor = -1;

        for (int j = 0; j < colunas; j++) {
            int somatorio = 0;

            for (int i = 0; i < linhas; i++) {
                somatorio += Math.abs(matriz[i][j]);
            }

            if(somatorio < menorValor || menorValor == -1){
                menorValor = somatorio;
            }
        }

        return menorValor;
    }

    private static int maiorValor_ProdutorioLinhas(int[][] matriz){
        int maiorValor = 0;


        for (int i = 0; i < linhas; i++) {
            int produtorio = 1;

             for (int j = 0; j < colunas; j++) {
                 produtorio *= matriz[i][j];
            }

            if(produtorio > maiorValor){
                maiorValor = produtorio;
            }
        }

        return maiorValor;
    }

    private static boolean verificarCondicao(int[][] matriz){
        return menorValor_SomatorioColunas(matriz) <= maiorValor_ProdutorioLinhas(matriz);
    }

    private static void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matriz = gerarMatriz();
        imprimirMatriz(matriz);

        if(verificarCondicao(matriz)){
            System.out.println("Condicao Satisfeita");
        }else{
            System.out.println("Condicao Nao Satisfeita");
        }
    }
}