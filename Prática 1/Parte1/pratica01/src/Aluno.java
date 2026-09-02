import java.util.Scanner;

public class Aluno {
    private String nome;
    private int idade;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private int estrategia;
    private int criatividade;
    private String casa;

    public Aluno(String nome, int idade, int coragem, int inteligencia, int ambicao, int lealdade, int estrategia, int criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
    }

    public void calcularCasa() {
        double ptGrifinoria = (2 * coragem) + lealdade;
        double ptSonserina = (2 * ambicao) + estrategia;
        double ptCorvinal = (2 * inteligencia) + criatividade;
        double ptLufaLufa = ((2 * lealdade) + coragem) / 3.0;

        double maior = ptGrifinoria;
        this.casa = "Grifinória";

        if (ptSonserina > maior) {
            maior = ptSonserina;
            this.casa = "Sonserina";
        }
        if (ptCorvinal > maior) {
            maior = ptCorvinal;
            this.casa = "Corvinal";
        }
        if (ptLufaLufa > maior) {
            this.casa = "Lufa-Lufa";
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + " | Idade: " + idade);
        System.out.println("Casa: " + casa);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {
            System.out.print("Nome: ");
            String nome = scanner.next();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            System.out.print("Coragem: ");
            int cor = scanner.nextInt();
            System.out.print("Inteligência: ");
            int inte = scanner.nextInt();
            System.out.print("Ambição: ");
            int amb = scanner.nextInt();
            System.out.print("Lealdade: ");
            int lea = scanner.nextInt();
            System.out.print("Estratégia: ");
            int est = scanner.nextInt();
            System.out.print("Criatividade: ");
            int cri = scanner.nextInt();

            Aluno aluno = new Aluno(nome, idade, cor, inte, amb, lea, est, cri);
            aluno.calcularCasa();
            aluno.exibirInformacoes();

            System.out.print("Classificar outro aluno? (S/N): ");
            continuar = scanner.next();
        }
        scanner.close();
    }
}