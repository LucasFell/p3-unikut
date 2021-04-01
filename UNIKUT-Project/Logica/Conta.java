package Logica;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */

public class Conta implements Comparable <Conta>{

    private String login;
    private String nome;
    private String senha;
   

    public Conta(String login, String nome, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;      

    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }


    public String toString() {
        return "O Login: " + this.login + "\nUsuario: " + this.nome + "\nSenha: " + this.senha;
    }

    public void alterarConta() {
        Scanner in = new Scanner(System.in);
        int escolha;
        System.out.println("Escolha uma das opcoes");
        System.out.println("1-Editar nome");
        System.out.println("2-Editar senha");
        System.out.println("0-Sair");
        escolha = in.nextInt();
        String antigoNome, novoNome, antigaSenha, novaSenha;
        switch (escolha) {
            case 1:
                antigoNome = this.nome;//nome antigo
                System.out.println("Digite o novo nome: ");
                novoNome = in.nextLine();
                setNome(novoNome);//nome novo
                break;

            case 2:
                antigaSenha = this.senha;
                System.out.println("Digite a nova senha: ");
                novaSenha = in.nextLine();
                setSenha(novaSenha);
                break;

            case 0:
                System.out.println("Você saiu do metodo alterar");
                break;

            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
    @Override
    public int compareTo(Conta C) {//comparacao de login.
        return this.login.compareTo(C.login);
    }
}
