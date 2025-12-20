package Practical_work_1

fun main()
{
    println("Программа создает одно или два (если возможно) нечетных числа из двух введённых вами цифр")

    val firstDigit = getValidDigit("Введите первую цифру:")


    val secondDigit = getValidDigit("Введите вторую цифру:", firstDigit)


    val number1 = firstDigit * 10 + secondDigit
    val number2 = secondDigit * 10 + firstDigit


    val oddNumbers = mutableListOf<Int>()

    if (number1 % 2 != 0)
    {
        oddNumbers.add(number1)
    }
    if (number2 % 2 != 0)
    {
        oddNumbers.add(number2)
    }


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


fun getValidDigit(prompt: String, excludeDigit: Int? = null): Int
{
    while (true)
    {
        println(prompt)
        val input = readLine()


        val digit = input?.toIntOrNull()
        if (digit == null)
        {
            println("Ошибка: введите ЦИФРУ (0-9)!")
            continue
        }


        if (digit !in 0..9)
        {
            println("Ошибка: введите цифру от 0 до 9!")
            continue
        }

        if (excludeDigit != null && digit == excludeDigit)
        {
            println("Ошибка: цифра должна отличаться от первой ($excludeDigit)!")
            continue
        }

        return digit
    }
}