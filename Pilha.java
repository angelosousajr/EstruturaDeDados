public class Pilha {
    public int[] dados;
    public int topo;

    public Pilha(int capacidade) {
        dados = new int[capacidade];
        topo = -1;
    }

    public void adicionar(int valor) {
        if (topo < dados.length - 1) {
            topo++;
            dados[topo] = valor;
            System.out.println("Colocou o medicamento " + valor + " na pilha.");
        } else {
            System.out.println("A pilha já está cheia, não é possível adicionar mais!");
        }
    }

    public int remover() {
        if (topo >= 0) {
            int valorRemovido = dados[topo];
            topo--;
            return valorRemovido;
        } else {
            System.out.println("A pilha está vazia, não é possível remover!");
            return -1;
        }
    }

    public void exibir() {
        if (topo >= 0) {
            System.out.println("Conteúdo da pilha:");
            for (int i = topo; i >= 0; i--) {
                System.out.println(dados[i]);
            }
        } else {
            System.out.println("A pilha está vazia!");
        }
    }
}
