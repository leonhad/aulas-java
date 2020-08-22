package lista;

public class ListaEncadeada {
    private No topo;

    /**
     * Incluir.
     *
     * @param valor o valor a ser incluído.
     */
    public void add(int valor) {
        if (topo == null) {
            // Primeiro.
            topo = new No();
            topo.setValor(valor);
        } else {
            // Qualquer outro.
            No temp = topo;

            while(temp.getProximo() != null) {
                // Vai para o próximo
                temp = temp.getProximo();
            }

            // Cria um novo.
            No novo = new No();
            novo.setValor(valor);

            // Último aponta para o novo (próximo).
            temp.setProximo(novo);
        }
    }

    public int size() {
        int total = 0;
        No temp = topo;

        while(temp != null) {
            total++;

            // Vai para o próximo
            temp = temp.getProximo();
        }

        return total;
    }

    public int get(int indice) {
        No temp = topo;

        for (int i = 0; i < indice; i++) {
            // Vai para o próximo
            temp = temp.getProximo();
        }

        return temp.getValor();
    }
}
