package cl.utalca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InventarioLetras inv = new InventarioLetras("Probando si los métodos funcionan"); //Objeto InventarioLetras
        System.out.println("size: " + inv.size());
        System.out.println("isEmpty: " + inv.isEmpty());
        System.out.println("get('o'): " + inv.get('o'));
        System.out.println("toString: " + inv.toString()); //Probando toString

        inv.set('a', 9); //Probando el set
        System.out.println("size: " + inv.size());
        System.out.println("toString: " + inv.toString());

        inv.set('a', 0); //Probando el set
        System.out.println("size: " + inv.size());
        System.out.println("toString: " + inv.toString());

        //Probando Encriptar y Desencriptar CON DESPLAZAMIENTO
        System.out.println("Encriptar Cesar letra B: " + inv.encriptarCesar('b', 2));
        System.out.println("Encriptar Cesar letra X: " + inv.encriptarCesar('x', 1));
        System.out.println("Desencriptar Cesar letra E: " + inv.desencriptarCesar('_', 1));

        System.out.println(inv.encriptarPalabra("Xilofono", 4));
        System.out.println(inv.desencriptarPalabra("bmpsjsrs", 4));

        //Probando add, amplifies y subtract
        InventarioLetras inv1 = new InventarioLetras("Alan Turing");
        InventarioLetras inv2 = new InventarioLetras("Ada Lovelace");
        InventarioLetras suma = inv1.add(inv2);
        InventarioLetras resta = inv1.subtract(inv2);
        InventarioLetras producto = inv1.amplifies(2);
        System.out.println(suma);
        System.out.println(resta);
        System.out.println(producto);
    }
}

//AQUÍ VA EL MENÚ