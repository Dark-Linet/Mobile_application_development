package Practical_work_2

fun task5() {
    // Ввод слов через пробел
    print("Введите слова через пробел: ")
    val words = readLine()!!.split(" ")

    // Словарь: ключ — отсортированные буквы, значение — список слов из этой группы
    val groups = mutableMapOf<String, MutableList<String>>()

    // Обрабатываем каждое слово
    for (word in words)
    {
        // Сортируем буквы в слове и делаем из них строку-ключ
        val key = word.lowercase().toCharArray().sorted().joinToString("")

        // Если такой ключ уже есть — добавляем слово в существующий список
        if (key in groups)
        {
            groups[key]!!.add(word)
        } else
        {
            // Иначе создаём новую группу
            groups[key] = mutableListOf(word)
        }
    }

    // Выводим все группы
    println("Группы слов из одинаковых букв:")
    for (group in groups.values)
    {
        println(group)
    }
}