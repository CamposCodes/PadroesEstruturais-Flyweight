package padroesestruturais.flyweight;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private String tamanho;
    private double desconto;

    public ItemPedido(Produto produto, int quantidade, String tamanho, double desconto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.desconto = desconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getDesconto() {
        return desconto;
    }

    public double calcularPrecoTotal() {
        double preco = produto.getPrecoBase() * quantidade;
        return preco - desconto;
    }

    @Override
    public String toString() {
        return "ItemPedido{\" +
                "produto='" + produto.getNome() + '\'' +
                ", quantidade=" + quantidade +
                ", tamanho='" + tamanho + '\'' +
                ", desconto=" + desconto +
                ", precoTotal=" + calcularPrecoTotal() +
                '}';
    }
}