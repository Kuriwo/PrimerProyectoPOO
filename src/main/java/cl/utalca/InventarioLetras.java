package cl.utalca;

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
        }
        int indice = letra - 'a';
        return inventario[indice]; //Retorna las veces que una letra fue registrada en el inventario
    }

    public void set(char letra, int valor) {
        letra = Character.toLowerCase(letra);

        if (letra < 'a' || letra > 'z' || valor < 0) { //Se valida que la letra cumpla con los requisitos
            throw new IllegalArgumentException("Letra no valida");
        }
        int indice = letra - 'a';
        totalCount = totalCount + (valor - inventario[indice]); //La resta nos indica en cuanto debemos aumentar totalCount y se lo sumamos
        if (inventario[indice] == 0 && valor > 0) { //Verifica si la letra NO está registrada y si se agregó en "valor" (es decir, se debe registrar)
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

    public char encriptarCesar(char letra, int desplazamiento) {
        letra = Character.toLowerCase(letra);
        int indice =  letra - 'a';

        if (indice + desplazamiento <= 25) { //Excluye las letras que al sumarles el desplazamiento superan la posición 25 (Z en el alfabeto inglés)
            return letra = (char) (letra + desplazamiento); //Suma desplazamiento al valor ASCII de la letra, significa que avanza n letras en el abecedario
        }else{
            return letra = (char) ((indice + desplazamiento) - 26 + 'a'); //La letra supera la Z, por lo que "da la vuelta" al inicio del alfabeto
        }
    }

    public char desencriptarCesar(char letra, int desplazamiento) {
        letra = Character.toLowerCase(letra);
        int indice = letra - 'a';

        if (indice - desplazamiento >= 0) { //Incluye las letras que al restarles el desplazamiento son mayores que 0 (indica que no deben "dar vuelta" el alfabeto)
            return letra = (char) (letra - desplazamiento); //Resta desplazamiento, significa que retrocede 3 letras en el abecedario
        }else{
            return (char)((indice - desplazamiento) + 26 + 'a'); //La letra debe retroceder más allá de A, por lo que "da la vuelta" al final del alfabeto
        }
    }

    public String encriptarPalabra (String palabra, int desplazamiento) {
       palabra = palabra.toLowerCase();
       String palabraEncriptada = ""; //Almacena la palabra encriptada

       for (int i = 0; i < palabra.length(); i++) { //Recorre término por término
           char letra = palabra.charAt(i); //Extrae la letra específica en la posición "i"
           palabraEncriptada = palabraEncriptada + encriptarCesar(letra, desplazamiento); //Aplica el encriptado letra por letra
       }
        return palabraEncriptada;
    }

    public String desencriptarPalabra (String palabra, int desplazamiento) { //Hace lo mismo que encriptarPalabra pero aplicando desencriptadoCesar
        palabra = palabra.toLowerCase();
        String palabraDesencriptada = "";

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            palabraDesencriptada = palabraDesencriptada + desencriptarCesar(letra, desplazamiento);
        }
        return palabraDesencriptada;
    }

    public InventarioLetras add(InventarioLetras otro) {
        InventarioLetras suma = new InventarioLetras(""); //Se guarda la suma de inventarios

        for(int i = 0; i < 26; i++) {
            char letra = (char)(i + 'a');
            suma.set(letra, this.get(letra) + otro.get(letra)); //Suma letra por letra el inventario "actual" con el otro inventario
        }
        return suma;
    }

    public InventarioLetras subtract(InventarioLetras otro) {
        InventarioLetras resta = new InventarioLetras(""); //Se guarda la resta de inventarios

        for(int i = 0; i < 26; i++) {
            char letra = (char)(i + 'a');
            if (this.get(letra) - otro.get(letra) < 0) { //Si la resta de letras es negativa retorna null
                return null;
            }
            resta.set(letra, this.get(letra) - otro.get(letra)); //Resta letra por letra el inventario "actual" con el otro inventario
        }
        return resta;
    }

    public InventarioLetras amplifies(int n) {
        InventarioLetras producto = new InventarioLetras(""); //Se guarda el producto de la multiplicación

        for(int i = 0; i < 26; i++) {
            char letra = (char)(i + 'a');
            producto.set(letra, this.get(letra) * n); //Multiplica cada letra por n
        }
        return producto;
    }
}