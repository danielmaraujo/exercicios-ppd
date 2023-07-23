package br.edu.iff.trabalho2.runnable;

public class MultiplicacaoRunnable implements Runnable{
    private Integer a;
    private Integer b;
    private Integer t;

    public MultiplicacaoRunnable(Integer a, Integer b, Integer t) {
        this.a = a;
        this.b = b;
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("Eu sou a Thread MULTIPLICACAO (" + (a * b) + ") e vou dormir por " + t + " segundos!");

        //Exceção é lançada caso a thread que está dormindo seja interrompida por outra
        try {
            Thread.sleep(t * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Eu sou a Thread MULTIPLICACAO (" + (a * b) + "). Já se passaram " + t + " segundos, então terminei!");
    }
}
