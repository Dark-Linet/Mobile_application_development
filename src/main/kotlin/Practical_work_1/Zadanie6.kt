package Practical_work_1

fun main()
{
    println("Программа создает одно или два (если возможно) нечетных числа из двух введённых вами цифр")
    // Получаем первую цифру с проверкой
    val firstDigit = getValidDigit("Введите первую цифру:")

    // Получаем вторую цифру с проверкой и проверкой на отличие от первой
    val secondDigit = getValidDigit("Введите вторую цифру:", firstDigit)

    // Составляем два возможных числа
    val number1 = firstDigit * 10 + secondDigit
    val number2 = secondDigit * 10 + firstDigit

    // Собираем все нечетные числа в список
    val oddNumbers = mutableListOf<Int>()

    if (number1 % 2 != 0)          // Проверяем, является ли первое число нечетным
    {
        oddNumbers.add(number1)     // Если нечетное, добавляем в список
    }
    if (number2 % 2 != 0)          // Проверяем, является ли второе число нечетным
    {
        oddNumbers.add(number2)     // Если нечетное, добавляем в список
    }

    // Выводим результат
    if (oddNumbers.isNotEmpty())
    {
        oddNumbers.forEach { number ->
            println("Из этих цифр возможно создать нечетное число: $number")
        }
    } else
    {
        println("Создать нечетное число невозможно")
    }
}

// Функция для получения корректной цифры от пользователя
fun getValidDigit(prompt: String, excludeDigit: Int? = null): Int
{
    while (true)
    {
        println(prompt)
        val input = readLine()

        // Проверяем, что введено число
        val digit = input?.toIntOrNull()
        if (digit == null)
        {
            println("Ошибка: введите ЦИФРУ (0-9)!")
            continue
        }

        // Проверяем, что это цифра от 0 до 9
        if (digit !in 0..9)
        {
            println("Ошибка: введите цифру от 0 до 9!")
            continue
        }

        // Проверяем, что цифры отличаются друг от друга
        if (excludeDigit != null && digit == excludeDigit)
        {
            println("Ошибка: цифра должна отличаться от первой ($excludeDigit)!")
            continue
        }

        return digit
    }
}