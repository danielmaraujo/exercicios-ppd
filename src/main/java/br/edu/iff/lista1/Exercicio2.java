//Grupo: Gabriel Silveira, Daniel Machado, Lívia Pessanha, Matheus Rocha
package br.edu.iff.lista1;

import java.util.Arrays;
import java.util.Random;

public class Exercicio2 {
    private static final int ordem = 4;

    private static int[][] gerarMatriz(){
        int[][] matriz = new int[ordem][ordem];
        Random random = new Random();

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                matriz[i][j] = random.nextInt(0, 29);
            }
        }

        return matriz;
    }

    private static int[][] calcularTransposta(int[][] matriz){
        int[][] transposta = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }

        return transposta;
    }

    private static int[][] multiplicarMatriz(int[][] m1, int[][]m2){
        int[][] resultado = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                int soma = 0;
                for (int k = 0; k < ordem; k++) {
                    soma += m1[i][k] * m2[k][j];
                }
                resultado[i][j] = soma;
            }
        }

        return resultado;
    }

    private static boolean checarOrtogonal(int[][] matriz){
        int[][] identidade = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };

        return Arrays.deepEquals(multiplicarMatriz(matriz, calcularTransposta(matriz)), identidade);
    }

    public static void main(String[] args) {
        int[][] matriz = gerarMatriz();
        int[][] transposta = calcularTransposta(matriz);
        int[][] resultado = multiplicarMatriz(matriz, transposta);

        if (checarOrtogonal(resultado)){
            System.out.println("A matriz é ortogonal");
        }else{
            System.out.println("A matriz não é ortogonal");
        }
    }
}