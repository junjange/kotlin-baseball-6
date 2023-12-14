package baseball.controller

import baseball.model.GameStatus
import baseball.model.RandomNumber
import baseball.model.Score
import baseball.view.InputView
import baseball.view.OutputView

class BaseballController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {

    fun run() {
        val randomNumber = RandomNumber()
        var gameStatus = GameStatus.GAME_START
        outputView.printGameStartMessage()

        val score = Score()

        while (gameStatus != GameStatus.GAME_OVER) {
            when (gameStatus) {
                GameStatus.GAME_START -> {
                    randomNumber.generateRandomNumber()
                    gameStatus = GameStatus.GAME_IN_PROGRESS
                }

                GameStatus.GAME_IN_PROGRESS -> {
                    gameStatus = processGameInProgress(
                        score = score,
                        randomNumber = randomNumber.uniqueNumbers.joinToString(""),
                        gameStatus = gameStatus
                    )
                }

                else -> break
            }
        }
    }

    private fun processGameInProgress(score: Score, randomNumber: String, gameStatus: GameStatus): GameStatus {
        outputView.printNumberInputMessage()
        val userInput = inputView.getInputNumber()
        score.calculateScore(randomNumber, userInput)
        outputView.printScoreMessage(score)

        if (score.isCorrectAnswer()) {
            outputView.printGameSuccessMessage()
            outputView.printGameRestartMessage()
            return if (gameRestart()) GameStatus.GAME_START else GameStatus.GAME_OVER
        }
        return gameStatus
    }

    private fun gameRestart(): Boolean {
        return when (inputView.getInputBaseballRestart()) {
            "1" -> true
            else -> {
                outputView.printGameOverMessage()
                false
            }
        }
    }
}