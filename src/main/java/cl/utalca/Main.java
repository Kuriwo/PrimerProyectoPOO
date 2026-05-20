package cl.utalca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InventarioLetras inv = new InventarioLetras("Probando si los métodos funcionan"); //Objeto InventarioLetras
        System.out.println("size: " + inv.size());
        System.out.println("isEmpty: " + inv.isEmpty());
        System.out.println("get('o'): " + inv.get('o'));
    }
}

//AQUÍ VA EL MENÚ