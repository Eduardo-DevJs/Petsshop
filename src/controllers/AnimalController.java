package controllers;

import conexao.Conexao;
import models.Animal;
import models.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimalController {
    public void cadastrarAnimal(Animal animal, int id_cliente){
        String sql = "INSERT INTO animais (nome_animal,especie, raca, id_cliente) VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,animal.getNome_animal());
            preparedStatement.setString(2, animal.getEspecie());
            preparedStatement.setString(3,animal.getRaca());
            preparedStatement.setInt(4, id_cliente);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Animal cadastrado com suceso!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public List<Animal> mostrarAnimais(){
        String sql = "SELECT animais.nome_animal, clientes.nome_cliente, clientes.id_cliente FROM animais INNER JOIN clientes ON animais.id_cliente = clientes.id_cliente;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Animal> animais = new ArrayList<Animal>();

        try {

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Animal animal = new Animal();

                animal.setNome_animal(resultSet.getString("nome_animal"));
                animal.setId_cliente(resultSet.getInt("id_cliente"));

                animais.add(animal);
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

        return animais;
    }

}
