package untils

import java.util.concurrent.TimeUnit

class Pausa {
    fun pausar(segundos: Long) {
        try {
            TimeUnit.SECONDS.sleep(segundos)
        } catch (e: InterruptedException) {
            println("Erro ao pausar por $segundos segundos")
        }
    }
}