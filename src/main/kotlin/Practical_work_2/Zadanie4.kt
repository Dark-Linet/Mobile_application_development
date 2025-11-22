package Practical_work_2

fun main() {
    // Ввод первого массива
    print("Введите первый массив (через пробел): ")
    val arr1 = readLine()!!.split(" ").map { it.toInt() }

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