import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilhaController<Produto> carrinho = new  PilhaController<>();
        Scanner sc = new Scanner(System.in);

        int numero;
        String nome;
        String datainput;
        do{
            System.out.println("Escolha uma funcao de 0 a 4: ");
            System.out.println("1. adicionar ");
            System.out.println("2. remover ");
            System.out.println("3. mostrar");
            System.out.println("0. sair ");
            numero = sc.nextInt();

            switch (numero){
                case 1:
                    sc.nextLine();
                    System.out.println("Qual o nome do produto?");
                    nome = sc.nextLine();
                    System.out.println("Qual a data de vencimento do produto?(ano/mes/dia)");
                    datainput = sc.nextLine();
                    LocalDate data = LocalDate.parse(datainput);
                    Produto produto = new Produto();
                    produto.setNome(nome);
                    produto.setDataVencimento(data);
                    carrinho.adiciona(produto);
                    break;
                case 2:
                    int posicao;
                    System.out.println("Qual produto deseja remover");
                    posicao = sc.nextInt();
                    carrinho.remove(posicao);
                    break;
                case 3:
                    carrinho.mostra();
            }
        }while(numero != 0);
    }
}
