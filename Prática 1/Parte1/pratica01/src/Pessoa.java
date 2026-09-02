import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getImc() { return imc; }

    public void CalculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
    }

    public String InformaObesidade() {
        if (this.imc < 18.5) {
            return "Abaixo do peso";
        } else if (this.imc >= 18.5 && this.imc <= 24.9) {
            return "Peso normal";
        } else if (this.imc >= 25 && this.imc <= 29.9) {
            return "Sobrepeso";
        } else if (this.imc >= 30 && this.imc <= 34.9) {
            return "Obesidade grau 1";
        } else if (this.imc >= 35 && this.imc <= 39.9) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        System.out.print("Altura (ex: 1,75): ");
        double altura = scanner.nextDouble();

        System.out.print("Peso (ex: 70,5): ");
        double peso = scanner.nextDouble();

        Pessoa pessoa = new Pessoa(nome, sobrenome, idade, altura, peso);

        pessoa.CalculaIMC();

        System.out.println("IMC: " + String.format("%.2f", pessoa.getImc()));
        System.out.println("Classificação: " + pessoa.InformaObesidade());

        scanner.close();
    }
}