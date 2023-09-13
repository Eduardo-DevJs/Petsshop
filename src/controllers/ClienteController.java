package controllers;

import conexao.Conexao;
import models.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO clientes (nome_cliente,telefone, cpf) VALUES (?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,cliente.getNome_cliente());
            preparedStatement.setString(2,cliente.getTelefone());
            preparedStatement.setString(3,cliente.getCpf());

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }catch (Exception e){
            System.out.println("Erro: " + e);
        }
    }

    public void mostrarClientes(){
        String sql = "select clientes.id_cliente, clientes.nome_cliente, clientes.telefone, clientes.cpf, animais.nome_animal from animais INNER JOIN clientes ON animais.id_cliente = clientes.id_cliente;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int codigoCliente = resultSet.getInt("id_cliente");
                String nomeCliente = resultSet.getString("nome_cliente");
                String telefone = resultSet.getString("telefone");
                String cpf = resultSet.getString("cpf");
                String nomeAnimal = resultSet.getString("nome_animal");

                System.out.println("Codigo do cliente: " + codigoCliente);
                System.out.println("Nome do cliente: " + nomeCliente);
                System.out.println("Telefone: " + telefone);
                System.out.println("CPF: " + cpf);
                System.out.println("Pet: " + nomeAnimal);
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }


    }

    public void atualizarClientes(Cliente cliente){
        String sql = "UPDATE clientes SET nome_cliente=?,telefone=?,cpf=? WHERE id_cliente=?";

        Connection connection = null;
        PreparedStatement prepareStatement = null;

        try{

            connection = Conexao.createConnectionMySQL();
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1,cliente.getNome_cliente());
            prepareStatement.setString(2,cliente.getTelefone());
            prepareStatement.setString(3,cliente.getCpf());

            prepareStatement.setInt(4,cliente.getId_cliente());

            prepareStatement.execute();

            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");

        }catch (Exception e){
            System.out.println("Erro: " + e);
        }
    }

    public void deletarCliente(int id){
        String sql = "DELETE FROM clientes WHERE id_cliente=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null,"Deletado com sucesso!");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não é possivel deletar um cliente sem deletar o animal primeiro");
            System.out.println("Erro " + e);
        }

    }

}
