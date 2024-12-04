
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author sebas
 */
public class simulador_Futbol {

    public static class Jugador {
        String nombre;
        String posicion;
        int edad;
        int goles;

        public Jugador(String nombre, String posicion, int edad) {
            this.nombre = nombre;
            this.posicion = posicion;
            this.edad = edad;
            this.goles = 0;
        }
    }

    public static class Equipo {
        String nombre;
        List<Jugador> jugadores;
        int golesTotales;

        public Equipo(String nombre) {
            this.nombre = nombre;
            this.jugadores = new ArrayList<>();
            this.golesTotales = 0;
        }

        public void agregarJugador(Jugador jugador) {
            jugadores.add(jugador);
        }
    }

    public static void main(String[] args) {
        Equipo equipoA = new Equipo("Equipo A");
        Equipo equipoB = new Equipo("Equipo B");
        
        generarJugadores(equipoA);
        generarJugadores(equipoB);
        
        simularPartido(equipoA);
        simularPartido(equipoB);
        
        System.out.println("LISTADO DE JUGADORES POR EQUIPO:");
        mostrarJugadores(equipoA);
        mostrarJugadores(equipoB);
        
        System.out.println("\nESTADÍSTICAS DEL PARTIDO:");
        System.out.println("Goles " + equipoA.nombre + ": " + equipoA.golesTotales);
        System.out.println("Goles " + equipoB.nombre + ": " + equipoB.golesTotales);
        
        if (equipoA.golesTotales > equipoB.golesTotales) {
            System.out.println("Equipo ganador: " + equipoA.nombre);
        } else if (equipoA.golesTotales < equipoB.golesTotales) {
            System.out.println("Equipo ganador: " + equipoB.nombre);
        } else {
            System.out.println("Empate en tiempo reglamentario. Simulando tanda de penales...");
            simularPenales(equipoA, equipoB);
        }
    }

    public static void generarJugadores(Equipo equipo) {
        String[] posiciones = {"Portero", "Defensa", "Mediocampista", "Delantero"};
        Random random = new Random();
        for (int i = 1; i <= 11; i++) {
            String nombre = equipo.nombre + " Jugador " + i;
            String posicion = posiciones[random.nextInt(posiciones.length)];
            int edad = random.nextInt(15) + 18;
            equipo.agregarJugador(new Jugador(nombre, posicion, edad));
        }
    }

    public static void simularPartido(Equipo equipo) {
        Random random = new Random();
        for (Jugador jugador : equipo.jugadores) {
            int goles = random.nextInt(3);
            jugador.goles = goles;
            equipo.golesTotales += goles;
        }
    }

    public static void mostrarJugadores(Equipo equipo) {
        System.out.println("\n" + equipo.nombre + ":");
        System.out.printf("%-20s %-15s %-5s %-5s\n", "NOMBRE", "POSICIÓN", "EDAD", "GOLES");
        for (Jugador jugador : equipo.jugadores) {
            System.out.printf("%-20s %-15s %-5d %-5d\n", jugador.nombre, jugador.posicion, jugador.edad, jugador.goles);
        }
    }

    public static void simularPenales(Equipo equipoA, Equipo equipoB) {
        Random random = new Random();
        int penalesEquipoA = 0;
        int penalesEquipoB = 0;
        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) {
                penalesEquipoA++;
            }
            if (random.nextBoolean()) {
                penalesEquipoB++;
            }
        }
        System.out.println("\nResultado de los penales:");
        System.out.println("Goles en penales " + equipoA.nombre + ": " + penalesEquipoA);
        System.out.println("Goles en penales " + equipoB.nombre + ": " + penalesEquipoB);
        if (penalesEquipoA > penalesEquipoB) {
            System.out.println("Equipo ganador: " + equipoA.nombre);
        } else if (penalesEquipoA < penalesEquipoB) {
            System.out.println("Equipo ganador: " + equipoB.nombre);
        } else {
            System.out.println("Empate en penales. Se debe realizar una nueva tanda.");
            simularPenales(equipoA, equipoB);
        }
    }
}

/***
 * run:
LISTADO DE JUGADORES POR EQUIPO:

Equipo A:
NOMBRE               POSICIÓN        EDAD  GOLES
Equipo A Jugador 1   Portero         29    0    
Equipo A Jugador 2   Portero         22    0    
Equipo A Jugador 3   Defensa         27    1    
Equipo A Jugador 4   Portero         20    1    
Equipo A Jugador 5   Delantero       26    1    
Equipo A Jugador 6   Portero         30    2    
Equipo A Jugador 7   Portero         28    1    
Equipo A Jugador 8   Delantero       24    0    
Equipo A Jugador 9   Defensa         30    2    
Equipo A Jugador 10  Mediocampista   28    0    
Equipo A Jugador 11  Portero         25    1    

Equipo B:
NOMBRE               POSICIÓN        EDAD  GOLES
Equipo B Jugador 1   Mediocampista   23    0    
Equipo B Jugador 2   Defensa         24    0    
Equipo B Jugador 3   Portero         22    1    
Equipo B Jugador 4   Portero         26    2    
Equipo B Jugador 5   Delantero       21    1    
Equipo B Jugador 6   Defensa         29    0    
Equipo B Jugador 7   Mediocampista   29    2    
Equipo B Jugador 8   Defensa         23    2    
Equipo B Jugador 9   Portero         25    1    
Equipo B Jugador 10  Portero         28    2    
Equipo B Jugador 11  Portero         26    0    

ESTADÍSTICAS DEL PARTIDO:
Goles Equipo A: 9
Goles Equipo B: 11
Equipo ganador: Equipo B
BUILD SUCCESSFUL (total time: 0 seconds)
* 
* 
* run:
LISTADO DE JUGADORES POR EQUIPO:

Equipo A:
NOMBRE               POSICIÓN        EDAD  GOLES
Equipo A Jugador 1   Portero         29    1    
Equipo A Jugador 2   Mediocampista   20    0    
Equipo A Jugador 3   Portero         31    1    
Equipo A Jugador 4   Mediocampista   23    1    
Equipo A Jugador 5   Portero         23    0    
Equipo A Jugador 6   Defensa         18    0    
Equipo A Jugador 7   Portero         26    1    
Equipo A Jugador 8   Delantero       30    0    
Equipo A Jugador 9   Mediocampista   20    0    
Equipo A Jugador 10  Defensa         26    2    
Equipo A Jugador 11  Delantero       31    0    

Equipo B:
NOMBRE               POSICIÓN        EDAD  GOLES
Equipo B Jugador 1   Defensa         19    1    
Equipo B Jugador 2   Portero         29    1    
Equipo B Jugador 3   Defensa         18    0    
Equipo B Jugador 4   Defensa         20    2    
Equipo B Jugador 5   Portero         27    1    
Equipo B Jugador 6   Mediocampista   30    1    
Equipo B Jugador 7   Delantero       26    1    
Equipo B Jugador 8   Portero         32    1    
Equipo B Jugador 9   Defensa         31    2    
Equipo B Jugador 10  Defensa         27    2    
Equipo B Jugador 11  Portero         21    2    

ESTADÍSTICAS DEL PARTIDO:
Goles Equipo A: 6
Goles Equipo B: 14
Equipo ganador: Equipo B
BUILD SUCCESSFUL (total time: 0 seconds)
 */