package Model;

public class Produto {
    private static int contadorId = 0;

    private int id;
    private String nome;
    private String descricao;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public Produto(String nome, String descricao, double preco) {
        this.id = ++contadorId;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto() {
    }

    @Override
    public String toString() {
        return "Produto " +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco ;
    }
}
