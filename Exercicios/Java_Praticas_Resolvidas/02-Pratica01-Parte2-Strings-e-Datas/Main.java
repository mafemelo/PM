import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static final int MAX_ALUNOS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno[] alunos = new Aluno[MAX_ALUNOS];
        int quantidade = 0;

        while (true) {
            System.out.println("\n=== CADASTRO DE HOGWARTS ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar todos os alunos");
            System.out.println("3 - Exibir alunos de uma casa");
            System.out.println("4 - Exibir alunos por casa");
            System.out.println("5 - Exibir alunos maiores de idade");
            System.out.println("6 - Exibir alunos menores de idade");
            System.out.println("7 - Buscar por sobrenome");
            System.out.println("8 - Encerrar");
            System.out.print("Opção: ");
            String entrada = scanner.nextLine();

            int opcao;
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida.");
                continue;
            }

            if (opcao == 1) {
                if (quantidade >= MAX_ALUNOS) {
                    System.out.println("Limite de 10 alunos atingido.");
                    continue;
                }

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Sobrenome: ");
                String sobrenome = scanner.nextLine();

                System.out.print("Casa: ");
                String casa = scanner.nextLine();

                LocalDate dataNascimento;
                while (true) {
                    System.out.print("Data de nascimento (AAAA-MM-DD): ");
                    String data = scanner.nextLine();
                    try {
                        dataNascimento = LocalDate.parse(data);
                        break;
                    } catch (DateTimeParseException e) {
                        System.out.println("Data inválida. Tente novamente.");
                    }
                }

                Aluno aluno = new Aluno(nome, sobrenome, casa, dataNascimento);
                aluno.gerarCodigoMatricula(quantidade + 1);
                alunos[quantidade] = aluno;
                quantidade++;

                System.out.println("Aluno cadastrado com sucesso.");
            } else if (opcao == 2) {
                listarTodos(alunos, quantidade);
            } else if (opcao == 3) {
                System.out.print("Casa: ");
                String casa = scanner.nextLine();
                int total = 0;

                for (int i = 0; i < quantidade; i++) {
                    if (alunos[i].verificaCasa(casa)) {
                        alunos[i].exibirInformacoes();
                        total++;
                    }
                }
                System.out.println("Total de alunos da casa: " + total);
            } else if (opcao == 4) {
                String[] casas = {"Grifinória", "Sonserina", "Corvinal", "Lufa-Lufa"};

                for (String casa : casas) {
                    System.out.println("\n=== " + casa.toUpperCase() + " ===");
                    int total = 0;

                    for (int i = 0; i < quantidade; i++) {
                        if (alunos[i].verificaCasa(casa)) {
                            alunos[i].exibirInformacoes();
                            total++;
                        }
                    }

                    System.out.println("Total: " + total);
                }
            } else if (opcao == 5) {
                for (int i = 0; i < quantidade; i++) {
                    if (alunos[i].verificarMaioridadeMagica()) {
                        alunos[i].exibirInformacoes();
                    }
                }
            } else if (opcao == 6) {
                for (int i = 0; i < quantidade; i++) {
                    if (!alunos[i].verificarMaioridadeMagica()) {
                        alunos[i].exibirInformacoes();
                    }
                }
            } else if (opcao == 7) {
                System.out.print("Digite parte do sobrenome: ");
                String palavra = scanner.nextLine();

                for (int i = 0; i < quantidade; i++) {
                    if (alunos[i].verificaPresencaPalavra(palavra)) {
                        alunos[i].exibirInformacoes();
                    }
                }
            } else if (opcao == 8) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        System.out.println("\n=== ALUNOS CADASTRADOS ===");
        listarTodos(alunos, quantidade);
        scanner.close();
    }

    private static void listarTodos(Aluno[] alunos, int quantidade) {
        if (quantidade == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (int i = 0; i < quantidade; i++) {
            alunos[i].exibirInformacoes();
        }
    }
}
