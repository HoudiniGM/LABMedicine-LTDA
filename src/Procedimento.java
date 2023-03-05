import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Procedimento {

    //MÉTODOS
    public static boolean cadastrarPaciente(){
        List<Medico> listaMedicos = Lista.getListaMedicos();
        Scanner scannerInt = new Scanner(System.in);
        int opcao;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Isso não permitirá datas inválidas.


        //Caso não exista médico cadastrado, esse IF impede o cadastro de paciente.
        if (listaMedicos.size() == 0){
            System.out.println("Não há médicos para cadastrar um paciente. Cadastre um médico primeiro.");
            return false;
        }

        //Aqui é renderizado uma lista de opções de médicos para cadastrar um paciente.
        System.out.println("Deseja cadastrar um paciente para qual médico?");
        for (int i=0; i<listaMedicos.size(); i++){
            System.out.println("%d. %s, %s.".formatted(i, listaMedicos.get(i).getNome(),
                    listaMedicos.get(i).getEspecializacao()));
        }

        //Aqui impede o usuário de selecionar uma opção de médico não existente.
        while (!scannerInt.hasNextInt() || (opcao = scannerInt.nextInt()) < 0 || opcao >= listaMedicos.size()){
            System.out.println("Opção inválida para médico. Tente novamente!");
            scannerInt.nextLine();
        }

        //Aqui começará o cadastro.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("""
                Gênero:
                1. Masculino
                2. Feminino
                3. Outro
                """);
        String genero = scanner.nextLine();
        while (!Arrays.asList("1", "2", "3").contains(genero)){
            System.out.println("Opção inválida. Tente novamente");
            genero = scannerInt.nextLine();
        }

        System.out.print("Nascimento 'dd/mm/aaaa': ");
        String nascimento;
        while (true) {
            nascimento = scanner.nextLine();

            try {
                Date data = dateFormat.parse(nascimento); //valida a data informada
                break;
            } catch (ParseException e){
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        while (cpf.length() != 11){
            System.out.println("O CPF precisa ter 11 dígitos. Tente novamente.");
            cpf = scanner.nextLine();
        }

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        while (telefone == ""){
            System.out.println("Campo obrigatório. Tente novamente.");
            telefone = scanner.nextLine();
        }

        System.out.print("Contato de Emergência: ");
        String contatoEmergencia = scanner.nextLine();
        while (contatoEmergencia == ""){
            System.out.println("Campo obrigatório. Tente novamente.");
            contatoEmergencia = scanner.nextLine();
        }

        System.out.println("Lista de Alergias (Caso não haja alergia, deixe em branco e pressione ENTER): ");
        List<String> listaAlergias = new ArrayList<>();
        int cont = 1;
        System.out.print("%d. ".formatted(cont));
        String alergias = scanner.nextLine();
        while (alergias != ""){
            listaAlergias.add(alergias);
            cont++;
            System.out.print("%d. ".formatted(cont));
            alergias = scanner.nextLine();
        }

        System.out.println("Lista de Cuidados Específicos (Caso não haja cuidados, deixe em branco e pressione ENTER)" +
                ": ");
        List<String> listaCuidados = new ArrayList<>();
        cont = 1;
        System.out.print("%d. ".formatted(cont));
        String cuidados = scanner.nextLine();
        while (cuidados != ""){
            listaCuidados.add(cuidados);
            cont++;
            System.out.print("%d. ".formatted(cont));
            cuidados = scanner.nextLine();
        }

        System.out.print("Convênio: ");
        String convenio = scanner.nextLine();

        String numeroConvenio = "";
        String validadeConvenio = "";
        if (convenio != "") {
            System.out.print("Número do Convênio: ");
            numeroConvenio = scanner.nextLine();
            while (numeroConvenio.equals("")){
                System.out.println("Campo obrigatório. Tente novamente.");
                numeroConvenio = scanner.nextLine();
            }

            System.out.print("Validade do Convênio: ");
            while (true) {
                validadeConvenio = scanner.nextLine();

                try {
                    Date data = dateFormat.parse(validadeConvenio);
                    break;
                } catch (ParseException e) {
                    System.out.println("Data inválida. Tente novamente.");
                }
            } //impede o usuário de usar data inválida
        }

        System.out.print("""
                Status de Atendimento:
                1. Aguardando Atendimento
                2. Em Atendimento
                3. Atendido
                4. Não Atendido
                """);
        String status = scanner.nextLine();
        while (!Arrays.asList("1", "2", "3", "4").contains(status)){
            System.out.println("Opção inválida para status. Tente novamente.");
            status = scanner.nextLine();
        }

        //Com todos os dados informados, o objeto paciente é instanciado e adicionado à lista de pacientes do
        // médico selecionado.
        Paciente paciente = new Paciente(nome, genero, nascimento, cpf, telefone, contatoEmergencia,
                listaAlergias, listaCuidados, convenio, numeroConvenio, validadeConvenio, status);
        Medico.addPaciente(opcao, paciente);
        System.out.println("Paciente cadastrado!");

        return true;
    }

    public static Enfermeiro cadastrarEnfermeiro(){
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Isso não permitirá datas inválidas.


        System.out.print("Nome do enfermeiro: ");
        String nome = scanner.nextLine();

        System.out.print("""
                Gênero:
                1. Masculino
                2. Feminino
                3. Outro
                """);
        String genero = scanner.nextLine();
        while (!Arrays.asList("1", "2", "3").contains(genero)){
            System.out.println("Opção inválida. Tente novamente");
            genero = scanner.nextLine();
        }

        System.out.print("Nascimento 'dd/mm/aaaa': ");
        String nascimento;
        while (true) {
            nascimento = scanner.nextLine();

            try {
                Date data = dateFormat.parse(nascimento);
                break;
            } catch (ParseException e){
                System.out.println("Data inválida. Tente novamente.");
            }
        } // Impede o usuário de usar data inválida

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        while (cpf.length() != 11){
            System.out.println("O CPF precisa ter 11 dígitos. Tente novamente.");
            cpf = scanner.nextLine();
        }

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        while (telefone == ""){
            System.out.println("Campo obrigatório. Tente novamente.");
            telefone = scanner.nextLine();
        }

        System.out.print("Instituição de Ensino da Formação: ");
        String instituicao = scanner.nextLine();
        while (instituicao == ""){
            System.out.println("Campo obrigatório. Tente novamente.");
            instituicao = scanner.nextLine();
        }

        System.out.print("Cadastro do COFEN/UF: ");
        String cadastroCOFEN = scanner.nextLine();
        while (cadastroCOFEN == ""){
            System.out.println("Campo obrigatório. Tente novamente.");
            cadastroCOFEN = scanner.nextLine();
        }

        Enfermeiro enfermeiro = new Enfermeiro(nome, genero, nascimento, cpf, telefone, instituicao, cadastroCOFEN);
        Lista.setEnfermeiro(enfermeiro);
        System.out.println("Enfermeiro cadastrado!");

        return enfermeiro;
    }

    public static Medico cadastrarMedico(){
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Isso não permitirá datas inválidas.


        System.out.print("Nome do médico: ");
        String nome = scanner.nextLine();

        System.out.print("""
                Gênero:
                1. Masculino
                2. Feminino
                3. Outro
                """);
        String genero = scanner.nextLine();
        while (!Arrays.asList("1", "2", "3").contains(genero)){
            System.out.println("Opção inválida. Tente novamente");
            genero = scanner.nextLine();
        }

        System.out.print("Nascimento 'dd/mm/aaaa': ");
        String nascimento;
        while (true) {
            nascimento = scanner.nextLine();

            try {
                Date data = dateFormat.parse(nascimento);
                break;
            } catch (ParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        while (cpf.length() != 11){
            System.out.println("O CPF precisa ter 11 dígitos. Tente novamente.");
            cpf = scanner.nextLine();
        }

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        while (telefone == ""){
            System.out.println("Campo obrigatório. Tente novamente.");
            telefone = scanner.nextLine();
        }

        System.out.print("Instituição de Ensino da Formação: ");
        String instituicao = scanner.nextLine();
        while (instituicao == ""){
            System.out.println("Campo obrigatório. Tente novamente.");
            instituicao = scanner.nextLine();
        }

        System.out.print("Cadastro do CRM/UF: ");
        String cadastroCRM = scanner.nextLine();
        while (cadastroCRM == ""){
            System.out.println("Campo obrigatório. Tente novamente.");
            cadastroCRM = scanner.nextLine();
        }

        System.out.print("""
                Especialização Clínica:
                1. Clínico Geral
                2. Anestesista
                3. Dermatologista
                4. Ginecologista
                5. Neurologista
                6. Pediatra
                7. Psiquiatra
                8. Ortopedista
                """);
        String especializacao = scanner.nextLine();
        while (!Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8").contains(especializacao)){
            System.out.println("Opção inválida. Tente novamente.");
            especializacao = scanner.nextLine();
        }

        System.out.print("""
                Estado no sistema:
                1. Ativo
                2. Inativo
                """);
        String ativo = scanner.nextLine();
        while (!Arrays.asList("1", "2").contains(ativo)){
            System.out.println("Opção inválida. Tente novamente.");
            ativo = scanner.nextLine();
        }

        Medico medico = new Medico(nome, genero, nascimento, cpf, telefone, instituicao, cadastroCRM,
                especializacao, ativo);
        Lista.setMedico(medico);
        System.out.println("Médico cadastrado!");

        return medico;
    }

    public static boolean atenderPaciente(){
        Scanner scannerInt = new Scanner(System.in);
        List<Medico> listaMedicos = Lista.getListaMedicos();
        int opcao;

        //Caso não exista médico cadastrado, esse IF impede a função de continuar e retorna ao menu principal.
        if (listaMedicos.size() == 0){
            System.out.println("Desculpe, mas antes é necessário cadastrar um médico.");
            return false;
        }

        //Aqui é renderizado uma lista de opções de médicos.
        System.out.println("Qual médico participou do atendimento?");
        for (int i=0; i<listaMedicos.size(); i++) {
            System.out.println("%d. %s, %s".formatted(i, listaMedicos.get(i).getNome(),
                    listaMedicos.get(i).getEspecializacao()));
        }

        //Aqui impede o usuário de selecionar uma opção não existente de médico.
        while (!scannerInt.hasNextInt() || (opcao = scannerInt.nextInt()) < 0 || opcao >= listaMedicos.size()){
            System.out.println("Opção inválida para médico. Tente novamente!");
            scannerInt.nextLine();
        }

        //Essa parte avalia se existe algum paciente desse médico. Se não, volta ao menu principal.
        Medico medico = listaMedicos.get(opcao); // Médico selecionado
        if (medico.getListaPacientes().size() == 0){
            System.out.println("Dr(a). %s não possui pacientes cadastrados.".formatted(medico.getNome()));
            return false;
        } else if (medico.getAtivo().equals("Inativo")){
            System.out.println("Dr(a). %s não está ativo no momento.");
            return false;
        }

        //Agora, listar os pacientes desse médico.
        System.out.println("Qual paciente participou do atendimento?");
        for (int i=0; i<medico.getListaPacientes().size(); i++){
            System.out.println("%d. %s".formatted(i, medico.getListaPacientes().get(i).getNome()));
        }

        //Aqui impede o usuário de selecionar uma opção não existente de paciente.
        while (!scannerInt.hasNextInt() || (opcao = scannerInt.nextInt()) < 0 || opcao >= medico.getListaPacientes().size()){
            System.out.println("Opção inválida para paciente. Tente novamente!");
            scannerInt.nextLine();
        }

        medico.addTotalAtendimentos(); //+1 no totalAtendimentos do médico
        medico.getListaPacientes().get(opcao).addTotalAtendimentos(); //+1 no totalAtendimentos do paciente
        medico.getListaPacientes().get(opcao).setStatus(2); // Mudar status do paciente para Em Atendimento

        System.out.println("Atendimento efetuado entre o(a) médico(a) %s e o(a) paciente %s."
                .formatted(medico.getNome(),medico.getListaPacientes().get(opcao).getNome()));

        return true;
    }

    public static boolean atualizarStatusPaciente(){
        Scanner scanner = new Scanner(System.in);
        List<Medico> listaMedicos = Lista.getListaMedicos();
        int opcao;

        //Caso não exista médico cadastrado, esse IF impede a função de continuar e retorna ao menu principal.
        if (listaMedicos.size() == 0){
            System.out.println("Desculpe, mas antes é necessário cadastrar um médico.");
            return false;
        }

        //Aqui é renderizado uma lista de opções de médicos.
        System.out.println("De qual médico o paciente pertence?");
        for (int i=0; i<listaMedicos.size(); i++){
            System.out.println("%d. %s, %s".formatted(i, listaMedicos.get(i).getNome(),
                    listaMedicos.get(i).getEspecializacao()));
        }

        //Aqui impede o usuário de selecionar uma opção não existente de médico.
        while (!scanner.hasNextInt() || (opcao = scanner.nextInt()) < 0 || opcao >= listaMedicos.size()){
            System.out.println("Opção inválida para médico. Tente novamente!");
            scanner.nextLine();
        }

        //Essa parte avalia se existe algum paciente desse médico. Se não, volta ao menu principal.
        Medico medico = listaMedicos.get(opcao); // Médico selecionado
        if (medico.getListaPacientes().size() == 0){
            System.out.println("Dr(a). %s não possui pacientes cadastrados.".formatted(medico.getNome()));
            return false;
        }


        //Agora, listar os pacientes desse médico.
        System.out.println("Selecione o paciente:");
        for (int i=0; i<medico.getListaPacientes().size(); i++){
            System.out.println("%d. %s".formatted(i, medico.getListaPacientes().get(i).getNome()));
        }

        //Aqui impede o usuário de selecionar uma opção não existente de paciente.
        while (!scanner.hasNextInt() || (opcao = scanner.nextInt()) < 0 || opcao >= medico.getListaPacientes().size()){
            System.out.println("Opção inválida para paciente. Tente novamente!");
            scanner.nextLine();
        }

        Paciente paciente = medico.getListaPacientes().get(opcao);
        System.out.println("""
                Status atual: %s. 
                Deseja definir o status de %s para qual:"""
                .formatted(paciente.getStatus(), paciente.getNome()));
        System.out.println("""
                1. Aguardando Atendimento
                2. Em Atendimento
                3. Atendido
                4. Não Atendido""");

        while (!scanner.hasNextInt() || (opcao = scanner.nextInt()) < 1 || opcao > 4){
            System.out.println("Opção inválida para status. Tente novamente!");
            scanner.nextLine();
        }
        paciente.setStatus(opcao);
        System.out.println("O status de %s agora é: %s".formatted(paciente.getNome(), paciente.getStatus()));

        return true;
    }
}
