package Service;


import Model.Produto;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Operacoes {



    public String nomearProduto(Scanner sc){
        while(true){
            System.out.println("Digite o nome do produto: ");
           String nome = sc.nextLine();
            if(nome.isEmpty()){
                System.out.println("O nome não pode estar em branco");
            }else{
                return nome;
            }
        }
    }

    public String descreverProduto(Scanner sc){
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

    public double precificarProduto(Scanner sc){
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

    public void listarProdutos(List<Produto> produtos){
        if(produtos.isEmpty()){
            System.out.println("A lista de produtos esta vazia");

        }else {
            for (Produto produto : produtos) {
                System.out.println(produto.toString());
            }
        }
    }

    public void procurarProduto(Scanner sc, List<Produto> produtos){
        if(produtos.isEmpty()){
            System.out.println("A lista de produtos esta vazia");
        }else{
        while(true){
            boolean procurado = false;
            System.out.println("Digite o nome do produto: ");
            String nome = sc.nextLine();
            if(nome.isEmpty()){
                System.out.println("Voce deve digitar um nome");
            }else {
                for (Produto produto : produtos) {
                    if (produto.getNome().equals(nome)) {
                        System.out.println(produto);
                        procurado = true;
                    }
              }
                if(procurado){
                    break;
                }else {
                    System.out.println("Produto não localizado");
                    break;
                }
            }
            System.out.println("Digite o nome do produto: ");
          }
        }

    }

    public void atualizarProduto(Scanner sc, List<Produto> produtos){
        if(produtos.isEmpty()){
            System.out.println("A lista de produtos esta vazia");
        }else{
            System.out.println("Qual nome do produto que você gostaria de atualizar?");
            String atualizar = sc.nextLine();
            boolean atualizado = false;
            for(Produto p : produtos){
                if(p.getNome().equals(atualizar)){
                    System.out.println(p);
                    atualizado = true;
                    System.out.println("Qual informação voce gostaria de atualizar?");
                    System.out.println("1- Nome: "+p.getNome());
                    System.out.println("2- Descrição: "+p.getDescricao());
                    System.out.println("3- preco: "+p.getPreco());
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
                    switch(menuUpdate){
                        case 1:
                            p.setNome(nomearProduto(sc));
                            break;
                        case 2:
                            p.setDescricao(descreverProduto(sc));
                            break;
                        case 3:
                            p.setPreco(precificarProduto(sc));
                            break;
                    }
                    break;

                }

            }
            if(!atualizado){
                System.out.println("Produto não encontrado");

            }
        }
    }

    public void excluirProduto(Scanner sc, List<Produto> produtos){
        if(produtos.isEmpty()){
            System.out.println("A lista de produtos esta vazia");
        }else {
            System.out.println("Qual nome do produto você gostaria de excluir?");
            String excluir = sc.nextLine();
            Produto produtoExcluido = null;
            for (Produto p : produtos) {
                if (p.getNome().equals(excluir)) {
                    produtoExcluido = p;
                    break;
                }
            }
            if (produtoExcluido == null) {
                System.out.println("Nenhum produto foi encontrado.");
            }else{
                while (true) {
                    System.out.println("Você tem certeza que desejas excluir esse produto: " + produtoExcluido.getNome());
                    System.out.println("1- Sim");
                    System.out.println("2- Não");
                    int menuExcluir;
                    try {
                        menuExcluir = sc.nextInt();
                        sc.nextLine();
                        if (menuExcluir < 1 || menuExcluir > 2) {
                            System.out.println("Você deve digitar um numero entre 1 e 2");
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Você deve digitar um numero entre 1 e 2");
                        System.out.println("Erro: " + e.getMessage());
                        sc.nextLine();
                        continue;
                    }
                    if (menuExcluir == 1) {
                        produtos.remove(produtoExcluido);
                        System.out.println("Produto excluido com sucesso!");
                        break;
                    } else {
                        System.out.println("Exclusão cancelada!");
                        break;
                    }

                }


            }
        }
    }
}



