package models;

public class Cliente {
    private int id_cliente;
    private String nome_cliente;
    private String nome_pet;
    private String telefone;
    private String cpf;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nome_cliente, String nome_pet, String telefone, String cpf) {
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.nome_pet = nome_pet;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
