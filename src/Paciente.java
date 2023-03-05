import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paciente extends Pessoa{
    private String emergencia;
    private List<String> alergias = new ArrayList<>();
    private List<String> cuidados = new ArrayList<>();
    private String convenio = "";
    private String numeroConvenio = "";
    private String validadeConvenio = "";
    private String status;
    private int totalAtendimentos = 0;

    public Paciente(String nome, String genero, String nascimento, String cpf,
                    String telefone, String emergencia, List<String> alergias, List<String> cuidados,
                    String convenio, String numeroConvenio, String validadeConvenio, String status) {
        super(nome, genero, nascimento, cpf, telefone);
        this.emergencia = emergencia;
        this.alergias = alergias;
        this.cuidados = cuidados;
        this.convenio = convenio.equals("") ? "Sem Convênio" : convenio;
        this.numeroConvenio = numeroConvenio;
        this.validadeConvenio = validadeConvenio;
        this.status = status.equals("1") ? "Aguardando Atendimento"
                : status.equals("2") ? "Em Atendimento"
                : status.equals("3") ? "Atendido"
                : "Não Atendido";
    }

    public void setStatus(int opcao) {
        this.status = (opcao == 1) ? "Aguardando Atendimento"
                : (opcao == 2) ? "Em Atendimento"
                : (opcao == 3) ? "Atendido"
                : (opcao == 4) ? "Não Atendido"
                : "";
    }

    public void addTotalAtendimentos() {
        this.totalAtendimentos += 1;
    }

    public String getStatus() {
        return status;
    }

    public String getConvenio() {
        return convenio;
    }

    public int getTotalAtendimentos() {
        return totalAtendimentos;
    }
}
