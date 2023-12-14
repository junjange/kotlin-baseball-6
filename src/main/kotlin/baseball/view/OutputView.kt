package baseball.view

import baseball.model.Score

class OutputView {


    fun printGameStartMessage() = println(GAME_START_MESSAGE)

    fun printNumberInputMessage() = print(NUMBER_INPUT_MESSAGE)

    fun printScoreMessage(score: Score) = println(buildString {
        if (score.balls > 0) append("${score.balls}볼 ")
        if (score.strikes > 0) append("${score.strikes}스트라이크")
        if (score.outs == 3) append("낫싱")
    }.trim())

    fun printGameSuccessMessage() = println(GAME_SUCCESS_MESSAGE)

    fun printGameRestartMessage() = println(GAME_RESTART_MESSAGE)

    fun printGameOverMessage() = println(GAME_OVER_MESSAGE)

    companion object {
        const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
        const val NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : "
        const val GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        const val GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        const val GAME_OVER_MESSAGE = "게임 종료"
    }

}