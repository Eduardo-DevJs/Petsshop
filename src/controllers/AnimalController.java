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
    public void cadastrarAnimal(Animal animal){
        String sql = "INSERT INTO animais (nome_animal,id_dono) VALUES (?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,animal.getNome_animal());
            preparedStatement.setInt(2,animal.getId_dono());

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Cadastrado com suceso!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public List<Animal> mostrarClientes(){
        String sql = "SELECT clientes.nome_cliente, animais.nome_animal FROM clientes INNER JOIN animais ON clientes.id_cliente = animais.id_dono";

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

                animal.setId_dono(resultSet.getInt("id_dono"));
                animal.setNome_animal(resultSet.getString("nome_animal"));

                animais.add(animal);
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

        return animais;
    }

}
