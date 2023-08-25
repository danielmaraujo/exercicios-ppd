package br.edu.iff.trabalho3;

import br.edu.iff.trabalho3.thread.DivisaoThread;
import br.edu.iff.trabalho3.thread.MultiplicacaoThread;
import br.edu.iff.trabalho3.thread.SomaThread;
import br.edu.iff.trabalho3.thread.SubtracaoThread;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        int a = scanner.nextInt();

        System.out.print("Digite o valor de b (b ≠ 0): ");
        int b = scanner.nextInt();

        System.out.print("Digite o valor de N (N ≥ 1): ");
        int N = scanner.nextInt();

        Semaphore somaSemaphore = new Semaphore(1);
        Semaphore subtracaoSemaphore = new Semaphore(0);
        Semaphore multiplicacaoSemaphore = new Semaphore(0);
        Semaphore divisaoSemaphore = new Semaphore(0);

        SomaThread soma = new SomaThread(a, b, N, somaSemaphore, subtracaoSemaphore);
        SubtracaoThread subtracao = new SubtracaoThread(a, b, N, subtracaoSemaphore, multiplicacaoSemaphore);
        MultiplicacaoThread multiplicacao = new MultiplicacaoThread(a, b, N, multiplicacaoSemaphore, divisaoSemaphore);
        DivisaoThread divisao = new DivisaoThread(a, b, N, divisaoSemaphore, somaSemaphore);

        subtracao.start();
        soma.start();
        multiplicacao.start();
        divisao.start();

    }
}
