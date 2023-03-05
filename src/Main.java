import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int opcao;
        System.out.println("BEM VINDO AO SISTEMA LABMEDICINE LTDA");

        while (true) {
            System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO: ");
            System.out.println("""
                    1. Cadastro de Paciente
                    2. Cadastro de Enfermeiro
                    3. Cadastro de Médico
                    4. Realização de Atendimento Médico
                    5. Atualização do Status de Atendimento do Paciente
                    6. Relatórios""");

            //Impede o usuário de selecionar opção inexistente
            while (!scanner.hasNextInt() || (opcao = scanner.nextInt()) < 1 || opcao > 6) {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
            }


            switch (opcao){
                case 1:
                    Procedimento.cadastrarPaciente();
                    System.out.println("\nPressione Enter para retornar ao menu principal.");
                    scanner2.nextLine();
                    break;
                case 2:
                    Procedimento.cadastrarEnfermeiro();
                    System.out.println("\nPressione Enter para retornar ao menu principal.");
                    scanner2.nextLine();
                    break;
                case 3:
                    Procedimento.cadastrarMedico();
                    System.out.println("\nPressione Enter para retornar ao menu principal.");
                    scanner2.nextLine();
                    break;
                case 4:
                    Procedimento.atenderPaciente();
                    System.out.println("\nPressione Enter para retornar ao menu principal.");
                    scanner2.nextLine();
                    break;
                case 5:
                    Procedimento.atualizarStatusPaciente();
                    System.out.println("\nPressione Enter para retornar ao menu principal.");
                    scanner2.nextLine();
                    break;
                case 6:
                    Relatorio.relatorio();
                    System.out.println("\nPressione Enter para retornar ao menu principal.");
                    scanner2.nextLine();
                    break;
            }
        }
    }
}
