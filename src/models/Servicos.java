package models;

public class Servicos {
    private int id_servico;
    private String tipo_servico;
    private String descricao;
    private double preco;

    public Servicos() {
    }

    public Servicos(int id_servico, String tipo_servico, String descricao, double preco) {
        this.id_servico = id_servico;
        this.tipo_servico = tipo_servico;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(String tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
