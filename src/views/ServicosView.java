package views;

import controllers.ServicoController;
import models.Servicos;

import javax.swing.*;

public class ServicosView {
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

    public void mostrarServicos(){
        servicoController.mostrarServicos();
    }

    public void atualizarServico(){
        String input = JOptionPane.showInputDialog("Qual servico deseja atualizar? [ID]");
        // CONVERTENDO O VALOR RECEBIDO DA VARIAVEL INPUT EM NÚMERO
        int id = Integer.parseInt(input);
        servicos.setId_animal(id);

        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");

        if(confirm == JOptionPane.OK_OPTION){
            read = JOptionPane.showInputDialog("Editar tipo de serviço: ");
            servicos.setTipo_servico(read);
            read = JOptionPane.showInputDialog("Editar preço: ");
            servicos.setPreco(Integer.parseInt(read));
            read = JOptionPane.showInputDialog("Editar descrição: ");
            servicos.setDescricao(read);
            read = JOptionPane.showInputDialog("Editar ID do animal: ");
            servicos.setId_animal(Integer.parseInt(read));

            servicoController.updateServico(servicos);
        }else{
            JOptionPane.showMessageDialog(null,"Atualização cancelada");
        }
    }

    public void deletarServico(){
        String input = JOptionPane.showInputDialog("Qual serviço deseja deletar? [ID]");

        // CONVERTENDO O VALOR RECEBIDO DA VARIAVEL INPUT EM NÚMERO
        int id = Integer.parseInt(input);

        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");

        if(confirm == JOptionPane.OK_OPTION){
            servicoController.deletarServico(id);
        }else{
            JOptionPane.showMessageDialog(null,"Exlcusão cancelada");
        }
    }
}
