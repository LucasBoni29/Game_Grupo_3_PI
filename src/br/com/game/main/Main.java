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
  :: Desenvolvedor : Lucas Boni dos Santos                      ::
  :: Data          : 01/12/2022                  Vers?o Java: 4 ::
  :: Altera??o     : Criado o restante da história do game.     ::
  ::               : SP-0010: Desenvolver o restante da história::
  ::               : do jogo e suas validações!                 ::
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
    /* Variáveis Globais */
    /* ==================*/

	/**
     * VARIÁVEL PARA ARMAZENAR O NOME DO JOGADOR
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
	static String nome = "";
    /**
     * VARIÁVEL PARA ARMAZENAR VIDA E DINHEIRO DO JOGADOR
     * @Índice 0 = VIDA
     * @Índice 1 = DINHEIRO
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    static int[] vidaDinheiro = {100, 20000};

    /**
     * VARIÁVEL PARA ARMAZENAR O TEMPO DAS FALAS
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    static int tempoDasFalas = 0;

    /**
     * VARIÁVEL USADA PARA VERIFICAÇÃO DO QUE FAZER COM A VIDA DO JOGADOR.
     * @Valor 0 = PADRÃO
     * @Valor 1 = ACRESCENTAR VIDA
     * @Valor 2 = DIMINUIR VIDA
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    static float statusVida = 0;
    /**
     * VARIÁVEL USADA PARA VERIFICAÇÃO DO QUE FAZER COM O DINHEIRO
     * @Valor 0 = PADRÃO
     * @Valor 1 = ACRESCENTAR DINHEIRO
     * @Valor 2 = DIMINUIR DINHEIRO
     * @Class {@link Main}
     * @author Lucas Boni
     * @author Gustavo Xavier
     */
    static float statusDinheiro = 0;

    /**
     * MÉTODO USADO PARA MOSTRAR O MENU DO JOGO.
     * @Opção 1 = NOVO JOGO
     * @Opção 2 = Carregar Jogo
     * @Opção 2 = CONFIGURAÇÕES
     * @Opção 3 = CRÉDITOS
     * @Opção 4 = SAIR
     * @Class {@link Main}
     * @author Lucas Boni.
     */
    public static void menu(){
        Scanner ler = new Scanner(System.in);
        List<String> menu = new ArrayList<>();

        menu.add("Novo Jogo");
        menu.add("Carregar Jogo (Beta)");
        menu.add("Instru??es");
        menu.add("Cr?ditos");
        menu.add("Sair");

        System.out.println("Bem vindo ao jogo do grupo 3\n" +
                "1 -> "+menu.get(0)+"\n" +
                "2 -> "+menu.get(1)+"\n" +
                "3 -> "+menu.get(2)+"\n" +
                "4 -> "+menu.get(3)+"\n" +
                "5 -> "+menu.get(4)+"\n" +
                "Escolha uma das op??es");
        String opcao = ler.next();
        validaOpcaoMenu(opcao);
    }

    /**
     * MÉTODO USADO PARA VALIDAR A OPÇÃO ESCOLHIDA DO MENU.
     * @Opção 1 = NOVO JOGO
     * @Opção 2 = Carregar Jogo
     * @Opção 2 = CONFIGURAÇÕES
     * @Opção 3 = CRÉDITOS
     * @Opção 4 = SAIR
     * @Class {@link Main}
     * @Opção 1
     * @author Lucas Boni.
     */
    public static void validaOpcaoMenu(String opcao){
        Scanner input = new Scanner(System.in);
        switch (opcao){
            case "1":
                novoJogo();
                break;
            case "2":
                System.err.println("Esta opção estará disponível na próxima atualização. Por favor, aguarde ansiosamente :)");
                menu();
                break;
            case "3":
            	System.out.println("O jogo ser? baseado em escolhas boas, neutras e ruins.\n"
            			+ "Voc? tamb?m ter? uma barra de vida e dinheiro.\n"
            			+ "Caso sua vida chegue a 0, ou o seu dinheiro seja insuficiante para manter a empresa, voc? perde.\n");
            	menu();
            	break;
            case "4":
            	System.out.println("================DESENVOLVEDORES================\n"
            			+ "Lucas Boni dos Santos\n"
            			+ "Gustavo Xavier\n"
            			+ "Ryan Nascimento\n"
            			+ "Matheus Terzi\n"
            			+ "================GESTOR================\n"
            			+ "Lucas Boni dos Santos\n");
            	menu();
            	break;
            case "5":
                sair();
                break;
            default:
                System.err.print("Por favor, escolha uma das op??es corretamente!\n");
                menu();
        }
    }

    /**
     * MÉTODO USADO PARA MOSTRAR O STATUS DO JOGADOR.
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
            throw new RuntimeException("Erro na execução de um sleep",e);
        }
    }

    /**
     * MÉTODO USADO PARA CALCULAR O STATUS DO JOGADOR.
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
            throw new RuntimeException("Erro na execução de um sleep", e);
        }
        return status;
    }

    /**
     * MÉTODO USADO VALIDAR SE A ESTOUROU OU NÃO.
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
     * MÉTODO USADO PARA VALIDAR O GAME OVER.
     * @Class {@link Main}
     * @param status VIDA E DINHEIRO
     * @author Lucas Boni
     * @author Gustavo Xavier.
     */
    public static void validaGameOver(int[] status){
            try {
                if (status[0] <= 0){
                    System.out.println("Sua vida chegou a 0. Você perdeu. Game Over!");
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
     * @Opção 1 = FÁCIL
     * @Opção 2 = NORMAL
     * @Opção 3 = DIFÍCIL
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
     * MÉTODO USADO PARA VERIFICAR O NÍVEL DE DIFICULDADE ESCOLHIDO.
     * @Valor 1 = FÁCIL
     * @Valor 2 = NORMAL
     * @Valor 3 = DIFÍCIL
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
                System.err.print("Por favor, escolha uma das opções corretamente!\n");
                dificuldade();
                break;
        }
    }

    /**
     * MÉTODO USADO PARA VERIFICAR SE QUER INICIAR O JOGO OU NÃO.
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void novoJogo(){
        Scanner input = new Scanner(System.in);
        String opcao = "";
        System.out.println("Nesta jornada você será resposável por controlar uma empresa herdada. Está preparado? (S ou N)");
        opcao = input.next();
        validaNovoJogo(opcao.toLowerCase());
    }

    /**
     * MÉTODO USADO PARA VALIDAR A RESPOSTA DO NOVO JOGO.
     * @Método novoJogo
     * @param opcao
     * @Valor s = Sim
     * @Valor n = Não
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
     * MÉTODO USADO PARA SAIR DO JOGO.
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void sair(){
        System.out.println("Espero que volte :?)");
        System.exit(0);
    }

    /**
     * MÉTODO USADO PARA IMPRIMIR A INTRO DO JOGO.
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
            Thread.sleep(tempoDasFalas);
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
            Thread.sleep(tempoDasFalas);
            System.out.println("Durante o mês passado você teve que cobrir o "
                    + "horário de outro funcionário, pois ele tinha ficado doente. "
                    + "Na hora de receber o seu salário a empresa falou que o\n"
                    + "?Sistema de Bater Ponto?? não mostrava as horas extras que "
                    + "você havia feito, e por isso não iam te pagar a mais.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
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
     * MÉTODO USADO PARA IMPRIMIR A INTRO 2 DO JOGO.
     * @Class {@link Main}
     * @author Gustavo Xavier.
     */
    public static void txtIntro02(){
        try{
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Com raiva da empresa e com medo da mesma situação "
                    + "acontecer novamente você tem as seguintes opções: ");
            System.out.println(" ");
            p1Intro();
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Você chega deprimido e decide dormir. No dia seguinte "
                    + "acorda com seu pai te chamando,falando que ?tem um advogado "
                    + "querendo falar com voc???.");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ele está sentado na cozinha explica que você é herdeiro "
                    + "direto da empresa da sua mãe, e que ela infelizmente "
                    + "morreu de covid...");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            Thread.sleep(tempoDasFalas);
            System.out.println("Essa notícia te deixa abalado, mas também te motiva a "
                    + "conseguir mudar a sua qualidade de vida e a do seu pai, deseja "
                    + "aceitar o desafio de comandar uma empresa ?");
            System.out.println(" ");
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execu??o de um sleep.", e);
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
     * MÉTODO USADO PARA VALIDAR A RESPOSTA DA PRIMEIRA PERGUNTA DA INTRO DO JOGO.
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
                            + "escuro você acaba ralando o carro em uma caçamba de lixo."
                            + " O seu supervisor vê a cena e avisa para o chefe.\nAo fim "
                            + "do expediente ele pede para que você passe no RH.");
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
                    System.out.println("\nSendo honesto você explica sua "
                            + "situação. Porém isso não ajuda muito, ele pede "
                            + "para que você passe no RH.");
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
     * MÉTODO USADO PARA IMPRIMIR A SEGUNDA PERGUNTA DA INTRO DO JOGO.
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
     * MÉTODO USADO PARA VALIDAR A RESPOSTA DA SEGUNDA PERGUNTA DA INTRO DO JOGO.
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

    public static void capitulo02(){
        try{
            System.out.println("==================\n" +
                    "CAP?TULO 2\n" +
                    "==================");
            Thread.sleep(tempoDasFalas);
            System.out.println("A semana se inicia com uma notícia ruim, seu gato Frederico está doente." +
                    "O tratamento é caro e devido à idade tem poucas chances de sobrevivência. ");
            Thread.sleep(tempoDasFalas);
            System.out.println("O que deseja fazer ?");
            Thread.sleep(tempoDasFalas);
            p1Capitulo02();
            Thread.sleep(tempoDasFalas);
            System.out.println("Depois de um tempo no comando da empresa você nota que seus funcionários estão ficando" +
                    " doentes com muita frequência, deseja pagar um convênio médico?");
            Thread.sleep(tempoDasFalas);
            p2Capitulo02();
            Thread.sleep(tempoDasFalas);
            System.out.println("Você sente que alguns dos seus funcionários não estão sendo tão efetivos como poderiam " +
                    "estar sendo, deseja pagar um curso para prepará-los melhor?");
            Thread.sleep(tempoDasFalas);
            p3Capitulo02();
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep.", e);
        }
    }

    public static void capitulo03(){
        try{
            System.out.println("==================\n" +
                    "CAP?TULO 3\n" +
                    "==================");
            Thread.sleep(tempoDasFalas);
            System.out.println("Você acorda e se arruma para ir para a empresa. Até o atual momento parece tudo bem. " +
                    "Após chegar você nota algo estranho. A secretaria relata que uma Van de transportadora deixou uma " +
                    "caixa para o Sr(a) "+nome+".");
            Thread.sleep(tempoDasFalas);
            System.out.println("Chegando em sua sala você observa uma embalagem bege de formato retangular em cima de " +
                    "sua mesa, aparentemente nada suspeito. Deseja abrir a embalagem?");
            Thread.sleep(tempoDasFalas);
            p1Capitulo03();
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep.", e);
        }
    }

    public static void capitulo04(){
        try{
            System.out.println("==================\n" +
                    "CAP?TULO 4\n" +
                    "==================");
            Thread.sleep(tempoDasFalas);
            System.out.println("No dia seguinte ao incidente da encomenda, um carro estaciona em frente a sua empresa. \n" +
                    "Dele desce um homem de cabelos brancos usando um terno caro.\n" +
                    "Com calma ele entra na empresa e fala com a recepcionista.\n" +
                    "Ele deseja falar com o "+nome+".");
            Thread.sleep(tempoDasFalas);
            System.out.println("Você o recepciona em sala e após olhar de perto você nota que conhece aquele homem. \n" +
                    "Ele era o dono da ExtraTec. A antiga empresa onde você trabalhava como manobrista.");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ele notifica que dentro da embalagem tem uma maleta com dinheiro e que caso você aceite " +
                    "a proposta que ele tem a fazer, essa não seria a última maleta que você receberia.");
            Thread.sleep(tempoDasFalas);
            System.out.println("O homem explica que viu algum dos seus produtos e acha que sua empresa pode prosperar, " +
                    "caso seja governada pelas mãos certas. Ele pede que você contrate três funcionários e entrega um " +
                    "envelope com os seus currículos. Fala que eles comandariam a empresa por debaixo dos panos, e que " +
                    "você seria um “laranja”. Manteria o cargo de CEO mas não teria mais nem um trabalho, a não ser " +
                    "fingir que ainda está no comando.");
            Thread.sleep(tempoDasFalas);
            System.out.println("De imediato você nota que isso é corrupção. Deseja aceitar a proposta do Homem?");
            Thread.sleep(tempoDasFalas);
            p1Capitulo04();
            Thread.sleep(tempoDasFalas);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep.", e);
        }
    }

    public static void capitulo05(){
        try{
            System.out.println("==================\n" +
                    "CAP?TULO 5\n" +
                    "==================\n");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ao ligar a televisão você vê uma notícia no jornal.\n");
            Thread.sleep(tempoDasFalas);
            System.out.println("Cinco empresas ligadas á ExtraTec foram processadas por corrupção.\n");
            Thread.sleep(tempoDasFalas);
            System.out.println("A multa desse processo foi milionária e nem uma das empresas tinha dinheiro suficiente " +
                    "para pagar e por isso todas foram à falência.\n");
            Thread.sleep(tempoDasFalas);
            System.out.println("Não aceitar o acordo corrupto foi a melhor coisa que você poderia ter feito.\n");
            Thread.sleep(tempoDasFalas);
            System.out.println("Caso contrário você seria a sexta empresa que viria a falir.\n");
            Thread.sleep(tempoDasFalas);
            System.out.println("Uma pesquisa está sendo feita para baratear o custo de uma assistente virtual, como por " +
                    "exemplo a Alexa. O projeto é promissor e promete trazer lucros no futuro. Deseja investir nesse projeto?\n");
            Thread.sleep(tempoDasFalas);
            p1Capitulo05();
            Thread.sleep(tempoDasFalas);
            System.out.println(" Feliz aniversário !\n");
            Thread.sleep(tempoDasFalas);
            System.out.println("A empresa está fazendo mais um ano de vida, os funcionários pedem uma celebração.\n" +
                    "Deseja fazer uma festa de aniversário da empresa ?");
            Thread.sleep(tempoDasFalas);
            p2Capitulo05();
            Thread.sleep(tempoDasFalas);
            System.out.println("Após um certo tempo como CEO você sente que está indo na direção correta, você já " +
                    "vivenciou diversas coisas no comando da “Hi Tec”");
            Thread.sleep(tempoDasFalas);
            System.out.println("Ao fim do dia você está sozinho na empresa. Decidiu ficar mais um pouco para admirar o " +
                    "local. Anda lentamente dentro da pequena empresa passando a mão nos móveis, olhando as plantas que " +
                    "fazem a decoração e pensando em seus funcionários. " +
                    "Você volta para sua sala e pega uma foto de sua mãe que está dentro da sua carteira. " +
                    "E se pergunta se ela estaria feliz com o seu desenho como CEO. ");
            Thread.sleep(tempoDasFalas);
            System.out.println("É dia quinze de dezembro e você sente que está chegando no fim de um ciclo, no fim de um ano. ");
            Thread.sleep(tempoDasFalas);
            System.out.println("No fim de um jogo…");
            Thread.sleep(tempoDasFalas);
            System.out.println("Devido a data estar próxima do fim do ano você decide dar férias para os seus funcionários.");
            Thread.sleep(tempoDasFalas);
            System.out.println("Uma semana após declarar férias você recebe um e-mail de um consultor, ele fala que " +
                    "todo final de ano essa passa para conferir como está o desempenho e lucro da empresa, ele marca " +
                    "uma visita para o dia seguinte. ");
            Thread.sleep(tempoDasFalas);
            System.out.println("No dia seguinte você chega mais cedo, limpa e organiza a pequena empresa. " +
                    "Você sente que está arrumada a casa para receber a visita de um parente para a celebração do natal " +
                    "ou final de ano.");
            Thread.sleep(tempoDasFalas);
            System.out.println("O consultor chega e se apresenta, você o leva para sua sala e vocês ficam conversando por horas e horas.");
            Thread.sleep(tempoDasFalas);
            mostrarStatus();
            validaFinalAlternativo(vidaDinheiro);
            Thread.sleep(tempoDasFalas);
            System.out.println("O consultor vai embora e você fica sozinho na empresa. Após a conversa com ele você começa " +
                    "a refletir sobre sua vida e sobre sua organização. Foi uma mudança radical e mesmo com pouco preparo você " +
                    "conseguiu chegar ao fim de um ciclo.");
            Thread.sleep(tempoDasFalas);
            System.out.println("É hora de descansar e aproveitar o fim de ano.");
            Thread.sleep(tempoDasFalas);
            System.out.println("O jogo só está começando.");
            Thread.sleep(tempoDasFalas);
            System.out.println("  _______");
            System.out.println(" | °___  |");
            System.out.println(" |       |");
            System.out.println(" | 23:59!|");
            System.out.println(" |       |");
            System.out.println(" |___°___|");
            Thread.sleep(tempoDasFalas);
            System.out.println("...");
            Thread.sleep(tempoDasFalas);
            System.out.println("...");
            Thread.sleep(tempoDasFalas);
            System.out.println("...");
            Thread.sleep(tempoDasFalas);
            System.out.println("  _______");
            System.out.println(" | ?___  |");
            System.out.println(" |       |");
            System.out.println(" | 00:00!|");
            System.out.println(" |       |");
            System.out.println(" |___°___|");
            Thread.sleep(tempoDasFalas);
            System.out.println("...");
            Thread.sleep(tempoDasFalas);
            System.out.println("...");
            Thread.sleep(tempoDasFalas);
            System.out.println("...");
            Thread.sleep(tempoDasFalas);
            System.out.println("  _______");
            System.out.println(" | ?___  |");
            System.out.println(" |       |");
            System.out.println(" | 05:30!|");
            System.out.println(" | Extra |");
            System.out.println(" |  Tec  |");
            System.out.println(" |___°___|");
            Thread.sleep(tempoDasFalas);
            System.out.println("Você ainda me pega!\n");
            Thread.sleep(tempoDasFalas);
            System.err.println("Continua...");
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep.", e);
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

    public static void p1Capitulo02(){
        Scanner input = new Scanner(System.in);
        try{
            mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Pagar o tratamento.           |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Não fazer nada.               |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" ___________________________________");
            System.out.println("|                                   |");
            System.out.println("| c) Tentar tratar por conta própria|");
            System.out.println("|___________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("A sua resposta ?: ");
            String resposta01 = input.next().toLowerCase();
            validaP1Capitulo02(resposta01);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
            mostrarStatus();
            validaGameOver(vidaDinheiro);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep!", e);
        }
    }

    public static void validaP1Capitulo02(String resposta01){
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("O tratamento dá certo e o gato se recupera da doença de forma impressionantemente" +
                            " rápida. Você se sente feliz de ter pago o tratamento. ");
                    statusVida = 1;
                    statusDinheiro = 1;
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Infelizmente o gato acaba morrendo, você se sente culpado de não ter feito nada.");
                    statusVida = 2;
                    break;

                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você tenta tratá-lo de forma caseira mas devido à falta de conhecimento você não" +
                            " consegue. O gato acaba morrendo.");
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p1Capitulo02();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }

    public static void p2Capitulo02(){
        Scanner input = new Scanner(System.in);
        try{
            mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Paga o convênio.              |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Não pagar o convênio.         |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" ___________________________________");
            System.out.println("|                                   |");
            System.out.println("| c) Trocar alguns departamentos    |");
            System.out.println("| para o estilo de 'home office'.   |");
            System.out.println("|___________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("A sua resposta ?: ");
            String resposta01 = input.next().toLowerCase();
            validaP2Capitulo02(resposta01);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
            mostrarStatus();
            validaGameOver(vidaDinheiro);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep!", e);
        }
    }

    public static void validaP2Capitulo02(String resposta01){
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Seus colaboradores começam a adoecer menos e se sentem mais valorizados. Isso " +
                            "vai ajudar no lucro futuro da empresa.");
                    statusVida = 1;
                    statusDinheiro = 2;
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Seus colaboradores começam a adoecer mais e isso afeta diretamente os lucros e " +
                            "moral da empresa.");
                    statusVida = 2;
                    statusDinheiro = 2;
                    break;
                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("No home office os funcionários começam a adoecer menos, porém isso não soluciona" +
                            " o problema, apenas minimiza.");
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p2Capitulo02();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }

    public static void p3Capitulo02(){
        Scanner input = new Scanner(System.in);
        try{
            mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Não pagar o curso.            |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Treinar apenas alguns         |");
            System.out.println("| colaboradores.                   |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" ___________________________________");
            System.out.println("|                                   |");
            System.out.println("| c) Pagar o curso.                 |");
            System.out.println("|___________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("A sua resposta ?: ");
            String resposta01 = input.next().toLowerCase();
            validaP3Capitulo02(resposta01);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
            mostrarStatus();
            validaGameOver(vidaDinheiro);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep!", e);
        }
    }

    public static void validaP3Capitulo02(String resposta01){
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Seus funcionários estão mais preparados do que antes, e mesmo tendo que gastar " +
                            "dinheiro com treinamento a empresa saiu no lucro.");
                    statusVida = 1;
                    statusDinheiro = 1;
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Devido a baixa efetividade dos funcionários a empresa perdeu parte de seus lucros.");
                    statusVida = 2;
                    statusDinheiro = 2;
                    break;
                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Treinar apenas alguns funcionários não trouxe um grande retorno. O gastos com " +
                            "treinamento foi praticamente igual ao lucro.");
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p3Capitulo02();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }

    public static void p1Capitulo03(){
        Scanner input = new Scanner(System.in);
        try{
            mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Abrir e olhar o conteúdo.     |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Não abrir.                    |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println("A sua resposta é: ");
            String resposta01 = input.next().toLowerCase();
            validaP1Capitulo03(resposta01);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
            mostrarStatus();
            validaGameOver(vidaDinheiro);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep!", e);
        }
    }

    public static void validaP1Capitulo03(String resposta01){
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Ao abrir você olha uma pequena maleta cinza embalada em plástico bolha, e aos " +
                            "poucos vai retirando ela de dentro do plástico, a maleta está meio pesada, provavelmente não está vazia.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você coloca a maleta ao lado da embalagem que agora está vazia…\n" +
                            "Se senta…\n" +
                            "E lentamente vai abrindo a maleta…\n");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Notas… muitas notas. Você retira uma cédula e passa a mão, logo depois a coloca " +
                            "contra a luz. Tudo parece certo, a nota é verdadeira.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Após retirar outras notas você nota um bilhete, ele é básico. Fundo branco com " +
                            "letra preta, e nele está escrito: \n" +
                            "Olá, "+nome+", tudo bem? Temos um grande interesse em sua" +
                            "empresa, amanhã vamos realizar uma pequena visita para conversar.");
                    vidaDinheiro[1] += 10000;
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você ignora a estranha embalagem e volta ao trabalho.");
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p1Capitulo03();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }

    public static void p1Capitulo04(){
        Scanner input = new Scanner(System.in);
        try{
            mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Aceitar a proposta.           |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Recusar a proposta e devolver |");
            System.out.println("| e devolver o dinheiro.           |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| c) Recusar a proposta e ficar    |");
            System.out.println("| com o dinheiro.                  |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println("A sua resposta é: ");
            String resposta01 = input.next().toLowerCase();
            validaP1Capitulo04(resposta01);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
            mostrarStatus();
            validaGameOver(vidaDinheiro);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep!", e);
        }
    }

    public static void validaP1Capitulo04(String resposta01){
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você aceita a proposta e assina um contrato de poucas páginas. Logo após isso " +
                            "contrata os três funcionários que foram solicitados no acordo.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Uma semana se passou e aparentemente tudo está bem.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("No final da segunda semana você recebe um e-mail falando que sua empresa está " +
                            "sendo processada por fazer parte de um golpe. Uma denuncia anônima foi feita contra a " +
                            "empresa com a qual você fechou o acordo e após investigações eles descobriram o esquema de " +
                            "corrupção deles. Como você assinou um contrato e colaborou com o golpe acabou virando um complice.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Sem dinheiro para pagar o processo milionário a sua empresa acabou falindo e fechando.\n");
                    vidaDinheiro[1] -= 60000;
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você acaba ficando bravo e expulsando o homem de sua sala, pede que ele leve sua " +
                            "maleta de dinheiro junto com ele e que nunca mais apareça em sua empresa.");
                    statusVida = 1;
                    statusDinheiro = 2;
                    break;
                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você ardilosamente ameaça ligar para a polícia e denunciar o homem por corrupção. " +
                            "Ele automaticamente entra em desespero e pede que você não faça isso, pergunta se tem " +
                            "alguma forma de contornar a situação.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você fala que vai ficar com o dinheiro da maleta e que ele deve sair de sua " +
                            "sala agora e não voltar mais. O homem parece meio bravo com a situação mas concorda.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Após o ocorrido você se sente meio culpado ficando com aquele dinheiro 'sujo' e " +
                            "não sabe dizer se foi uma escolha que valeu a pena ou não.");
                    statusVida = 2;
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p1Capitulo04();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }

    public static void p1Capitulo05(){
        Scanner input = new Scanner(System.in);
        try{
            mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Não investir no projeto.      |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Vender o projeto.             |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| c) Investir no projeto.          |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println("A sua resposta é: ");
            String resposta01 = input.next().toLowerCase();
            validaP1Capitulo05(resposta01);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
            mostrarStatus();
            validaGameOver(vidaDinheiro);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep!", e);
        }
    }

    public static void validaP1Capitulo05(String resposta01){
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("O projeto poderia ser um grande triunfo para sua empresa. Não investir foi um erro.");
                    statusVida = 2;
                    statusDinheiro = 2;
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você vende o projeto mas infelizmente o valor foi extremamente baixo. " +
                            "A empresa não obteve lucros.");
                    break;
                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Você decide investir no projeto, a ideia parece promissora, o projeto parece " +
                            "bom, tem tudo para dar certo.");
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Após finalizar o projeto e colocar a venda a empresa obtém lucros, a ideia de " +
                            "baratear uma assistente virtual deu certo.");
                    statusVida = 1;
                    statusDinheiro = 1;
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p1Capitulo04();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }

    public static void p2Capitulo05(){
        Scanner input = new Scanner(System.in);
        try{
            mostrarStatus();
            Thread.sleep(tempoDasFalas);
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| a) Fazer uma pequena celebração  |");
            System.out.println("| no horário de almoço.            |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Fazer uma festa e dar um      |");
            System.out.println("| 'day off' para os funcionários.  |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println(" ");
            System.out.println(" __________________________________");
            System.out.println("|                                  |");
            System.out.println("| b) Não realizar a festa.         |");
            System.out.println("|__________________________________|");
            Thread.sleep(tempoDasFalas);
            System.out.println("A sua resposta é: ");
            String resposta01 = input.next().toLowerCase();
            validaP2Capitulo05(resposta01);
            vidaDinheiro = calcularStatus(vidaDinheiro);
            vidaDinheiro = validaLimiteVida(vidaDinheiro);
            mostrarStatus();
            validaGameOver(vidaDinheiro);
        }catch(InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep!", e);
        }
    }

    public static void validaP2Capitulo05(String resposta01){
        Scanner input = new Scanner(System.in);
        try{
            switch (resposta01){
                case "a":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("A pequena celebração no horário de almoço serviu apenas para uma pequena " +
                            "distração, logo após comerem todos os colabores já voltaram para o trabalho. " +
                            "A empresa acaba gastando pouco dinheiro, e os funcionários já voltaram ao trabalho. " +
                            "Parece até um dia normal.");
                    break;
                case "b":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("A festa aconteceu. A empresa foi reorganizada de forma que tivesse mais espaço " +
                            "para a celebração. Foram comprados bebidas e comida. Todos estão contentes e se divertindo." +
                            "Foi um dia incrível e apesar de ter gastado bastante dinheiro você se sente contente de ter dado a festa.");
                    statusVida = 1;
                    statusDinheiro = 2;
                    break;
                case "c":
                    Thread.sleep(tempoDasFalas);
                    System.out.println(" ");
                    System.out.println("Os colaboradores estão frustrados, mesmo com o aniversário da empresa todos " +
                            "tiveram que trabalhar como se fosse um dia normal.");
                    statusVida = 2;
                    statusDinheiro = 1;
                    break;
                default:
                    System.out.println("Op??o Inv?lida, escolha apenas entre a, b ou c\n >:(");
                    p2Capitulo05();
            }
        }catch (InterruptedException e){
            throw new RuntimeException("Erroa na execu??o de um sleep.", e);
        }
    }

    public static void validaFinalAlternativo(int[] vidaEDinheiro){
        System.out.println("Qual o lucro atual de sua empresa Sr(a). "+nome);
        try{
            Thread.sleep(tempoDasFalas);
            if (vidaEDinheiro[1] <= 70000 && vidaEDinheiro[1] >= 40000){
                System.out.println("A sua empresa vai bem, os lucros estão ótimos. " +
                        "Você teve um bom crescimento de capital e se continuar assim tenho certeza que sua empresa vai " +
                        "transformar essa empresa em algo muito maior do que é hoje.");
            }
            Thread.sleep(tempoDasFalas);
            if (vidaEDinheiro[1] <= 39999 && vidaEDinheiro[1] >= 20000){
                System.out.println("A sua empresa está com um lucro mediano, você deve ficar alerta com suas escolhas e " +
                        "funcionários. Mantenha o foco no lucro e saúde da empresa se não terá problemas no futuro.");
            }
            Thread.sleep(tempoDasFalas);
            if (vidaEDinheiro[1] < 20000){
                System.out.println("“Os lucros da empresa vão muito mal, você corre o perigo de falir se continuar assim. " +
                        "Aconselho a renunciar ao cargo de CEO ou procurar um treinamento urgente. ");
            }
            Thread.sleep(tempoDasFalas);
            System.out.println("Sr(a). "+nome+", você está feliz?");
            Thread.sleep(tempoDasFalas);
            mostrarStatus();

            if (vidaEDinheiro[0] <= 100 && vidaEDinheiro[0] >= 70){
                System.out.println("Sim eu estou feliz, sinto que essa empresa faz parte da minha vida. Não me vejo " +
                        "fazendo outra coisa a não ser comandar essa organização.");
                Thread.sleep(tempoDasFalas);
                System.out.println("Isso é ótimo Sr(a) "+nome+". Fico contente em ouvir isso.");
            }
            Thread.sleep(tempoDasFalas);
            if (vidaEDinheiro[0] <= 69 && vidaEDinheiro[0] >= 40){
                System.out.println("Não muito. Não me sinto feliz, porém não me sinto triste. Ainda estou em dúvida se " +
                        "realmente devo ser o CEO desta empresa.");
                Thread.sleep(tempoDasFalas);
                System.out.println("Entendo Sr(a) "+nome+". É realmente uma tarefa difícil.");
            }
            Thread.sleep(tempoDasFalas);
            if (vidaEDinheiro[0] < 40){
                System.out.println("Eu não estou feliz, não me sinto pronto psicologicamente para ser o CEO desta empresa. " +
                        "Me sinto triste e pressionado(a)");
                Thread.sleep(tempoDasFalas);
                System.out.println("Lamento muito Sr(a). "+nome+". Me dói ouvir isso.");
            }
            Thread.sleep(tempoDasFalas);
        }catch (InterruptedException e){
            throw new RuntimeException("Erro na execução de um sleep!", e);
        }
    }

    /**
     * MÉTODO MAIN DO PROJETO. ELE QUE IRÁ RODAR O JOGO.
     * @param args RECEBE VALORES DA LINHA DE COMANDO NA HORA DE RODAR A APLICAÇÃO
     * @Class {@link Main}
     * @author Lucas Boni
     */
    public static void main(String[] args){
    	//Apare?a
        menu();
        txtIntro02();
        capitulo01();
        capitulo02();
        capitulo03();
        capitulo04();
        capitulo05();
    }
}