package Practical_work_2

fun task4() {
    // Ввод первого массива
    //print("Введите первый массив (через пробел): ")
    //val arr1 = readLine()!!.split(" ").map { it.toInt() }

    // --- Ввод первого массива ---
    var arr1: List<Int>
    while (true) {
        print("Введите первый массив (целые числа через пробел): ")
        val input = readLine()?.trim()
        if (input.isNullOrEmpty()) {
            println("Массив не может быть пустым. Попробуйте снова.\n")
            continue
        }

        val parts = input.split(" ")
        val nums = mutableListOf<Int>()
        var valid = true

        for (part in parts) {
            try {
                val num = part.toInt()
                nums.add(num)
            } catch (e: NumberFormatException) {
                println("'$part' — это не число. Попробуйте снова.\n")
                valid = false
                break
            }
        }

        if (valid) {
            arr1 = nums
            break
        }
    }




    // Ввод второго массива
    print("Введите второй массив (через пробел): ")
    val arr2 = readLine()!!.split(" ").map { it.toInt() }

    // Создаём копию второго массива — будем из неё "забирать" использованные числа
    val arr2Mutable = arr2.toMutableList()

    // Сюда будем складывать общие элементы
    val result = mutableListOf<Int>()

    // Проходим по каждому числу из первого массива
    for (num in arr1)
    {
        // Если это число есть во втором массиве (в оставшихся)
        if (num in arr2Mutable)
        {
            result.add(num)        // добавляем в результат
            arr2Mutable.remove(num) // удаляем одно вхождение из второго массива
        }
    }

    // Выводим результат
    println("Пересечение: $result")
}