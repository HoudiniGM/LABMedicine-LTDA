import java.util.ArrayList;
import java.util.List;

public class Lista {
    private static List<Medico> listaMedicos = new ArrayList<>();
    private static List<Enfermeiro> listaEnfermeiros = new ArrayList<>();


    public static List<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public static void setMedico(Medico medico){
        getListaMedicos().add(medico);
    }

    public static List<Enfermeiro> getListaEnfermeiros(){
        return listaEnfermeiros;
    }

    public static void setEnfermeiro(Enfermeiro enfermeiro){
        getListaEnfermeiros().add(enfermeiro);
    }


}
