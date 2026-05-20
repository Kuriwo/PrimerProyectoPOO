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

    public int get(char letra) {
        letra = Character.toLowerCase(letra);

        if (letra < 'a' || letra > 'z') {
            throw new IllegalArgumentException("Letra no valida");
        } else {
            int indice = letra - 'a';
            return inventario[indice]; //Retorna las veces que una letra fue registrada en el inventario
        }
    }

    public void set(char letra, int valor) {
        letra = Character.toLowerCase(letra);

        if (letra < 'a' || letra > 'z' || valor < 0) { //Se valida que la letra cumpla con los requisitos
            throw new IllegalArgumentException("Letra no valida");
        }
        int indice = letra - 'a';
        totalCount = totalCount + (valor - inventario[indice]); //La resta nos indica en cuanto debemos aumentar totalCount y se lo sumamos
        if (inventario[indice] == 0 && valor > 0) { //Verifica si la letra NO estaba registrada y si se agregó en "valor" (es decir, se debe registrar)
            nonZeroCount++;
        } else if (inventario[indice] > 0 && valor == 0) { //Verifica si la letra está registrada y si el valor que se le quiere asignar es 0 (es decir, se debe eliminar)
            nonZeroCount--;
        }
        inventario[indice] = valor;
    }


    public int size() {
        return totalCount;
    }

    public boolean isEmpty() {
        return nonZeroCount == 0; //Retorna True si nonZeroCount == 0
    }

    public String toString() {
        String letrasOrdenadas = "";

        for (int i = 0; i < inventario.length; i++) { //Recorre los 26 espacios del Array
            for (int j = 0; j < inventario[i]; j++) { //Indíca cuantas veces se debe agregar la letra
                letrasOrdenadas = letrasOrdenadas + (char)(i + 'a'); //Convierte el valor ASCII en letra y la almacena en letrasOrdenadas
            }
        }
        return letrasOrdenadas;
    }
}