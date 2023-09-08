package util;

import controllers.AnimalController;
import java.util.HashSet;
import controllers.ClienteController;
import models.Animal;
import models.Cliente;

import javax.swing.*;

import java.util.Scanner;

public class Util{
    UtilAnimal utilAnimal = new UtilAnimal();
    UtilCliente utilCliente = new UtilCliente();
    UtilServicos utilServicos = new UtilServicos();
    String read;

    public void menuOpcoes(){
        Scanner read = new Scanner(System.in);
        String op;
        char res;
        do{
            System.out.println("-------- CLIENTES ----------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Mostrar clientes");
            System.out.println("3 - Deletar clientes");
            System.out.println("4 - Atualizar clientes");
            System.out.println("\n");
            System.out.println("-------- ANIMAL ----------");
            System.out.println("5 - Cadastrar Animal");
            System.out.println("6 - Mostrar animais");
            System.out.println("7 - Deletar animais");
            System.out.println("8 - Atualizar animal");
            System.out.println("\n");
            System.out.println("Digite uma das opções acima: ");

            int option = Integer.parseInt(read.nextLine());

            switch (option){
                case 1:
                    utilCliente.createCliente();
                    break;
                case 2:
                    utilCliente.mostraClientes();
                    break;
                case 3:
                    utilCliente.deleteCliente();
                    break;
                case 4:
                    utilCliente.atualizaCliente();
                    break;
                case 5:
                    utilAnimal.cadastrarAnimal();
                    break;
                case 6:
                    utilAnimal.mostrarAnimais();
                    break;
                case 7:
                    utilAnimal.deleteAnimal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }

            op = JOptionPane.showInputDialog("Deseja voltar ao menu? [S/n]");
        }while (op.charAt(0) != 'n');
    }
}
