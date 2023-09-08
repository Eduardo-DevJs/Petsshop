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

    public void mostrarAnimais(){
        String sql = "SELECT animais.nome_animal, animais.id_animal, animais.raca, animais.especie, clientes.nome_cliente, clientes.id_cliente FROM animais INNER JOIN clientes ON animais.id_cliente = clientes.id_cliente;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int idAnimal = resultSet.getInt("id_animal");
                String nomeAnimal = resultSet.getString("nome_animal");
                String especie = resultSet.getString("especie");
                String raca = resultSet.getString("raca");
                String nomeCliente = resultSet.getString("nome_cliente");
                int idCliente = resultSet.getInt("id_cliente");

                System.out.println("Id do animal: " + idAnimal);
                System.out.println("Nome do animal: " + nomeAnimal);
                System.out.println("Espécie: " + especie);
                System.out.println("Raça: " + raca);
                System.out.println("Dono: " + nomeCliente);
                System.out.println("Id do dono: " + idCliente);

                System.out.println("----------------------------------------------");

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    public void atualizarAnimal(Animal animal){
        String sql = "UPDATE animais SET nome_animal=?,especie=?,raca=?,id_cliente=? WHERE id_animal";

        Connection connection = null;
        PreparedStatement prepareStatement = null;

        try{

            connection = Conexao.createConnectionMySQL();
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1,animal.getNome_animal());
            prepareStatement.setString(2,animal.getRaca());
            prepareStatement.setString(3,animal.getEspecie());

            prepareStatement.setInt(4,animal.getId_animal());

            prepareStatement.execute();

            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public void deletarAnimal(int id){
        String sql = "DELETE FROM animais WHERE id_animal=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null,"Deletado com sucesso!");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

}
