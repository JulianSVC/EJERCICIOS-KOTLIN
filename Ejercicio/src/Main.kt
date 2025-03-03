import kotlin.random.Random

fun main() {
    val candidatos = listOf("Candidato A", "Candidato B", "Candidato C")
    val costosPublicidad = mapOf(
        "Internet" to 700000,
        "Radio" to 200000,
        "Televisión" to 600000
    )

    val votos = mutableMapOf<String, Int>().apply { candidatos.forEach { put(it, 0) } }
    val costosCampaña = mutableMapOf<String, Int>().apply { candidatos.forEach { put(it, 0) } }

    while (true) {
        println(
            """
            Elecciones para representante del municipio "Premier"
                Seleccione una opción:
                1. Votar
                2. Calcular costo de campaña
                3. Vaciar urnas
                4. Ver total de votos y porcentajes
                5. Ver costo promedio de campaña
                6. Salir
        """.trimIndent()
        )

        when (readln().toIntOrNull()) {
            1 -> {
                println("Seleccione el candidato por el que quiere votar:")
                candidatos.forEachIndexed { index, candidato -> println("${index + 1}. $candidato") }
                val candidatoIndex = readln().toIntOrNull()?.minus(1)

                if (candidatoIndex in candidatos.indices) {
                    val candidato = candidatos[candidatoIndex!!]

                    println("Seleccione el medio que influyó en su voto:")
                    println("1. Internet\n2. Radio\n3. Televisión")
                    val medioIndex = readln().toIntOrNull()

                    val medioPublicidad = when (medioIndex) {
                        1 -> "Internet"
                        2 -> "Radio"
                        3 -> "Televisión"
                        else -> null
                    }

                    if (medioPublicidad != null) {
                        votos[candidato] = votos.getValue(candidato) + 1
                        costosCampaña[candidato] = costosCampaña.getValue(candidato) + costosPublicidad.getValue(medioPublicidad)
                        println("Voto registrado con éxito para $candidato (Publicidad: $medioPublicidad)")
                    } else {
                        println("Opción inválida. Inténtelo de nuevo.")
                    }
                } else {
                    println("Opción inválida. Inténtelo de nuevo.")
                }
            }

            2 -> {
                println("\n--- Costos de Campaña ---")
                candidatos.forEach { candidato ->
                    println("$candidato: $${costosCampaña.getValue(candidato)}")
                }
            }

            3 -> {
                votos.keys.forEach { votos[it] = 0 }
                costosCampaña.keys.forEach { costosCampaña[it] = 0 }
                println("Las urnas han sido vaciadas.")
            }

            4 -> {
                val totalVotos = votos.values.sum()
                if (totalVotos == 0) {
                    println("Aún no hay votos registrados.")
                } else {
                    println("\n--- Resultados Electorales ---")
                    candidatos.forEach { candidato ->
                        val porcentaje = (votos.getValue(candidato).toDouble() / totalVotos) * 100
                        println("$candidato: ${votos.getValue(candidato)} votos (${String.format("%.2f", porcentaje)}%)")
                    }
                    println("Total de votos: $totalVotos")
                }
            }

            5 -> {
                val totalCosto = costosCampaña.values.sum()
                val totalVotos = votos.values.sum()

                if (totalVotos == 0) {
                    println("No hay votos registrados, el costo promedio no puede calcularse.")
                } else {
                    val costoPromedio = totalCosto / totalVotos
                    println("Costo promedio de campaña: $$costoPromedio por voto.")
                }
            }

            6 -> {
                println("Saliendo del sistema...")
                break
            }

            else -> println("Opción inválida. Inténtelo nuevamente.")
        }
    }
}
