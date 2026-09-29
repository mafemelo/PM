import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    private String nome;
    private String sobrenome;
    private String casa;
    private LocalDate dataNascimento;
    private String codigoMatricula;

    public Aluno(String nome, String sobrenome, String casa, LocalDate dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.casa = casa;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public String getCasa() { return casa; }
    public void setCasa(String casa) { this.casa = casa; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getCodigoMatricula() { return codigoMatricula; }

    public int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public boolean verificarMaioridadeMagica() {
        return calcularIdade() >= 17;
    }

    public String formatarCasa() {
        return casa.toUpperCase();
    }

    public String gerarNomeUsuario() {
        if (nome.isBlank() || sobrenome.isBlank()) {
            return "";
        }
        return (nome.charAt(0) + sobrenome).toLowerCase();
    }

    public void gerarCodigoMatricula(int posicaoCadastro) {
        String[] partes = nome.trim().split("\\s+");
        String iniciais = "";

        if (partes.length > 0 && !partes[0].isEmpty()) {
            iniciais += partes[0].charAt(0);
        }
        if (!sobrenome.trim().isEmpty()) {
            iniciais += sobrenome.trim().charAt(0);
        }

        this.codigoMatricula = iniciais.toUpperCase()
                + "-" + LocalDate.now().getYear()
                + "-" + String.format("%02d", posicaoCadastro);
    }

    public boolean verificaCasa(String casaInformada) {
        return casa.equalsIgnoreCase(casaInformada);
    }

    public boolean verificaPresencaPalavra(String palavra) {
        return sobrenome.toLowerCase().contains(palavra.toLowerCase());
    }

    public void exibirInformacoes() {
        System.out.println("----------------------------");
        System.out.println("Nome: " + nome + " " + sobrenome);
        System.out.println("Casa: " + formatarCasa());
        System.out.println("Nascimento: " + dataNascimento);
        System.out.println("Idade: " + calcularIdade());
        System.out.println("Maioridade mágica: " + (verificarMaioridadeMagica() ? "Sim" : "Não"));
        System.out.println("Usuário: " + gerarNomeUsuario());
        System.out.println("Matrícula: " + codigoMatricula);
    }
}
