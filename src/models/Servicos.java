package models;

public class Servicos {
    private int id_servico;
    private String tipo_servico;
    private String descricao;
    private int preco;
    private int id_animal;

    public Servicos() {
    }

    public Servicos(int id_servico, String tipo_servico, String descricao, int preco, int id_animal) {
        this.id_servico = id_servico;
        this.tipo_servico = tipo_servico;
        this.descricao = descricao;
        this.preco = preco;
        this.id_animal = id_animal;
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

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }
}
