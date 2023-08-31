package br.edu.iff.trabalho4;

import br.edu.iff.trabalho4.thread.SomatorioThread;
import br.edu.iff.trabalho4.thread.XThread;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        int[][] L = {{2, 0, 0}, {1, 4, 0}, {1, 1, 1}};
        int[] b = {2, -3, 1};
        int[] x = new int[b.length];

        Semaphore xSemaphore = new Semaphore(0);
        Semaphore somaSemaphore = new Semaphore(0);

        XThread xThread = new XThread(x, b, L, xSemaphore, somaSemaphore);
        SomatorioThread sumThread = new SomatorioThread(x, L, xSemaphore, somaSemaphore);

        xThread.start();
        sumThread.start();

        try {
            xThread.join();
            sumThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
