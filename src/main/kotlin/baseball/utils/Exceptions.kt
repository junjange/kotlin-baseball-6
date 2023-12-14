package baseball.utils

object Exceptions {
    private const val GAME_OVER_MESSAGE = "게임 종료"

    fun String.userWrongTypeAnswer() = require(this.toIntOrNull() != null) { GAME_OVER_MESSAGE }

    fun String.userWrongSizeAnswer() = require(this.length == 3) { GAME_OVER_MESSAGE }

    fun String.userWrongDuplicationAnswer() = require(this.toSet().size == this.length) { GAME_OVER_MESSAGE }
}