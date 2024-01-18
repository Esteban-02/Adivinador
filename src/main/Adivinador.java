public class Adivinador {
    /*
    Cantidad maxima de intentos en dificualtad falcil
     */
    public static int MAX_INTENTOS_FACIL = 15;
    /*
    cantidad macima de intentos en dificultad dificil
     */
    public static int MAX_INTENTOS_DIFICIL = 10;
    /**
     * numero maximo posible de eleccion. Se generara un valor al azar entre 1
     * y el NUMERO_MAXIMO
     */
    public static int NUMERO_MAXIMO = 100;

    /**
     * Las dificuldes disponibles en el juego
     * <ul>
     *     <li><b> JUGANDO: </b> El juego ha iniciado. No se ha ganado aun, ni se ha perdido.</li>
     *     <li><b> GANIO:</b> El jugad qor adivino el numero secreto antes de agotar los intentos.</li>
     *     <li><b> PERDIO: </b> EL jugador agoto los intentos antes de adivinar el numero secreto.</li>
     * </ul>
     */

    public static enum Estado {JUGANDO, GANO, PERDIO}

    /**
     * Se utilizara para comparar el numero ingresado por el usuario frente al
     * numero secreto
     */
    public static enum Resultado {ES_MAYOR, ES_IGUAL, ES_MENOR}

    /**
     * Modelo de juego: <br>
     * <ul><li><b>Dificultad:</b> Arreglo de una celda conteniendo la dificultad del juego</li>
     * <li><b>maxIntentos:</b> Cantidad maxima de intentos con que se inicio el juego segun su dificultad.</li>
     * <li><b>estado:</b> Arreglo de la celda conteniendo el estado actual del juego.</li>
     * <li><b>numSecreto:</b> El numero secreto generado aleatoriamente entre el 1 y el NUMERO_MAXIMO.</li>
     * <li><b>intentoActual:</b> El intento actual del jugador</li>
     * </ul>
     */

    public static record Juego (
            Dificultad[] dificultad,
            AtomicInteger maxIntentos,
            Estado[] estado,
            AtomicInteger numeroSecreto,
            AtomiInteger intentoActal,
    ){}

    /**
     * Inicializa el juego con los valores correctos acorde a la dificultad asigada.
     * El estado inicial sera JUGANDO y el intento actual sera 0. Tambien se generara
     * un numero aleatorio entre 1 y NUMERO_MAXIMO
     * @param d La dificutad con que se iniciara el juego
     * @return Retorna un juego listo para comenzar
     * @see Dificultad
     * @see Estado
     * @see Juego
     * @see NUMERO_MAXIMO
     */

    public static Juego iniciarJuego(Dificultad d){
        Juego j = new Juego(new Dificultad[1], new AtomicInteger(), Estado[1], new AtomicInteger(), new AtomicInteger());
        j.dificultad[0]=d;
        if (d==Dificultad.FACIL){
            j.maxIntentos.set(MAX_INTENTOS_FACIL);
        }else {
            j.maxIntentos.set(MAX_INTENTOS_DIFICIL);
        }

        j.estado[0]=Estado.JUGANDO;
        j.numeroSecreto.set(new Random().nextInt(NUMERO_MAXIMO)+1;

        return j;
}

    public static Resultado verificarNumero(int n, Juego j, StringBuilder mensaje){
        j.intentoActal.set(j.intentoActal.get()+1);
        mensaje.delete(0,mensaje.lenth());
        Resultado resultado;
        if (n==j.numeroSecreto.get()){
            j.estado[0]= Estado.GANO;
            mensaje.appened("GANASTE!!");
            resultado= Resultado.ES_IGUAL;
        } else if (j.numeroSecreto.get() < n) {
            mensaje.appened("El numero es menor, sigue intentando...");
            Resultado = Resultado.ES_MENOR;
        } else if (j.numeroSecreto.get() > n) {
            mensaje.appened("El numero es mayor");
            Resultado = Resultado.ES_MAYOR;
        }

        if (j.intentoActal.get() == j.maxIntentos.get()){
            mensaje.delete(0,mensaje.lengt());
            mensaje.appened("Perdiste, completeaste el numero maximo de intentos, el numero secreto es: "+j.numeroSecreto.get()+".");
            j.estado[0]=Estado.PERDIO;
        }
        return Resultado;
    }



    /**
     * Logica del juego
     * @param args
     */

    public static void main(String[] args) {

    }
}
