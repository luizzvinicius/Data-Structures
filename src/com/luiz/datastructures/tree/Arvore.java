package com.luiz.datastructures.tree;

import com.luiz.datastructures.fila.Fila;

public class Arvore<T> {
    private No<T> raiz;
    private int tamanho;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(T valor) {
        this.raiz = new No<T>(valor);
        this.tamanho++;
    }

    public void adiciona(T valor) {
        No<T> novo = new No<>(valor);
        if (this.tamanho == 0) {
            this.raiz = novo;
            this.tamanho++;
        } else {
            No<T> atual = this.raiz;
            @SuppressWarnings("unchecked")
            Comparable<T> chave = (Comparable<T>) valor;
            while (true) {
                if (chave.compareTo(atual.getValor()) < 0) {
                    if (atual.getEsquerda() != null) {
                        atual = atual.getEsquerda();
                    } else {
                        atual.setEsquerda(novo);
                        this.tamanho++;
                        break;
                    }
                } else {
                    if (atual.getDireita() != null) {
                        atual = atual.getDireita();
                    } else {
                        atual.setDireita(novo);
                        this.tamanho++;
                        break;
                    }
                }
            }
        }
    }

    public No<T> remove(T valor, No<T> node) {
        if (valor.equals(this.raiz.getValor())) {
            node = this.raiz;
        }
        if (node == null) {
            return node;
        }
        @SuppressWarnings("unchecked")
        Comparable<T> chave = (Comparable<T>) valor;
        if (chave.compareTo(node.getValor()) < 0) {
            node.setEsquerda(this.remove(valor, node.getEsquerda()));
        } else if (chave.compareTo(node.getValor()) > 0) {
            node.setDireita(this.remove(valor, node.getDireita()));
        } else {
            if (node.getEsquerda() == null) {
                return node.getDireita();
            } else if (node.getDireita() == null) {
                return node.getEsquerda();
            } else {
                T substituNo = this.menor(node.getDireita());
                node.setDireita(this.remove(substituNo, node.getDireita()));
                node.setValor(substituNo);
            }
        }
        // this.tamanho--; não funciona
        return node;
    }

    public boolean contains(T valor) {
        No<T> atual = this.raiz;
        @SuppressWarnings("unchecked")
        Comparable<T> chave = (Comparable<T>) valor;
        while (atual != null) {
            if (chave.compareTo(atual.getValor()) < 0) {
                atual = atual.getEsquerda();
            } else if (chave.compareTo(atual.getValor()) > 0) {
                atual = atual.getDireita();
            } else {
                return true;
            }
        }
        return false;
    }

    public void emOrdem(No<T> init) {
        if (init != null) {
            emOrdem(init.getEsquerda());
            System.out.print(init.getValor() + " ");
            emOrdem(init.getDireita());
        }
        // if (init.getEsquerda() != null) {
        //     emOrdem(init.getEsquerda());
        // }
        // System.out.print(init.getValor() + ", ");
        // if (init.getDireita() != null) {
        //     emOrdem(init.getDireita());
        // }
    }

    public void preOrdem(No<T> init) {
        if (init != null) {
            System.out.print(init.getValor() + " ");
            preOrdem(init.getEsquerda());
            preOrdem(init.getDireita());
        }
    }

    public void posOrdem(No<T> init) {
        if (init != null) {
            posOrdem(init.getEsquerda());
            posOrdem(init.getDireita());
            System.out.print(init.getValor() + " ");
        }
    }

    public void emNivel() {
        if (this.raiz == null) {
            return;
        }

        var fila = new Fila<No<T>>(this.tamanho);
        fila.enfileira(this.raiz);

        System.out.print("[");
        while (fila.tamanho() != 0) {
            No<T> removido = fila.desenfileira();
            if (removido.getEsquerda() != null) {
                fila.enfileira(removido.getEsquerda());
            }
            if (removido.getDireita() != null) {
                fila.enfileira(removido.getDireita());
            }
            System.out.print(" " + removido);
        }
        System.out.print("]");
    }

    public int height(No<T> init) { // usa a lógica do posOrdem | Entender melhor
        if (init == null) {
            return 0;
        }
        if (init.getEsquerda() == null && init.getDireita() == null) {
            return 1;
        }

        int altEsq = 0, altDir = 0;

        if (init.getEsquerda() != null) {
            altEsq = this.height(init.getEsquerda());
        }

        if (init.getDireita() != null) {
            altDir = this.height(init.getDireita());
        }

        return 1 + Math.max(altEsq, altDir);
    }

    public T menor(No<T> qualquer) {
        if (this.raiz == null) {
            return null;
        } else if (qualquer == null) {
            qualquer = this.raiz;
        }

        while (qualquer.getEsquerda() != null) {
            qualquer = qualquer.getEsquerda();
        }
        return qualquer.getValor();
    }

    public T maior(No<T> qualquer) {
        if (this.raiz == null) {
            return null;
        } else if (qualquer == null) {
            qualquer = this.raiz;
        }

        while (qualquer.getDireita() != null) {
            qualquer = qualquer.getDireita();
        }
        return qualquer.getValor();
    }

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getRaiz() {
        return raiz;
    }
}