/*::============================================================::
  :: Institui??o   : Senac - SP                                 ::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data:         : 31/10/2022                                 ::
  :: Projeto       : Jogo da aula de P.I                        ::
  ::============================================================::
  :: Desenvolvedor :                                            ::
  :: Data          :                             Vers?o Java:   ::
  :: Altera??o     :                                            ::
  ::============================================================::
  :: Desenvolvedor : Ryan Morais Do Nascimento                  ::
  :: Data          : 15/11/2022                  Vers?o Java: 3 ::
  :: Altera??o     : Criei a primeira historia do jovo e sua    ::
  ::               : valida??o.                                 ::
  ::============================================================::
  :: Desenvolvedor : Ryan Morais Do Nascimento                  ::
  :: Data          : 03/11/2022                  Vers?o Java: 2 ::
  :: Altera??o     : Criei o menu de dificuldade e a valida??o  ::
  ::============================================================::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data          : 05/11/2022                  Vers?o Java: 2 ::
  :: Altera??o     : Ajustado algumas fun??es da hist?ria e     ::
  ::               : adicionado algumas novas valida??es.       ::
  ::               : SP-0006 - Ajustar fun??es do Xavier e criar::
  ::               : novas para validar as respostas.           ::
  ::============================================================::
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data          : 31/10/2022                  Vers?o Java: 1 ::
  :: Altera??o     : Primeira vers?o                            ::
  ::============================================================::*/

