import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa{
    private String instituicao;
    private String cadastroCRM;
    private String especializacao;
    private String ativo;
    private Integer totalAtendimentos = 0;
    private List<Paciente> listaPacientes = new ArrayList<>();


    public Medico(String nome, String genero, String nascimento, String cpf, String telefone, String instituicao,
                  String cadastroCRM, String especializacao, String ativo) {
        super(nome, genero, nascimento, cpf, telefone);
        this.instituicao = instituicao;
        this.cadastroCRM = cadastroCRM;
        this.especializacao = especializacao.equals("1") ? "Clínico Geral"
                : especializacao.equals("2") ? "Anestesista"
                : especializacao.equals("3") ? "Dermatologista"
                : especializacao.equals("4") ? "Ginecologista"
                : especializacao.equals("5") ? "Neurologista"
                : especializacao.equals("6") ? "Pediatra"
                : especializacao.equals("7") ? "Psiquiatra"
                : especializacao.equals("8") ? "Ortopedista"
                : "";
        this.ativo = ativo.equals("1") ? "Ativo" : "Inativo";
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public static void addPaciente(int medicoID, Paciente paciente){
        //Buscar o médico dentro da lista na classe estática usando o index
        Medico medicoPorID = Lista.getListaMedicos().get(medicoID);
        //Adicionar paciente no atributo listaPacientes do médico especificado
        medicoPorID.listaPacientes.add(paciente);
    }

    public void addTotalAtendimentos() {
        this.totalAtendimentos += 1;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public String getCadastroCRM() {
        return cadastroCRM;
    }

    public String getAtivo() {
        return ativo;
    }
}
