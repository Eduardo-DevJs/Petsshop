package views;

import controllers.AnimalController;
import models.Animal;

import javax.swing.*;

public class AnimalView {
    String read;
    AnimalController animalController = new AnimalController();
    Animal animal = new Animal();
    public void cadastrarAnimal(){
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

    public void mostrarAnimais(){
        animalController.mostrarAnimais();
    }

    public void atualizarAnimal(){
        String input = JOptionPane.showInputDialog("Qual animal deseja atualizar? [ID]");
        // CONVERTENDO O VALOR RECEBIDO DA VARIAVEL INPUT EM NÚMERO
        int id = Integer.parseInt(input);
        animal.setId_animal(id);


        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");

        if(confirm == JOptionPane.OK_OPTION){
            read = JOptionPane.showInputDialog("Editar nome do animal: ");
            animal.setNome_animal(read);
            read = JOptionPane.showInputDialog("Editar Raça: ");
            animal.setRaca(read);
            read = JOptionPane.showInputDialog("Editar Especie: ");
            animal.setEspecie(read);
            read = JOptionPane.showInputDialog("Editar id do dono: ");
            animal.setId_cliente(Integer.parseInt(read));

            animalController.atualizarAnimal(animal);
        }else{
            JOptionPane.showMessageDialog(null,"Atualização cancelada");
        }
    }

    public void deleteAnimal(){
        String input = JOptionPane.showInputDialog("Qual animal deseja deletar? [ID]");

        // CONVERTENDO O VALOR RECEBIDO DA VARIAVEL INPUT EM NÚMERO
        int id = Integer.parseInt(input);

        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");

        if(confirm == JOptionPane.OK_OPTION){
            animalController.deletarAnimal(id);
        }else{
            JOptionPane.showMessageDialog(null,"Exclusão cancelada");
        }
    }
}
