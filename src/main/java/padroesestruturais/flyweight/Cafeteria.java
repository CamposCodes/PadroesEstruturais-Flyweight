package padroesestruturais.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Cafeteria {

    private List<Pedido> pedidos = new ArrayList<>();

    public void criarPedido(int numeroComanda) {
        Pedido pedido = new Pedido(numeroComanda);
        pedidos.add(pedido);
    }

    public Pedido obterPedido(int numeroComanda) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroComanda() == numeroComanda) {
                return pedido;
            }
        }
        return null;
    }

    public void adicionarItemAoPedido(int numeroComanda, Produto produto, int quantidade, String tamanho, double desconto) {
        Pedido pedido = obterPedido(numeroComanda);
        if (pedido != null) {
            pedido.adicionarItem(produto, quantidade, tamanho, desconto);
        }
    }

    public List<String> obterTodosPedidos() {
        List<String> saida = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            saida.add("Comanda " + pedido.getNumeroComanda() + ": R$ " + pedido.calcularTotal());
        }
        return saida;
    }

    public int getTotalProdutosDistintos() {
        return ProdutoFactory.getTotalProdutos();
    }
}