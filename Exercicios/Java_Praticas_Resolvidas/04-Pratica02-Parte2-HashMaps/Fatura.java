import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens = new ArrayList<>();

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new Item(produto, quantidade));
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
            System.out.println("Nenhum item vendido.");
        } else {
            for (Item item : itens) {
                item.exibirItem();
            }
        }

        System.out.printf("Total: R$ %.2f%n", calcularTotal());
    }
}
