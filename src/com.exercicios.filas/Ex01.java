public class Ex01 {
    public static void main(String[] args) {
        /*
         * Crie uma fila de documentos para serem impressos.
         * Cada documento tem um nome e quantidade de folhas.
         * Se desejar, use threads.
         */

        record Documento(String nome, int folhas) {
        }

        var fila = new Fila<Documento>(10);

        fila.enfileira(new Documento("PDF histórico", 3));
        fila.enfileira(new Documento("PDF identidade", 1));
        fila.enfileira(new Documento("PDF residência", 2));
        fila.enfileira(new Documento("PDF Quitação eleitoral", 1));

        while (!fila.isVazia()) {
            System.out.println("Imprimindo: " + fila.espiar().nome());
            try {
                Thread.sleep(fila.desenfileira().folhas() * 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}