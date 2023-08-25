package br.edu.iff.trabalho3.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SubtracaoThread extends Thread{
    private Semaphore subtracaoSemaphore;
    private Semaphore multiplicacaoSemaphore;
    private Integer a;
    private Integer b;
    private Integer n;
    private Integer t;

    public SubtracaoThread(Integer a, Integer b, Integer n, Semaphore subtracaoSemaphore, Semaphore multiplicacaoSemaphore) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.subtracaoSemaphore = subtracaoSemaphore;
        this.multiplicacaoSemaphore = multiplicacaoSemaphore;

        t = new Random().nextInt(10) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            try {
                subtracaoSemaphore.acquire();
                subtracao();
                multiplicacaoSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void subtracao() throws InterruptedException{
        System.out.println("Eu sou a Thread SUBTRACAO e vou dormir por " + t + " segundos!");
        Thread.sleep(t * 1000);
        System.out.println("Eu sou a Thread SUBTRACAO. Resultado: " + (a - b));
    }
}
