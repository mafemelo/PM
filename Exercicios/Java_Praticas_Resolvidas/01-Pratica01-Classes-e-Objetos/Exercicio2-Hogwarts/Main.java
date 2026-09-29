import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== CHAPÉU SELETOR ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Encerrar");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 2) {
                break;
            }

            if (opcao != 1) {
                System.out.println("Opção inválida.");
                continue;
            }

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            System.out.print("Coragem: ");
            double coragem = scanner.nextDouble();

            System.out.print("Inteligência: ");
            double inteligencia = scanner.nextDouble();

            System.out.print("Ambição: ");
            double ambicao = scanner.nextDouble();

            System.out.print("Lealdade: ");
            double lealdade = scanner.nextDouble();

            System.out.print("Estratégia: ");
            double estrategia = scanner.nextDouble();

            System.out.print("Criatividade: ");
            double criatividade = scanner.nextDouble();

            Aluno aluno = new Aluno(
                    nome, idade, coragem, inteligencia, ambicao,
                    lealdade, estrategia, criatividade
            );

            aluno.calcularCasa();
            System.out.println("\n=== RESULTADO ===");
            aluno.exibirInformacoes();
        }

        scanner.close();
    }
}
