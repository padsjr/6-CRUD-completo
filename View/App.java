package View;

import Model.Produto;
import Service.Operacoes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
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
                    String nome = nomearProduto();
                    String descricao = descreverProduto();
                    double valor = precificarProduto();
                    Produto produto = new Produto(nome, descricao, valor);
                    produtos.add(produto);
                    break;
                case 2:
                    op.listarProdutos(produtos);
                    break;
                case 3:
                    op.procurarProduto(pegarIdProduto(sc,produtos),produtos);
                    break;
                case 4:
                    System.out.println("Atualizar produto ");
                    int produtoAtualizado = pegarIdProduto(sc,produtos);
                    if (produtoAtualizado == 0) {
                        break;
                    }else{
                        System.out.println("Produto a ser atualizado: ");
                        op.procurarProduto(produtoAtualizado,produtos);
                        System.out.println("Qual informação voce gostaria de atualizar?");
                        System.out.println("1- Nome: "+ produtos.get(produtoAtualizado-1).getNome());
                        System.out.println("2- Descrição: "+produtos.get(produtoAtualizado-1).getDescricao());
                        System.out.println("3- preco: "+produtos.get(produtoAtualizado-1).getPreco());
                        int menuUpdate ;
                        try{
                            menuUpdate = sc.nextInt();
                            sc.nextLine();
                            if(menuUpdate < 1 || menuUpdate > 3){
                                System.out.println("Você deve digitar um numero entre 1 e 3");
                                continue;
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Você deve digitar um numero entre 1 e 3");
                            System.out.println("Erro: "+e.getMessage());
                            sc.nextLine();
                            continue;
                        }
                        String nomeAtualizado, descricaoAtualizado;
                        double valorAtualizado;
                        switch (menuUpdate) {
                            case 1:
                                System.out.println("Renomear produto ");
                                nomeAtualizado = nomearProduto();
                                produtos.get(produtoAtualizado-1).setNome(nomeAtualizado);
                                System.out.println("Nome atualizado");
                                break;
                            case 2:
                                System.out.println("Alterar descrição produto ");
                                descricaoAtualizado = descreverProduto();
                                produtos.get(produtoAtualizado-1).setDescricao(descricaoAtualizado);
                                System.out.println("Descricao atualizada");
                                break;
                            case 3:
                                System.out.println("Alterar valor do produto ");
                                valorAtualizado = precificarProduto();
                                produtos.get(produtoAtualizado-1).setPreco(valorAtualizado);
                                System.out.println("Preco atualizado");
                                break;
                        }
                        System.out.println("Produto atualizado com sucesso");

                    }
                    break;
                case 5:
                    System.out.println("Excluir produto ");
                    int produtoExcluido = pegarIdProduto(sc,produtos);
                    if (produtoExcluido == 0) {
                        break;
                    }else{
                        while(true){
                            System.out.println("Você tem certeza que deseja excluir esse produto: ");
                            op.procurarProduto(produtoExcluido,produtos);
                            System.out.println("1- Sim");
                            System.out.println("2- Não");
                            int menuExcluir;
                            try{
                                menuExcluir = sc.nextInt();
                                sc.nextLine();
                                if (menuExcluir < 1 || menuExcluir > 2) {
                                    System.out.println("Você deve digitar um numero entre 1 e 2");
                                    continue;
                                }
                            }catch (InputMismatchException e){
                                System.out.println("Você deve digitar um numero entre 1 e 2");
                                System.out.println("Erro: "+e.getMessage());
                                sc.nextLine();
                                continue;
                            }
                            if(menuExcluir == 1){
                                op.excluirProduto(produtoExcluido,produtos);
                                break;
                            }else{
                                System.out.println("Exclusão de produto cancelada!");
                                break;
                            }
                        }


                    }
                    break;
                case 0:
                    System.out.println("Saindo");
                    return;
            }

        }
    }
    public static String nomearProduto(){
        while(true){
            System.out.println("Digite o nome do produto: ");
            String nome = sc.nextLine();
            if(nome.isEmpty()){
                System.out.println("O nome não pode estar em branco");
            }else if(nome.isBlank()){
                System.out.println("O nome não pode estar em branco");
            }
            else{
                return nome;
            }
        }
    }
    public static String descreverProduto(){
        while(true){
            System.out.println("Crie uma breve descrição para o produto: ");
            String desc = sc.nextLine();
            if(desc.isEmpty()){
                System.out.println("A descrição não pode estar em branco");
            }else{
                return desc;
            }
        }
    }
    public static double precificarProduto(){
        while(true){
            double valor;
            System.out.println("Digite o valor do produto: ");
            try{
                valor = sc.nextDouble();
                if(valor < 0){
                    System.out.println("O valor não pode ser negativo");
                    sc.nextLine();
                }else if(valor > 0){
                    return valor;
                }

            }catch(InputMismatchException e){
                System.out.println("O preço deve ser um valor numerio inteiro ou decimal");
                sc.nextLine();
            }

        }
    }
    public static int pegarIdProduto(Scanner sc, List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("A lista de produtos esta vazia");
        } else {
            while (true) {
                System.out.println("Digite o nome do produto: ");
                String nome = sc.nextLine();
                if(nome.isEmpty()){
                    System.out.println("O nome não pode estar em branco");
                }else if(nome.isBlank()){
                    System.out.println("O nome não pode estar em branco");
                } else {
                    for (Produto produto : produtos) {
                        if (produto.getNome().equals(nome)) {
                            return produto.getId();
                        }
                    }
                    System.out.println("Produto não localizado, tente novamente");
                }
            }
        }
        return 0;
    }
}


