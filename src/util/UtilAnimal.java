package util;

import controllers.AnimalController;
import models.Animal;

import javax.swing.*;

public class UtilAnimal {
    String read;
    AnimalController animalController = new AnimalController();
    Animal animal = new Animal();
    public void cadastrarAnimal(){
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

    public void mostrarAnimais(){
        AnimalController animalController = new AnimalController();

        for (Animal mostrarAnimai : animalController.mostrarAnimais()) {
            System.out.println("Nome do animal: " + mostrarAnimai.getNome_animal());
            System.out.println("Especie: " + mostrarAnimai.getEspecie());
            System.out.println("Raça: " + mostrarAnimai.getRaca());
            System.out.println("Id do dono: " + mostrarAnimai.getId_cliente());
            System.out.println("---------------------------------------------------");
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
