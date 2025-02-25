//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var moneda_1 = 20
    var moneda_2 = 50
    var moneda_3 = 100
    var moneda_4 = 200
    var moneda_5 = 500
    var cantidad_20=0
    var cantidad_50=0
    var cantidad_100=0
    var cantidad_200=0
    var cantidad_500=0
    var  total = 0
    var opcion:Int


    do {
        println("""Seleciona una opción: 
            |1. Agregar Monedas
            |2. Contar Monedas
            |3. Calcular Monedas
            |4. Romper Alncancia 
            |""".trimIndent())
        opcion = readLine()!!.toInt()
        when(opcion){
            1 ->{
                var dato_ingresado: Int
                do {
                    println("""
                        Introduce el tipo de moneda que se desea ingresar:
                        1.${moneda_1}
                        2.${moneda_2}
                        3.${moneda_3}
                        4.${moneda_4}
                        5.${moneda_5}
                    """.trimIndent())
                    dato_ingresado = readLine()!!.toInt()
                }while (dato_ingresado !in 1..5)
                    when(dato_ingresado){
                        1 -> cantidad_20++
                        2 -> cantidad_50++
                        3 -> cantidad_100++
                        4 -> cantidad_200++
                        5 -> cantidad_500++
                    }
                println("Moneda Agregada Correctamente")
            }
            2 ->{
                println("""
                    Cantidad de monedas en la alcancia:
                     Monedas de 20 : ${cantidad_20}
                     Monedas de 50 : ${cantidad_50}
                     Monedas de 100 : ${cantidad_100}
                     Monedas de 200 : ${cantidad_200}
                     Monedas de 500 : ${cantidad_500}
                """.trimIndent())
            }
            3 ->{
                total= (cantidad_20*moneda_1)+(cantidad_50*moneda_2)+(cantidad_100*moneda_3)+(cantidad_200*moneda_4)+ (cantidad_500*moneda_5)
                println("Total ahorrado ${total}")
            }
            4 ->{
                total= (cantidad_20*moneda_1)+(cantidad_50*moneda_2)+(cantidad_100*moneda_3)+(cantidad_200*moneda_4)+ (cantidad_500*moneda_5)
                println("La alcancia se ha roto")
                cantidad_20 = 0
                cantidad_50 = 0
                cantidad_100 = 0
                cantidad_200 = 0
                cantidad_500 = 0
                total = 0
            }
            5-> println("Saliendo del programa")
            else -> println("Opcion no valida intentalo de nuevo")
        }
    }while (opcion !=5)

}