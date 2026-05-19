package cl.utalca;
//RECORDATORIO: Ver si nonZeroCount tiene otra función además de isEmpty, porque de ser solo esa, se debería poder usar totalCount para la misma función
public class InventarioLetras {

    //Se definen los atributos privados
    private int[] inventario;
    private int totalCount;
    private int nonZeroCount;

    public InventarioLetras(String data) {
        inventario = new int[26]; //Se define el tamaño del Array como el tamaño del alfabeto inglés
        data = data.toLowerCase(); //El String pasa a minúsculas para "ignorar" mayúsculas

        //Recorre cada letra del String.
        for (int i = 0; i < data.length(); i++) {
            char letra = data.charAt(i); //Extrae la letra específica en la posición "i"
            if (letra >= 'a' && letra <= 'z') { //Comprueba si la letra es del alfabeto inglés (compara los valores ASCII)
                int indice = letra - 'a'; //Indíca el índice de posición de la letra en el Array (resta los valores ASCII, los cuales son consecutivos)
                if (inventario[indice] == 0) {
                    nonZeroCount++; //Cuenta cuantas letras dístintas hay (Se usará para is Empty)
                }
                inventario[indice]++; //Suma 1 al índice (para llevar la cuenta de cuantas veces aparece cada letra)
                totalCount++; //Suma total de las letras registradas
            }
        }
    }
}
