package Practical_work_3

import kotlin.math.sqrt

// Класс для точки
class Point3(val x: Double, val y: Double)

fun main()
{
    println("Нахождение минимального и максимального расстояний между точками")
    println("===============================================================")

    // Ввод количества точек с проверкой
    val n = inputNumberOfPoints()

    // Ввод всех точек
    val points = mutableListOf<Point3>()
    for (i in 1..n)
    {
        println("\n--- Точка $i ---")
        val point = inputPointDistance3("$i")
        points.add(point)
    }

    // Проверка, что все точки разные
    if (areAllPointsUnique(points))
    {
        // Находим минимальное и максимальное расстояние
        val (minDistance, maxDistance, minPair, maxPair) = findMinMaxDistances(points)

        // Выводим результат
        printResults(minDistance, maxDistance, minPair, maxPair)
    } else
    {
        println("\nОшибка: найдены совпадающие точки!")
    }
}

// Функция для ввода количества точек с проверкой
fun inputNumberOfPoints(): Int
{
    while (true)
    {
        try
        {
            print("Введите количество точек (больше 2): ")
            val input = readln().trim()

            if (input.isEmpty())
            {
                println("Ошибка: пустой ввод.")
                continue
            }

            val n = input.toIntOrNull()

            if (n == null)
            {
                println("Ошибка: введите целое число.")
                continue
            }

            if (n <= 2)
            {
                println("Ошибка: количество точек должно быть больше 2.")
                continue
            }

            return n

        } catch (e: Exception)
        {
            println("Произошла ошибка: ${e.message}. Попробуйте снова.")
        }
    }
}

// Функция для ввода точки с проверками
fun inputPointDistance3(pointName: String): Point3
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

            return Point3(x, y)

        } catch (e: Exception)
        {
            println("Произошла ошибка: ${e.message}. Попробуйте снова.")
        }
    }
}

// Функция для проверки, что все точки уникальны
fun areAllPointsUnique(points: List<Point3>): Boolean
{
    for (i in 0 until points.size)
    {
        for (j in i + 1 until points.size)
        {
            if (points[i].x == points[j].x && points[i].y == points[j].y)
            {
                return false
            }
        }
    }
    return true
}

// Функция для вычисления расстояния между двумя точками
fun calculateDistance3(p1: Point3, p2: Point3): Double
{
    val dx = p2.x - p1.x
    val dy = p2.y - p1.y
    return sqrt(dx * dx + dy * dy)
}

// Функция для поиска минимального и максимального расстояний
fun findMinMaxDistances(points: List<Point3>): Quadruple<Double, Double, Pair<Int, Int>, Pair<Int, Int>>
{
    var minDistance = Double.MAX_VALUE
    var maxDistance = 0.0
    var minPair = Pair(0, 0)
    var maxPair = Pair(0, 0)

    for (i in 0 until points.size)
    {
        for (j in i + 1 until points.size)
        {
            val distance = calculateDistance3(points[i], points[j])

            if (distance < minDistance)
            {
                minDistance = distance
                minPair = Pair(i + 1, j + 1) // +1 для отображения номеров с 1
            }

            if (distance > maxDistance)
            {
                maxDistance = distance
                maxPair = Pair(i + 1, j + 1) // +1 для отображения номеров с 1
            }
        }
    }

    return Quadruple(minDistance, maxDistance, minPair, maxPair)
}

// Функция для вывода результатов
fun printResults(minDistance: Double, maxDistance: Double, minPair: Pair<Int, Int>, maxPair: Pair<Int, Int>)
{
    println("\n=== РЕЗУЛЬТАТЫ ===")
    println("Минимальное расстояние: ${String.format("%.3f", minDistance)}")
    println("Между точками: ${minPair.first} и ${minPair.second}")
    println("Максимальное расстояние: ${String.format("%.3f", maxDistance)}")
    println("Между точками: ${maxPair.first} и ${maxPair.second}")
}

// Вспомогательный класс для возврата четырех значений
data class Quadruple<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)