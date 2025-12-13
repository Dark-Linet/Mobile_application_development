package Practical_work_2

    fun task5()
    {
        var words: List<String>

        while (true)
        {
            print("Введите слова через пробел: ")
            val input = readLine()?.trim()

            if (input.isNullOrEmpty())
            {
                println("Ничего не введено. Попробуйте снова.\n")
                continue
            }

            // Разбиваем по пробелам и убираем пустые части (если были лишние пробелы)
            words = input.split(" ")

            var valid = true
            for (word in words)
            {
                for (char in word)
                {
                    if (!char.isLetter())
                    {
                        println("Слово '$word' содержит не буквы. Вводите только слова!\n")
                        valid = false
                        break
                    }
                }
                if (!valid) break
            }

            if (valid) break
        }

        val groups = mutableMapOf<String, MutableList<String>>()
        for (word in words)
        {
            val key = word.lowercase().toCharArray().sorted().joinToString("")
            groups.getOrPut(key) { mutableListOf() }.add(word)
        }

        println("\nГруппы слов из одинаковых букв:")
        for (group in groups.values)
        {
            println(group)
        }
    }
