package Practical_work_2

fun task1() {
    // Запрашиваем размеры массива
    print("Введите количество строк: ")
    val rows = readLine()!!.toInt()
    print("Введите количество столбцов: ")
    val cols = readLine()!!.toInt()

    // Создаем и заполняем массив
    val array = Array(rows) { IntArray(cols) }
    println("Введите $rows строк по $cols трехзначных чисел:")

    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            var number: Int
            do {
                print("Элемент [$i][$j]: ")
                number = readLine()!!.toInt()
                if (number < 100 || number > 999)
                {
                    println("Ошибка! Введите трехзначное число (от 100 до 999)")
                }
            } while (number < 100 || number > 999)
            array[i][j] = number
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