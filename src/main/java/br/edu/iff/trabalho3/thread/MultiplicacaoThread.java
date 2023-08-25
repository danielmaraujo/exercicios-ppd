package br.edu.iff.trabalho3.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class MultiplicacaoThread extends Thread{
    private Semaphore multiplicacaoSemaphore;
    private Semaphore divisaoSemaphore;
    private Integer a;
    private Integer b;
    private Integer n;
    private Integer t;

    public MultiplicacaoThread(Integer a, Integer b, Integer n, Semaphore multiplicacaoSemaphore, Semaphore divisaoSemaphore) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.multiplicacaoSemaphore = multiplicacaoSemaphore;
        this.divisaoSemaphore = divisaoSemaphore;

        t = new Random().nextInt(10) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            try {
                multiplicacaoSemaphore.acquire();
                multiplicacao();
                divisaoSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void multiplicacao() throws InterruptedException{
        System.out.println("Eu sou a Thread MULTIPLICACAO e vou dormir por " + t + " segundos!");
        Thread.sleep(t * 1000);
        System.out.println("Eu sou a Thread MULTIPLICACAO. Resultado: " + (a * b));
    }
}
