package padroesestruturais.flyweight;

public class Produto {

    private String nome;
    private String categoria;
    private double precoBase;
    private int tempoPreparoMinutos;

    public Produto(String nome, String categoria, double precoBase, int tempoPreparoMinutos) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoBase = precoBase;
        this.tempoPreparoMinutos = tempoPreparoMinutos;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int getTempoPreparoMinutos() {
        return tempoPreparoMinutos;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precoBase=" + precoBase +
                ", tempoPreparoMinutos=" + tempoPreparoMinutos +
                '}';
    }
}