package util;

import controllers.AnimalController;
import controllers.ClienteController;
import models.Animal;
import models.Cliente;

import javax.swing.*;

public class Util {
    String read;


    public void clientes(){
        ClienteController clienteController = new ClienteController();
        Cliente cliente  = new Cliente();

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

    public void animais(){
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

    public void petShop(){
        String boasVindas = "================= BEM VINDO AO PETSHOP =================";
        JOptionPane.showMessageDialog(null,boasVindas);
        char res;

        do{
            clientes();
            animais();

            read = JOptionPane.showInputDialog("Deseja voltar ao menu? [S/n]");
        }while (read.charAt(0) != 'n');

    }
}
