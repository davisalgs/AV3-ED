package estruturas.TabelaHash;

import estruturas.ABB.ArvoreBinariaBusca;
import estruturas.ABB.TreeNode;

public class TabelaHash {
    private static final int TAMANHO_TABELA = 26; // Uma posição para cada letra do alfabeto.
    private ListaDuplamenteEncadeada<ArvoreBinariaBusca<Palavra>>[] tabela;

    public TabelaHash() {
        // Inicializa o array de listas duplamente encadeadas.
        tabela = new ListaDuplamenteEncadeada[TAMANHO_TABELA];
        for (int i = 0; i < TAMANHO_TABELA; i++) {
            tabela[i] = new ListaDuplamenteEncadeada<>();
        }
    }

    // Método para calcular o índice da tabela baseado na primeira letra da palavra
    private int calcularIndice(String palavra) {
        char primeiraLetra = Character.toLowerCase(palavra.charAt(0)); // Ignora case.
        return primeiraLetra - 'a'; // Converte 'a' em 0, 'b' em 1, ..., 'z' em 25.
    }

    // Insere uma palavra na tabela hash
    public void inserir(String palavra, int linha) {
        int indice = calcularIndice(palavra);

        // Obtém a lista correspondente à letra inicial.
        ListaDuplamenteEncadeada<ArvoreBinariaBusca<Palavra>> lista = tabela[indice];

        // Procura a árvore binária onde a palavra está ou pode ser inserida.
        ArvoreBinariaBusca<Palavra> arvoreCorrespondente = null;

        // Verifica se a lista já contém uma árvore. Caso contrário, cria uma.
        if (lista.tamanho() == 0) {
            arvoreCorrespondente = new ArvoreBinariaBusca<>();
            lista.adicionarFinal(arvoreCorrespondente);
        } else {
            arvoreCorrespondente = lista.get(0); // Assume que há apenas uma árvore por letra.
        }

        // Procura pela palavra na árvore.
        Palavra novaPalavra = new Palavra(palavra);
        Palavra palavraExistente = arvoreCorrespondente.busca(novaPalavra);

        if (palavraExistente == null) {
            // Palavra não existe na árvore; insere uma nova.
            novaPalavra.adicionarOcorrencia(linha);
            arvoreCorrespondente.insere(novaPalavra);
        } else {
            // Palavra já existe; atualiza as ocorrências.
            palavraExistente.adicionarOcorrencia(linha);
        }
    }

    // Busca uma palavra na tabela hash
    public Palavra buscar(String palavra) {
        int indice = calcularIndice(palavra);

        ListaDuplamenteEncadeada<ArvoreBinariaBusca<Palavra>> lista = tabela[indice];

        if (lista.tamanho() == 0) {
            return null; // Nenhuma árvore associada à letra.
        }

        ArvoreBinariaBusca<Palavra> arvoreCorrespondente = lista.get(0);

        return arvoreCorrespondente.busca(new Palavra(palavra));
    }

    // Imprime todo o índice remissivo
    public void imprimirIndiceRemissivo() {
        for (int i = 0; i < TAMANHO_TABELA; i++) {
            ListaDuplamenteEncadeada<ArvoreBinariaBusca<Palavra>> lista = tabela[i];
            if (lista.tamanho() > 0) {
                System.out.println("Palavras com inicial '" + (char) ('a' + i) + "':");
                lista.get(0).imprimirEmOrdem(); // Assume que há apenas uma árvore na lista.
                System.out.println();
            }
        }
    }
}

