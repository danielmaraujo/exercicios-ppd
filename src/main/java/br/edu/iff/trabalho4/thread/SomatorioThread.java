package br.edu.iff.trabalho4.thread;

import java.util.concurrent.Semaphore;

public class SomatorioThread extends Thread{
    private int[] x;
    private int[][] L;
    private Semaphore xSemaphore;
    private Semaphore sumSemaphore;

    public SomatorioThread(int[] x, int[][] L, Semaphore xSemaphore, Semaphore sumSemaphore) {
        this.x = x;
        this.L = L;
        this.xSemaphore = xSemaphore;
        this.sumSemaphore = sumSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < x.length; i++) {
            try {
                sumSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int j = 0; j < i; j++) {
                x[i] -= L[i][j] * x[j];
            }

            xSemaphore.release();
        }
    }
}
