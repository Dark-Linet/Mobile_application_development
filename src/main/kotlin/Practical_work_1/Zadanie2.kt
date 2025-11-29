package Practical_work_1

fun main() {
    println("Введите строку из английских символов: ")
    val stroka = readln()


    val result = stroka
        .groupBy { it }
        .mapValues { it.value.size }
        .toSortedMap()


    for ((char, count) in result)
    {
        println("$char - $count")
    }
    }

