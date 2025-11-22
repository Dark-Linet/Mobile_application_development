package Practical_work_2

fun main() {
    val plainAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    val positions = intArrayOf(21,13,4,20,22,1,25,12,24,14,2,28,9,23,3,29,6,16,15,11,26,5,30,27,8,18,10,33,31,32,19,7,17)

    // Строим cipherAlphabet: позиция (1-33) -> буква
    val cipherAlphabet = CharArray(33)
    for (i in plainAlphabet.indices) {
        val pos = positions[i] // от 1 до 33
        cipherAlphabet[pos - 1] = plainAlphabet[i]
    }

    // Карта: буква -> её индекс в cipherAlphabet
    val charToIndex = mutableMapOf<Char, Int>()
    for (i in cipherAlphabet.indices) {
        charToIndex[cipherAlphabet[i]] = i
    }

    // Ввод от пользователя
    println("Выберите действие:")
    println("1 — зашифровать")
    println("2 — расшифровать")
    val choice = readLine()?.trim()

    print("Введите ключевое слово (только русские буквы): ")
    val keyword = readLine()?.trim()?.uppercase() ?: ""
    if (keyword.any { it !in plainAlphabet }) {
        println("Ключ содержит недопустимые символы!")
        return
    }

    // Преобразуем ключ в массив сдвигов (номера из таблицы)
    val shifts = mutableListOf<Int>()
    for (ch in keyword) {
        val idxInPlain = plainAlphabet.indexOf(ch)
        if (idxInPlain == -1) {
            println("Недопустимая буква в ключе: $ch")
            return
        }
        shifts.add(positions[idxInPlain]) // это сдвиг (от 1 до 33)
    }

    print("Введите текст: ")
    val text = readLine()?.trim()?.uppercase() ?: ""

    val result = StringBuilder()
    var keyIndex = 0

    for (ch in text) {
        if (ch in plainAlphabet) {
            val currentIndex = charToIndex[ch] ?: -1
            if (currentIndex == -1) {
                result.append(ch)
                continue
            }

            val shift = shifts[keyIndex % shifts.size]
            val newIndex = when (choice) {
                "1" -> (currentIndex + shift) % 33
                "2" -> (currentIndex - shift + 33) % 33
                else -> {
                    println("Неверный выбор!")
                    return
                }
            }
            result.append(cipherAlphabet[newIndex])
            keyIndex++
        } else {
            // Не русская буква — оставляем как есть
            result.append(ch)
        }
    }

    when (choice) {
        "1" -> println("Зашифрованный текст: $result")
        "2" -> println("Расшифрованный текст: $result")
    }
}