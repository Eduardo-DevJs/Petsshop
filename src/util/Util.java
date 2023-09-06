package util;

import controllers.AnimalController;
import controllers.ClienteController;
import models.Animal;
import models.Cliente;

import javax.swing.*;
import java.util.Scanner;

public class Util {
    ClienteController clienteController = new ClienteController();
    Cliente cliente  = new Cliente();

    String read;

    public void menuOpcoes(){
        Scanner read = new Scanner(System.in);
        String op;
        char res;
        do{
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Mostrar clientes");
            System.out.println("3 - Deletar clientes");
            System.out.println("4 - Atualizar clientes");
            System.out.println("5 - Cadastrar Animal");
            System.out.println("6 - Mostrar animais");
            System.out.println("7 - Deletar animais");
            System.out.println("8 - Atualizar animal");
            int option = Integer.parseInt(read.nextLine());

            switch (option){
                case 1:
                    createCliente();
                    break;
                case 2:
                    mostraClientes();
                    break;
                case 3:
                    deleteCliente();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }

            op = JOptionPane.showInputDialog("Deseja voltar ao menu? [S/n]");
        }while (op.charAt(0) != 'n');
    }

    public void createCliente(){

        JOptionPane.showMessageDialog(null,"------- MENU -------");
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
            System.out.println("ID: " + mostrarCliente.getId_cliente());
            System.out.println("Nome: " + mostrarCliente.getNome_cliente());
            System.out.println("Telefone: " + mostrarCliente.getTelefone());
            System.out.println("CPF: " + mostrarCliente.getCpf());
            System.out.println("-------------------------------------------------");
        }
    }

    public void deleteCliente(){
        String input = JOptionPane.showInputDialog("Qual cliente deseja deletar? [ID]");
        // CONVERTENDO O VALOR RECEBIDO DA VARIAVEL INPUT EM NÚMERO
        int id = Integer.parseInt(input);

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja deletar cliente?");

        if(confirm == JOptionPane.OK_OPTION){
            clienteController.deletarCliente(id);
        }else{
            JOptionPane.showMessageDialog(null,"Exclusão cancelada");
        }
    }

    public void createAnimal(){
        AnimalController animalController = new AnimalController();
        Animal animal = new Animal();

        JOptionPane.showMessageDialog(null,"CADASTRO DE ANIMAL");

        read = JOptionPane.showInputDialog("Nome do animal: ");
        animal.setNome_animal(read);
        read = JOptionPane.showInputDialog("Raça: ");
        animal.setRaca(read);
        read = JOptionPane.showInputDialog("Especie: ");
        animal.setEspecie(read);

        read = JOptionPane.showInputDialog("Dono do animal: [id]");
        int id = Integer.parseInt(read);

        animalController.cadastrarAnimal(animal, id);
    }

}
