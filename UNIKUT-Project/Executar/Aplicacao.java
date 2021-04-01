package Executar;

import java.util.Scanner;
import Logica.*;

public class Aplicacao {

    /*
    * @author Lucas
     */
    public static void menuMain() {
        System.out.println("Seu Feed:\n");
        System.out.println("1 => Editar Perfil");
        System.out.println("2 => Ver Amigos");
        System.out.println("3 => Adicionar Amigos");
        System.out.println("4 => Enviar Recados");
        System.out.println("5 => para Sair");
        System.out.print("=>");
    }

    public static void menuStart() {
        System.out.println("Eh novo por aqui?");
        System.out.println("1 => Criar Nova Conta\n");

        System.out.println("Ja tem cadastro?");
        System.out.println("2 => Entrar na sua conta\n");

        System.out.println("Quer Nos Abandonar?");
        System.out.println("3 => para Sair");
        System.out.print("=>");
    }

    public static void main(String[] args) {
        Unikut social = new Unikut();

        Scanner s = new Scanner(System.in);
        String login, nickName, password, passwordConfirm;
        String loginStart, nickNameStart, passwordStart;

        loginStart = "Conta Mestra";
        nickNameStart = "Conta Mestra";
        passwordStart = "Conta Mestra";
        social.criarConta(loginStart, nickNameStart, passwordStart);

        System.out.println("Bem vindo ao UNIKUT!\n");

        menuStart();
        int opcao = s.nextInt();
        s.nextLine();
        while (opcao != 3) {
            switch (opcao) {
                case 1 -> {
                    //Criar Nova Conta
                    System.out.print("\nCriar Login: ");
                    login = s.nextLine();
                    // Verifica se o login ja existe
                    while (social.verificaLogin(login)) {
                        System.out.print("\nErro:\nLogin Ja Existente\nPor Favor criar outro Login: ");
                        login = s.nextLine();                        
                    }

                    System.out.print("Criar Apelido (Opcional): ");
                    nickName = s.nextLine();

                    System.out.print("\nCrie uma senha: ");
                    password = s.nextLine();

                    System.out.print("\nDigite a senha novamente: ");
                    passwordConfirm = s.nextLine();
                    // Varifica se as senhas estão iguais
                    while (!password.equals(passwordConfirm)) {
                        System.out.print("\nSuas senhas nao estao compativeis\nDigite novamente a senha: ");
                        password = s.next();
                        System.out.print("\nVerifique a senha: ");
                        passwordConfirm = s.next();
                    }
                    // Se Nao inserir o nome, o mesmo recebe "Convidado"
                    if (nickName.isEmpty() == true) {
                        nickName = "Convidado!";
                    }
                    System.out.println("\nBem Vindo Ao UNIKUT!");
                    System.out.println(nickName+"!");
                    System.out.println("Conta criada com sucesso...");

                    //Criando a conta com os atributos coletados
                    social.criarConta(login, nickName, password);
                    System.out.println("\nBem vindo " + login+"!");
                    menuMain();
                    int opcao2 = s.nextInt();
                    s.nextLine();
                    while (opcao2 != 5) {
                        switch (opcao2) {
                            case 1 -> { // Editar perfil

                            }
                            case 2 -> { // Exibir amigos

                            }
                            case 3 -> { // Adicionar amigos

                            }
                            case 4 -> { // Enviar recados

                            }
                            default ->
                                System.out.println("\nComando inválido");
                        }

                        System.out.println("\nBem vindo " + login+"!");
                        menuMain();
                        opcao2 = s.nextInt();
                        s.nextLine();
                    }
                }
                case 2 -> {
                    //Login
                    System.out.print("\nLogin: ");
                    login = s.nextLine();
                    while (!social.verificaLogin(login)) {
                        System.out.print("\nErro:\nLogin Não Existente\nPor Favor usar outro Login: ");
                        login = s.nextLine();
                    }
                    System.out.print("Senha: ");
                    password = s.nextLine();
                    while (!social.verificaSenha(login, password)) {
                        System.out.print("\nErro:\nSenha Incorreta\n\nPor Favor tente novamente: ");
                        password = s.nextLine();
                    }
                    System.out.println("\nBem vindo " + login+"!");
                    menuMain();
                    int opcao2 = s.nextInt();
                    s.nextLine();
                    while (opcao2 != 5) {
                        switch (opcao2) {
                            case 1 -> { // Editar perfil

                            }
                            case 2 -> { // Exibir amigos

                            }
                            case 3 -> { // Adicionar amigos

                            }
                            case 4 -> { // Enviar recados

                            }
                            default ->
                                System.out.println("\nComando inválido");
                        }

                        System.out.println("\nBem vindo " + login+"!");
                        menuMain();
                        opcao2 = s.nextInt();
                        s.nextLine();
                    }
                }
                default ->
                    System.out.println("\nComando inválido");

            }

            System.out.println("\nCerto...\n");
            menuStart();
            opcao = s.nextInt();
            s.nextLine();
        }
        System.out.println("Adeus :( ");
    }

}
