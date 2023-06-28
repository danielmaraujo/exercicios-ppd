package br.edu.iff.lista1;

import java.util.Scanner;

public class Exercicio5 {
    public static int calcularPotencia(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            return a * calcularPotencia(a, b - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        int a = scanner.nextInt();

        System.out.print("Digite o valor de b: ");
        int b = scanner.nextInt();

        int resultado = calcularPotencia(a, b);

        System.out.println(a + "^" + b + " = " + resultado);
    }
}
