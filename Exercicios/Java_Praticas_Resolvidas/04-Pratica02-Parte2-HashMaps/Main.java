import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estoque estoque = new Estoque();
        Fatura fatura = new Fatura();

        estoque.adicionarProduto(new Produto("Arroz", 1, 25.90, 10));
        estoque.adicionarProduto(new Produto("Feijão", 2, 8.50, 3));
        estoque.adicionarProduto(new Produto("Macarrão", 3, 6.75, 8));

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Consultar produto");
            System.out.println("2 - Adicionar produto ao estoque");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Repor estoque");
            System.out.println("5 - Produtos com estoque baixo");
            System.out.println("6 - Listar produtos");
            System.out.println("7 - Comprar");
            System.out.println("8 - Ver fatura");
            System.out.println("9 - Encerrar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();

                    Produto produto = estoque.buscarProduto(codigo);

                    if (produto == null) {
                        System.out.println("Produto não encontrado.");
                    } else {
                        produto.exibirInformacoes();
                    }
                    break;

                case 2:
                    System.out.print("Nome: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();

                    System.out.print("Código: ");
                    codigo = scanner.nextInt();

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Quantidade inicial: ");
                    int quantidade = scanner.nextInt();

                    Produto novo = new Produto(nome, codigo, preco, quantidade);

                    if (estoque.adicionarProduto(novo)) {
                        System.out.println("Produto adicionado.");
                    } else {
                        System.out.println("Já existe produto com esse código.");
                    }
                    break;

                case 3:
                    System.out.print("Código do produto: ");
                    codigo = scanner.nextInt();

                    if (estoque.removerProduto(codigo)) {
                        System.out.println("Produto removido.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Código do produto: ");
                    codigo = scanner.nextInt();

                    produto = estoque.buscarProduto(codigo);

                    if (produto == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    System.out.print("Quantidade a adicionar: ");
                    quantidade = scanner.nextInt();

                    produto.adicionarEstoque(quantidade);
                    System.out.println("Estoque atualizado.");
                    break;

                case 5:
                    estoque.listarEstoqueBaixo();
                    break;

                case 6:
                    estoque.listarProdutos();
                    break;

                case 7:
                    estoque.listarProdutos();

                    System.out.print("Código do produto (0 para voltar): ");
                    codigo = scanner.nextInt();

                    if (codigo == 0) {
                        break;
                    }

                    System.out.print("Quantidade: ");
                    quantidade = scanner.nextInt();

                    if (estoque.realizarCompra(codigo, quantidade, fatura)) {
                        System.out.println("Compra realizada.");
                    } else {
                        System.out.println("Produto inexistente ou estoque insuficiente.");
                    }
                    break;

                case 8:
                    fatura.exibirFatura();
                    break;

                case 9:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 9);

        scanner.close();
    }
}
