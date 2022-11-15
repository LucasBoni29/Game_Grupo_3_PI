/*::============================================================::
  :: Institui��o   : Senac - SP                                 ::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data:         : 31/10/2022                                 ::
  :: Projeto       : Jogo da aula de P.I                        ::
  ::============================================================::
  :: Desenvolvedor :                                            ::
  :: Data          :                             Vers�o Java:   ::
  :: Altera��o     :                                            ::
  ::============================================================::
  :: Desenvolvedor : Ryan Morais Do Nascimento                  ::
  :: Data          : 15/11/2022                  Vers�o Java: 3 ::
  :: Altera��o     : Criei a primeira historia do jovo e sua    ::
  ::               : valida��o.                                 ::
  ::============================================================::
  :: Desenvolvedor : Ryan Morais Do Nascimento                  ::
  :: Data          : 03/11/2022                  Vers�o Java: 2 ::
  :: Altera��o     : Criei o menu de dificuldade e a valida��o  ::
  ::============================================================::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data          : 05/11/2022                  Vers�o Java: 2 ::
  :: Altera��o     : Ajustado algumas fun��es da hist�ria e     ::
  ::               : adicionado algumas novas valida��es.       ::
  ::               : SP-0006 - Ajustar fun��es do Xavier e criar::
  ::               : novas para validar as respostas.           ::
  ::============================================================::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data          : 31/10/2022                  Vers�o Java: 1 ::
  :: Altera��o     : Primeira vers�o                            ::
  ::============================================================::*/

