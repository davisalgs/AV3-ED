public class Main {
    public static void main(String[] args) {
        String caminhoTexto = "texto.txt"; // Caminho do texto-base.
        String caminhoPalavrasChave = "palavras-chave.txt"; // Caminho das palavras-chave.

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
