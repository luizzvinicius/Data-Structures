public class Vetor<T> {
    private T[] vetor;
    private int adicionados;

    public Vetor(int capacidade) {
        this.vetor = (T[]) new Object[capacidade];
        this.adicionados = 0;
    }

    // adicionar elemento
    public void adiciona(T elem) {
        this.aumentaCapacidade();
        this.vetor[this.adicionados] = elem;
        this.adicionados++;
    }

    public void adiciona(T elem, int index) throws Exception {
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

    // buscar elemento
    public int busca(T elem) {
        for (var i = 0; i < this.adicionados; i++) {
            if (this.vetor[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public T busca(int index) throws Exception {
        if (!(index >= 0 && index < this.adicionados)) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        return this.vetor[index];
    }

    public boolean contem(T elem) {
        return busca(elem) > -1 ? true : false;
    }

    public int ultimoIndice(T elem) {
        for (int i = this.adicionados - 1; i >= 0; i--) {
            if (this.vetor[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    // excluir elemento
    public void remove(int index) throws IllegalArgumentException {
        if (!(index >= 0 && index < this.adicionados)) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        for (var i = index; i < this.adicionados - 1; i++) {
            this.vetor[i] = this.vetor[i + 1];
        }
        this.adicionados--;
    }

    public void remove(T elem) {
        int index = busca(elem);
        try {
            this.remove(index);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void limpa() {
        // opção 1 (melhorzinha)
        for (int i = 0; i < this.adicionados; i++) {
            this.vetor[i] = null;
        }

        // opção 2
        // this.vetor = (T[]) new Object[this.adicionados];
        
        this.adicionados = 0;
    }

    // verificar quantidade
    public int tamanho() {
        return this.adicionados;
    }

    // mostrar elementos
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