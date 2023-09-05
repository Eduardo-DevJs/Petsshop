package models;

public class Animal {
    private int id_animaal;
    private String nome_animal;

    private int id_dono;

    public Animal() {
    }

    public Animal(int id_animaal, String nome_animal, int id_dono) {
        this.id_animaal = id_animaal;
        this.nome_animal = nome_animal;
        this.id_dono = id_dono;
    }

    public int getId_animaal() {
        return id_animaal;
    }

    public void setId_animaal(int id_animaal) {
        this.id_animaal = id_animaal;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public int getId_dono() {
        return id_dono;
    }

    public void setId_dono(int id_dono) {
        this.id_dono = id_dono;
    }
}
