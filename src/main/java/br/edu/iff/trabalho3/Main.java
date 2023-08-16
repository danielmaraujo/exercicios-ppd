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

        Semaphore executionSemaphore = new Semaphore(1, true);

        SomaThread soma = new SomaThread(a, b, N, executionSemaphore);
        SubtracaoThread subtracao = new SubtracaoThread(a, b, N, executionSemaphore);
        MultiplicacaoThread multiplicacao = new MultiplicacaoThread(a, b, N, executionSemaphore);
        DivisaoThread divisao = new DivisaoThread(a, b, N, executionSemaphore);


        Semaphore threadStartSemaphore = new Semaphore(1, true);

        try {
            threadStartSemaphore.acquire();
            soma.start();
            threadStartSemaphore.release();

            threadStartSemaphore.acquire();
            subtracao.start();
            threadStartSemaphore.release();

            threadStartSemaphore.acquire();
            multiplicacao.start();
            threadStartSemaphore.release();

            threadStartSemaphore.acquire();
            divisao.start();
            threadStartSemaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
