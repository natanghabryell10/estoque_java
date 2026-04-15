import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    int quantidade;

    Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }
}

public class Estoque {

    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }

        System.out.println("\n=== ESTOQUE ===");
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            System.out.println((i + 1) + ". " + p.nome + " | Quantidade: " + p.quantidade);
        }
    }

    public static void adicionar() {
        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();

        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(sc.nextLine());

        produtos.add(new Produto(nome, qtd));

        System.out.println("Produto adicionado!");
    }

    public static void remover() {
        listar();

        System.out.print("Número do produto para remover: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index >= 0 && index < produtos.size()) {
            produtos.remove(index);
            System.out.println("Produto removido!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public static void atualizar() {
        listar();

        System.out.print("Número do produto: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index >= 0 && index < produtos.size()) {
            System.out.print("Nova quantidade: ");
            int qtd = Integer.parseInt(sc.nextLine());

            produtos.get(index).quantidade = qtd;

            System.out.println("Quantidade atualizada!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar quantidade");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Sair");

            System.out.print("Escolha: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    adicionar();
                    break;
                case "2":
                    listar();
                    break;
                case "3":
                    atualizar();
                    break;
                case "4":
                    remover();
                    break;
                case "5":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
