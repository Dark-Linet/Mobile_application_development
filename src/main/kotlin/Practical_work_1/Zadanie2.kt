package Practical_work_1

fun main() {
    println("Введите строку из английских символов: ")
    val stroka = readln()

    // группируем символы и подсчитываем количество
    val result = stroka
        .groupBy { it }// Группируем по символам
        .mapValues { it.value.size } // Заменяем списки на размеры
        .toSortedMap() // Сортируем по ключу (алфавиту)

    // Выводим результат
    for ((char, count) in result)
    {
        println("$char - $count")
    }
    }

