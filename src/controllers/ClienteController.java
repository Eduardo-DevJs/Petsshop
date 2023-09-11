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
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public void mostrarClientes(){
        String sql = "SELECT clientes.nome_cliente, clientes.id_cliente, animais.nome_animal, animais.id_animal FROM clientes INNER JOIN animais ON clientes.id_cliente = animais.id_cliente";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("id do cliente: " + resultSet.getInt("id_cliente"));
                System.out.println("Nome do cliente: " + resultSet.getString("nome_cliente"));
                System.out.println("Nome do Animal: " + resultSet.getString("nome_animal"));
                System.out.println("Id do animal: " + resultSet.getString("id_animal"));

                System.out.println("--------------------------------------------------------------------");
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
