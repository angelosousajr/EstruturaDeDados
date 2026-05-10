public class Medicamento {
    private String nomeMedicamento;
    private String dataValidade;

    public Medicamento(String nomeMedicamento, String dataValidade) {
        this.nomeMedicamento = nomeMedicamento;
        this.dataValidade = dataValidade;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    @Override
    public String toString() {
        return "Medicamento: " + nomeMedicamento + ", Validade: " + dataValidade;
    }
}
