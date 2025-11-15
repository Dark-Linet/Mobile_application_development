package Practical_work_1

fun main()
{
    println("=== Простой калькулятор ===")
    println("Введите два числа и операцию через пробел")
    println("Пример: 10.5 2.5 +")
    // Чтение ввода и разделение строки по пробелам на список строк
    val input = readln().split(" ")
    val a = input[0].toDouble()
    val b = input[1].toDouble()
    val op = input[2]         // Получение третьего элемента списка (операции) как строки

    val result = when (op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> if (b != 0.0) a / b else "Ошибка: деление на ноль"
        else -> "Ошибка: неизвестная операция"
    }

    println("Результат: $result")
}