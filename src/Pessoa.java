public class Pessoa {
    private static int identificador = 0;

    private int id;
    private String nome;
    private String genero;
    private String nascimento;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String genero, String nascimento, String cpf, String telefone) {
        this.id = identificador++;
        this.nome = nome;
        this.genero = genero.equals("1") ? "Masculino"
                : genero.equals("2") ? "Feminino"
                : "Outro";
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }
}
