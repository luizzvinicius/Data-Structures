public class Vetor<T> extends EstruturaEstatica<T> {
    private T[] vetor;
    private int adicionados;

    public Vetor(int capacidade) {
        super(capacidade);
    }

    // adicionar elemento
    public void adiciona(T elem) {
        super.adiciona(elem);
    }

    public void adiciona(T elem, int index) throws Exception {
        super.adiciona(elem, index);
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
        super.remove(index);
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
}