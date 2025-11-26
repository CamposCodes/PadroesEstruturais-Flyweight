package padroesestruturais.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int numeroComanda;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(int numeroComanda) {
        this.numeroComanda = numeroComanda;
    }

    public void adicionarItem(Produto produto, int quantidade, String tamanho, double desconto) {
        ItemPedido item = new ItemPedido(produto, quantidade, tamanho, desconto);
        itens.add(item);
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularPrecoTotal();
        }
        return total;
    }

    public List<String> obterItensPedido() {
        List<String> saida = new ArrayList<>();
        for (ItemPedido item : itens) {
            saida.add(item.toString());
        }
        return saida;
    }
}