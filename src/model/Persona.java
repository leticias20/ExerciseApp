package model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private List<Viaje> lista = new ArrayList<Viaje>();

    public Persona(String nombre) {
        super();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addViaje(Viaje v) {
        lista.add(v);
    }

    public List<Viaje> getLista() {
        return lista;
    }
}