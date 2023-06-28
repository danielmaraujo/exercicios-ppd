//Grupo: Gabriel Silveira, Daniel Machado, Lívia Pessanha, Matheus Rocha
package br.edu.iff.lista1;

import java.util.Random;

public class Exercicio4 {
    private static void preencherVetor(int[] vetor) {
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(30) + 1;
        }
    }

    private static void ordenarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] < vetor[j]) {
                    trocarElementos(vetor, i ,j);
                }
            }
        }
    }

    private static void trocarElementos(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    private static void imprimirVetor(int[] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] vetor = new int[30];
        preencherVetor(vetor);
        imprimirVetor(vetor);
        ordenarVetor(vetor);
        imprimirVetor(vetor);
    }
}