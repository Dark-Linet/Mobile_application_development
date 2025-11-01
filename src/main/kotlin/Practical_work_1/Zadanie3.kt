package Practical_work_1

fun main() {
    print("Введите число: ")
    val number = readln().toInt()
    val binary = number.toString(2)
    println("Двоичное представление: $binary")
}