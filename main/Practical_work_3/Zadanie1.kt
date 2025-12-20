package Practical_work_3

import kotlin.math.abs

// Класс для точки
class Point(val x: Double, val y: Double)

// Класс для треугольника
class Triangle(val p1: Point, val p2: Point, val p3: Point)

fun main()
{
    println("Проверка положения точки относительно треугольника")
    println("=================================================")

    // Вводим точки треугольника с проверками
    var pointA = inputPoint("A")
    var pointB = inputPoint("B")
    var pointC = inputPoint("C")

    // Проверяем, что точки не лежат на одной прямой
    while (arePointsOnSameLine(pointA, pointB, pointC))
    {
        println("Ошибка: точки лежат на одной прямой. Это не треугольник!")
        println("Введите новые координаты:")
        pointA = inputPoint("A")
        pointB = inputPoint("B")
        pointC = inputPoint("C")
    }

    // Создаем треугольник
    val triangle = Triangle(pointA, pointB, pointC)
    println("\nТреугольник создан!")

    // Вводим проверяемую точку
    val testPoint = inputPoint("P (проверяемая)")

    // Проверяем положение точки
    val result = checkPointPosition(triangle, testPoint)

    // Выводим результат
    println("\nРезультат:")
    println(result)
}

// Функция для ввода точки с проверками
fun inputPoint(pointName: String): Point
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

            return Point(x, y)

        } catch (e: Exception)
        {
            println("Произошла ошибка: ${e.message}. Попробуйте снова.")
        }
    }
}

// Функция для проверки, лежат ли три точки на одной прямой
fun arePointsOnSameLine(p1: Point, p2: Point, p3: Point): Boolean
{
    // Вычисляем площадь треугольника
    val area = abs(
        p1.x * (p2.y - p3.y) +
                p2.x * (p3.y - p1.y) +
                p3.x * (p1.y - p2.y)
    ) / 2.0

    // Если площадь очень маленькая (близка к нулю), точки лежат на одной прямой
    return area < 0.0000001 // Используем очень маленькое число для учета погрешности
}

// Функция для проверки положения точки относительно треугольника
fun checkPointPosition(triangle: Triangle, point: Point): String
{
    val p1 = triangle.p1
    val p2 = triangle.p2
    val p3 = triangle.p3

    // Вычисляем площадь основного треугольника
    val mainArea = calculateTriangleArea(p1, p2, p3)

    // Вычисляем площади трех маленьких треугольников
    val area1 = calculateTriangleArea(point, p2, p3)
    val area2 = calculateTriangleArea(p1, point, p3)
    val area3 = calculateTriangleArea(p1, p2, point)

    // Сумма площадей маленьких треугольников
    val sumAreas = area1 + area2 + area3

    // Сравниваем с учетом погрешности вычислений
    if (abs(mainArea - sumAreas) < 0.0000001)
    {
        return "Точка находится ВНУТРИ треугольника"
    } else
    {
        return "Точка находится ВНЕ треугольника"
    }
}

// Функция для вычисления площади треугольника по трем точкам
fun calculateTriangleArea(a: Point, b: Point, c: Point): Double
{
    return abs(
        a.x * (b.y - c.y) +
                b.x * (c.y - a.y) +
                c.x * (a.y - b.y)
    ) / 2.0
}