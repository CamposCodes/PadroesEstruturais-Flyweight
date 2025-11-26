package padroesestruturais.flyweight;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CafeteriaTest {

    @Test
    void deveRetornarItensPedido() {
        Cafeteria cafeteria = new Cafeteria();
        
        Produto cafe = ProdutoFactory.getProduto("Café Espresso", "Bebida Quente", 5.50, 2);
        Produto cappuccino = ProdutoFactory.getProduto("Cappuccino", "Bebida Quente", 7.50, 3);
        
        cafeteria.criarPedido(1);
        cafeteria.adicionarItemAoPedido(1, cafe, 2, "Pequeno", 0.0);
        cafeteria.adicionarItemAoPedido(1, cappuccino, 1, "Grande", 1.0);

        Pedido pedido = cafeteria.obterPedido(1);
        List<ItemPedido> itens = pedido.getItens();

        assertEquals(2, itens.size());
        assertEquals("Café Espresso", itens.get(0).getProduto().getNome());
        assertEquals("Cappuccino", itens.get(1).getProduto().getNome());
    }

    @Test
    void deveRetornarTotalProdutos() {
        Cafeteria cafeteria = new Cafeteria();
        
        ProdutoFactory.getProduto("Café Espresso", "Bebida Quente", 5.50, 2);
        ProdutoFactory.getProduto("Cappuccino", "Bebida Quente", 7.50, 3);
        ProdutoFactory.getProduto("Croissant", "Comida", 8.50, 5);

        assertEquals(3, cafeteria.getTotalProdutosDistintos());
    }

    @Test
    void deveCalcularTotalPedido() {
        Cafeteria cafeteria = new Cafeteria();
        
        Produto cafe = ProdutoFactory.getProduto("Café Espresso", "Bebida Quente", 5.50, 2);
        Produto cappuccino = ProdutoFactory.getProduto("Cappuccino", "Bebida Quente", 7.50, 3);
        
        cafeteria.criarPedido(1);
        cafeteria.adicionarItemAoPedido(1, cafe, 2, "Pequeno", 0.0);
        cafeteria.adicionarItemAoPedido(1, cappuccino, 1, "Grande", 1.0);

        Pedido pedido = cafeteria.obterPedido(1);
        double total = pedido.calcularTotal();

        assertEquals(19.0, total, 0.01);
    }

    @Test
    void deveRetornarTodosPedidos() {
        Cafeteria cafeteria = new Cafeteria();
        
        Produto cafe = ProdutoFactory.getProduto("Café Espresso", "Bebida Quente", 5.50, 2);
        
        cafeteria.criarPedido(1);
        cafeteria.adicionarItemAoPedido(1, cafe, 1, "Pequeno", 0.0);
        
        cafeteria.criarPedido(2);
        cafeteria.adicionarItemAoPedido(2, cafe, 2, "Médio", 0.0);

        List<String> pedidos = cafeteria.obterTodosPedidos();

        assertEquals(2, pedidos.size());
    }

    @Test
    void deveReutilizarProdutosDoFactory() {
        Cafeteria cafeteria = new Cafeteria();
        
        Produto cafe1 = ProdutoFactory.getProduto("Café Espresso", "Bebida Quente", 5.50, 2);
        Produto cafe2 = ProdutoFactory.getProduto("Café Espresso", "Bebida Quente", 5.50, 2);

        assertSame(cafe1, cafe2);
    }

    @Test
    void deveAplicarDescontoAoItem() {
        Cafeteria cafeteria = new Cafeteria();
        
        Produto cafe = ProdutoFactory.getProduto("Café Espresso", "Bebida Quente", 5.50, 2);
        
        cafeteria.criarPedido(1);
        cafeteria.adicionarItemAoPedido(1, cafe, 2, "Pequeno", 2.0);

        Pedido pedido = cafeteria.obterPedido(1);
        double total = pedido.calcularTotal();

        assertEquals(9.0, total, 0.01);
    }
}