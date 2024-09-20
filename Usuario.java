import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String numeroCelular;
    private String tipo;
    private static List<Usuario> registroU = new ArrayList<>(); // registro de usuarios
    private int QtdLivrosEmprestados = 0;  // diminui ou aumenta nos metodos de devolucao/emprestimo na classe Livro

    // GETTERS E SETTERS (TOTAL: 10)

    public int getQtdLivrosEmprestados() {
        return QtdLivrosEmprestados;
    }

    public void setQtdLivrosEmprestados(int qtdLivrosEmprestados) {
        QtdLivrosEmprestados = qtdLivrosEmprestados;
    }

    public static List<Usuario> getRegistroU() {
        return registroU;
    }

    public static void setRegistroU(List<Usuario> registroU) {
        Usuario.registroU = registroU;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // FIM DOS GETTERS E SETTERS

    public void InserirUsuarios(){
        // nomeu : nome do usuario, numero = numero do celular, tip = tipo
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o nome do usuario: ");
        String nomeu = sc.nextLine().strip().replaceAll("\\s+", " ");
        System.out.print("Informe o numero de celular do usuario: ");
        String numero = sc.nextLine().strip().replaceAll("\\s+", " ");
        System.out.print("Informe o tipo de usuario...estudante ou professor? ");
        String tip = sc.nextLine().strip().replaceAll("\\s+", " ");
        Usuario usuario = new Usuario(); // criando um objeto e adicionando seus atributos
        usuario.nome = nomeu;
        usuario.numeroCelular = numero;
        usuario.tipo = tip;
        registroU.add(usuario); // adiciona o objeto á lista
        System.out.print("Usuario cadastrado com sucesso!\n ");
    }


}
