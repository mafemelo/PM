public class Aluno {
    private String nome;
    private int idade;
    private double coragem;
    private double inteligencia;
    private double ambicao;
    private double lealdade;
    private double estrategia;
    private double criatividade;
    private String casa;

    public Aluno(String nome, int idade, double coragem, double inteligencia,
                 double ambicao, double lealdade, double estrategia, double criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getCoragem() { return coragem; }
    public void setCoragem(double coragem) { this.coragem = coragem; }

    public double getInteligencia() { return inteligencia; }
    public void setInteligencia(double inteligencia) { this.inteligencia = inteligencia; }

    public double getAmbicao() { return ambicao; }
    public void setAmbicao(double ambicao) { this.ambicao = ambicao; }

    public double getLealdade() { return lealdade; }
    public void setLealdade(double lealdade) { this.lealdade = lealdade; }

    public double getEstrategia() { return estrategia; }
    public void setEstrategia(double estrategia) { this.estrategia = estrategia; }

    public double getCriatividade() { return criatividade; }
    public void setCriatividade(double criatividade) { this.criatividade = criatividade; }

    public String getCasa() { return casa; }

    public void calcularCasa() {
        double grifinoria = (2 * coragem) + lealdade;
        double sonserina = (2 * ambicao) + estrategia;
        double corvinal = (2 * inteligencia) + criatividade;
        double lufalufa = ((2 * lealdade) + coragem) / 3.0;

        double maior = grifinoria;
        casa = "Grifinória";

        if (sonserina > maior) {
            maior = sonserina;
            casa = "Sonserina";
        }
        if (corvinal > maior) {
            maior = corvinal;
            casa = "Corvinal";
        }
        if (lufalufa > maior) {
            casa = "Lufa-Lufa";
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Coragem: " + coragem);
        System.out.println("Inteligência: " + inteligencia);
        System.out.println("Ambição: " + ambicao);
        System.out.println("Lealdade: " + lealdade);
        System.out.println("Estratégia: " + estrategia);
        System.out.println("Criatividade: " + criatividade);
        System.out.println("Casa: " + casa);
    }
}
