//Proyecto Nro. 1 Inventario Letras - Francisco Ramírez

package cl.utalca;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        InventarioLetras inv1 = null;
        InventarioLetras inv2 = null;

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n------ MENU INVENTARIO DE LETRAS ------\n");
            System.out.println("1) Crear inventario");
            System.out.println("2) Ver inventario(s)");
            System.out.println("3) Consultar letra");
            System.out.println("4) Modificar letra");
            System.out.println("5) Encriptar palabra");
            System.out.println("6) Desencriptar palabra");
            System.out.println("7) Sumar inventarios");
            System.out.println("8) Restar inventarios");
            System.out.println("9) Amplificar inventario");
            System.out.println("0) Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                if (inv1 == null) {
                    System.out.print("Ingrese un texto para el primer inventario: ");
                    String texto = sc.nextLine();
                    inv1 = new InventarioLetras(texto);
                    System.out.println("Inventario 1 creado correctamente.");
                    System.out.println("Recuerda que maximo puedes crear 2 inventarios!");
                } else if (inv2 == null) {
                    System.out.print("Ingrese un texto para el segundo inventario: ");
                    String texto = sc.nextLine();
                    inv2 = new InventarioLetras(texto);
                    System.out.println("Inventario 2 creado correctamente.");
                    System.out.println("Recuerda que maximo puedes crear 2 inventarios!");
                } else {
                    System.out.println("Ya existen dos inventarios creados.");
                    System.out.println("Desea borrarlos y empezar de nuevo?");
                    System.out.println("1) Borrar inventarios --- 2) Conservar inventarios");
                    int opcion2 = sc.nextInt();
                    sc.nextLine();

                    if (opcion2 == 1) {
                        inv1 = null;
                        inv2 = null;
                        System.out.println("Inventarios borrados correctamente.");
                    } else {
                        System.out.println("Inventarios conservados.");
                    }
                }

            } else if (opcion == 2) {
                if (inv1 == null) {
                    System.out.println("Debe crear al menos un inventario primero.");
                } else {
                    System.out.println("Inventario 1: " + inv1);
                    if (inv2 == null) {
                        System.out.println("Inventario 2: Aun no creado.");
                    } else {
                        System.out.println("Inventario 2: " + inv2);
                    }
                }

            } else if (opcion == 3) {
                if (inv1 == null) {
                    System.out.println("Debe crear el inventario 1 primero.");
                } else {
                    System.out.print("Ingrese una letra: ");
                    char letra = sc.nextLine().charAt(0);
                    System.out.println("Conteo de '" + letra + "'en el inventario 1: " + inv1.get(letra));
                    if (inv2 == null) {
                        System.out.println("Inventario 2: Aun no creado.");
                    } else {
                        System.out.println("Conteo de '" + letra + "'en el inventario 2: " + inv2.get(letra));
                    }
                }

            } else if (opcion == 4) {
                if (inv1 == null) {
                    System.out.println("Debe crear al menos un inventario primero.");
                } else {
                    System.out.println("Que inventario desea modificar?");
                    System.out.println("1) Inventario 1 --- 2) Inventario 2");
                    int opcion2 = sc.nextInt();
                    sc.nextLine();

                    InventarioLetras inv = null;
                    if (opcion2 == 1) {
                        inv = inv1;
                    } else if (opcion2 == 2) {
                        if (inv2 == null) {
                            System.out.println("El inventario 2 aun no ha sido creado.");
                        } else {
                            inv = inv2;
                        }
                    }
                    if (inv != null) {
                    System.out.print("Ingrese una letra: ");
                    char letra = sc.nextLine().charAt(0);
                    System.out.print("Ingrese el nuevo valor: ");
                    int valor = sc.nextInt();
                    sc.nextLine();
                    inv.set(letra, valor);
                    System.out.println("Letra modificada correctamente.");
                    }
                }

            } else if (opcion == 5) {
                System.out.print("Ingrese una palabra a encriptar: ");
                String palabra = sc.nextLine();
                System.out.print("Ingrese el desplazamiento: ");
                int desplazamiento = sc.nextInt();
                sc.nextLine();
                System.out.println("Palabra encriptada: " + new InventarioLetras("").encriptarPalabra(palabra, desplazamiento));

            } else if (opcion == 6) {
                System.out.print("Ingrese una palabra a desencriptar: ");
                String palabra = sc.nextLine();
                System.out.print("Ingrese el desplazamiento: ");
                int desplazamiento = sc.nextInt();
                sc.nextLine();
                System.out.println("Palabra desencriptada: " + new InventarioLetras("").desencriptarPalabra(palabra, desplazamiento));

            } else if (opcion == 7) {
                if (inv1 == null || inv2 == null) {
                    System.out.println("Debe crear ambos inventarios primero.");
                } else {
                    InventarioLetras suma = inv1.add(inv2);
                    System.out.println("Suma de inventarios: " + suma);
                }

            } else if (opcion == 8) {
                if (inv1 == null || inv2 == null) {
                    System.out.println("Debe crear ambos inventarios primero.");
                } else {
                    InventarioLetras resta = inv1.subtract(inv2);
                    if (resta == null) {
                        System.out.println("No se puede restar, algun resultado seria negativo.");
                    } else {
                        System.out.println("Resta de inventarios: " + resta);
                    }
                }

            } else if (opcion == 9) {
                if (inv1 == null) {
                    System.out.println("Debe crear el inventario 1 primero.");
                } else {
                    System.out.print("Ingrese por cuanto desea amplificar: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inventario amplificado: " + inv1.amplifies(n));
                }

            } else if (opcion == 0) {
                System.out.println("Saliendo...");

            } else {
                System.out.println("Opcion no valida.");
            }
        }
    }
}