package util;
import views.AnimalView;
import views.ClienteView;
import views.ServicosView;

import javax.swing.*;
import java.util.Scanner;

public class Util{
    AnimalView animalView = new AnimalView();
    ClienteView clienteView = new ClienteView();
    ServicosView servicosView = new ServicosView();

    public void menuOpcoes(){
        Scanner read = new Scanner(System.in);
        int op;
        do{
            System.out.println("\n");
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
            System.out.println("-------- SERVICOS ----------");
            System.out.println("9 - Cadastrar servico");
            System.out.println("10 - Mostrar servicos");
            System.out.println("11 - Deletar serviço");
            System.out.println("12 - Atualizar serviço");
            System.out.println("\n");
            System.out.println("Digite uma das opções acima: ");


            int option = Integer.parseInt(read.nextLine());

            switch (option){
                case 1:
                    clienteView.createCliente();
                    break;
                case 2:
                    clienteView.mostraClientes();
                    break;
                case 3:
                    clienteView.deleteCliente();
                    break;
                case 4:
                    clienteView.atualizaCliente();
                    break;
                case 5:
                    animalView.cadastrarAnimal();
                    break;
                case 6:
                    animalView.mostrarAnimais();
                    break;
                case 7:
                    animalView.deleteAnimal();
                    break;
                case 8:
                    animalView.atualizarAnimal();
                    break;
                case 9:
                    servicosView.cadastraServico();
                    break;
                case 10:
                    servicosView.mostrarServicos();
                    break;
                case 11:
                    servicosView.deletarServico();
                    break;
                case 12:
                    servicosView.atualizarServico();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }

             op = JOptionPane.showConfirmDialog(null, "Deseja voltar ao menu? ");
        }while (op != JOptionPane.NO_OPTION && op != JOptionPane.CANCEL_OPTION);

    }
}
