//Grupo: Gabriel Silveira, Daniel Machado, Lívia Pessanha, Matheus Rocha
package br.edu.iff.lista1;

import java.util.Scanner;

public class Exercicio3 {
    private static void preencherVetor(int[] vetor) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os valores do vetor (10 pares e 10 ímpares): ");
        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = scanner.nextInt();
        }
    }

    private static void organizarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (i % 2 == 0 && vetor[i] % 2 != 0) {
                int j = i + 1;
                while (j < vetor.length && vetor[j] % 2 != 0) {
                    j += 2;
                }
                if (j < vetor.length) {
                    trocarElementos(vetor, i, j);
                }
            } else if (i % 2 != 0 && vetor[i] % 2 == 0) {
                int j = i + 1;
                while (j < vetor.length && vetor[j] % 2 == 0) {
                    j += 2;
                }
                if (j < vetor.length) {
                    trocarElementos(vetor, i, j);
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
    }

    public static void main(String[] args) {
// int[] vetor = new int[20];
// preencherVetor(vetor);

        int[] vetor = {1,1,2,2,1,1,2,2,1,1,2,2,1,1,2,2,1,1,2,2};

        organizarVetor(vetor);
        imprimirVetor(vetor);
    }
}