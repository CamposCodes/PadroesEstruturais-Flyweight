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
        double multiplicador = 1.0;
        if (tamanho != null) {
            if ("Pequeno".equalsIgnoreCase(tamanho)) {
                multiplicador = 1.0;
            } else if ("Médio".equalsIgnoreCase(tamanho) || "Medio".equalsIgnoreCase(tamanho) || "Medio".equalsIgnoreCase(tamanho)) {
                multiplicador = 1.1;
            } else if ("Grande".equalsIgnoreCase(tamanho)) {
                multiplicador = 1.2;
            }
        }

        double preco = produto.getPrecoBase() * multiplicador * quantidade;
        return preco - desconto;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
            "produto='" + produto.getNome() + '\'' +
            ", quantidade=" + quantidade +
            ", tamanho='" + tamanho + '\'' +
            ", desconto=" + desconto +
            ", precoTotal=" + calcularPrecoTotal() +
            "}";
    }
}