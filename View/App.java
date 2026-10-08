package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Selecione a opção para continuar:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Consultar produto por nome");
            System.out.println("4 - Atualizar produto");
            System.out.println("5 - Excluir produto");
            System.out.println("0 - Sair");
            int menu;
            try {
                menu = sc.nextInt();
                sc.nextLine();
                if (menu < 0 || menu > 5) {
                    System.out.println("Você deve digitar um numero entre 0 e 5");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Você deve digitar um numero entre 0 e 5");
                sc.nextLine();
                continue;
            }
            switch (menu) {
                case 1:
                    //chamaOp
                    break;
                case 2:
                    //chamaOp
                    break;
                case 3:
                    //chamaOp
                    break;
                case 4:
                    //chamaOp
                    break;
                case 5:
                    //chamaOp
                    break;
                case 0:
                    //chamaOp
                    break;
            }

        }
    }
}
