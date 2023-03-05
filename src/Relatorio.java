import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Relatorio {


    public static void relatorio(){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        //Listar opções de relatório
        System.out.println("""
                Qual relatório deseja ver?
                1. Pacientes
                2. Enfermeiros
                3. Médicos
                4. Todos""");


        //Impedir que o usuário escolha uma opção inexistente
        while (!scanner.hasNextInt() || (opcao = scanner.nextInt()) < 1 || opcao > 4){
            System.out.println("Opção inválida para relatório. Tente novamente.");
            scanner.nextLine();
        }

        switch (opcao) {
            case 1:
                relatorioPacientes();
                break;

            case 2:
                relatorioEnfermeiros();
                break;

            case 3:
                relatorioMedicos();
                break;

            case 4:
                relatorioGeral();
                break;

        }
    }

    public static void relatorioPacientes(){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        //Opções
        System.out.println("""
                Deseja ver os pacientes com qual status?
                1. Aguardando Atendimento
                2. Em Atendimento
                3. Atendido
                4. Não Atendido
                5. Todos""");

        //Impedir o usuário de digitar opção inválida
        while (!scanner.hasNextInt() || (opcao = scanner.nextInt()) < 1 || opcao > 5){
            System.out.println("Opção inválida para status. Tente novamente.");
            scanner.nextLine();
        }

        switch (opcao){
            case 1:
                imprimirPorStatus("Aguardando Atendimento");
                break;

            case 2:
                imprimirPorStatus("Em Atendimento");
                break;

            case 3:
                imprimirPorStatus("Atendido");
                break;

            case 4:
                imprimirPorStatus("Não Atendido");
                break;

            case 5:
                imprimirPorStatus("Todos");
                break;
        }
    }

    public static void relatorioEnfermeiros(){
        //Listagem
        for (Enfermeiro enfermeiro : Lista.getListaEnfermeiros()){
            System.out.println("%d. %s | CPF: %s".formatted(enfermeiro.getId(), enfermeiro.getNome(),
                    enfermeiro.getCpf()));
        }
    }

    public static void relatorioMedicos(){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("""
                Deseja ver os médicos de qual especialidade?
                1. CLínico Geral
                2. Anestesista
                3. Dermatologista
                4. Ginecologista
                5. Neurologista
                6. Pediatra
                7. Psiquiatra
                8. Ortopedista
                9. Todos""");

        //Impedir o usuário de selecionar opção inválida
        while (!scanner.hasNextInt() || (opcao = scanner.nextInt()) < 1 || opcao > 9){
            System.out.println("Opção inválida para especialidade. Tente novamente.");
            scanner.nextLine();
        }

        //Imprimir de acordo com a seleção do usuário
        switch (opcao){
            case 1:
                imprimirPorEspecialidade("Clínico Geral");
                break;

            case 2:
                imprimirPorEspecialidade("Anestesista");
                break;

            case 3:
                imprimirPorEspecialidade("Dermatologista");
                break;

            case 4:
                imprimirPorEspecialidade("Ginecologista");
                break;

            case 5:
                imprimirPorEspecialidade("Neurologista");
                break;

            case 6:
                imprimirPorEspecialidade("Pediatra");
                break;

            case 7:
                imprimirPorEspecialidade("Psiquiatra");
                break;

            case 8:
                imprimirPorEspecialidade("Ortopedista");
                break;

            case 9:
                imprimirPorEspecialidade("Todos");
                break;
        }

    }

    public static void relatorioGeral(){
        System.out.println("Médicos:");
        imprimirPorEspecialidade("Todos");

        System.out.println("\nEnfermeiros:");
        relatorioEnfermeiros();

        System.out.println("\nPacientes:");
        imprimirPorStatus("Todos");
    }

    public static void imprimirPorStatus(String status){
        for (Medico medico : Lista.getListaMedicos()){
            for (Paciente paciente : medico.getListaPacientes()){
                if (paciente.getStatus().equalsIgnoreCase(status) || status == "Todos") {
                    System.out.println("%d. %s | %s | %d atendimento(s)".formatted(paciente.getId(), paciente.getNome(),
                            paciente.getConvenio(), paciente.getTotalAtendimentos()));
                }
            }
        }
    }

    public static void imprimirPorEspecialidade(String especialidade){
        for (Medico medico : Lista.getListaMedicos()){
            if (medico.getEspecializacao().equalsIgnoreCase(especialidade) || especialidade ==
                    "Todos"){
                System.out.println("""
                        %d. %s | %s | %s | %s""".formatted(medico.getId(), medico.getNome(), medico.getInstituicao(),
                        medico.getCadastroCRM(), medico.getEspecializacao()));
            }
        }
    }
}
