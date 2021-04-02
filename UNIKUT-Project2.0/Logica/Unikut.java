package Logica;

/**
 *
 * @author Lucas
 */
public class Unikut {

    private Conta[] Contas;
    private int indiceConta;

    public Unikut() {
        indiceConta = 0;
        Contas = new Conta[1000];

    }

    // Cria Conta
    public void criarConta(String login, String nickName, String password) {
        Contas[indiceConta] = new Conta(login, nickName, password);
        indiceConta++;

    }

    // Verifica se ja existe o login criado
    public boolean verificaLogin(String login) {
        boolean loginFound = false;
        for (int i = 0; i < indiceConta; i++) {
            if (login.equals(Contas[i].getLogin())) {
                loginFound = true;
                break;
            }
        }

        return loginFound;
    }

    // Verifica se a senha existe e se é a do login correspondente
    public boolean verificaSenha(String login, String senha) {
        Conta conta = this.pesquisarPessoas(login);
        if (conta != null) {
            return senha.equals(conta.getSenha());
        }
        return false;

    }

    // Pesquisa contas ja Cadastradas
    public Conta pesquisarPessoas(String login) {
        for (int i = 0; i <= indiceConta; i++) {
            if (login.equals(Contas[i].getLogin())) {
                return Contas[i];
            }
        }
        return null;
    }

    public void addAmigo(String login) {

    }

    // Editar Nome
    public void alterarContaNome(String login, String novoNome) {
        Conta conta = this.pesquisarPessoas(login);
        conta.setNome(novoNome);
    }

    // Editar Senha
    public void alterarContaSenha(String login, String novaSenha) {
        Conta conta = this.pesquisarPessoas(login);
        conta.setSenha(novaSenha);
    }

    // Exibir Contas e Dados
    public void exibir() {
        int i;
        for (i = 0; i < this.indiceConta; i++) {
            System.out.println("Usuaio: " + i + "\nDados do usuario:\n" + this.Contas[i]);
        }
    }
}
