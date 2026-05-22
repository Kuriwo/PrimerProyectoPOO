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

        //Probando Encriptar y Desencriptar, Funciona perfecto, exceptuando que no puede encriptar de X en adelante
        System.out.println("Encriptar Cesar letra B: " + inv.encriptarCesar('b'));
        System.out.println("Desencriptar Cesar letra X: " + inv.encriptarCesar('X')); //MALO, si es de X en adelante
        System.out.println("Desencriptar Cesar letra E: " + inv.desencriptarCesar('e'));

        System.out.println(inv.encriptarPalabra("Probando encriptar", 3)); //Necesario decidir qué hacer con el parámetro desplazamiento, actualmente es inútil
        System.out.println(inv.desencriptarPalabra("suredqgr#hqfulswdu", 3));
    }
}

//AQUÍ VA EL MENÚ