//Grupo: Gabriel Silveira, Daniel Machado, Lívia Pessanha, Matheus Rocha, Gabriel Fraga
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
        //Iterando o vetor
        for (int i = 0; i < vetor.length; i++) {
            //Checa se a posição e seu conteúdo corrrespondente são pares
            if (i % 2 == 0 && vetor[i] % 2 == 0) {
                //A partir da próxima posição (ímpar)
                int j = i + 1;
                //Enquanto conteúdo na posição j for par, pula para a próxima posição ímpar
                while (j < vetor.length && vetor[j] % 2 == 0) {
                    j += 2;
                }
                //Troca elementos
                if (j < vetor.length) {
                    trocarElementos(vetor, i, j);
                }
            //Checa se a posição e seu conteúdo corrrespondente são pares
            } else if (i % 2 != 0 && vetor[i] % 2 != 0) {
                //A partir da próxima posição (par)
                int j = i + 1;
                //Enquanto conteúdo na posição j for ímpar, pula para a próxima posição par
                while (j < vetor.length && vetor[j] % 2 != 0) {
                    j += 2;
                }
                //Troca elementos
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
        int[] vetor = new int[20];
        preencherVetor(vetor);
        organizarVetor(vetor);
        imprimirVetor(vetor);
    }
}