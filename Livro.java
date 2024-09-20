import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit; // Para calcular a subtracao de datas, ou seja, os dias de atraso na devolução

public class Livro {
    Scanner sc = new Scanner(System.in);
    public LocalDate dataAtual = LocalDate.now();
    private String titulo;
    private String autor;
    private String categoria;
    public static List<Livro> catalogo = new ArrayList<>();
    private boolean status; // Se o livro esta disponivel ou não para emprestimo
    private LocalDate dataEmprestimo = LocalDate.now();
    private LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(14); // Prazo : 2 semanas = 14 dias

    // METODO CONSTRUTOR, so para inicializar
    public Livro(){
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.status = true; // livro começa disponivel. True = disponivel. False = indisponivel
    }

    // GETTERS E SETTERS (TOTAL: 16)

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }


    public static List<Livro> getCatalogo() {
        return catalogo;
    }

    public static void setCatalogo(List<Livro> catalogo) {
        Livro.catalogo = catalogo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // FIM DE GETTERS E SETTERS


    // descricao do livro, do objeto:
    public String representacao(){
        return "\nTitulo: "+titulo+"\nAutor: "+autor+"\nCategoria: "+categoria+"\n";
    }


    public void InserirLivros(){
        // t : titulo, a : autor , c: categoria
        System.out.print("Titulo: ");
        String t = sc.nextLine().strip().replaceAll("\\s+", " "); // replaceAll substitui os caracteres de espacos por UM unico espaco
        System.out.print("Autor: ");
        String a = sc.nextLine().strip().replaceAll("\\s+", " ");
        System.out.print("Categoria: ");
        String c = sc.nextLine().strip().replaceAll("\\s+", " ");

        Livro livro = new Livro(); // criando o objeto livro e adicionando os atributos dados a ele:
        livro.titulo = t;
        livro.autor = a;
        livro.categoria = c;
        catalogo.add(livro); // adiciona o objeto ao catalogo
        System.out.print("Livro acidiconado com sucesso\n");

    }


    public void RemoverLivros(){
        // tr = titulo do livro a ser removido, encontrei = se encontrei o livro no catalogo
        System.out.print("Qual o titulo do livro deseja remover? ");
        String tr = sc.nextLine().strip().replaceAll("\\s+", " ");

        boolean encontrei = false;
        for (Livro livro: catalogo){
            if (livro.getTitulo().equalsIgnoreCase(tr)){
                catalogo.remove(livro);
                System.out.print("Livro removido com sucesso\n");
                encontrei = true;
                break;
            }
        }
        if (!encontrei){
            System.out.print("Livro não encontrado\n");
        }
    }


    public void Edicao(){
        // te = titulo do livro a ser editado
        //titn = titulo novo, autn = autor novo, catn = categoria nova
        System.out.print("Qual o titulo do livro que deseja editar?");
        String te = sc.nextLine().strip().replaceAll("\\s+", " ");

        boolean encontrei = false;
        for (Livro livro: catalogo) {
            if (livro.getTitulo().equalsIgnoreCase(te)) {
                System.out.print("Qual sera o titulo? ");
                String titn = sc.nextLine().strip().replaceAll("\\s+", " ");
                System.out.print("Qual sera o autor? ");
                String autn = sc.nextLine().strip().replaceAll("\\s+", " ");
                System.out.print("Qual sera a categoria? ");
                String catn = sc.nextLine().strip().replaceAll("\\s+", " ");

                // editando:
                livro.setTitulo(titn);
                livro.setAutor(autn);
                livro.setCategoria(catn);

                encontrei = true;
                System.out.print("Livro editado com sucesso\n");
                break;
            }
        }
        if (!encontrei){
            System.out.print("Livro não encontrado\n");
        }
    }


    public void Consulta(){
        // resp : resposta, t = titulo, a = autor, c = categoria
        Scanner sc = new Scanner(System.in);
        System.out.print("Deseja pesquisar pelo o que? \n[1] Titulo \n[2] Autor \n[3] Categoria ?\n");
        int resp = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        boolean encontrado = false;
        switch (resp){
            case 1:
                System.out.print("Informe o titulo do livro: ");
                String t = sc.nextLine().strip().replaceAll("\\s+", " ");

                for (Livro livro: catalogo){
                    if (livro.getTitulo().equalsIgnoreCase(t)){ // procura um livro pelo titulo
                        System.out.print("Livro encontrado!\nInformações: ");
                        System.out.print(livro.representacao()); // coloca os detalhes do livro achado
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado){
                    System.out.print("Livro não encontrado");
                }
                break;
            case 2:
                System.out.print("Informe o autor do livro: ");
                String a = sc.nextLine().strip().replaceAll("\\s+", " ");

                for (Livro livro: catalogo){
                    if (livro.getAutor().equalsIgnoreCase(a)){ // procura todos os livros do autor
                        System.out.print("\nAutor encontrado!\nInformações: ");
                        System.out.print(livro.representacao());
                        encontrado = true;
                    }
                }
                if (!encontrado){
                    System.out.print("Autor não encontrado");
                }
                break;
            case 3:
                System.out.print("Informe a categoria do livro: ");
                String c = sc.nextLine().strip().replaceAll("\\s+", " ");

                for (Livro livro: catalogo){
                    if (livro.getCategoria().equalsIgnoreCase(c)){ // procura todos os livros da mesma categoria
                        System.out.print("\nCategoria encontrada!\nInformações: ");
                        System.out.print(livro.representacao());
                        encontrado = true;
                    }
                }
                if (!encontrado){
                    System.out.print("Categoria não encontrado");
                }
                break;
            default:
                System.out.print("Opção invalida! ");
                break;
        }
    }


    public void Emprestimos() {
        // tit = titulo do livro que quer fazer o emprestimo
        // encontradoL = livro foi encontrado ou nao
        // encontradoU = usuario encontrado ou nao
        System.out.print("Qual o titulo do livro que deseja fazer um emprestimo? ");
        String tit = sc.nextLine().strip().replaceAll("\\s+", " ");

        boolean encontradoL = false;
        for (Livro livro : catalogo) {
            if ((livro.getTitulo().equalsIgnoreCase(tit))) { // achar o livro
                encontradoL = true; //achei o livro!

                if (!livro.status) {
                    System.out.print("Livro indisponivel");
                    return; // interrompe o metodo emprestimos se o livro nao estiver disponivel
                }

                System.out.print("Informe seu nome Completo: ");
                String nomee = sc.nextLine().strip().replaceAll("\\s+", " "); //nomee= nome do usuario

                boolean encontradoU = false;
                for (Usuario usuario : Usuario.getRegistroU()) { // achar o usuario
                    if (usuario.getNome().equalsIgnoreCase(nomee)) {
                        System.out.print("Ok, emprestimo feito a " + usuario.getNome()); // para saber quem fez o emprestimo
                        System.out.print("\nInformaçoes do livro: ");
                        System.out.print(livro.representacao());
                        usuario.setQtdLivrosEmprestados(usuario.getQtdLivrosEmprestados() + 1); // adicionando um livro devolvido ao usuario
                        System.out.print("\nPRAZO DE EMPRESTIMO: 2 semanas.\nMulta por atraso(por dia): 2 reais.\nData de devolucao: " + dataDevolucaoPrevista+"\n");
                        encontradoU = true;
                        livro.status = false; // se o livro ta disponivel, deixa ele indiponivel para o emprestimo
                        System.out.print("Livros emprestados de "+ usuario.getNome()+" = "+usuario.getQtdLivrosEmprestados());
                        break;
                    }
                }
                if (!encontradoU) {
                    System.out.print("Nao encontrado, por favor faça o cadastro."); //Usuario nao pode fazer o emprestimo se nao estiver cadastrado
                }
            }
        }
        if (!encontradoL) {
            System.out.print("Livro nao encontrado");
        }
    }


    public void Devolucao(){
        // tit = titulo do livro que quer devolver
        System.out.print("Qual o titulo do livro que deseja devolver?");
        String tit = sc.nextLine().strip().replaceAll("\\s+", " ");

        boolean encontradoL = false;
        for (Livro livro : catalogo){
            if (livro.getTitulo().equalsIgnoreCase(tit)){ //achando o livro
                System.out.print("Sei qual é o livro!");

                System.out.print("Informe seu nome completo: ");
                String usu = sc.nextLine().strip().replaceAll("\\s+", " ");  // usu = usuario
                boolean encontradoU = false;
                for (Usuario usuario: Usuario.getRegistroU()) { // achando o usuario
                    if (usuario.getNome().equalsIgnoreCase(usu)) {// tirando o livro devolvido do usuario
                        encontradoU = true;
                        usuario.setQtdLivrosEmprestados(usuario.getQtdLivrosEmprestados() - 1);
                        livro.status = true; // disponibilizando o livro novamente
                        // SABER SE TEM MULTA MULTA OU NAO:
                        if (dataAtual.isBefore(dataDevolucaoPrevista) || dataAtual.equals(dataDevolucaoPrevista)){
                            System.out.print("\nLivro devolvido com sucesso. Sem multas"); // Se a data de devolucao esta antes ou no dia do prazo
                        }else{
                            // Para calcular a subtracao de datas, ou seja, os dias de atraso na devolução:
                            long diasAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataAtual);
                            double multa = diasAtraso * 2;
                            System.out.print("Devolucao atrasada! Multa: "+multa);
                        }
                        break;
                    }

                }
                if (!encontradoU){
                    System.out.print("Nome de usuario nao encontrado");
                }

                encontradoL = true;
                break;
            }
        }
        if (!encontradoL){
            System.out.print("Esse livro nao existe no catalogo");
        }
    }


    public void Cadastro(){ // Para colocar no switch do main
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (i == 0) {
            System.out.print("\nCADASTRO DE LIVROS");
            System.out.print("\nEscolha a opcao que deseja:\n[1] Incluir livro.\n[2] Editar livro\n[3] Remover livro\n[4] Voltar para o menu principal\n");
            int resp = sc.nextInt(); //resp = resposta
            sc.nextLine(); // limpar o buffer
            switch (resp) {
                case 1:
                    InserirLivros();
                    break;
                case 2:
                    Edicao();
                    break;
                case 3:
                    RemoverLivros();
                    break;
                case 4:
                    i = 1;
                    break;
                default:
                    System.out.print("Opcao invalida");
                    break;
            }
        }

    }
}
