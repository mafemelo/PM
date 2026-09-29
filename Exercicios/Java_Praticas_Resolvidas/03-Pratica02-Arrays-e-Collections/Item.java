public class Item {
    private Produto produto;
    private int quantidade;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getValorTotal() {
        return produto.getPreco() * quantidade;
    }

    public void realizarCompra(int quantidade) {
        this.quantidade += quantidade;
    }

    public void exibirItem() {
        System.out.printf("%s | Quantidade: %d | Total: R$ %.2f%n",
                produto.getNome(), quantidade, getValorTotal());
    }
}
