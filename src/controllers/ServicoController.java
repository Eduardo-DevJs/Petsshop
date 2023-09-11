package controllers;

import conexao.Conexao;
import models.Servicos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicoController {
    public void criarServico(Servicos servicos){
        String sql = "INSERT INTO servicos (tipo_servico,preco,descricao, id_animal) VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, servicos.getTipo_servico());
            preparedStatement.setInt(2, servicos.getPreco());
            preparedStatement.setString(3, servicos.getDescricao());

            preparedStatement.execute();

        }catch (Exception e){
            System.out.println("Erro: " + e);
        }
    }

    public void mostrarServicos(){
        String sql = "SELECT animais.id_animal,animais.nome_animal, servicos.tipo_servico, servicos.preco, servicos.descricao FROM animais INNER JOIN servicos ON animais.id_animal = servicos.id_animal";

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
                String tipoServico = resultSet.getString("tipo_servico");
                double preco = resultSet.getDouble("preco");
                String descricao = resultSet.getString("descricao");

                System.out.println("Id animal: " + idAnimal);
                System.out.println("Nome do animal: " + nomeAnimal);
                System.out.println("Tipo: " + tipoServico);
                System.out.println("Preço: " + preco);
                System.out.println("Descricao: " + descricao);
            }


        }catch (Exception e){
            System.out.println("Erro: " + e);
        }

    }
}
