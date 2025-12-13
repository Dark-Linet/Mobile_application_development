package Practical_work_2

fun task1() {
    val rows = readPositiveInt("Введите количество строк: ")
    val cols = readPositiveInt("Введите количество столбцов: ")

    val array = Array(rows) { IntArray(cols) }
    println("Введите $rows строк по $cols трехзначных чисел:")

    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            array[i][j] = readThreeDigitNumber("Элемент [$i][$j]: ")
        }
    }

    val uniqueDigits = mutableSetOf<Char>()

    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            val number = array[i][j]
            number.toString().forEach { digit ->
                uniqueDigits.add(digit)
            }
        }
    }

    println("\nВведенный массив:")
    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            print("${array[i][j]}\t")
        }
        println()
    }

    println("\nВ массиве использовано ${uniqueDigits.size} различных цифр")
}

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