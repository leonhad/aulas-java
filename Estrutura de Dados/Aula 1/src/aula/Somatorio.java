package aula;

public class Somatorio {
    public static void main(String[] args) {
        Somatorio instancia = new Somatorio();

        System.out.println("Linear");
        System.out.println(instancia.linear(10));

        System.out.println("Recursivo");
        System.out.println(instancia.recursivo(10));
    }

    public int linear(int valor) {
        int somatorio = 0;

        for (int indice = 1; indice <= valor; indice++) {
            somatorio += indice;
        }

        return somatorio;
    }

    public int recursivo(int valor) {
        // Condição de parada
        if (valor < 1) {
            return 0;
        }

        return valor + recursivo(valor - 1);
    }
}
