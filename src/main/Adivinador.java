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
     *     <li><b> GANIO:</b> El jugador adivino el numero secreto antes de agotar los intentos.</li>
     *     <li><b> PERDIO: </b> EL jugador agoto los intentos antes de adivinar el numero secreto.</li>
     * </ul>
     */

    public static enum Estado {JUGANDO, GANO, PERDIO}

    /**
     * Se utilizara para comparar el numero ingresado por el usuario frente al
     * numero secreto
     */
    public static enum Resultado {ES_MAYOR, ES_IGUAL, ES_MENOR}

    public static record Juego (
            Dificultad[] dificultad,
            AtomicInteger maxIntentos,
            Estado[] estado,
            AtomicInteger numeroSecreto,
            AtomiInteger intentoActal,
    ){}




}


    /**
     * Logica del juego
     * @param args
     */

    public static void main(String[] args) {

    }
}
