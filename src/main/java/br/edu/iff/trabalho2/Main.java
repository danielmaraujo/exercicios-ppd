package br.edu.iff.trabalho2;

import br.edu.iff.trabalho2.runnable.DivisaoRunnable;
import br.edu.iff.trabalho2.runnable.MultiplicacaoRunnable;
import br.edu.iff.trabalho2.runnable.SomaRunnable;
import br.edu.iff.trabalho2.runnable.SubtracaoRunnable;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int a = scanner.nextInt();
        System.out.println("Digite o segundo número: ");
        int b = scanner.nextInt();

        Random random = new Random();

        Thread threadSoma = new Thread(new SomaRunnable(a, b, random.nextInt(20) + 1));
        Thread threadSubtracao = new Thread(new SubtracaoRunnable(a, b, random.nextInt(20) + 1));
        Thread threadMultiplicacao = new Thread(new MultiplicacaoRunnable(a, b, random.nextInt(20) + 1));
        Thread threadDivisao = new Thread(new DivisaoRunnable(a, b, random.nextInt(20) + 1));

        threadSoma.start();
        threadSubtracao.start();
        threadMultiplicacao.start();
        threadDivisao.start();
    }
}
