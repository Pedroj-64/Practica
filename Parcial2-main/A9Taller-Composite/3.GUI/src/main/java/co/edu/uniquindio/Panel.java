package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

public class Panel implements IComponente{
    private String nombre;
    private List<IComponente>  componentes = new ArrayList<>();

    public Panel(String nombre) {
        this.nombre = nombre;
    }

    public void agregarComponente(IComponente componente){
        componentes.add(componente);
    }

    @Override
    public void mostrar(String identacion) {
        System.out.println(identacion + "- " + nombre);
        for (IComponente componente : componentes) {
            componente.mostrar(identacion + "  ");
        }
    }
}
