fun main() {
    var time: Int = 60
    println(agoToText(time))
}

fun agoToText(time: Int): String {
    return "был(а) " + when {
        toMinutes(time) <= 1 -> {
            "только что"
        }

        toMinutes(time) > 1 && toHours(time) < 1 -> {
            minutesPassed(toMinutes(time))
        }

        toHours(time) >= 1 && toDays(time) < 1 -> {
            hoursPassed(toHours(time))
        }

        toDays(time) >= 1 && toDays(time) < 2 -> {
            "вчера"
        }

        toDays(time) == 2 -> {
            "позавчера"
        }

        else -> {
            "давно"
        }
    }
}

fun toMinutes(secondsHasPassed: Int): Int {
    return secondsHasPassed / 60
}

fun toHours(secondsHasPassed: Int): Int {
    return toMinutes(secondsHasPassed) / 60
}

fun toDays(secondsHasPassed: Int): Int {
    return toHours(secondsHasPassed) / 24
}

fun minutesPassed(minutes: Int): String {
    return when (minutes) {
        1 -> "$minutes минуту назад"
        in 2..4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursPassed(hours: Int): String {
    return when (hours % 10) {
        1 -> "$hours час назад"
        in 2..4 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}