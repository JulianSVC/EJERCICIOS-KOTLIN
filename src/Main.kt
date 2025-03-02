import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    var intentos = 0
    val maximoIntetos =2

    while (intentos < maximoIntetos) {
        println("Ingrese su còdigo:")
        val codigo = scanner.nextInt()
        when{
            codigo in 999..1999 ->{
            println("El còdigo es correcto bienvenido empleado: ${codigo}")
        }
            codigo in 2000..2999 ->{
                scanner.nextLine()
                println("Ingrese su nombre:")
                val nombre = scanner.nextLine()
                println("Motivo de su visita:")
                val  motivo = scanner.nextLine()
                println("Bienvenido, ${nombre}, ya puede ingresar. su motivo ${motivo}")
                return
            }
            else ->{
                println("Còdigo incorrecto, intente nuevamente.")
                intentos++
                if (intentos<maximoIntetos){
                    println("Còdigo incorrecto, intente nuevamente. Intentos ${intentos}/${maximoIntetos}")

                }else{
                    println("Se han superado el número máximo de intentos.Sitema bloqueado")
                }
            }
        }
    }
}