package br.com.game.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class Main {
    /* ==================*/
    /* Vari�veis Globais */
    /* ==================*/

	/**
     * VARI�VEL PARA ARMAZENAR O NOME DO JOGADOR
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
	static String nome = "";
    /**
     * VARI�VEL PARA ARMAZENAR VIDA E DINHEIRO DO JOGADOR
     * @�ndice 0 = VIDA
     * @�ndice 1 = DINHEIRO
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    static int[] vidaDinheiro = {100, 200};

    /**
     * VARI�VEL PARA ARMAZENAR O TEMPO DAS FALAS
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    static int tempoDasFalas = 0;

    /**
     * VARI�VEL USADA PARA VERIFICA��O DO QUE FAZER COM A VIDA DO JOGADOR.
     * @Valor 0 = PADR�O
     * @Valor 1 = ACRESCENTAR VIDA
     * @Valor 2 = DIMINUIR VIDA
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    static float statusVida = 0;
    /**
     * VARI�VEL USADA PARA VERIFICA��O DO QUE FAZER COM O DINHEIRO
     * @Valor 0 = PADR�O
     * @Valor 1 = ACRESCENTAR DINHEIRO
     * @Valor 2 = DIMINUIR DINHEIRO
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    static float statusDinheiro = 0;

    /**
     * M�TODO USADO PARA MOSTRAR O MENU DO JOGO.
     * @Op��o 1 = NOVO JOGO
     * @Op��o 2 = CONFIGURA��ES
     * @Op��o 3 = CR�DITOS
     * @Op��o 4 = SAIR
     * @Class {@link Main}
     * @author Lucas Boni.
     */
    public static void menu(){
        Scanner ler = new Scanner(System.in);
        List<String> menu = new ArrayList<>();

        menu.add("Novo Jogo");
        menu.add("Carregar Jogo");
        menu.add("Instru??es");
        menu.add("Cr?ditos");
        menu.add("Sair");

        System.out.println("Bem vindo ao jogo do grupo 3\n" +
                "1 -> "+menu.get(0)+"\n" +
                "2 -> "+menu.get(1)+"\n" +
                "3 -> "+menu.get(2)+"\n" +
                "4 -> "+menu.get(3)+"\n" +
                "Escolha uma das op??es");
        String opcao = ler.next();
        validaOpcaoMenu(opcao);
    }

    /**
     * M�TODO USADO PARA VALIDAR A OP��O ESCOLHIDA DO MENU.
     * @Op��o 1 = NOVO JOGO
     * @Op��o 2 = CONFIGURA��ES
     * @Op��o 3 = CR�DITOS
     * @Op��o 4 = SAIR
     * @Class {@link Main}
     * @Op��o 1
     * @author Lucas Boni.
     */
    public static void validaOpcaoMenu(String opcao){
        switch (opcao){
            case "1":
                novoJogo();
                break;
            case "2":
            	System.out.println("O jogo ser? baseado em escolhas boas, neutras e ruins.\n"
            			+ "Voc? tamb?m ter? uma barra de vida e dinheiro.\n"
            			+ "Caso sua vida chegue a 0, ou o seu dinheiro seja insuficiante para manter a empresa, voc? perde.\n");
            	menu();
            	break;
            case "3":
            	System.out.println("================DESENVOLVEDORES================\n"
            			+ "Lucas Boni dos Santos\n"
            			+ "Gustavo Xavier\n"
            			+ "Ryan Nascimento\n"
            			+ "Matheus Terzi\n"
            			+ "================GESTOR================\n"
            			+ "Lucas Boni dos Santos\n");
            	menu();
            	break;
            case "4":
                sair();
                break;
            default:
                System.err.print("Por favor, escolha uma das op??es corretamente!\n");
                menu();
        }
    }

    /**
     * M�TODO USADO PARA MOSTRAR O STATUS DO JOGADOR.
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier.
     */
    public static void mostrarStatus(){
        try {
        	String[] hpDinheiro = {"HP", "R$"};
        	int contador = 0;

            System.out.println("==================\n" +
                    "MOSTRANDO STATUS\n" +
                    "==================");
            System.out.println("");
            Thread.sleep(tempoDasFalas);

            for(int status : vidaDinheiro) {
            	System.out.println("===============\n"
            +hpDinheiro[contador]+": "+status+"\n" +
                        "===============");
            	contador++;
            }

        } catch (InterruptedException e) {
            throw new RuntimeException("Erro na execu��o de um sleep",e);
        }
    }

    /**
     * M�TODO USADO PARA CALCULAR O STATUS DO JOGADOR.
     * @Class {@link Main}
     * @param status VIDA E DINHEIRO
     * @author Lucas Boni
     * @author Gustavo Xavier.
     */
    public static int[] calcularStatus(int[] status){
        Random dano =  new Random();
        try {
            if (statusVida == 1 && statusDinheiro == 2){
                status[0] += dano.nextInt(20) + 10;
                status[1] -= dano.nextInt(7000)+ tempoDasFalas;
                statusVida = 0;
                statusDinheiro = 0;
                return status;
            } else if (statusVida == 2 && statusDinheiro == 1) {
                status[0] -= dano.nextInt(20) + 10;
                status[1] += dano.nextInt(7000)+ tempoDasFalas;
                statusVida = 0;
                statusDinheiro = 0;
                return status;
            } else if (statusVida == 1 && statusDinheiro == 1) {
                status[0] += dano.nextInt(20) + 10;
                status[1] += dano.nextInt(7000)+ tempoDasFalas;
                statusVida = 0;
                statusDinheiro = 0;
                return status;
            }
            status[0] -= dano.nextInt(20) + 10;
            status[1] -= dano.nextInt(7000)+ tempoDasFalas;
            statusVida = 0;
            statusDinheiro = 0;
            System.out.println("==================\n" +
                    "CALCULANDO STATUS\n" +
                    "==================");
            System.out.println("");
            Thread.sleep(tempoDasFalas);
        } catch (InterruptedException e) {
            throw new RuntimeException("Erro na execu��o de um sleep", e);
        }
        return status;
    }

    /**
     * M�TODO USADO VALIDAR SE A ESTOUROU OU N�O.
     * @Class {@link Main}
     * @param status VIDA E DINHEIRO
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    public static int[] validaLimiteVida(int[] status){
        if (status[0] > 100){
            status[0] = 100;
            return status;
        } else if (status[0] < 0) {
        	status[0] = 0;
        	return status;
        }
        return status;
    }

    /**
     * M�TODO USADO PARA VALIDAR O GAME OVER.
     * @Class {@link Main}
     * @param status VIDA E DINHEIRO
     * @author Lucas Boni
     * @author Gustavo Xavier.
     */
    public static void validaGameOver(int[] status){
            try {
                if (status[0] <= 0){
                    System.out.println("Sua vida chegou a 0. Voc� perdeu. Game Over!");
                    System.exit(0);
                } else if (status[1] <= 0) {
                    System.out.println("Seu dinheiro chegou a "+status[1]+". Voc� perdeu.");
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
     * MENU DOS N�VEIS DE DIFICULDADE
     * @Op��o 1 = F�CIL
     * @Op��o 2 = NORMAL
     * @Op��o 3 = DIF�CIL
     * @Class {@link Main}
     * @author Ryan Nascimento
     */
    public static void dificuldade(){
        Scanner input = new Scanner(System.in);
        List<String> dificuldades = new ArrayList<>();

        dificuldades.add("F?cil");
        dificuldades.add("Normal");
        dificuldades.add("Dif?cil");

        System.out.println("Qual n?vel deseja jogar?\n" +
                "1 -> "+dificuldades.get(0)+"\n" +
                "2 -> "+dificuldades.get(1)+"\n" +
                "3 -> "+dificuldades.get(2)+"\n" +
                "Escolha uma das op??es");
        int nivel = input.nextInt();
        validarDificuldade(nivel);
    }

    /**
     * M�TODO USADO PARA VERIFICAR O N�VEL DE DIFICULDADE ESCOLHIDO.
     * @Valor 1 = F�CIL
     * @Valor 2 = NORMAL
     * @Valor 3 = DIF�CIL
     * @Class {@link Main}
     * @param nivel
     * @author Ryan Nascimento
     */
    public static void validarDificuldade(int nivel){
        switch (nivel){
            case 1:
                txtIntro01();
                break;
            case 2:
                txtIntro01();
                break;
            case 3:
                txtIntro01();
                break;
            default:
                System.err.print("Por favor, escolha uma das op��es corretamente!\n");
                dificuldade();
                break;
        }
    }

    /**
     * M�TODO USADO PARA VERIFICAR SE QUER INICIAR O JOGO OU N�O.
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void novoJogo(){
        Scanner ler = new Scanner(System.in);
        String opcao = "Nesta jornada voc� ser� respos�vel por controlar uma empresa herdada. Est� preparado? (S ou N)";
        System.out.println(opcao);
        opcao = ler.next();
        validaNovoJogo(opcao.toLowerCase());
    }

    /**
     * M�TODO USADO PARA VALIDAR A RESPOSTA DO NOVO JOGO.
     * @M�todo novoJogo
     * @param opcao
     * @Valor s = Sim
     * @Valor n = N�o
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void validaNovoJogo(String opcao){
        switch (opcao){
            case "s":
                System.out.println("......");
                dificuldade();
                break;
            case "n":
                menu();
                break;
            default:
                System.out.println("Digite somente S ou N. Por favor tente novamente.");
                novoJogo();
        }
    }

    /**
     * M�TODO USADO PARA SAIR DO JOGO.
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void sair(){
        System.out.println("Espero que volte :?)");
        System.exit(0);
    }

    /**
     * M�TODO USADO PARA IMPRIMIR A INTRO DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void txtIntro01(){
        try {
            Thread.sleep(tempoDasFalas);
            System.out.println("  _______");
            System.out.println(" | ?___  |");
            System.out.println(" |       |");
            System.out.println(" | 05:30!|");
            System.out.println(" |       |");
            System.out.println(" |___�___|");
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
            System.out.println("Voc� acorda com o barulho do alarme do seu  "
                    + "celular, estica o bra�o para deslig�-lo e com os olhos "
                    + "serrilhados de sono tenta ver as horas?");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("S�o exatamente 5:30 da manh� e chegou a hora de "
                    + "levantar para trabalhar!");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ainda com sono, voc� desliga o alarme. Ao tentar "
                    + "se sentar na cama sente algumas dores e extrema indisposi��o."
                    + " Seu corpo pesa como se algu�m \nestivesse te segurando, "
                    + "sua cabe�a d�i e lateja, seus olhos ardem e sua mente ainda"
                    + " est� confusa. ");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Infelizmente n�o � ressaca. O motivo disso foi sua"
                    + " jornada de trabalho exaustiva?");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ap�s quatro minutos de uma dura luta com a sua "
                    + "cama, sono e indisposi��o voc� consegue se levantar e ir "
                    + "ao banheiro.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Voc� acende a luz e se olha no espelho, observa "
                    + "que est� com um semblante cansado e olhos levemente vermelhos"
                    + " com olheiras.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Olhando para si mesmo  lembra do filme "
                    + "?eu sou a lenda??, que assistiu no fim de semana passado. "
                    + "Infelizmente, voc� n�o � o Will Smith\ne muito menos um pastor"
                    + " alem�o, voc� se sente como um zumbi. ");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Seu apartamento � apertado, voc� vive com seu pai e"
                    + " seu gato chamado Frederico. Sua m�e deixou a casa ap�s abrir uma empresa. ");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("J? fazem cinco anos, mas voc? se lembra da cena "
                    + "como se fosse ontem. A imagem de sua m?e com uma pequena mala"
                    + " de roupas debaixo dos bra?os,\ndiscutindo e gritando com seu"
                    + " pai enquanto andava em dire??o a estreita porta do "
                    + "apartamento. ");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ela sofria de Burnout e acabava descontado isso"
                    + "dentro de casa. Ela raramente descansava,e se tornou obcecada"
                    + " e cega por seu trabalho, vivia falando que isso era\n?para o "
                    + "bem de todos e queria nos dar uma vida digna e melhor??,"
                    + "por?m isso n?o aconteceu, ap?s diversas brigas ela decidiu "
                    + "sair de casa e cortou total contato.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Desde ent�o voc�s n�o se falaram, voc� n�o tem "
                    + "mais noticias, n�o sabe se ela est� bem, n�o sabe sequer se "
                    + "est� viva. \nNem tudo s�o flores, mas nem tudo s�o espinhos "
                    + "tamb�m?");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Voc� prepara seu caf� da manh� e ap�s com�-lo e "
                    + "volta para o quarto para se arrumar, por�m a ideia de deitar "
                    + "e dormir � tentadora.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Durante o m�s passado voc� teve que cobrir o "
                    + "hor�rio de outro funcion�rio, pois ele tinha ficado doente. "
                    + "Na hora de receber o seu sal�rio a empresa falou que o\n"
                    + "?Sistema de Bater Ponto?? n�o mostrava as horas extras que "
                    + "voc� havia feito, e por isso n�o iam te pagar a mais.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ontem esse mesmo funcion�rio foi demitido e por "
                    + "falta de pessoas voc� teve que trabalhar at� mais tarde "
                    + "novamente, e com isso \nvoc� chegou em casa por volta da 1:30 da  manh�.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * M�TODO USADO PARA IMPRIMIR O CAP�TULO 1 DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void txtIntro02(){
        try{
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Com raiva da empresa e com medo da mesma situa��o "
                    + "acontecer novamente voc� tem as seguintes op��es: ");
            System.out.println(" ");
            p1Intro();
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Voc� chega deprimido e decide dormir. No dia seguinte "
                    + "acorda com seu pai te chamando,falando que ?tem um advogado "
                    + "querendo falar com voc???.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ele est� sentado na cozinha explica que voc� � herdeiro "
                    + "direto da empresa da sua m�e, e que ela infelizmente "
                    + "morreu de covid...");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Essa not�cia te deixa abalado, mas tamb�m te motiva a "
                    + "conseguir mudar a sua qualidade de vida e a do seu pai, deseja "
                    + "aceitar o desafio de comandar uma empresa ?");
            System.out.println(" ");
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu??o de um sleep.", e);
        }
        p2Intro();
    }

    /**
     * M�TODO USADO PARA IMPRIMIR A PRIMEIRA PERGUNTA DA INTRO DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void p1Intro(){
        Scanner input = new Scanner(System.in);
        try {
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
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("A sua Respota ?: ");
            String rP1 = input.next();
            validaP1Intro(rP1.toLowerCase());
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execu??o de um sleep.", e);
        }
    }

    /**
     * M�TODO USADO PARA VALIDAR A RESPOSTA DA PRIMEIRA PERGUNTA DA INTRO DO JOGO.
     * @Method: p1Intro
     * @param rP1
     * @Class: {@link Main}
     * @author Gustavo Xavier.
     */
    public static void validaP1Intro(String rP1) {
        try{
            switch (rP1) {
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Chegando no trabalho foram dados diversos carros"
                            + " para voc? estacionar, o sono e cansa?o est?o te "
                            + "atrapalhando de forma severa, ap?s quatro copos de caf?\n"
                            + "e levar o rosto v?rias vezes voc? ainda se sente casado.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("\nPerto do fim do expediente chega o ?ltimo carro do "
                            + "dia. ? um carro de passeio todo preto e dele desce um"
                            + "homem,\nele est? meio apresentado, joga as chaves na "
                            + "sua m?o e entra correndo para dentro da empresa.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("\nA maioria das vagas est?o ocupadas, ent?o voc? tem que ir para o estacionamento"
                            + "dos fundos da empresa.\nDirigindo com sono em lugar "
                            + "escuro voc� acaba ralando o carro em uma ca�amba de lixo."
                            + " O seu supervisor v� a cena e avisa para o chefe.\nAo fim "
                            + "do expediente ele pede para que voc� passe no RH.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Voc?...");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Est?...");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Demitido!");
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Ap?s acordar do seu cochilo voc? pega seu "
                            + "celular e se depara com o seguinte cen?rio"
                            + " ?2 liga??es perdidas e 7 mensagens n?o lidas??.\n"
                            + "Seu chefe est? furioso, pois n?o tinha ningu?m para "
                            + "estacionar os carros.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Voc?...");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Est?...");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Demitido!");
                    break;
                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("\nVoc? cehga atrasado no trabalho e foram dados diversos carros"
                            + " para voc? estacionar. Perto do fim do expediente ? dado o "
                            + "?ltimo carro do dia.\n? um carro de passeio todo preto"
                            + " e dele desce um homem, ele est? meio apresentado, "
                            + "joga as chaves na sua m?o e entra correndo para "
                            + "dentro da empresa.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("\nA maioria das vagas est?o ocupadas, "
                            + "ent?o voc? tem que ir para o estacionamento dos "
                            + "fundos da empresa.\nVoc? guarda o carro na vaga e "
                            + "volta para onde estava antes." + " Seu supervisor n?o "
                            + "parece estar muito feliz, ele pergunta o motivo de "
                            + "seu atraso hoje.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("\nSendo honesto voc� explica sua "
                            + "situa��o. Por�m isso n�o ajuda muito, ele pede "
                            + "para que voc� passe no RH.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Voc?...");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Est?...");
                    Thread.sleep(tempoDasFalas);
                    System.out.println("Demitido!");
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p1Intro();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu??o de um sleep.", e);
        }
    }

    /**
     * M�TODO USADO PARA IMPRIMIR A SEGUNDA PERGUNTA DA INTRO DO JOGO.
     * @Class: {@link Main}
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
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("A sua Respota ?: ");
            String rP2 = input.next();
            validaP2Intro(rP2);
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu??o de um sleep.", e);
        }
    }

    /**
     * M�TODO USADO PARA VALIDAR A RESPOSTA DA SEGUNDA PERGUNTA DA INTRO DO JOGO.
     * @Method: p2Intro
     * @Class: {@link Main}
     * @param rP2
     * @author Gustavo Xavier.
     */
    public static void validaP2Intro(String rP2) {
        Scanner input = new Scanner(System.in);
        try{
            switch (rP2){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Ele te entrega um contrato e pede para que voc? assine com seu nome. Qual o seu nome? ");
                    nome = input.next();
                    System.out.println("Ap?s isso ele passa o contato de um importante funcion?rio e amigo de sua m?e e fala que ele j? tem um grande conhecimento da empresa e pode te ajudar. ");
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Voc? decide n?o aceitar comandar a empresa,"
                            + "e decide vend?-la, com esse dinheiro voc? consegue ajudar"
                            + "seu pai em casa.\nPouco tempo depois voc? consegue"
                            + "arrumar um novo emprego como entregador de encomendas.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Que pena que voc? n?o aceitou o desafio. Fim de jogo.");
                    System.exit(0);
                    break;
                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Voc? rasga o contrato com raiva, o advogado "
                            + "te encara meio confuso por?m n?o nem uma pergunta, "
                            + "apenas se levanta e sai.\nPouco tempo depois voc? "
                            + "consegue arrumar um novo emprego como entregador de encomendas. ");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Que pena que voc? n?o aceitou o desafio. Fim de jogo.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p2Intro();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }


    /* --------iNTRODU??O -------- */
    public static void capitulo01(){
        try{
        	System.out.println("==================\n" +
                    "CAP?TULO 1\n" +
                    "==================");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ol?,"+nome+", tudo bem? O jogo ? dividido em cap?tulos com cerca de duas a tr?s perguntas cada. " + "\n" +
                                "Ap?s o final do cap?tulo ? a apresentado o lucro da empresa e sa?de mental" + "\n" +
                                 "de seu personagem, caso a sa?de ou o lucro seja igual a 0 ? apresentado a mensagem de game over.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("A empresa tem um gasto para se manter ent?o a cada troca de catipo voc? perde o valor de 8 mil reais.");

            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Tome cuidado com quem voc? fecha parcerias, nem todas empresas t?m interesses sinceros =(");


            //-------SOBRE A EMPRESA ---------//
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Sua empresa ? voltada para ?rea da tecnologia, focada em produ??o de softwares e tem como " +
                                "atividade secund?ria a produ??o de aparelhos eletr?nicos.");

            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("O funcion?rio ? um amigo pr?ximo de sua m?e, o seu nome ? Davi e ele vai te ajudar nessa primeira semana de introdu??o. " +
                                "\n" +
                                "Ele tem bastante tempo de empresa e foi praticamente um dos primeiros a serem contratados.");

            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Voc? chega na empresa e ao entrar todos est?o te olhando, o novo CEO ? o foco das aten??es. O pr?dio ? pequeno e tem cerca de trinta funcion?rios, " + "\n" +
                                "alguns te comprimentam de forma gentil e outras te olham com certo desd?m, como se n?o confiassem no seu potencial. Voc? est? empenhado nos estudos para " +"\n" +
                                "melhorar sua autoconfian?a e conhecimento." );

            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ap?s uma semana aparentemente tranquila no comando da empresa voc? come?a a notar um certo movimento dos seus colaboradores. Devido a transi??o de CEO a " + "\n" +
                                "empresa aparenta estar bagun?ada. As divis?es de departamentos e cargos est?o fora de ordem e alguns funcion?rios se queixam de que est?o fazendo " + "\n" +
                                "fun??es desconexas das que foram de fato contratados para fazer.");

            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("O que deseja fazer?");
            p1Captitulo01();
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Surge a oportunidade de uma parceria com uma empresa maior. Eles desejam dar suporte de forma financeira \n" +
                                "a produ??o de um software voltado para a organiza??o da rotina. Ajudando a arcar com os gastos de publica??o \n" +
                                "do aplicativo nas lojas digitais e cuidando de parte do marketing e divulga??o.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("Deseja fechar essa parceria?");
            p2Capitulo01();

        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu??o de um sleep.", e);
        }

    }

    /* -------- RESPOSTA -------- */
    public static void p1Captitulo01(){
        Scanner input = new Scanner(System.in);
        try{
        	mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Analisar a empresa e realizar |");
            System.out.println("|   a divis?o de cargos e fun??es. |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Manter a empresa como est?.   |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| c) Realizar a divis?o sem nem um |");
            System.out.println("|   tipo de pesquisa ou fundamento.|");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("A sua resposta ?: ");
            String resposta01 = input.next().toLowerCase();
            validaP1Capitulo01(resposta01);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
		    mostrarStatus();
		    validaGameOver(vidaDinheiro);

        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu??o de um sleep.", e);
        }
    }

    /* -------- VALIDA RESPOSTA 01 -------- */
    public static void validaP1Capitulo01(String resposta01) {
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("A divis?o de cargos foi um sucesso, os colaboradores est?o mais felizes, \n" +
                                        "focados e produtivos ap?s a mudan?a. ");
                    statusVida = 1;
                    statusDinheiro = 1;
                    break;

                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("A empresa mant?m o mesmo formato, seus funcion?rios continuam meio confusos e perdidos. \n " +
                                        "A longo prazo isso pode prejudicar os lucros e funcionamento da empresa. ");
                    break;

                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("A empresa est? pior do que antes, dividir cargos e fun??es sem nenhum tipo de pesquisa \n" +
                                        "foi uma p?ssima ideia. Seus funcion?rios est?o mais perdidos do que antes, e isso afeta diretamente os lucros da empresa.");
                    statusVida = 2;
                    statusDinheiro = 2;
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p1Captitulo01();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }


    /* -------- RESPOSTA 02 -------- */
    public static void p2Capitulo01(){
        Scanner input = new Scanner(System.in);
        try{
        	mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Recusar parceria.             |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Aceitar parceria.             |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| c) N?o dar resposta ? empresa.   |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("A sua resposta ?: ");
            String resposta02 = input.next();
            validaP2Capitulo01(resposta02);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
		    mostrarStatus();
		    validaGameOver(vidaDinheiro);

        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu??o de um sleep.", e);
        }
    }

    /* -------- VALIDA RESPOSTA 02 -------- */
    public static void validaP2Capitulo01(String resposta02) {
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta02){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Voc? recusa a parceria e deseja seguir a ideia do software sem ajuda, os gastos s?o praticamente iguais aos lucros.\n");
                    break;

                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("A parceria deu certo e gerou lucros para ambos os lados permitindo futuras parcerias");
                    statusVida = 1;
                    statusDinheiro = 1;
                    break;

                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("N?o dar resposta a empresa foi uma escolha ruim, seu nome come?a ficar mal falado");
                    statusVida = 2;
                    statusDinheiro = 2;
                    break;

                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p2Capitulo01();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }

    /**
     * M�TODO MAIN DO PROJETO. ELE QUE IR� RODAR O JOGO.
     * @param args RECEBE VALORES DA LINHA DE COMANDO NA HORA DE RODAR A APLICA��O
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void main(String[] args){
    	//Apare?a
        menu();
        txtIntro02();
        capitulo01();
    }
}