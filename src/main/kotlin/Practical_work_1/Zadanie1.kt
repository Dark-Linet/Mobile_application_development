package Practical_work_1

fun main() {
    println("Введите строку из английских символов: ")
    val stroka = readln()

    var numberOfCharacters = 1
    for (i in 0 until stroka.length - 1)
    {
        if (stroka[i] == stroka[i + 1])
            numberOfCharacters++
        else
        {
            print(stroka[i])
            if (numberOfCharacters > 1)
                print(numberOfCharacters)
            numberOfCharacters = 1
        }
    }


    print(stroka.last())
    if (numberOfCharacters > 1)
        print(numberOfCharacters)

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")
}