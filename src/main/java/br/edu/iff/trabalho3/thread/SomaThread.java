package br.edu.iff.trabalho3.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SomaThread extends Thread{
    private Semaphore somaSemaphore;
    private Semaphore subtracaoSemaphore;
    private Integer a;
    private Integer b;
    private Integer n;
    private Integer t;

    public SomaThread(Integer a, Integer b, Integer n, Semaphore somaSemaphore, Semaphore subtracaoSemaphore) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.somaSemaphore = somaSemaphore;
        this.subtracaoSemaphore = subtracaoSemaphore;

        t = new Random().nextInt(10) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            try {
                somaSemaphore.acquire();
                soma();
                subtracaoSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void soma() throws InterruptedException{
        System.out.println("Eu sou a Thread SOMA e vou dormir por " + t + " segundos!");
        Thread.sleep(t * 1000);
        System.out.println("Eu sou a Thread SOMA. Resultado: " + (a + b));
    }
}
