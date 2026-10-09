package View;

import Model.Produto;
import Service.Operacoes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operacoes op = new Operacoes();
        List<Produto> produtos = new ArrayList<Produto>();
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
                    System.out.println("Cadastrar produto ");
                    String nome = op.nomearProduto(sc);
                    String descricao = op.descreverProduto(sc);
                    double valor = op.precificarProduto(sc);
                    Produto produto = new Produto(nome, descricao, valor);
                    produtos.add(produto);
                    break;
                case 2:
                    op.listarProdutos(produtos);
                    break;
                case 3:
                    op.procurarProduto(sc,produtos);
                    break;
                case 4:
                    op.atualizarProduto(sc,produtos);
                    break;
                case 5:
                    op.excluirProduto(sc,produtos);
                    break;
                case 0:
                    System.out.println("Saindo");
                    return;
            }

        }
    }
}
