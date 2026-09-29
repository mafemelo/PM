import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;

    public Fatura() {
        itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void incluirItem(Produto produto, int quantidade) {
        for (Item item : itens) {
            if (item.getProduto().getCodigo() == produto.getCodigo()) {
                item.realizarCompra(quantidade);
                return;
            }
        }
        itens.add(new Item(produto, quantidade));
    }

    public boolean excluirItem(int codigoProduto) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().getCodigo() == codigoProduto) {
                itens.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean alterarItem(int codigoProduto, int novaQuantidade) {
        if (novaQuantidade <= 0) {
            return false;
        }

        for (Item item : itens) {
            if (item.getProduto().getCodigo() == codigoProduto) {
                item.setQuantidade(novaQuantidade);
                return true;
            }
        }
        return false;
    }

    public double calcularTotal() {
        double total = 0;

        for (Item item : itens) {
            total += item.getValorTotal();
        }

        return total;
    }

    public void exibirFatura() {
        System.out.println("\n=== FATURA ===");

        if (itens.isEmpty()) {
            System.out.println("Nenhum item comprado.");
        } else {
            for (Item item : itens) {
                item.exibirItem();
            }
        }

        System.out.printf("Valor final: R$ %.2f%n", calcularTotal());
    }
}
