package controllers;

import conexao.Conexao;
import models.Servicos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicoController {
    public void CreateServico(Servicos servicos, int id_animal){
        String sql = "INSERT INTO servicos (tipo_servico, descricao ,preco) VALUES (?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, servicos.getTipo_servico());
            preparedStatement.setString(2, servicos.getDescricao());
            preparedStatement.setInt(3, servicos.getPreco());
            preparedStatement.setInt(4, id_animal);

            preparedStatement.execute();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro: " + e);
        }
    }

    public void showServicos(){
        String sql = "SELECT animais.nome_animal, animais.id_animal, servicos.tipo_servico, servicos.descricao, servicos.preco FROM servicos INNER JOIN animais ON animais.id_animal = servicos.id_animal";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String nomeAnimal = resultSet.getString("nome_animal");
                String idAnimal = resultSet.getString("id_animal");
                String tipoServico = resultSet.getString("tipo_servico");
                String descricaoServico = resultSet.getString("descricao");
                int preco = resultSet.getInt("preco");

                System.out.println("Id do animal: " + idAnimal);
                System.out.println("Nome do animal: " + nomeAnimal);
                System.out.println("Tipo de serviço: " + tipoServico);
                System.out.println("Descricao do servico: " + descricaoServico);
                System.out.println("Preço " + preco + "reais");

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro: " + e);
        }
    }
}
