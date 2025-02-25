import kotlin.random.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
   var jugador_1 = IntArray(10) {Random.nextInt(1,7)} // Jugador 1 Lanza De Manera Aleatoria 10 Dados resultados posibles (1 a 6)
    var jugador_2 = IntArray(10) {Random.nextInt(1,7)} // Jugador 2 Lanza De Manera Aleatoria 10 Dados resultados posibles (1 a 6)
    val suma_jugador_1 = jugador_1.sum()
    val suma_jugador_2 = jugador_2.sum()
    println("Jugador 1: ${jugador_1.joinToString(" , ")}")
    println("Total del jugador 1: $suma_jugador_1")
    println("Jugador 2: ${jugador_2.joinToString(" , ")}")
    println("Total del jugador 2: $suma_jugador_2")
    when{
        suma_jugador_1 > suma_jugador_2 -> println("Ganador: Jugador 1 Con ${suma_jugador_1} Puntos")
        suma_jugador_2 > suma_jugador_1 -> println("Ganador: Jugador 2 Con ${suma_jugador_2} Puntos")
    }
}