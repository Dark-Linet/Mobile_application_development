package Practical_work_2

fun main() {
    // Заданная матрица 5x5
    val matrix = arrayOf(
        intArrayOf(5, 9, 6, 7, 2),
        intArrayOf(9, 8, 4, 5, 3),
        intArrayOf(6, 4, 3, 8, 7),
        intArrayOf(7, 5, 8, 4, 8),
        intArrayOf(2, 3, 7, 8, 1)
    )

    // Вывод матрицы
    println("Исходная матрица:")
    for (row in matrix)
    {
        for (element in row)
        {
            print("${element.toString().padStart(3)} ")
        }
        println()
    }

    // Проверка симметричности относительно главной диагонали
    val n = matrix.size
    var isSymmetric = true

    // Проверяем, что матрица квадратная
    for (row in matrix)
    {
        if (row.size != n)
        {
            isSymmetric = false
            break
        }
    }

    // Если матрица квадратная — проверяем симметрию
    if (isSymmetric) {
        for (i in 0 until n)
        {
            for (j in i + 1 until n)
            {
                if (matrix[i][j] != matrix[j][i])
                {
                    isSymmetric = false
                    break
                }
            }
            if (!isSymmetric) break
        }
    }

    println("\nМатрица симметрична относительно главной диагонали: $isSymmetric")
}