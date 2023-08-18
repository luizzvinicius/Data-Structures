import java.util.*;

public class Main {
    public static void main(String[] args) {
        var lista = new Vetor<String>(1);
        lista.adiciona("A");
        lista.adiciona("B");
        lista.adiciona("C");
        lista.adiciona("C");
        lista.adiciona("C");
        lista.adiciona("E");
        lista.adiciona("F");

        lista.limpa();
        System.out.println(lista.toString());
    }
}
