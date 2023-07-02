//Grupo: Gabriel Silveira, Daniel Machado, Lívia Pessanha, Matheus Rocha, Gabriel Fraga
package br.edu.iff.trabalho;

public class Trabalho1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Programacao Paralela");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sistemas de Informacao");
            }
        });

        thread1.start();
        thread2.start();
    }
}
