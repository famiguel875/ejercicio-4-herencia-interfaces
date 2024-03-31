/**
 * Clase de utilidad para gestionar mensajes de log y errores.
 */
class GestorMensajes {
    companion object {
        /**
         * Registra un mensaje de log.
         * @param texto El texto del mensaje de log.
         */
        fun log(texto: String) {
            println("[LOG] $texto")
        }

        /**
         * Registra un mensaje de error.
         * @param texto El texto del mensaje de error.
         */
        fun error(texto: String) {
            println("[ERROR] $texto")
        }
    }
}