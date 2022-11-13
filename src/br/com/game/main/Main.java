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
  :: Data          : 05/11/2022                  Versão Java: 2 ::
  :: Alteração     : Ajustado algumas funções da história e     ::
  ::               : adicionado algumas novas validações.       ::
  ::               : SP-0006 - Ajustar funções do Xavier e criar::
  ::               : novas para validar as respostas.           ::
  ::============================================================::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data          : 31/10/2022                  Versão Java: 1 ::
  :: Alteração     : Primeira versão                            ::
  ::============================================================::*/

package br.com.game.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class Main {
    //     * @param texto Colunas a serem desativadas {@link Main}
    //     * @author Lucas Boni
    //TODO Criar função da barra de vida, função pra remover vida.
    //TODO criar variáveis globais para os Thread.sleep.

    /* ==================*/
    /* Variáveis Globais */
    /* ==================*/

    /**
     * VARIÁVEL PARA ARMAZENAR VIDA E DINHEIRO DO JOGADOR
     * ÍNDICE 0 = VIDA
     * ÍNDICE 1 = DINHEIRO
     */
    static int[] vidaDinheiro = {100, 20000};
    static int tempoDasFalas = 0;

    /**
     * VARIÁVEL USADA PARA VERIFICAÇÃO DO QUE FAZER COM A VIDA
     * 0 = NADA
     * 1 = ACRESCENTAR VIDA
     * 2 = DIMINUIR VIDA
     */
    static float statusVida = 0;
    /**
     * VARIÁVEL USADA PARA VERIFICAÇÃO DO QUE FAZER COM O DINHEIRO
     * 0 = NADA
     * 1 = ACRESCENTAR DINHEIRO
     * 2 = DIMINUIR DINHEIRO
     */
    static float statusDinheiro = 0;

    /**
     * MÉTODO USADO PARA MOSTRAR O MENU DO JOGO.
     * @author Lucas Boni.
     */
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

    /**
     * MÉTODO USADO PARA VALIDAR A OPÇÃO ESCOLHIDA DO MENU.
     * @author Lucas Boni.
     */
    public static void validaOpcaoMenu(String opcao){
        switch (opcao){
            case "1":
                novoJogo();
                break;
            case "4":
                sair();
                break;
            default:
                System.err.print("Por favor, escolha uma das opções corretamente!");
                menu();
        }
    }

    /**
     * MÉTODO USADO PARA MOSTRAR O STATUS DO JOGADOR.
     * @author Lucas Boni
     * @author Gustavo Xavier.
     */
    public static void mostrarStatus(){
        try {
            System.out.println("==================\n" +
                    "MOSTRANDO STATUS\n" +
                    "==================");
            System.out.println("");
            Thread.sleep(tempoDasFalas);
            System.out.println("===============\n" +
                    "HP: "+vidaDinheiro[0]+"\n" +
                    "===============\n" +
                    "R$: "+vidaDinheiro[1]+"\n" +
                    "===============");
        } catch (InterruptedException e) {
            throw new RuntimeException("Erro na execução de um sleep",e);
        }
    }

    /**
     * MÉTODO USADO PARA CALCULAR O STATUS DO JOGADOR.
     * @param status PASSANDO VIDA E DINHEIRO
     * @author Lucas Boni
     * @author Gustavo Xavier.
     */
    public static int[] calcularStatus(int[] status){
        Random dano =  new Random();
        try {
            if (statusVida == 1 && statusDinheiro == 2){
                status[0] += dano.nextInt(20) + 10;
                status[1] -= dano.nextInt(7000)+ 5000;
                statusVida = 0;
                statusDinheiro = 0;
                return status;
            } else if (statusVida == 2 && statusDinheiro == 1) {
                status[0] -= dano.nextInt(20) + 10;
                status[1] += dano.nextInt(7000)+ 5000;
                statusVida = 0;
                statusDinheiro = 0;
                return status;
            } else if (statusVida == 1 && statusDinheiro == 2) {
                status[0] += dano.nextInt(20) + 10;
                status[1] += dano.nextInt(7000)+ 5000;
                statusVida = 0;
                statusDinheiro = 0;
                return status;
            }
            status[0] -= dano.nextInt(20) + 10;
            status[1] -= dano.nextInt(7000)+ 5000;
            statusVida = 0;
            statusDinheiro = 0;
            System.out.println("==================\n" +
                    "CALCULANDO STATUS\n" +
                    "==================");
            System.out.println("");
            Thread.sleep(tempoDasFalas);
        } catch (InterruptedException e) {
            throw new RuntimeException("Erro na execução de um sleep", e);
        }
        return status;
    }

    /**
     * MÉTODO USADO VALIDAR SE A ESTOUROU OU NÃO.
     * @param status PASSANDO VIDA E DINHEIRO
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    public static int[] validaLimiteVida(int[] status){
        if (status[0] > 100){
            status[0] = 100;
            return status;
        }
        return status;
    }

    /**
     * MÉTODO USADO PARA VALIDAR O GAME OVER.
     * @param status PASSANDO VIDA E DINHEIRO
     * @author Lucas Boni
     * @author Gustavo Xavier.
     */
    public static void validaGameOver(int[] status){
            try {
                if (status[0] <= 0){
                    System.out.println("Sua vida chegou a 0. Você perdeu.");
                    System.exit(0);
                } else if (status[1] <= 0) {
                    System.out.println("Seu dinheiro chegou a "+status[1]+". Você perdeu.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Sua empresa...");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Faliu. Game Over!");
                    System.exit(0);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * MENU DOS NÍVEIS DE DIFICULDADE
     * @author Ryan Nascimento
     */
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

    /**
     * MÉTODO USADO PARA VERIFICAR O NÍVEL DE DIFICULDADE ESCOLHIDO.
     * @param nivel 1 = FÁCIL, 2 = NORMAL, 3 = DIFÍCIL
     * @author Ryan Nascimento
     */
    public static void validarDificuldade(int nivel){
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

    /**
     * MÉTODO USADO PARA VERIFICAR SE QUER INICIAR O JOGO OU NÃO.
     * @author Lucas Boni
     */
    public static void novoJogo(){
        Scanner ler = new Scanner(System.in);
        String opcao = "Nesta jornada você será resposável por controlar uma empresa herdada. Está preparado?\n" +
                "Digite sim ou não.";
        System.out.println(opcao);
        opcao = ler.next();
        validaNovoJogo(opcao.toLowerCase());
    }

    /**
     * MÉTODO USADO PARA VALIDAR A FUNÇÃO DO NOVO JOGO.
     * @Método novoJogo
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void validaNovoJogo(String opcao){
        if (opcao.equals("sim")){
            System.out.println("......");
            capitulo01();
        }else {
            menu();
        }
    }

    /**
     * MÉTODO USADO PARA SAIR DO JOGO.
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void sair(){
        System.out.println("Espero que volte :´)");
        return;
    }

    /**
     * MÉTODO USADO PARA IMPRIMIR A INTRO DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void txtIntro(){
        try {
            Thread.sleep(tempoDasFalas);
            System.out.println("  _______");
            System.out.println(" | °___  |");
            System.out.println(" |       |");
            System.out.println(" | 05:30!|");
            System.out.println(" |       |");
            System.out.println(" |___°___|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Trrrrrrrim...");
            Thread.sleep(tempoDasFalas);
            System.out.println("trrrrrrrim...");
            Thread.sleep(tempoDasFalas);
            System.out.println("trrrrrrrim!");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Trrrrrrrim...");
            Thread.sleep(tempoDasFalas);
            System.out.println("trrrrrrrim...");
            Thread.sleep(tempoDasFalas);
            System.out.println("trrrrrrrim!");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Você acorda com o barulho do alarme do seu  "
                    + "celular, estica o braço para desligá-lo e com os olhos "
                    + "serrilhados de sono tenta ver as horas?");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("São exatamente 5:30 da manhã e chegou a hora de "
                    + "levantar para trabalhar!");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ainda com sono, você desliga o alarme. Ao tentar "
                    + "se sentar na cama sente algumas dores e extrema indisposição."
                    + " Seu corpo pesa como se alguém \nestivesse te segurando, "
                    + "sua cabeça dói e lateja, seus olhos ardem e sua mente ainda"
                    + " está confusa. ");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Infelizmente não é ressaca. O motivo disso foi sua"
                    + " jornada de trabalho exaustiva?");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Após quatro minutos de uma dura luta com a sua "
                    + "cama, sono e indisposição você consegue se levantar e ir "
                    + "ao banheiro.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Você acende a luz e se olha no espelho, observa "
                    + "que está com um semblante cansado e olhos levemente vermelhos"
                    + " com olheiras.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Olhando para si mesmo  lembra do filme "
                    + "?eu sou a lenda??, que assistiu no fim de semana passado. "
                    + "Infelizmente, você não é o Will Smith\ne muito menos um pastor"
                    + " alemão, você se sente como um zumbi. ");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Seu apartamento é apertado, você vive com seu pai e"
                    + " seu gato chamado Frederico. Sua mãe deixou a casa após abrir uma empresa. ");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Já fazem cinco anos, mas você se lembra da cena "
                    + "como se fosse ontem. A imagem de sua mãe com uma pequena mala"
                    + " de roupas debaixo dos braços,\ndiscutindo e gritando com seu"
                    + " pai enquanto andava em direção a estreita porta do "
                    + "apartamento. ");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Ela sofria de Burnout e acabava descontado isso"
                    + "dentro de casa. Ela raramente descansava,e se tornou obcecada"
                    + " e cega por seu trabalho, vivia falando que isso era\n?para o "
                    + "bem de todos e queria nos dar uma vida digna e melhor??,"
                    + "porém isso não aconteceu, após diversas brigas ela decidiu "
                    + "sair de casa e cortou total contato.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Desde então vocês não se falaram, você não tem "
                    + "mais noticias, não sabe se ela está bem, não sabe sequer se "
                    + "está viva. \nNem tudo são flores, mas nem tudo são espinhos "
                    + "também?");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Você prepara seu café da manhã e após comê-lo e "
                    + "volta para o quarto para se arrumar, porém a ideia de deitar "
                    + "e dormir é tentadora.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Durante o mês passado você teve que cobrir o "
                    + "horário de outro funcionário, pois ele tinha ficado doente. "
                    + "Na hora de receber o seu salário a empresa falou que o\n"
                    + "?Sistema de Bater Ponto?? não mostrava as horas extras que "
                    + "você havia feito, e por isso não iam te pagar a mais.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Ontem esse mesmo funcionário foi demitido e por "
                    + "falta de pessoas você teve que trabalhar até mais tarde "
                    + "novamente, e com isso \nvocê chegou em casa por volta da 1:30 da  manhã.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * MÉTODO USADO PARA IMPRIMIR O CAPÍTULO 1 DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void capitulo01(){
        try{
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Com raiva da empresa e com medo da mesma situação "
                    + "acontecer novamente você tem as seguintes opções: ");
            System.out.println(" ");
            p1Intro();
            Thread.sleep(2500);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Você chega deprimido e decide dormir. No dia seguinte "
                    + "acorda com seu pai te chamando,falando que ?tem um advogado "
                    + "querendo falar com você??.");
            Thread.sleep(2500);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ele está sentado na cozinha explica que você é herdeiro "
                    + "direto da empresa da sua mãe, e que ela infelizmente "
                    + "morreu de covid...");
            Thread.sleep(2500);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Essa notícia te deixa abalado, mas também te motiva a "
                    + "conseguir mudar a sua qualidade de vida e a do seu pai, deseja "
                    + "aceitar o desafio de comandar uma empresa ?");
            System.out.println(" ");
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep.", e);
        }
        p2Intro();
    }

    /**
     * MÉTODO USADO PARA IMPRIMIR A PRIMEIRA PERGUNTA DA INTRO DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void p1Intro(){
        Scanner input = new Scanner(System.in);
        try {
            mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" _________________________________");
            System.out.println("|                                 |");
            System.out.println("| a) Ir para o trabalho cansado.  |");
            System.out.println("|_________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" _________________________________");
            System.out.println("|                                 |");
            System.out.println("| b) Dormir e faltar no trabalho. |");
            System.out.println("|_________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" _________________________________");
            System.out.println("|                                 |");
            System.out.println("| c) Cochilar e chegar atrasado.  |");
            System.out.println("|_________________________________|");
            Thread.sleep(2500);
            System.out.println(" ");
            System.out.println("A sua Respota é: ");
            String rP1 = input.next();
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
            validaGameOver(vidaDinheiro);
            mostrarStatus();
            System.exit(0);
            validaP1Intro(rP1);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep.", e);
        }
    }

    /**
     * MÉTODO USADO PARA VALIDAR A RESPOSTA DA PRIMEIRA PERGUNTA DA INTRO DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void validaP1Intro(String rP1) {
        try{
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
                    Thread.sleep(tempoDasFalas);
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
                    Thread.sleep(tempoDasFalas);
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
                    Thread.sleep(tempoDasFalas);
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
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep.", e);
        }
    }

    /**
     * MÉTODO USADO PARA IMPRIMIR A SEGUNDA PERGUNTA DA INTRO DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void p2Intro(){
        Scanner input = new Scanner(System.in);
        try{
            Thread.sleep(tempoDasFalas);
            System.out.println(" _________________________________");
            System.out.println("|                                 |");
            System.out.println("| a) Aceitar o desafio.           |");
            System.out.println("|_________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" _________________________________");
            System.out.println("|                                 |");
            System.out.println("| b) Recusar o desafio.           |");
            System.out.println("|_________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" _________________________________");
            System.out.println("|                                 |");
            System.out.println("| c) Rasgar o contrato            |");
            System.out.println("|_________________________________|");
            Thread.sleep(2500);
            System.out.println(" ");
            System.out.println("A sua Respota é: ");
            String rP2 = input.next();
            validaP2Intro(rP2);
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep.", e);
        }
    }

    /**
     * MÉTODO USADO PARA VALIDAR A RESPOSTA DA SEGUNDA PERGUNTA DA INTRO DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void validaP2Intro(String rP2) {
        Scanner input = new Scanner(System.in);
        try{
            switch (rP2){
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
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execução de um sleep.", e);
        }
    }

    /**
     * MÉTODO MAIN DO PROJETO. ELE QUE IRÁ RODAR O JOGO.
     * @param args RECEBE VALORES DA LINHA DE COMANDO
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void main(String[] args){
//        menu();
//        txtIntro();
//        capitulo01();
        p1Intro();
    }
}