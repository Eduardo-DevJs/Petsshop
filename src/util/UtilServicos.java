package util;

import controllers.ServicoController;
import models.Animal;
import models.Servicos;

import javax.swing.*;

public class UtilServicos {
    ServicoController servicoController = new ServicoController();
    Servicos servicos = new Servicos();
    String read;

    public void cadastraServico(){
        JOptionPane.showMessageDialog(null,"CADASTRO DE SERVIÇO");

        read = JOptionPane.showInputDialog("Nome do servico: ");
        servicos.setTipo_servico(read);
        read = JOptionPane.showInputDialog("Preço: ");
        servicos.setPreco(Integer.parseInt(read));
        read = JOptionPane.showInputDialog("Descrição: ");
        servicos.setDescricao(read);
        read = JOptionPane.showInputDialog("Id do Animal: ");
        servicos.setId_animal(Integer.parseInt(read));

        servicoController.criarServico(servicos);
    }
}
