import java.util.*;

public class Main {
    public static void main(String[] args) {
        var fila = new Fila<Integer>(10);

        fila.enfileira(2);
        fila.enfileira(3);
        fila.enfileira(4);
        fila.enfileira(5);

        fila.desenfileira();

        System.out.println(fila);
    }
}
