//Grupo: Gabriel Silveira, Daniel Machado, Lívia Pessanha, Matheus Rocha
package br.edu.iff.lista1;

import java.util.Random;

public class Exercicio1 {
    private static final int linhas = 3;
    private static final int colunas = 4;

    private static final int[][] matriz = new int[linhas][colunas];

    private static void preencherMatriz(){
        Random random = new Random();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = random.nextInt(1, 20);
            }
        }
    }

    private static int menorValor_SomatorioColunas(){
        int menorValor = -1;

        for (int j = 0; j < colunas; j++) {
            int somatorio = 0;

            for (int i = 0; i < linhas; i++) {
                somatorio += matriz[i][j];
            }

            if(somatorio < menorValor || menorValor == -1){
                menorValor = somatorio;
            }
        }

        return menorValor;
    }

    private static int maiorValor_ProdutorioLinhas(){
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

    private static boolean verificarCondicao(){
        return menorValor_SomatorioColunas() <= maiorValor_ProdutorioLinhas();
    }

    private static void imprimirMatriz(){
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        preencherMatriz();
        imprimirMatriz();

        if(verificarCondicao()){
            System.out.println("Condicao Satisfeita");
        }else{
            System.out.println("Condicao Nao Satisfeita");
        }
    }
}