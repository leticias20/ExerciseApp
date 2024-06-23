import model.Persona;
import model.Viaje;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlatMapUsage {

    public static void main(String args[]){

    Persona p = new Persona("pedro");
    Viaje v = new Viaje("Francia");
    Viaje v2 = new Viaje("Inglaterra");
        p.addViaje(v);
        p.addViaje(v2);
    Persona p1 = new Persona("gema");
    Viaje v3 = new Viaje("Italia");
    Viaje v4 = new Viaje("Belgica");
        p1.addViaje(v3);
        p1.addViaje(v4);
    List<Persona> lista = new ArrayList<Persona>();
        lista.add(p);
        lista.add(p1);

        lista.stream()
                .map(persona -> persona.getLista())
                .flatMap(viajes -> viajes.stream()).forEach( viajes -> System.out.println(LocalDateTime.now() + " " +  viajes.getPais()));
    }


}
