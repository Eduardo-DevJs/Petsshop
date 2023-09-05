import controllers.AnimalController;
import controllers.ClienteController;
import models.Animal;
import models.Cliente;

import javax.swing.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        AnimalController animalController = new AnimalController();
        Cliente cliente = new Cliente();
        Animal animal = new Animal();

        String read;

        // CADASTRO

        /*
        read = JOptionPane.showInputDialog("Nome do cliente: ");
        cliente.setNome_cliente(read);
        read = JOptionPane.showInputDialog("Nome do pet: ");
        cliente.setNome_pet(read);
        read = JOptionPane.showInputDialog("Telefone: ");
        cliente.setTelefone(read);
        read = JOptionPane.showInputDialog("CPF: ");
        cliente.setCpf(read);

        clienteController.cadastrarCliente(cliente);
        */

    }
}