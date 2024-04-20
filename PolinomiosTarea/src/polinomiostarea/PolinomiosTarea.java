/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package polinomiostarea;

/**
 *
 * @author LEGCIUS
 */
import java.util.Scanner;
class Nodo {
    int coeficiente;
    int exponente;
    Nodo siguiente;

    public Nodo(int coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }
}

class Polinomio {
    Nodo inicio;

    public Polinomio() {
        this.inicio = null;
    }

    public void insertar(int coeficiente, int exponente) {
        Nodo nuevoNodo = new Nodo(coeficiente, exponente);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }
    
    //En esta parte se resuelven los polinomios con todos los valores de X desde 0.0 hasta 5.0
       public double resolver(double x) {
        double resultado = 0;
        Nodo temp = inicio;
        while (temp != null) {
            resultado += temp.coeficiente * Math.pow(x, temp.exponente);
            temp = temp.siguiente;
        }
        return resultado;
    }
}

public class PolinomiosTarea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polinomio polinomio = new Polinomio();

        System.out.println("Ingrese los términos del polinomio (coeficiente y "
                + "exponente separados por un espacio y si el numero no cuenta\n"
                + "con un exponente pon un 0), " +
                "ingrese 'res' para terminar:");

         //Este while nos permite agregar la cantidad de polinomios que queramos
         //hasta que este lo finalize el usuario poniendo res 
          while (true) {
            //Salva vidas
            try {
                
                System.out.print("Polinomio: ");
                String entrada = scanner.nextLine();
                if (entrada.equals("res")) {
                    break;
                }
                // Divide la entrada del usuario en partes separadas por un espacio
                // y convierte las partes en enteros para el coeficiente y el exponente.
                String[] partes = entrada.split(" ");
                int coeficiente = Integer.parseInt(partes[0]);
                int exponente = Integer.parseInt(partes[1]);
                polinomio.insertar(coeficiente, exponente);
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un formato válido para el "
                        + "coeficiente y el exponente.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Debes ingresar tanto el coeficiente "
                        + "como el exponente.");
            }
        }
        System.out.println("Valor de la x      |         Respuesta");
        
        //Con este for cambiamos el valor de X hasta llegar a 5 y se muestran las respuestas
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double resultado = polinomio.resolver(x);
            System.out.println( "     "+ x +"           |            " + resultado);
        }
    }
}