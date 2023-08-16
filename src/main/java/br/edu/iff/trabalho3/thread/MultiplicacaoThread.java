package br.edu.iff.trabalho3.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class MultiplicacaoThread extends Thread{
    private Semaphore semaphore;
    private Integer a;
    private Integer b;
    private Integer n;
    private Integer t;

    public MultiplicacaoThread(Integer a, Integer b, Integer n, Semaphore semaphore) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.semaphore = semaphore;

        t = new Random().nextInt(2) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            try {
                semaphore.acquire();
                multiplicacao();
                semaphore.release();
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
