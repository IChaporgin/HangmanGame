import kotlin.random.Random

fun main() {
    val words = listOf("программа", "кот")
    val hiddenWord = words[Random.nextInt(words.size)]
    val hiddenWordSimbol = CharArray(hiddenWord.length) {'*'}
    var countError = 6
    val charLetters = mutableSetOf<Char>()

    while (countError > 0 && hiddenWordSimbol.contains('*')) {
        println("Мы загадали слово ${hiddenWordSimbol.joinToString ("")}")
        println("Ваше количество попыток ${countError}")
        println("Введенныe буквы: ${if (charLetters.isEmpty()) "нет" else charLetters.joinToString(", ") }")
        println("Введи букву:")


        val char = readln()
        val input = char[0]
        charLetters.add(input)

        if (input in hiddenWord) {
            for (i in hiddenWord.indices) {
                if (hiddenWord[i] == input) {
                    hiddenWordSimbol[i] = input
                }
            }
        } else {
            println("Такой буквы нет!")
            --countError
        }

        println()
        when (countError) {
            5 -> println("""
            |
            |
            |
            |
            
        """.trimIndent())
            4 -> println("""
            /--------
            |
            |
            |
            |
            
        """.trimIndent())
            3 -> println("""
            /--------
            |         |
            |         
            |       
            |    
                
        """.trimIndent())
            2 -> println("""
            /--------
            |         |
            |         *
            |       
            |    
                
        """.trimIndent())
            1 -> println("""
            /--------
            |         |
            |         *
            |       /   \
            |       
            
        """.trimIndent())
            0 -> println("""
            /--------
            |         |
            |         *
            |       /   \
            |        / \
            
        """.trimIndent())
        }

    }
    if (!hiddenWordSimbol.contains('*')) {
        println("\nПоздравляем! Вы угадали слово: ${hiddenWordSimbol.joinToString("")}")
    } else {
        println("\nВы проиграли! Загаданное слово было: $hiddenWord")
    }
    println("Спасибо за игру!")
}