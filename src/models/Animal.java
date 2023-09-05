package models;

public class Animal {
    private int id_animal;
    private String nome_animal;
    private String especie;
    private String raca;
    private int id_cliente;

    public Animal() {
    }

    public Animal(int id_animal, String nome_animal, String especie, String raca, int id_cliente) {
        this.id_animal = id_animal;
        this.nome_animal = nome_animal;
        this.especie = especie;
        this.raca = raca;
        this.id_cliente = id_cliente;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
