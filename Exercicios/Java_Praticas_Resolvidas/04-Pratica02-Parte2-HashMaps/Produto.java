public class Produto {
    private String nome;
    private int codigo;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, int codigo, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() { return nome; }
    public int getCodigo() { return codigo; }
    public double getPreco() { return preco; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
        }
    }

    public boolean retirarEstoque(int quantidade) {
        if (quantidade <= 0 || quantidade > quantidadeEstoque) {
            return false;
        }

        quantidadeEstoque -= quantidade;
        return true;
    }

    public void exibirInformacoes() {
        System.out.printf("Código: %d | %s | R$ %.2f | Estoque: %d%n",
                codigo, nome, preco, quantidadeEstoque);
    }
}
