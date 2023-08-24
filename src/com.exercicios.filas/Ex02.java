import java.util.*;

public class Ex02 {
    public static void main(String[] args) {
        /*
         * Distribuição de senhas. As senhas devem ter prioridade ou não.
         * Existe apenas 1 atendente
         * Uma senha normal deve ser atendida após três senhas prioritárias
         * Não havendo prioridades, atendimento normal.
         */

        record Senha(int numero, int prioridade) implements Comparable<Senha> {
            @Override
            public int compareTo(Senha e1) {
                if (this.prioridade() < e1.prioridade()) {
                    return -1;
                } else if (this.prioridade() > e1.prioridade())
                    return 1;
                return 0;
            }
        }
        var fila = new FilaPrioridade<Senha>(8);
        var filaPrioridade = new FilaPrioridade<Senha>(8);
        final int MAX_PRIORIDADE_ATENDIDAS = 3;

        for (var i = 1; i < 20; i++) {
            int prioridade = new Random().nextInt(2) + 1;
            if (prioridade == 1) {
                filaPrioridade.enfileira(new Senha(i, prioridade));
            } else {
                fila.enfileira(new Senha(i, prioridade));
            }
        }

        System.out.println(fila);
        System.out.println(filaPrioridade);

        int atendidoPrioridade = 0;
        while (!fila.isVazia() || !filaPrioridade.isVazia()) {
            if (filaPrioridade.espiar() != null && atendidoPrioridade < MAX_PRIORIDADE_ATENDIDAS) {
                System.out.println(filaPrioridade.desenfileira());
                atendidoPrioridade += 1;
                continue;
            }
            atendidoPrioridade = 0;
            if (fila != null) {
                System.out.println(fila.desenfileira());
            }
        }
    }
}