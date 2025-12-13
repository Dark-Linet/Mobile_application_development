package Practical_work_2

fun task4() {
    var arr1: List<Int>
    while (true)
    {
        print("Введите первый массив (целые числа через пробел): ")
        val input = readLine()?.trim()
        if (input.isNullOrEmpty())
        {
            println("Массив не может быть пустым.\n")
            continue
        }

        val parts = input.split(" ")
        val nums = mutableListOf<Int>()
        var valid = true

        for (part in parts)
        {
            try
            {
                val num = part.toInt()
                nums.add(num)
            } catch (e: NumberFormatException)
            {
                println("'$part' — это не число. Попробуйте снова.\n")
                valid = false
                break
            }
        }

        if (valid)
        {
            arr1 = nums
            break
        }
    }

    var arr2: List<Int>
    while (true)
    {
        print("Введите второй массив (целые числа через пробел): ")
        val input = readLine()?.trim()
        if (input.isNullOrEmpty())
        {
            println("Массив не может быть пустым.\n")
            continue
        }

        val parts = input.split(" ")
        val nums = mutableListOf<Int>()
        var valid = true

        for (part in parts)
        {
            try
            {
                val num = part.toInt()
                nums.add(num)
            } catch (e: NumberFormatException)
            {
                println("'$part' — это не число. Попробуйте снова.\n")
                valid = false
                break
            }
        }

        if (valid)
        {
            arr2 = nums
            break
        }
    }

    val arr2Mutable = arr2.toMutableList()

    val result = mutableListOf<Int>()

    for (num in arr1)
    {
        if (num in arr2Mutable)
        {
            result.add(num)
            arr2Mutable.remove(num)
        }
    }

    println("Пересечение: $result")
}