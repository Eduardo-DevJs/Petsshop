package views;

import controllers.ClienteController;
import models.Cliente;

import javax.swing.*;

public class ClienteView {
    String read;
    ClienteController clienteController = new ClienteController();
    Cliente cliente  = new Cliente();

    public void createCliente(){
        JOptionPane.showMessageDialog(null,"CADASTRO DE CLIENTE");

        read = JOptionPane.showInputDialog("Nome do cliente: ");
        cliente.setNome_cliente(read);
        read = JOptionPane.showInputDialog("Telefone: ");
        cliente.setTelefone(read);
        read = JOptionPane.showInputDialog("CPF: ");
        cliente.setCpf(read);

        clienteController.cadastrarCliente(cliente);
    }

    public void mostraClientes(){
        for (Cliente mostrarCliente : clienteController.mostrarClientes()) {
            System.out.println("ID do cliente: " + mostrarCliente.getId_cliente());
            System.out.println("Nome do cliente: " + mostrarCliente.getNome_cliente());
            System.out.println("Telefone: " + mostrarCliente.getTelefone());
            System.out.println("CPF: " + mostrarCliente.getCpf());
        }
    }


    public void atualizaCliente(){
        String input = JOptionPane.showInputDialog("Qual cliente deseja atualizar? [ID]");
        // CONVERTENDO O VALOR RECEBIDO DA VARIAVEL INPUT EM NÚMERO
        int id = Integer.parseInt(input);
        cliente.setId_cliente(id);


        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");

        if(confirm == JOptionPane.OK_OPTION){
            read = JOptionPane.showInputDialog("Editar nome do cliente: ");
            cliente.setNome_cliente(read);
            read = JOptionPane.showInputDialog("Editar telefone: ");
            cliente.setTelefone(read);
            read = JOptionPane.showInputDialog("Editar CPF: ");
            cliente.setCpf(read);

            clienteController.atualizarClientes(cliente);
        }else{
            JOptionPane.showMessageDialog(null,"Atualização cancelada");
        }
    }

    public void deleteCliente(){
        String input = JOptionPane.showInputDialog("Qual cliente deseja deletar? [ID]");

        // CONVERTENDO O VALOR RECEBIDO DA VARIAVEL INPUT EM NÚMERO
        int id = Integer.parseInt(input);

        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");

        if(confirm == JOptionPane.OK_OPTION){
            clienteController.deletarCliente(id);
        }else{
            JOptionPane.showMessageDialog(null,"Exclusão cancelada");
        }
    }

}
