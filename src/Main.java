public class Main {
    public static void main(String[] args) {
        String caminhoTexto = "resources/texto.txt";
        String caminhoPalavrasChave = "resources/palavras-chave.txt";


        // Processar o texto.
        ProcessadorTexto processadorTexto = new ProcessadorTexto();
        processadorTexto.processarTexto(caminhoTexto);

        // Buscar palavras-chave.
        BuscadorPalavrasChave buscador = new BuscadorPalavrasChave(processadorTexto.getTabelaHash());
        buscador.buscarPalavrasChave(caminhoPalavrasChave);

        // Imprimir índice remissivo completo (opcional).
        System.out.println("\nÍndice Remissivo Completo:");
        processadorTexto.getTabelaHash().imprimirIndiceRemissivo();
    }
}
