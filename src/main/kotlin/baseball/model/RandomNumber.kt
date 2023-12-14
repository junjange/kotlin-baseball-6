package baseball.model

import camp.nextstep.edu.missionutils.Randoms

data class RandomNumber(
    val uniqueNumbers: MutableList<Int> = mutableListOf()
) {

    fun generateRandomNumber() {
        uniqueNumbers.clear()
        while (uniqueNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            uniqueNumbers.add(randomNumber)
        }
    }
}