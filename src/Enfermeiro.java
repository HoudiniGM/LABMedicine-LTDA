public class Enfermeiro extends Pessoa {
    private String instituicao;
    private String cadastroCOFEN;

    public Enfermeiro(String nome, String genero, String nascimento, String cpf,
                      String telefone, String instituicao, String cadastroCOFEN) {
        super(nome, genero, nascimento, cpf, telefone);
        this.instituicao = instituicao;
        this.cadastroCOFEN = cadastroCOFEN;
    }

}
