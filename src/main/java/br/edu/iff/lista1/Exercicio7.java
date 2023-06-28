//Grupo: Gabriel Silveira, Daniel Machado, Lívia Pessanha, Matheus Rocha, Gabriel Fraga
package br.edu.iff.lista1;

import java.util.Random;

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

    //Parâmetros são o vetor, o índice atual da iteração e o maior valor até o momento
    private static int encontrarMaiorValorRecursivo(int[] vetor, int indice, int maiorValor) {
        //Chamará a função recusivamente até o final do vetor
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

        //Chama função recursiva com início no índice 0 e com o maior valor sendo 0
        int maiorValor = encontrarMaiorValorRecursivo(vetor, 0, 0);

        System.out.println("Maior valor do vetor: " + maiorValor);
    }
}
