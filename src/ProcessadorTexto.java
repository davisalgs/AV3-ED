import estruturas.TabelaHash.TabelaHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessadorTexto {
    private TabelaHash tabelaHash;

    public ProcessadorTexto() {
        this.tabelaHash = new TabelaHash();
    }

    public TabelaHash getTabelaHash() {
        return tabelaHash;
    }

    public void processarTexto(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int numeroLinha = 1;

            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.split("[^a-zA-ZÀ-ÿ]+"); // Divide ignorando pontuações.
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        tabelaHash.inserir(palavra, numeroLinha);
                    }
                }
                numeroLinha++;
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
