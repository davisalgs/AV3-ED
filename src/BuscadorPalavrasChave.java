import estruturas.TabelaHash.Palavra;
import estruturas.TabelaHash.TabelaHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuscadorPalavrasChave {
    private TabelaHash tabelaHash;

    public BuscadorPalavrasChave(TabelaHash tabelaHash) {
        this.tabelaHash = tabelaHash;
    }

    public void buscarPalavrasChave(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String palavra;

            while ((palavra = reader.readLine()) != null) {
                Palavra resultado = tabelaHash.buscar(palavra);

                if (resultado != null) {
                    System.out.println("Palavra: " + resultado.getTexto());
                    System.out.println("Ocorrências: " + resultado.getOcorrencias());
                } else {
                    System.out.println("Palavra '" + palavra + "' não encontrada.");
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
