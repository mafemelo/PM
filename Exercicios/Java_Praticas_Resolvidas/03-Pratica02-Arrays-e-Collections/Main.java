import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 1, 25.90));
        produtos.add(new Produto("Feijão", 2, 8.50));
        produtos.add(new Produto("Macarrão", 3, 6.75));

        Fatura fatura = new Fatura();

        int opcao;

        do {
            System.out.println("\n=== CARRINHO DE COMPRAS ===");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Excluir item");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Finalizar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    for (Produto produto : produtos) {
                        produto.exibirInformacoes();
                    }

                    System.out.print("Código do produto (0 para voltar): ");
                    int codigo = scanner.nextInt();

                    if (codigo == 0) {
                        break;
                    }

                    Produto produtoEscolhido = buscarProduto(produtos, codigo);

                    if (produtoEscolhido == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    if (quantidade <= 0) {
                        System.out.println("Quantidade inválida.");
                        break;
                    }

                    fatura.incluirItem(produtoEscolhido, quantidade);
                    System.out.println("Item adicionado à fatura.");
                    break;

                case 2:
                    fatura.exibirFatura();
                    break;

                case 3:
                    fatura.exibirFatura();
                    System.out.print("Código do produto a excluir (0 para voltar): ");
                    codigo = scanner.nextInt();

                    if (codigo != 0) {
                        if (fatura.excluirItem(codigo)) {
                            System.out.println("Item excluído.");
                        } else {
                            System.out.println("Item não encontrado.");
                        }
                    }
                    break;

                case 4:
                    fatura.exibirFatura();
                    System.out.print("Código do produto a alterar (0 para voltar): ");
                    codigo = scanner.nextInt();

                    if (codigo == 0) {
                        break;
                    }

                    System.out.print("Nova quantidade: ");
                    quantidade = scanner.nextInt();

                    if (fatura.alterarItem(codigo, quantidade)) {
                        System.out.println("Item alterado.");
                    } else {
                        System.out.println("Não foi possível alterar o item.");
                    }
                    break;

                case 5:
                    fatura.exibirFatura();
                    System.out.println("Compra finalizada.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        scanner.close();
    }

    private static Produto buscarProduto(ArrayList<Produto> produtos, int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }
}
