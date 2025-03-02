import kotlin.random.Random

fun main() {
    println("Bienvenido al juego del apostador, digite el dinero a ingresar!")
    var dineroIngresado = readln().toInt()
    if (dineroIngresado <= 0) {
        println("Debe ingresar una cantidad válida para jugar")
        return
    }

    while (true) {
        println("Dinero actual: $dineroIngresado")

        val numeroRandom = Random.nextInt(1, 4) // Generar un nuevo número en cada iteración

        when (numeroRandom) {
            1 -> {
                dineroIngresado *= 2
                println("¡Felicitaciones! Ganaste el doble de tu dinero: $dineroIngresado")
            }
            2 -> {
                dineroIngresado /= 2
                println("Perdiste la mitad de tu dinero: $dineroIngresado")
            }
            3 -> {
                dineroIngresado = 0
                println("Perdiste todo tu dinero. Fin del juego")
            }
        }

        if (dineroIngresado <= 0) {
            println("Perdiste tu dinero. Se acabó el juego")
            break
        }

        println("¿Quieres seguir jugando? (si/no)")
        val respuesta = readln().trim().lowercase()

        if (respuesta == "no") {
            println("Decidiste retirarte con tu dinero: $dineroIngresado")
            break
        }
    }
}
