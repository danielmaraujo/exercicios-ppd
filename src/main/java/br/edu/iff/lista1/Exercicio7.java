package br.edu.iff.lista1;

import java.util.Random;
import java.util.Scanner;

public class Exercicio7 {
    private static void preencherVetor(int[] vetor) {
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100) + 1;
        }
    }

    private static void imprimirVetor(int[] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    private static int encontrarMaiorValorRecursivo(int[] vetor, int indice, int maiorValor) {
        if (indice >= vetor.length) {
            return maiorValor;
        }

        if (vetor[indice] > maiorValor) {
            maiorValor = vetor[indice];
        }

        return encontrarMaiorValorRecursivo(vetor, indice + 1, maiorValor);
    }

    public static void main(String[] args) {
        int[] vetor = new int[50];

        preencherVetor(vetor);
        imprimirVetor(vetor);

        int maiorValor = encontrarMaiorValorRecursivo(vetor, 0, 1);

        System.out.println("Maior valor do vetor: " + maiorValor);
    }
}
