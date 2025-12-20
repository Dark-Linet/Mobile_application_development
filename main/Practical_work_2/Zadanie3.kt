package Practical_work_2

fun task3() {
    val plainAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    val positions = intArrayOf(21,13,4,20,22,1,25,12,24,14,2,28,9,23,3,29,6,16,15,11,26,5,30,27,8,18,10,33,31,32,19,7,17)

    val cipherAlphabet = CharArray(33)
    for (i in plainAlphabet.indices)
    {
        val pos = positions[i]
        cipherAlphabet[pos - 1] = plainAlphabet[i]
    }

    val charToIndex = mutableMapOf<Char, Int>()
    for (i in cipherAlphabet.indices)
    {
        charToIndex[cipherAlphabet[i]] = i
    }

    var choice = ""
    while (true)
    {
        println("Выберите действие:")
        println("1 — зашифровать")
        println("2 — расшифровать")
        choice = readLine()?.trim() ?: ""
        if (choice in setOf("1", "2")) break
        println("Неверный выбор! Допустимые значения: 1 или 2.\n")
    }

    var keyword = ""
    while (true)
    {
        print("Введите ключевое слово (только русские буквы): ")
        keyword = readLine()?.trim()?.uppercase() ?: ""
        if (keyword.isEmpty())
        {
            println("Ключевое слово не может быть пустым! Попробуйте снова.\n")
            continue
        }
        if (keyword.all { it in plainAlphabet })
        {
            break
        } else
        {
            println("Ключ содержит недопустимые символы! Используйте только русские буквы из алфавита.\n")
        }
    }

    val shifts = mutableListOf<Int>()
    for (ch in keyword)
    {
        val idxInPlain = plainAlphabet.indexOf(ch)
        shifts.add(positions[idxInPlain])
    }

    var text = ""
    while (true)
    {
        print("Введите текст (только русские буквы без пробелов и знаков препинания): ")
        text = readLine()?.trim()?.uppercase() ?: ""

        if (text.isEmpty())
        {
            println("Текст не может быть пустым!\n")
            continue
        }

        if (text.all { it in plainAlphabet })
        {
            break
        } else
        {
            println("Текст содержит недопустимые символы! Разрешены только буквы: $plainAlphabet\n")
        }
    }

    val result = StringBuilder()
    var keyIndex = 0

    for (ch in text)
    {
        if (ch in plainAlphabet)
        {
            val currentIndex = charToIndex[ch] ?: -1
            if (currentIndex == -1)
            {
                result.append(ch)
                continue
            }

            val shift = shifts[keyIndex % shifts.size]
            val newIndex = when (choice)
            {
                "1" -> (currentIndex + shift) % 33
                "2" -> (currentIndex - shift + 33) % 33
                else ->
                {
                    println("Неверный выбор!")
                    return
                }
            }
            result.append(cipherAlphabet[newIndex])
            keyIndex++
        }
    }

    when (choice)
    {
        "1" -> println("Зашифрованный текст: $result")
        "2" -> println("Расшифрованный текст: $result")
    }
}