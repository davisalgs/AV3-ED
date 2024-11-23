package estruturas.TabelaHash;

public class Palavra implements Comparable<Palavra> {
    private String texto;
    private ListaDuplamenteEncadeada<Integer> ocorrencias;

    public Palavra(String texto) {
        this.texto = texto.toLowerCase(); // Ignora case.
        this.ocorrencias = new ListaDuplamenteEncadeada<>();
    }

    public String getTexto() {
        return texto;
    }

    public ListaDuplamenteEncadeada<Integer> getOcorrencias() {
        return ocorrencias;
    }

    public void adicionarOcorrencia(int linha) {
        this.ocorrencias.adicionarFinal(linha);
    }

    @Override
    public int compareTo(Palavra outra) {
        return this.texto.compareTo(outra.texto);
    }

    @Override
    public String toString() {
        return texto + " -> " + ocorrencias.toString();
    }
}
