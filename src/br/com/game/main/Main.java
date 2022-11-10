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
  :: Desenvolvedor : Ryan Morais Do Nascimento                  ::
  :: Data          : 03/11/2022                  Versão Java: 2 ::
  :: Alteração     : Criei o menu de dificuldade e a validação  ::
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

    //Escolhe o nivel de dificuldade
    public static int dificuldade(){
        Scanner input = new Scanner(System.in);
        List<String> dificuldades = new ArrayList<>();

        dificuldades.add("Fácil");
        dificuldades.add("Normal");
        dificuldades.add("Difícil");

        System.out.println("Qual nível deseja jogar?\n" +
                "1 -> "+dificuldades.get(0)+"\n" +
                "2 -> "+dificuldades.get(1)+"\n" +
                "3 -> "+dificuldades.get(2)+"\n" +
                "Escolha uma das opções");
        int nivel = input.nextInt();
        return nivel;
    }

    //Valida se a escolha foi válida
    public static void  validarDificuldade(int nivel) throws InterruptedException {
        switch (nivel){
            case 1:
                p1Intro();
                break;
            case 2:
                p1Intro();
                break;
            case 3:
                p1Intro();
                break;
            default:
                System.err.print("Valor inválido. Tente novamente");
                dificuldade();
                break;
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

    public static void txtIntro() throws InterruptedException {
        Thread.sleep(1200);
        System.out.println("  _______");
        System.out.println(" | °___  |");
        System.out.println(" |       |");
        System.out.println(" | 05:30!|");
        System.out.println(" |       |");
        System.out.println(" |___°___|");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(1200);
        System.out.println("Trrrrrrrim...");
        Thread.sleep(1200);
        System.out.println("trrrrrrrim...");
        Thread.sleep(1200);
        System.out.println("trrrrrrrim!");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(1200);
        System.out.println("Trrrrrrrim...");
        Thread.sleep(1200);
        System.out.println("trrrrrrrim...");
        Thread.sleep(1200);
        System.out.println("trrrrrrrim!");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Você acorda com o barulho do alarme do seu  "
                + "celular, estica o braço para desligá-lo e com os olhos "
                + "serrilhados de sono tenta ver as horas?");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("São exatamente 5:30 da manhã e chegou a hora de "
                + "levantar para trabalhar!");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Ainda com sono, você desliga o alarme. Ao tentar "
                + "se sentar na cama sente algumas dores e extrema indisposição."
                + " Seu corpo pesa como se alguém \nestivesse te segurando, "
                + "sua cabeça dói e lateja, seus olhos ardem e sua mente ainda"
                + " está confusa. ");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Infelizmente não é ressaca. O motivo disso foi sua"
                + " jornada de trabalho exaustiva?");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Após quatro minutos de uma dura luta com a sua "
                + "cama, sono e indisposição você consegue se levantar e ir "
                + "ao banheiro.");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Você acende a luz e se olha no espelho, observa "
                + "que está com um semblante cansado e olhos levemente vermelhos"
                + " com olheiras.");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(5000);
        System.out.println("Olhando para si mesmo  lembra do filme "
                + "?eu sou a lenda??, que assistiu no fim de semana passado. "
                + "Infelizmente, você não é o Will Smith\ne muito menos um pastor"
                + " alemão, você se sente como um zumbi. ");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Seu apartamento é apertado, você vive com seu pai"
                + " e a sua mãe deixou a casa após abrir uma empresa. ");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(5000);
        System.out.println("Já fazem cinco anos, mas você se lembra da cena "
                + "como se fosse ontem. A imagem de sua mãe com uma pequena mala"
                + " de roupas debaixo dos braços,\ndiscutindo e gritando com seu"
                + " pai enquanto andava em direção a estreita porta do "
                + "apartamento. ");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(5000);
        System.out.println("Ela sofria de Burnout e acabava descontado isso"
                + "dentro de casa. Ela raramente descansava,e se tornou obcecada"
                + " e cega por seu trabalho, vivia falando que isso era\n?para o "
                + "bem de todos e queria nos dar uma vida digna e melhor??,"
                + "porém isso não aconteceu, após diversas brigas ela decidiu "
                + "sair de casa e cortou total contato.");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(5000);
        System.out.println("Desde então vocês não se falaram, você não tem "
                + "mais noticias, não sabe se ela está bem, não sabe sequer se "
                + "está viva. \nNem tudo são flores, mas nem tudo são espinhos "
                + "também?");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Você prepara seu café da manhã e após comê-lo e "
                + "volta para o quarto para se arrumar, porém a ideia de deitar "
                + "e dormir é tentadora.");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(5000);
        System.out.println("Durante o mês passado você teve que cobrir o "
                + "horário de outro funcionário, pois ele tinha ficado doente. "
                + "Na hora de receber o seu salário a empresa falou que o\n"
                + "?Sistema de Bater Ponto?? não mostrava as horas extras que "
                + "você havia feito, e por isso não iam te pagar a mais.");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(5000);
        System.out.println("Ontem esse mesmo funcionário foi demitido e por "
                + "falta de pessoas você teve que trabalhar até mais tarde "
                + "novamente, e com isso \nvocê chegou em casa por volta da 1:30 da  manhã.");
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(1200);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");


    }
    public static void p1Intro() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Thread.sleep(1200);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Com raiva da empresa e com medo da mesma situação "
                + "acontecer novamente você tem as seguintes opções: ");
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println(" _________________________________");
        System.out.println("|                                 |");
        System.out.println("| a) Ir para o trabalho cansando. |");
        System.out.println("|_________________________________|");
        Thread.sleep(3500);
        System.out.println(" ");
        System.out.println(" _________________________________");
        System.out.println("|                                 |");
        System.out.println("| b) Dormir e faltar no trabalho. |");
        System.out.println("|_________________________________|");
        Thread.sleep(3500);
        System.out.println(" ");
        System.out.println(" _________________________________");
        System.out.println("|                                 |");
        System.out.println("| c) Cochilar e chegar atrasado.  |");
        System.out.println("|_________________________________|");
        Thread.sleep(2500);
        System.out.println(" ");
        System.out.println("A sua Respota é: ");
        String rP1 = input.next();

        switch (rP1) {
            case "a":
                Thread.sleep(2500);
                System.out.println(" ");
                System.out.println("Chegando no trabalho foram dados diversos carros"
                        + " para você estacionar, o sono e cansaço estão te "
                        + "atrapalhando de forma severa, após quatro copos de café\n"
                        + "e levar o rosto várias vezes você ainda se sente casado.");
                Thread.sleep(5500);
                System.out.println("\nPerto do fim do expediente chega o último carro do "
                        + "dia. É um carro de passeio todo preto e dele desce um"
                        + "homem,\nele está meio apresentado, joga as chaves na "
                        + "sua mão e entra correndo para dentro da empresa.");
                Thread.sleep(5500);
                System.out.println("\nA maioria das vagas estão ocupadas, então você tem que ir para o estacionamento"
                        + "dos fundos da empresa.\nDirigindo com sono em lugar "
                        + "escuro você acaba ralando o carro em uma caçamba de lixo."
                        + " O seu supervisor vê a cena e avisa para o chefe.\nAo fim "
                        + "do expediente ele pede para que você passe no RH.");
                Thread.sleep(3500);
                System.out.println(" ");
                Thread.sleep(2500);
                System.out.println("Você...");
                Thread.sleep(2500);
                System.out.println("Está...");
                Thread.sleep(2500);
                System.out.println("Demitido!");
                break;
            case "b":
                Thread.sleep(2500);
                System.out.println(" ");
                System.out.println("Após acordar do seu cochilo você pega seu "
                        + "celular e se depara com o seguinte cenário"
                        + " ?2 ligações perdidas e 7 mensagens não lidas??.\n"
                        + "Seu chefe está furioso, pois não tinha ninguém para "
                        + "estacionar os carros.");
                Thread.sleep(3500);
                System.out.println(" ");
                Thread.sleep(2500);
                System.out.println("Você...");
                Thread.sleep(2500);
                System.out.println("Está...");
                Thread.sleep(2500);
                System.out.println("Demitido!");
                break;
            case "c":
                Thread.sleep(2500);
                System.out.println(" ");
                Thread.sleep(5500);
                System.out.println("\nVocê cehga atrasado no trabalho e foram dados diversos carros"
                        + " para você estacionar. Perto do fim do expediente é dado o "
                        + "último carro do dia.\nÉ um carro de passeio todo preto"
                        + " e dele desce um homem, ele está meio apresentado, "
                        + "joga as chaves na sua mão e entra correndo para "
                        + "dentro da empresa.");
                Thread.sleep(5500);
                System.out.println("\nA maioria das vagas estão ocupadas, "
                        + "então você tem que ir para o estacionamento dos "
                        + "fundos da empresa.\nVocê guarda o carro na vaga e "
                        + "volta para onde estava antes." + " Seu supervisor não "
                        + "parece estar muito feliz, ele pergunta o motivo de "
                        + "seu atraso hoje.");
                Thread.sleep(5500);
                System.out.println("\nSendo honesto você explica sua "
                        + "situação. Porém isso não ajuda muito, ele pede "
                        + "para que você passe no RH.");
                Thread.sleep(3500);
                System.out.println(" ");
                Thread.sleep(2500);
                System.out.println("Você...");
                Thread.sleep(2500);
                System.out.println("Está...");
                Thread.sleep(2500);
                System.out.println("Demitido!");
                break;
            default:
                System.out.println("Opção Inválida, escolha apenas entre a, b ou c\n >:(");
                p1Intro();
        }
    }

    public static void p2Intro() throws InterruptedException {
        Thread.sleep(2500);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Você chega deprimido e decide dormir. No dia seguinte "
                + "acorda com seu pai te chamando,falando que ?tem um advogado "
                + "querendo falar com você??.");
        Thread.sleep(2500);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Ele está sentado na cozinha explica que você é herdeiro "
                + "direto da empresa da sua mãe, e que ela infelizmente "
                + "morreu de covid...");
        Thread.sleep(2500);
        System.out.println(" ");
        Thread.sleep(3500);
        System.out.println("Essa notícia te deixa abalado, mas também te motiva a "
                + "conseguir mudar a sua qualidade de vida e a do seu pai, deseja "
                + "aceitar o desafio de comandar uma empresa ?");

        System.out.println(" ");
        Scanner input = new Scanner(System.in);
        Thread.sleep(3500);
        System.out.println(" _________________________________");
        System.out.println("|                                 |");
        System.out.println("| a) Aceitar o desafio.           |");
        System.out.println("|_________________________________|");
        Thread.sleep(3500);
        System.out.println(" ");
        System.out.println(" _________________________________");
        System.out.println("|                                 |");
        System.out.println("| b) Recusar o desafio.           |");
        System.out.println("|_________________________________|");
        Thread.sleep(3500);
        System.out.println(" ");
        System.out.println(" _________________________________");
        System.out.println("|                                 |");
        System.out.println("| c) Rasgar o contrato            |");
        System.out.println("|_________________________________|");
        Thread.sleep(2500);
        System.out.println(" ");
        System.out.println("A sua Respota é: ");
        String rP2 = input.next();
        switch (rP2) {
            case "a":
                Thread.sleep(2500);
                System.out.println(" ");
                System.out.println("Ele te entrega um contrato e pede para que você assine com seu nome. Qual o seu nome? ");
                System.out.println("A sua Respota é: ");
                String nome = input.next();
                System.out.println("nome");
                System.out.println("Após isso ele passa o contato de um importante funcionário e amigo de sua mãe e fala que ele já tem um grandeconhecimento da empresa e pode te ajudar. ");
                break;
            case "b":
                Thread.sleep(2500);
                System.out.println(" ");
                System.out.println("Você decide não aceitar comandar a empresa, "
                        + "e decide vendê-la, com esse dinheiro você consegue ajudar "
                        + "seu pai em casa.\nPouco tempo depois você consegue "
                        + "arrumar um novo emprego como entregador de encomendas. ");
                break;
            case "c":
                Thread.sleep(2500);
                System.out.println(" ");
                System.out.println("Você rasga o contrato com raiva, o advogado "
                        + "te encara meio confuso porém não nem uma pergunta, "
                        + "apenas se levanta e sai.\nPouco tempo depois você "
                        + "consegue arrumar um novo emprego como entregador de encomendas. ");
                break;
            default:
                System.out.println("Opção Inválida, escolha apenas entre a, b ou c\n >:(");
                p2Intro();
        }
    }

    public static void main(String[] args) {
        menu();
    }
}