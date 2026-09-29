import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        System.out.print("Altura (m): ");
        double altura = scanner.nextDouble();

        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();

        Pessoa pessoa = new Pessoa(nome, sobrenome, idade, altura, peso);
        pessoa.CalculaIMC();

        System.out.printf("%nPessoa: %s %s%n", pessoa.getNome(), pessoa.getSobrenome());
        System.out.printf("IMC: %.2f%n", pessoa.getImc());
        System.out.println("Classificação: " + pessoa.InformaObesidade());

        scanner.close();
    }
}
