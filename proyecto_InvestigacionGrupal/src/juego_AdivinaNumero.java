
import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class juego_AdivinaNumero {

    public static void main(String[] args) {
        int aleatorio = (int) (Math.random() * 100) + 1;
        int intentosMaximos = 7;
        int intentos = 0;
        int numero = 0;
        Scanner tcl = new Scanner(System.in);

        System.out.println("BIENVENIDO AL JUEGO: ADIVINA EL NUMERO (1-100)");
        System.out.println("Tienes " + intentosMaximos + " intentos para adivinar el numero secreto.");
        System.out.println("Buena suerte!");

        while (intentos < intentosMaximos) {
            System.out.print("Intento " + (intentos + 1) + ": Ingresa tu numero (o -1 para salir): ");
            if (tcl.hasNextInt()) {
                numero = tcl.nextInt();
            } else {
                System.out.println("Por favor, ingresa un numero válido.");
                tcl.next();
                continue;
            }

            if (numero == -1) {
                System.out.println("Gracias por jugar. ¡Hasta la próxima!");
                break;
            }
            if (numero < 1 || numero > 100) {
                System.out.println("Por favor, ingresa un numero entre 1 y 100.");
                continue;
            }

            intentos++;

            if (numero == aleatorio) {
                System.out.println("¡FELICIDADES! Adivinaste el numero en " + intentos + " intento(s).");
                break;
            } else {

                if (aleatorio > numero) {
                    System.out.println("El numero es MAYOR.");
                } else {
                    System.out.println("El numero es MENOR.");
                }

                if (aleatorio % 2 == 0) {
                    System.out.println("Pista: El numero es PAR.");
                } else {
                    System.out.println("Pista: El numero es IMPAR.");
                }

                System.out.println("Te quedan " + (intentosMaximos - intentos) + " intento(s).");
            }
        }

        if (intentos == intentosMaximos && aleatorio != numero) {
            System.out.println("Lo siento, se te acabaron los intentos. El numero era: " + aleatorio);
        }
    }
}
/**
 * *
 * run: BIENVENIDO AL JUEGO: ADIVINA EL NUMERO (1-100) Tienes 7 intentos para
 * adivinar el numero secreto. Buena suerte! Intento 1: Ingresa tu numero (o -1
 * para salir): 34 El numero es MAYOR. Pista: El numero es PAR. Te quedan 6
 * intento(s). Intento 2: Ingresa tu numero (o -1 para salir): 46 El numero es
 * MAYOR. Pista: El numero es PAR. Te quedan 5 intento(s). Intento 3: Ingresa tu
 * numero (o -1 para salir): 68 El numero es MAYOR. Pista: El numero es PAR. Te
 * quedan 4 intento(s). Intento 4: Ingresa tu numero (o -1 para salir): 88 El
 * numero es MENOR. Pista: El numero es PAR. Te quedan 3 intento(s). Intento 5:
 * Ingresa tu numero (o -1 para salir): 78 El numero es MENOR. Pista: El numero
 * es PAR. Te quedan 2 intento(s). Intento 6: Ingresa tu numero (o -1 para
 * salir): 74 ¡FELICIDADES! Adivinaste el numero en 6 intento(s). BUILD
 * SUCCESSFUL (total time: 36 seconds)
 *
 */
