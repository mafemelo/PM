import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private HashMap<Integer, Produto> produtos;
    private int tamanho;

    public Estoque() {
        produtos = new HashMap<>();
        tamanho = 0;
    }

    public boolean adicionarProduto(Produto produto) {
        if (produtos.containsKey(produto.getCodigo())) {
            return false;
        }

        produtos.put(produto.getCodigo(), produto);
        tamanho++;
        return true;
    }

    public Produto buscarProduto(int codigo) {
        return produtos.get(codigo);
    }

    public boolean removerProduto(int codigo) {
        if (produtos.remove(codigo) != null) {
            tamanho--;
            return true;
        }
        return false;
    }

    public boolean verificarExistencia(int codigo) {
        return produtos.containsKey(codigo);
    }

    public int getTamanho() {
        return tamanho;
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }

        for (Produto produto : produtos.values()) {
            produto.exibirInformacoes();
        }
    }

    public void listarEstoqueBaixo() {
        boolean encontrou = false;

        for (Produto produto : produtos.values()) {
            if (produto.getQuantidadeEstoque() < 5) {
                produto.exibirInformacoes();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto com estoque abaixo de 5.");
        }
    }

    public boolean realizarCompra(int codigo, int quantidade, Fatura fatura) {
        Produto produto = buscarProduto(codigo);

        if (produto == null) {
            return false;
        }

        if (!produto.retirarEstoque(quantidade)) {
            return false;
        }

        fatura.adicionarItem(produto, quantidade);
        return true;
    }
}
