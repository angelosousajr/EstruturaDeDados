import java.util.Scanner;
public class Armazenamento {
    public static void main(String[] args) {
        Pilha[][] Caixa = new Pilha[3][3];
        int capacidadePilha = 5;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < Caixa.length; i++) {
            for (int j = 0; j < Caixa[i].length; j++) {
                Caixa[i][j] = new Pilha(capacidadePilha);
            }
        }

        System.out.println("--- PREENCHENDO A CAIXA ---");
        for (int i = 0; i < Caixa.length; i++) {
            char letraArmazenamento = (char) ('A' + i);
            for (int j = 0; j < Caixa[i].length; j++) {
                int numeroEspaço = j + 1;

                System.out.println("Armazenamento " + letraArmazenamento + ", Espaço " + numeroEspaço);
                System.out.print("Quantos medicamentos deseja adicionar aqui? (Máx " + capacidadePilha + "): ");
                int qtd = scanner.nextInt();
                scanner.nextLine();

                for (int k = 0; k < qtd; k++) {
                    System.out.print("Digite o nome do medicamento " + (k + 1) + ": ");
                    String nomeMedicamento = scanner.nextLine();
                    System.out.print("Digite a data de validade (ex: 12/26): ");
                    String dataValidade = scanner.nextLine();
                    Medicamento medicamento = new Medicamento(nomeMedicamento, dataValidade);
                    Caixa[i][j].adicionar(medicamento);
                }
            }
        }

        System.out.println();
        System.out.println("------------------------------------");
        System.out.println();

        System.out.println("--- CONTEÚDO DA CAIXA ---");
        for (int i = 0; i < Caixa.length; i++) {
            char letraArmazenamento = (char) ('A' + i);
            for (int j = 0; j < Caixa[i].length; j++) {
                int numeroEspaço = j + 1;
                System.out.println("Armazenamento " + letraArmazenamento + ", Espaço " + numeroEspaço + ": ");
                Caixa[i][j].exibir();
                System.out.println();
            }
        }

        scanner.close();
    }
}
