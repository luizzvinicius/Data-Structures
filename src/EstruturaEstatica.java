public class EstruturaEstatica<T> {
    // Vai servir de base para as outras estruturas
    protected T[] vetor;
    protected int adicionados;

    public EstruturaEstatica(int capacidade) {
        this.vetor = (T[]) new Object[capacidade];
        this.adicionados = 0;
    }

    protected void adiciona(T elem) {
        this.aumentaCapacidade();
        this.vetor[this.adicionados] = elem;
        this.adicionados++;
    }

    protected void adiciona(T elem, int index) throws Exception {
        this.aumentaCapacidade();
        if (index < 0 || index > this.adicionados) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        for (var i = this.adicionados; i > index; i--) {
            this.vetor[i] = this.vetor[i - 1];
        }
        this.vetor[index] = elem;
        this.adicionados++;
    }

    private void aumentaCapacidade() {
        var size = this.vetor.length;
        if (this.adicionados == size) {
            var biggerVetor = (T[]) new Object[size * 2];
            for (var i = 0; i < this.vetor.length; i++) {
                biggerVetor[i] = this.vetor[i];
            }
            this.vetor = biggerVetor;
        }
    }

    public int tamanho() {
        return this.adicionados;
    }

    public boolean isVazia() {
        return this.adicionados == 0;
    }

    @Override
    public String toString() {
        var s = new StringBuilder();
        s.append("[");

        for (var i = 0; i < this.adicionados; i++) {
            s.append(this.vetor[i]);
            s.append(", ");
        }

        if (this.adicionados > 0) {
            var size = s.length();
            s.delete(size - 2, size);
        }

        s.append("]");
        return s.toString();
    }
}
