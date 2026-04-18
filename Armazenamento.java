import java.util.Scanner;
public class Armazenamento {
    public static void main(String[] args) {
        String[][] Setor = new String[3][3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < Setor.length; i++) {
            char letraCorredor = (char) ('A' + i);
            for (int j = 0; j < Setor[i].length; j++) {
                int numeroPrateleira = j + 1;
                System.out.println("Digite o medicamento que entrará no estoque do corredor " + letraCorredor + " e prateleira " + numeroPrateleira + ":");
                Setor[i][j] = scanner.nextLine();
            }
        }

        System.out.println("Conteúdo do estoque:");
        for (int i = 0; i < Setor.length; i++) {
            char letraCorredor = (char) ('A' + i);
            for (int j = 0; j < Setor[i].length; j++) {
                int numeroPrateleira = j + 1;
                System.out.println("Corredor " + letraCorredor + ", Prateleira " + numeroPrateleira + ": " + Setor[i][j]);
            }
        }

        scanner.close();
    }
}
