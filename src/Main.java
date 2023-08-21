import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pilha<String> pilha = new Pilha<String>(2);
        pilha.adiciona("Gym");
        pilha.adiciona("Leg day");

        try {
            pilha.adiciona("Hard");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(pilha.desempilha());
        System.out.println(pilha);
    }
}
