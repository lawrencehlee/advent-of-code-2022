package aoc.day1

import java.io.File

fun solve1(): Int {
    var overallMax = 0
    var currentMax = 0
    File("input1.txt").forEachLine {
        if (it.isNotBlank()) {
            currentMax += it.toInt()
            if (currentMax > overallMax) {
                overallMax = currentMax
            }
        } else {
            currentMax = 0
        }
    }

    return overallMax
}

fun solve2(): Int {
    val textSplitByDoubleNewline = File("input1.txt").readText().split(System.lineSeparator() + System.lineSeparator())
    val sums = textSplitByDoubleNewline.map {
        it.split("\n")
                .asSequence()
                .map { it2 -> it2.trim() }
                .filter { it2 -> it2.isNotBlank() }
                .map { it2 -> it2.toInt() }
                .sum()
    }

    return sums.sortedDescending().take(3).sum()
}