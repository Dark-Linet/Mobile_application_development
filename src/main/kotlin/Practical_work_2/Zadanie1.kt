package Practical_work_2

fun task1() {
    // Запрашиваем размеры массива
    val rows = readPositiveInt("Введите количество строк: ")
    val cols = readPositiveInt("Введите количество столбцов: ")

    // Создаем и заполняем массив
    val array = Array(rows) { IntArray(cols) }
    println("Введите $rows строк по $cols трехзначных чисел:")

    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            array[i][j] = readThreeDigitNumber("Элемент [$i][$j]: ")
        }
    }

    // Множество для хранения уникальных цифр
    val uniqueDigits = mutableSetOf<Char>()

    // Перебираем все числа и их цифры
    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            val number = array[i][j]
            // Преобразуем число в строку и добавляем каждую цифру в множество
            number.toString().forEach { digit ->
                uniqueDigits.add(digit)
            }
        }
    }

    // Выводим массив
    println("\nВведенный массив:")
    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            print("${array[i][j]}\t")
        }
        println()
    }

    // Выводим результат
    println("\nВ массиве использовано ${uniqueDigits.size} различных цифр")
}

// Функция для чтения положительного целого числа
fun readPositiveInt(prompt: String): Int
{
    while (true)
    {
        print(prompt)
        val input = readln().trim()

        try
        {
            val number = input.toInt()

            if (number <= 0)
            {
                println("Ошибка! Введите положительное число больше 0")
            } else
            {
                return number
            }
        } catch (e: NumberFormatException)
        {
            println("Ошибка! Введите положительное число больше 0")
        }
    }
}

// Функция для чтения трехзначного числа
fun readThreeDigitNumber(prompt: String): Int
{
    while (true)
    {
        print(prompt)
        val input = readln().trim()

        try
        {
            val number = input.toInt()

            if (number !in 100..999)
            {
                println("Ошибка! Введите трехзначное число (от 100 до 999)")
            } else
            {
                return number
            }
        } catch (e: NumberFormatException)
        {
            println("Ошибка! Введите трехзначное число (от 100 до 999)")
        }
    }
}