package br.com.game.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    //TODO Criar as vari�veis globais dos Time Sleep;
    //TODO Criar as dificuldades do jogo;
    public static void menu(){
        Scanner ler = new Scanner(System.in);
        List<String> menu = new ArrayList<>();

        menu.add("Novo Jogo");
        menu.add("Configura��es");
        menu.add("Cr�ditos");
        menu.add("Sair");

        System.out.println("Bem vindo ao jogo do grupo 3\n" +
                "1 -> "+menu.get(0)+"\n" +
                "2 -> "+menu.get(1)+"\n" +
                "3 -> "+menu.get(2)+"\n" +
                "4 -> "+menu.get(3)+"\n" +
                "Escolha uma das op��es");
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
                System.err.print("Por favor, escolha uma das op��es corretamente!");
                menu();
        }
    }
    
    //Escolhe o nivel de dificuldade
    public static int dificuldade(){
        Scanner input = new Scanner(System.in);
        List<String> dificuldades = new ArrayList<>();

        dificuldades.add("F�cil");
        dificuldades.add("Normal");
        dificuldades.add("Dif�cil");

        System.out.println("Qual n�vel deseja jogar?\n" +
                "1 -> "+dificuldades.get(0)+"\n" +
                "2 -> "+dificuldades.get(1)+"\n" +
                "3 -> "+dificuldades.get(2)+"\n" +
                "Escolha uma das op��es");
        int nivel = input.nextInt();
        return nivel;
    }

    //Valida se a escolha foi v�lida
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
                System.err.print("Valor inv�lido. Tente novamente");
                dificuldade();
                break;
        }

    }
    
    public static void novoJogo(){
        Scanner ler = new Scanner(System.in);
        String opcao = "Nesta jornada voc� ser� respos�vel por controlar uma empresa herdada. Est� preparado?\n" +
                "Digite sim ou n�o.";
        System.out.println(opcao);
        opcao = ler.next();
        validaNovoJogo(opcao.toLowerCase());
    }
    public static void validaNovoJogo(String opcao){
        if (opcao.equals("sim")){
            System.out.println("......");
            capitulo01();
        }else {
            menu();
        }
    }
    public static void sair(){
        System.out.println("Espero que volte :�)");
        return;
    }
    public static void txtIntro(){
        try {
            Thread.sleep(1200);
            System.out.println("  _______");
            System.out.println(" | �___  |");
            System.out.println(" |       |");
            System.out.println(" | 05:30!|");
            System.out.println(" |       |");
            System.out.println(" |___�___|");
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
            System.out.println("Voc� acorda com o barulho do alarme do seu  "
                    + "celular, estica o bra�o para deslig�-lo e com os olhos "
                    + "serrilhados de sono tenta ver as horas?");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("S�o exatamente 5:30 da manh� e chegou a hora de "
                    + "levantar para trabalhar!");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Ainda com sono, voc� desliga o alarme. Ao tentar "
                    + "se sentar na cama sente algumas dores e extrema indisposi��o."
                    + " Seu corpo pesa como se algu�m \nestivesse te segurando, "
                    + "sua cabe�a d�i e lateja, seus olhos ardem e sua mente ainda"
                    + " est� confusa. ");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Infelizmente n�o � ressaca. O motivo disso foi sua"
                    + " jornada de trabalho exaustiva?");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Ap�s quatro minutos de uma dura luta com a sua "
                    + "cama, sono e indisposi��o voc� consegue se levantar e ir "
                    + "ao banheiro.");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Voc� acende a luz e se olha no espelho, observa "
                    + "que est� com um semblante cansado e olhos levemente vermelhos"
                    + " com olheiras.");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Olhando para si mesmo  lembra do filme "
                    + "?eu sou a lenda??, que assistiu no fim de semana passado. "
                    + "Infelizmente, voc� n�o � o Will Smith\ne muito menos um pastor"
                    + " alem�o, voc� se sente como um zumbi. ");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Seu apartamento � apertado, voc� vive com seu pai"
                    + " e a sua m�e deixou a casa ap�s abrir uma empresa. ");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("J� fazem cinco anos, mas voc� se lembra da cena "
                    + "como se fosse ontem. A imagem de sua m�e com uma pequena mala"
                    + " de roupas debaixo dos bra�os,\ndiscutindo e gritando com seu"
                    + " pai enquanto andava em dire��o a estreita porta do "
                    + "apartamento. ");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Ela sofria de Burnout e acabava descontado isso"
                    + "dentro de casa. Ela raramente descansava,e se tornou obcecada"
                    + " e cega por seu trabalho, vivia falando que isso era\n?para o "
                    + "bem de todos e queria nos dar uma vida digna e melhor??,"
                    + "por�m isso n�o aconteceu, ap�s diversas brigas ela decidiu "
                    + "sair de casa e cortou total contato.");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Desde ent�o voc�s n�o se falaram, voc� n�o tem "
                    + "mais noticias, n�o sabe se ela est� bem, n�o sabe sequer se "
                    + "est� viva. \nNem tudo s�o flores, mas nem tudo s�o espinhos "
                    + "tamb�m?");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Voc� prepara seu caf� da manh� e ap�s com�-lo e "
                    + "volta para o quarto para se arrumar, por�m a ideia de deitar "
                    + "e dormir � tentadora.");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Durante o m�s passado voc� teve que cobrir o "
                    + "hor�rio de outro funcion�rio, pois ele tinha ficado doente. "
                    + "Na hora de receber o seu sal�rio a empresa falou que o\n"
                    + "?Sistema de Bater Ponto?? n�o mostrava as horas extras que "
                    + "voc� havia feito, e por isso n�o iam te pagar a mais.");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(5000);
            System.out.println("Ontem esse mesmo funcion�rio foi demitido e por "
                    + "falta de pessoas voc� teve que trabalhar at� mais tarde "
                    + "novamente, e com isso \nvoc� chegou em casa por volta da 1:30 da  manh�.");
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(1200);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void capitulo01(){
        try{
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Com raiva da empresa e com medo da mesma situa��o "
                    + "acontecer novamente voc� tem as seguintes op��es: ");
            System.out.println(" ");
            p1Intro();
            Thread.sleep(2500);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Voc� chega deprimido e decide dormir. No dia seguinte "
                    + "acorda com seu pai te chamando,falando que ?tem um advogado "
                    + "querendo falar com voc�??.");
            Thread.sleep(2500);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Ele est� sentado na cozinha explica que voc� � herdeiro "
                    + "direto da empresa da sua m�e, e que ela infelizmente "
                    + "morreu de covid...");
            Thread.sleep(2500);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Essa not�cia te deixa abalado, mas tamb�m te motiva a "
                    + "conseguir mudar a sua qualidade de vida e a do seu pai, deseja "
                    + "aceitar o desafio de comandar uma empresa ?");
            System.out.println(" ");
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu��o de um sleep.", e);
        }
        p2Intro();
    }
    public static void p1Intro(){
        Scanner input = new Scanner(System.in);
        try {
            Thread.sleep(3500);
            System.out.println(" _________________________________");
            System.out.println("|                                 |");
            System.out.println("| a) Ir para o trabalho cansado.  |");
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
            System.out.println("A sua Respota �: ");
            String rP1 = input.next();
            validaP1Intro(rP1);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execu��o de um sleep.", e);
        }
    }
    public static void validaP1Intro(String rP1) {
        try{
            switch (rP1) {
                case "a":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("Chegando no trabalho foram dados diversos carros"
                            + " para voc� estacionar, o sono e cansa�o est�o te "
                            + "atrapalhando de forma severa, ap�s quatro copos de caf�\n"
                            + "e levar o rosto v�rias vezes voc� ainda se sente casado.");
                    Thread.sleep(5500);
                    System.out.println("\nPerto do fim do expediente chega o �ltimo carro do "
                            + "dia. � um carro de passeio todo preto e dele desce um"
                            + "homem,\nele est� meio apresentado, joga as chaves na "
                            + "sua m�o e entra correndo para dentro da empresa.");
                    Thread.sleep(5500);
                    System.out.println("\nA maioria das vagas est�o ocupadas, ent�o voc� tem que ir para o estacionamento"
                            + "dos fundos da empresa.\nDirigindo com sono em lugar "
                            + "escuro voc� acaba ralando o carro em uma ca�amba de lixo."
                            + " O seu supervisor v� a cena e avisa para o chefe.\nAo fim "
                            + "do expediente ele pede para que voc� passe no RH.");
                    Thread.sleep(3500);
                    System.out.println(" ");
                    Thread.sleep(2500);
                    System.out.println("Voc�...");
                    Thread.sleep(2500);
                    System.out.println("Est�...");
                    Thread.sleep(2500);
                    System.out.println("Demitido!");
                    break;
                case "b":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("Ap�s acordar do seu cochilo voc� pega seu "
                            + "celular e se depara com o seguinte cen�rio"
                            + " ?2 liga��es perdidas e 7 mensagens n�o lidas??.\n"
                            + "Seu chefe est� furioso, pois n�o tinha ningu�m para "
                            + "estacionar os carros.");
                    Thread.sleep(3500);
                    System.out.println(" ");
                    Thread.sleep(2500);
                    System.out.println("Voc�...");
                    Thread.sleep(2500);
                    System.out.println("Est�...");
                    Thread.sleep(2500);
                    System.out.println("Demitido!");
                    break;
                case "c":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    Thread.sleep(5500);
                    System.out.println("\nVoc� cehga atrasado no trabalho e foram dados diversos carros"
                            + " para voc� estacionar. Perto do fim do expediente � dado o "
                            + "�ltimo carro do dia.\n� um carro de passeio todo preto"
                            + " e dele desce um homem, ele est� meio apresentado, "
                            + "joga as chaves na sua m�o e entra correndo para "
                            + "dentro da empresa.");
                    Thread.sleep(5500);
                    System.out.println("\nA maioria das vagas est�o ocupadas, "
                            + "ent�o voc� tem que ir para o estacionamento dos "
                            + "fundos da empresa.\nVoc� guarda o carro na vaga e "
                            + "volta para onde estava antes." + " Seu supervisor n�o "
                            + "parece estar muito feliz, ele pergunta o motivo de "
                            + "seu atraso hoje.");
                    Thread.sleep(5500);
                    System.out.println("\nSendo honesto voc� explica sua "
                            + "situa��o. Por�m isso n�o ajuda muito, ele pede "
                            + "para que voc� passe no RH.");
                    Thread.sleep(3500);
                    System.out.println(" ");
                    Thread.sleep(2500);
                    System.out.println("Voc�...");
                    Thread.sleep(2500);
                    System.out.println("Est�...");
                    Thread.sleep(2500);
                    System.out.println("Demitido!");
                    break;
                default:
                    System.out.println("Op��o Inv�lida, escolha apenas entre a, b ou c\n >:(");
                    p1Intro();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu��o de um sleep.", e);
        }
    }
    public static void p2Intro(){
        Scanner input = new Scanner(System.in);
        try{
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
            System.out.println("A sua Respota �: ");
            String rP2 = input.next();
            validaP2Intro(rP2);
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu��o de um sleep.", e);
        }
    }
    public static void validaP2Intro(String rP2) {
        Scanner input = new Scanner(System.in);
        try{
            switch (rP2){
                case "a":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("Ele te entrega um contrato e pede para que voc� assine com seu nome. Qual o seu nome? ");
                    System.out.println("A sua Respota �: ");
                    String nome = input.next();
                    System.out.println("nome");
                    System.out.println("Ap�s isso ele passa o contato de um importante funcion�rio e amigo de sua m�e e fala que ele j� tem um grandeconhecimento da empresa e pode te ajudar. ");
                    break;
                case "b":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("Voc� decide n�o aceitar comandar a empresa, "
                            + "e decide vend�-la, com esse dinheiro voc� consegue ajudar "
                            + "seu pai em casa.\nPouco tempo depois voc� consegue "
                            + "arrumar um novo emprego como entregador de encomendas. ");
                    break;
                case "c":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("Voc� rasga o contrato com raiva, o advogado "
                            + "te encara meio confuso por�m n�o nem uma pergunta, "
                            + "apenas se levanta e sai.\nPouco tempo depois voc� "
                            + "consegue arrumar um novo emprego como entregador de encomendas. ");
                    break;
                default:
                    System.out.println("Op��o Inv�lida, escolha apenas entre a, b ou c\n >:(");
                    p2Intro();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu��o de um sleep.", e);
        }
    }


    /* --------iNTRODU��O -------- */
    public static void capituloTxt02(){
        try{
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Ol�,jogador, tudo bem? O jogo � dividido em cap�tulos com cerca de duas a tr�s perguntas cada. " + "\n" +
                                "Ap�s o final do cap�tulo � a apresentado o lucro da empresa e sa�de mental" + "\n" +
                                 "de seu personagem, caso a sa�de ou o lucro seja igual a 0 � apresentado a mensagem de game over.");

            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("A empresa tem um gasto para se manter ent�o a cada troca de catipo voc� perde o valor de 8 mil reais.");

            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Tome cuidado com quem voc� fecha parcerias, nem todas empresas t�m interesses sinceros =(");


            //-------SOBRE A EMPRESA ---------//
            Thread.sleep(2400);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Sua empresa � voltada para �rea da tecnologia, focada em produ��o de softwares e tem como " +
                                "atividade secund�ria a produ��o de aparelhos eletr�nicos.");

            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("O funcion�rio � um amigo pr�ximo de sua m�e, o seu nome � Davi e ele vai te ajudar nessa primeira semana de introdu��o. " +
                                "\n" +
                                "Ele tem bastante tempo de empresa e foi praticamente um dos primeiros a serem contratados.");

            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Voc� chega na empresa e ao entrar todos est�o te olhando, o novo CEO � o foco das aten��es. O pr�dio � pequeno e tem cerca de trinta funcion�rios, " + "\n" +
                                "alguns te comprimentam de forma gentil e outras te olham com certo desd�m, como se n�o confiassem no seu potencial. Voc� est� empenhado nos estudos para " +"\n" +
                                "melhorar sua autoconfian�a e conhecimento." );

            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Ap�s uma semana aparentemente tranquila no comando da empresa voc� come�a a notar um certo movimento dos seus colaboradores. Devido a transi��o de CEO a " + "\n" +
                                "empresa aparenta estar bagun�ada. As divis�es de departamentos e cargos est�o fora de ordem e alguns funcion�rios se queixam de que est�o fazendo " + "\n" +
                                "fun��es desconexas das que foram de fato contratados para fazer.");

            Thread.sleep(2000);
            System.out.println(" ");
            System.out.println("O que deseja fazer?");

            resposta01();

        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu��o de um sleep.", e);
        }

    }

    /* -------- RESPOSTA -------- */
    public static void resposta01(){
        Scanner input = new Scanner(System.in);
        try{
            Thread.sleep(3500);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Analisar a empresa e realizar |");
            System.out.println("|   a divis�o de cargos e fun��es. |");
            System.out.println("|__________________________________|");
            Thread.sleep(3500);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Manter a empresa como est�.   |");
            System.out.println("|__________________________________|");
            Thread.sleep(3500);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| c) Realizar a divis�o sem nem um |");
            System.out.println("|   tipo de pesquisa ou fundamento.|");
            System.out.println("|__________________________________|");
            Thread.sleep(2500);
            System.out.println(" ");
            System.out.println("A sua resposta �: ");
            String resposta01 = input.next();
            validaResposta01(resposta01);

        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu��o de um sleep.", e);
        }
    }

    /* -------- VALIDA RESPOSTA 01 -------- */
    public static void validaResposta01(String resposta01) {
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("A divis�o de cargos foi um sucesso, os colaboradores est�o mais felizes, \n" +
                                        "focados e produtivos ap�s a mudan�a. ");
                    break;

                case "b":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("A empresa mant�m o mesmo formato, seus funcion�rios continuam meio confusos e perdidos. \n " +
                                        "A longo prazo isso pode prejudicar os lucros e funcionamento da empresa. ");
                    break;

                case "c":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("A empresa est� pior do que antes, dividir cargos e fun��es sem nenhum tipo de pesquisa \n" +
                                        "foi uma p�ssima ideia. Seus funcion�rios est�o mais perdidos do que antes, e isso afeta diretamente os lucros da empresa.");
                    break;
                default:
                    System.out.println("Op��o Inv�lida, escolha apenas entre a, b ou c\n >:(");
                    resposta01();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu��o de um sleep.", e);
        }
    }


    public static void capituloTxt02_2(){
        try{
            Thread.sleep(1200);
            System.out.println(" ");
            Thread.sleep(3500);
            System.out.println("Surge a oportunidade de uma parceria com uma empresa maior. Eles desejam dar suporte de forma financeira \n" +
                                "a produ��o de um software voltado para a organiza��o da rotina. Ajudando a arcar com os gastos de publica��o \n" +
                                "do aplicativo nas lojas digitais e cuidando de parte do marketing e divulga��o.");

            Thread.sleep(2000);
            System.out.println(" ");
            System.out.println("Deseja fechar essa parceria?");

            resposta02();

        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu��o de um sleep.", e);
        }

        }

    /* -------- RESPOSTA 02 -------- */
    public static void resposta02(){
        Scanner input = new Scanner(System.in);
        try{
            Thread.sleep(3500);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Recusar parceria.             |");
            System.out.println("|__________________________________|");
            Thread.sleep(3500);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Aceitar parceria.             |");
            System.out.println("|__________________________________|");
            Thread.sleep(3500);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| c) N�o dar resposta � empresa.   |");
            System.out.println("|__________________________________|");
            Thread.sleep(2500);
            System.out.println(" ");
            System.out.println("A sua resposta �: ");
            String resposta02 = input.next();
            validaResposta02(resposta02);

        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu��o de um sleep.", e);
        }
    }

    /* -------- VALIDA RESPOSTA 02 -------- */
    public static void validaResposta02(String resposta02) {
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta02){
                case "a":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("Voc� recusa a parceria e deseja seguir a ideia do software sem ajuda, os gastos s�o praticamente iguais aos lucros.\n");
                    break;

                case "b":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("A parceria deu certo e gerou lucros para ambos os lados permitindo futuras parcerias");
                    break;

                case "c":
                    Thread.sleep(2500);
                    System.out.println(" ");
                    System.out.println("N�o dar resposta a empresa foi uma escolha ruim, seu nome come�a ficar mal falado");
                    break;

                default:
                    System.out.println("Op��o Inv�lida, escolha apenas entre a, b ou c\n >:(");
                    resposta02();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu��o de um sleep.", e);
        }
    }


    public static void main(String[] args){
        menu();
        txtIntro();
        capitulo01();
        capituloTxt02();
        capituloTxt02_2();
    }
}