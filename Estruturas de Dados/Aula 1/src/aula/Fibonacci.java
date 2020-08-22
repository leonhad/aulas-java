package aula;

public class Fibonacci {
    public static void main(String[] args) {
        // 1 1 2 3 5 8 ... valor
        // 0 1 2 3 4 5 ... índice

        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonnaci(6));
    }

    public int fibonnaci(int indice) {
        if (indice < 2) {
            return 1;
        }

        return fibonnaci(indice - 1) + fibonnaci(indice - 2);
    }
}
