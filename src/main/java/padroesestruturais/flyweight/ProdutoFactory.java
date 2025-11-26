package padroesestruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ProdutoFactory {

    private static Map<String, Produto> produtos = new HashMap<>();

    public static Produto getProduto(String nome, String categoria, double precoBase, int tempoPreparoMinutos) {
        Produto produto = produtos.get(nome);
        if (produto == null) {
            produto = new Produto(nome, categoria, precoBase, tempoPreparoMinutos);
            produtos.put(nome, produto);
        }
        return produto;
    }

    public static int getTotalProdutos() {
        return produtos.size();
    }
}