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

            JOptionPane.showMessageDialog(null, "Cadastrado com suceso!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public List<Cliente> mostrarClientes(){
        String sql = "SELECT * FROM clientes";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try {

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Cliente cliente = new Cliente();

                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNome_cliente(resultSet.getString("nome_cliente"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setCpf(resultSet.getString("cpf"));

                clientes.add(cliente);
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

        return clientes;
    }

    public void atualizarClientes(Cliente cliente){
        String sql = "UPDATE clientes SET nome_cliente=?,telefone=?,cpf=? WHERE id_cliente";

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
            JOptionPane.showMessageDialog(null, "Erro: " + e);
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
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

}
