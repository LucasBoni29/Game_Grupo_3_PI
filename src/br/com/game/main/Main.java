/*::============================================================::
  :: Instituição   : Senac - SP                                 ::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data:         : 31/10/2022                                 ::
  :: Projeto       : Jogo da aula de P.I                        ::
  ::============================================================::
  :: Desenvolvedor :                                            ::
  :: Data          :                             Versão Java:   ::
  :: Alteração     :                                            ::
  ::============================================================::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data          : 31/10/2022                  Versão Java: 1 ::
  :: Alteração     : Primeira versão                            ::
  ::============================================================::*/

package br.com.game.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    //TODO Criar as variáveis globais dos Time Sleep
    //TODO Criar o menu
    //TODO Criar as dificuldades do jogo
    //TODO Estilizar os textos do jogo

    public static void menu(){
        Scanner ler = new Scanner(System.in);
        List<String> menu = new ArrayList<>();

        menu.add("Novo Jogo");
        menu.add("Configurações");
        menu.add("Créditos");
        menu.add("Sair");

        System.out.println("Bem vindo ao jogo do grupo 3\n" +
                "1 -> "+menu.get(0)+"\n" +
                "2 -> "+menu.get(1)+"\n" +
                "3 -> "+menu.get(2)+"\n" +
                "4 -> "+menu.get(3)+"\n" +
                "Escolha uma das opções");
        String opcao = ler.next();
        validaOpcaoMenu(opcao);
    }

    public static void validaOpcaoMenu(String opcao){
        while (opcao != "4"){
            switch (opcao){
                case "1":
                    novoJogo();
                    break;
                case "4":
                    sair();
                    break;
                default:
                    System.err.print("Valor inválido. Tente novamente");
                    break;
            }
        }
    }

    public static String novoJogo(){
        Scanner ler = new Scanner(System.in);
        String explicacao = "Nesta jornada você será resposável por controlar uma empresa herdada. Está preparado?\n" +
                "Digite sim ou não.";
        System.out.println(explicacao);
        explicacao = ler.next();
        return explicacao;
    }


    public static void sair(){
        System.out.println("Espero que volte :´)");
        return;
    }

    public static void main(String[] args) {
        menu();
    }
}