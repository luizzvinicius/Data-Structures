import java.util.*;

public class Main {
    public static void main(String[] args) {
        var quociente = new Pilha<Integer>(10);
        
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Digite o número: ");
            int num = scan.nextInt();
            while (num > 0) {
                quociente.empilha(num % 2);
                num /= 2;
            }
            while (!quociente.isVazia()) {
                System.out.print(quociente.desempilha());
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
