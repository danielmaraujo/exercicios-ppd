package br.edu.iff.trabalho4.thread;

import br.edu.iff.trabalho4.Main;

import java.util.concurrent.Semaphore;

public class XThread extends Thread{
    private int[] x;
    private int[] b;
    private int[][] L;
    private Semaphore xSemaphore;
    private Semaphore sumSemaphore;

    public XThread(int[] x, int[] b, int[][] L, Semaphore xSemaphore, Semaphore sumSemaphore) {
        this.x = x;
        this.b = b;
        this.L = L;
        this.xSemaphore = xSemaphore;
        this.sumSemaphore = sumSemaphore;
    }

    public void run() {
        for (int i = 0; i < x.length; i++) {
            x[i] = b[i];

            sumSemaphore.release();

            try {
                xSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            x[i] /= L[i][i];
        }
    }
}
