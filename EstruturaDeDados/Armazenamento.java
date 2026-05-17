import java.util.Scanner;

public class Armazenamento {
    public static void main(String[] args) {

        Pilha[][] Caixa = new Pilha[3][3];
        int capacidadePilha = 5;
        Scanner scanner = new Scanner(System.in);

        // Inicializando todas as pilhas
        for (int i = 0; i < Caixa.length; i++) {
            for (int j = 0; j < Caixa[i].length; j++) {
                Caixa[i][j] = new Pilha(capacidadePilha);
            }
        }

        int opcao;

        // Menu interativo
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar medicamento");
            System.out.println("2 - Remover medicamento");
            System.out.println("3 - Visualizar caixa");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            if (opcao >= 1 && opcao <= 3) {

                // Escolha da posição
                System.out.print("Digite a linha (A, B ou C): ");
                char linha = scanner.next().toUpperCase().charAt(0);
                int i = linha - 'A';

                System.out.print("Digite o espaço (1, 2 ou 3): ");
                int j = scanner.nextInt() - 1;
                scanner.nextLine();

                // Validação
                if (i < 0 || i >= 3 || j < 0 || j >= 3) {
                    System.out.println("Posição inválida!");
                    continue;
                }

                switch (opcao) {

                    case 1:
                        System.out.print("Nome do medicamento: ");
                        String nome = scanner.nextLine();

                        System.out.print("Data de validade: ");
                        String validade = scanner.nextLine();

                        Medicamento m = new Medicamento(nome, validade);
                        Caixa[i][j].adicionar(m);
                        break;

                    case 2:
                        System.out.println("1 - Remover o do topo (último adicionado)");
                        System.out.println("2 - Procurar e remover por nome específico");
                        System.out.print("Escolha: ");
                        int tipoRemocao = scanner.nextInt();
                        scanner.nextLine();

                        if (tipoRemocao == 1) {
                            Medicamento removido = Caixa[i][j].remover();
                            if (removido != null) {
                                System.out.println("Removido do topo: " + removido);
                            }
                        } else if (tipoRemocao == 2) {
                            System.out.print("Digite o nome do medicamento a ser removido: ");
                            String nomeBusca = scanner.nextLine();
                            
                            Medicamento removidoEspecifico = Caixa[i][j].removerEspecifico(nomeBusca);

                            if (removidoEspecifico != null) {
                                System.out.println("Medicamento removido: " + removidoEspecifico);
                            }else{
                                System.out.println("Medicamento " + nomeBusca + " não encontrado na caixa.");
                            }
                        }
                        break;

                    case 3:
                        Caixa[i][j].exibir();
                        break;
                }
            }

        } while (opcao != 4);

        // Mostrar estado final antes de encerrar (opcional, mas bom)
        System.out.println("\n--- CONTEÚDO FINAL DA CAIXA ---");
        for (int i = 0; i < Caixa.length; i++) {
            char letraArmazenamento = (char) ('A' + i);
            for (int j = 0; j < Caixa[i].length; j++) {
                int numeroEspaço = j + 1;
                System.out.println("Armazenamento " + letraArmazenamento + ", Espaço " + numeroEspaço + ": ");
                Caixa[i][j].exibir();
                System.out.println();
            }
        }

        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}