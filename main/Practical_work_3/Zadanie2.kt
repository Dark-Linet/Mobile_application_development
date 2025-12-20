package Practical_work_3

import kotlin.math.sqrt

// Измените название класса на уникальное
class Point2(val x: Double, val y: Double)

fun main()
{
    println("Расстояние между двумя точками")
    println("==============================")

    // Вводим первую точку
    println("\n--- Первая точка ---")
    val point1 = inputPointDistance("1")

    // Вводим вторую точку
    println("\n--- Вторая точка ---")
    val point2 = inputPointDistance("2")

    // Вычисляем расстояние
    val distance = calculateDistance(point1, point2)

    // Выводим результат
    println("\nРезультат:")
    println("Расстояние между точками: ${String.format("%.3f", distance)}")
}

// Функция для ввода точки с проверками
fun inputPointDistance(pointName: String): Point2
{
    while (true)
    {
        try
        {
            print("Введите координаты точки $pointName (x y): ")
            val input = readln().trim()

            if (input.isEmpty())
            {
                println("Ошибка: пустой ввод. Введите два числа через пробел.")
                continue
            }

            val parts = input.split(" ")

            if (parts.size != 2)
            {
                println("Ошибка: нужно ввести два числа через пробел.")
                continue
            }

            val x = parts[0].toDoubleOrNull()
            val y = parts[1].toDoubleOrNull()

            if (x == null)
            {
                println("Ошибка: первое значение '${parts[0]}' не является числом.")
                continue
            }

            if (y == null)
            {
                println("Ошибка: второе значение '${parts[1]}' не является числом.")
                continue
            }

            // Проверяем, что числа не бесконечны и не NaN
            if (x.isInfinite() || x.isNaN() || y.isInfinite() || y.isNaN())
            {
                println("Ошибка: координаты должны быть обычными числами.")
                continue
            }

            return Point2(x, y)

        } catch (e: Exception)
        {
            println("Произошла ошибка: ${e.message}. Попробуйте снова.")
        }
    }
}

// Функция для вычисления расстояния между двумя точками
fun calculateDistance(p1: Point2, p2: Point2): Double
{
    val dx = p2.x - p1.x
    val dy = p2.y - p1.y
    return sqrt(dx * dx + dy * dy)
}