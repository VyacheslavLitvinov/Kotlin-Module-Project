import java.util.Scanner
import kotlin.system.exitProcess

open class Navigation{

    val scanner = Scanner(System.`in`)

    open fun input(text: String): String {
        var input = ""
        while (input.isBlank()) {
            println(text)
            input = scanner.nextLine().trim()
            if (input.isBlank()) {
                println("Вы ничего не ввели.")
            }
        }
        return input
    }

    fun inputSome(): String? {
        print("\nВведите любой символ или нажимте Enter чтобы вернуться обратно: ")
        return readlnOrNull()
    }

    fun exit(){
        println("\nЗавершение работы программы.")
        exitProcess(0)
    }
}