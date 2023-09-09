package util;

import controllers.ServicoController;
import models.Servicos;

import javax.swing.*;

public class UtilServicos {
    Servicos servicos = new Servicos();
    ServicoController servicoController = new ServicoController();

    String read;
    public void createServico(){
        JOptionPane.showMessageDialog(null,"CADASTRO DE SERVIÇO");

        read = JOptionPane.showInputDialog("Tipo do serviço: ");
        servicos.setTipo_servico(read);
        read = JOptionPane.showInputDialog("Descricao: ");
        servicos.setDescricao(read);
        read = JOptionPane.showInputDialog("Preço: ");
        servicos.setPreco(Integer.parseInt(read));

        read = JOptionPane.showInputDialog("Animal: [id]");
        int id = Integer.parseInt(read);

        servicoController.CreateServico(servicos, id);
    }

    public void mostrarServicos(){
        servicoController.showServicos();
    }
}
