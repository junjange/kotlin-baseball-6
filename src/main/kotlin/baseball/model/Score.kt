package baseball.model

data class Score(
    var strikes: Int = 0,
    var balls: Int = 0,
    var outs: Int = 0
) {
    fun calculateScore(answer: String, userAnswer: String) {
        strikes = 0
        balls = 0
        outs = 0
        answer.forEachIndexed { index, c ->
            when {
                c == userAnswer[index] -> strikes++
                userAnswer.contains(c) -> balls++
                else -> outs++
            }
        }
    }

    fun isCorrectAnswer(): Boolean = strikes == 3

}