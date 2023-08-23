public class FilaPrioridade<T> extends Fila<T> {

    public FilaPrioridade(int capacidade) {
        super(capacidade);
    }

    public void enfileira(T elem) {
        Comparable<T> chave = (Comparable<T>) elem;

        int i;
        for (i = 0; i < this.tamanho(); i++) {
            if (chave.compareTo(this.vetor[i]) < 0) {
                break;
            }
        }

        try {
            super.adiciona(elem, i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}