package br.edu.iff.trabalho3.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DivisaoThread extends Thread{
    private Semaphore divisaoSemaphore;
    private Semaphore somaSemaphore;
    private Integer a;
    private Integer b;
    private Integer n;
    private Integer t;

    public DivisaoThread(Integer a, Integer b, Integer n, Semaphore divisaoSemaphore, Semaphore somaSemaphore) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.divisaoSemaphore = divisaoSemaphore;
        this.somaSemaphore = somaSemaphore;

        t = new Random().nextInt(10) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            try {
                divisaoSemaphore.acquire();
                divisao();
                somaSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void divisao() throws InterruptedException{
        System.out.println("Eu sou a Thread DIVISAO e vou dormir por " + t + " segundos!");
        Thread.sleep(t * 1000);
        System.out.println("Eu sou a Thread DIVISAO. Resultado: " + (a / b));
    }
}
