package Practical_work_1

fun main()
{
    println("Программа проверяет, существует ли показатель степени y для которого выполняется равенство x^y = n")
    print("Введите число n: ")
    val n = readln().toInt()

    print("Введите основание x: ")

    val x = readln().toInt()

    var y = 0
    var power = 1

    while (power < n)
    {
        power *= x
        y++
    }

    if (power == n)
        println("Показатель степени: $y")
    else
        println("Целочисленный показатель не существует")
}