
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Livro livro = new Livro();
        Usuario usuario = new Usuario();



        System.out.print("Bem vindo! ");
        int i = 0;
        while (i == 0){
            System.out.print("\nEscolha sua opcao:\n[1] Cadastro de Usuarios\n[2] Cadastro de livros\n[3] Emprestimo de livros" +
                    "\n[4] Devolução de livros\n[5] Consulta de livros\n[6] Sair\n");
            int escolha = sc.nextInt();
            switch(escolha){
                case 1:
                    usuario.InserirUsuarios();
                    break;
                case 2:
                    livro.Cadastro();
                    break;
                case 3:
                    livro.Emprestimos();
                    break;
                case 4:
                    livro.Devolucao();
                    break;
                case 5:
                    livro.Consulta();
                    break;
                case 6:
                    i = 1;
                    System.out.print("Até mais! ;) ");
                    break;
                default:
                    System.out.print("Opcao invalida");
            }
        }





    }
}