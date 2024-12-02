package estruturas.TabelaHash;

import estruturas.ABB.ArvoreBinariaBusca;
import estruturas.ABB.TreeNode;

public class TabelaHash {
    private static final int TAMANHO_TABELA = 26;
    private ListaDuplamenteEncadeada<ArvoreBinariaBusca<Palavra>>[] tabela;

    public TabelaHash() {

        tabela = new ListaDuplamenteEncadeada[TAMANHO_TABELA];
        for (int i = 0; i < TAMANHO_TABELA; i++) {
            tabela[i] = new ListaDuplamenteEncadeada<>();
        }
    }


    private int calcularIndice(String palavra) {
        char primeiraLetra = Character.toLowerCase(palavra.charAt(0));
        return primeiraLetra - 'a';
    }


    public void inserir(String palavra, int linha) {
        int indice = calcularIndice(palavra);


        ListaDuplamenteEncadeada<ArvoreBinariaBusca<Palavra>> lista = tabela[indice];


        ArvoreBinariaBusca<Palavra> arvoreCorrespondente = null;


        if (lista.tamanho() == 0) {
            arvoreCorrespondente = new ArvoreBinariaBusca<>();
            lista.adicionarFinal(arvoreCorrespondente);
        } else {
            arvoreCorrespondente = lista.get(0);
        }


        Palavra novaPalavra = new Palavra(palavra);
        Palavra palavraExistente = arvoreCorrespondente.busca(novaPalavra);

        if (palavraExistente == null) {

            novaPalavra.adicionarOcorrencia(linha);
            arvoreCorrespondente.insere(novaPalavra);
        } else {

            palavraExistente.adicionarOcorrencia(linha);
        }
    }


    public Palavra buscar(String palavra) {
        int indice = calcularIndice(palavra);

        ListaDuplamenteEncadeada<ArvoreBinariaBusca<Palavra>> lista = tabela[indice];

        if (lista.tamanho() == 0) {
            return null;
        }

        ArvoreBinariaBusca<Palavra> arvoreCorrespondente = lista.get(0);

        return arvoreCorrespondente.busca(new Palavra(palavra));
    }


    public void imprimirIndiceRemissivo() {
        for (int i = 0; i < TAMANHO_TABELA; i++) {
            ListaDuplamenteEncadeada<ArvoreBinariaBusca<Palavra>> lista = tabela[i];
            if (lista.tamanho() > 0) {
                System.out.println("Palavras com inicial '" + (char) ('a' + i) + "':");
                lista.get(0).imprimirEmOrdem();
                System.out.println();
            }
        }
    }
}

