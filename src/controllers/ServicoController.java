package controllers;

import conexao.Conexao;
import models.Servicos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ServicoController {
    public void CreateServico(Servicos servicos){
        String sql = "INSERT INTO servicos (id_servico, tipo_servico, descricao ,preco)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexao.createConnectionMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, servicos.getTipo_servico());
            preparedStatement.setDouble(2, servicos.getPreco());
            preparedStatement.setString(3, servicos.getDescricao());

            preparedStatement.execute();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro: " + e);
        }
    }
}
