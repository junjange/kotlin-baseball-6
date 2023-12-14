package baseball.view

import baseball.utils.Exceptions.userWrongDuplicationAnswer
import baseball.utils.Exceptions.userWrongSizeAnswer
import baseball.utils.Exceptions.userWrongTypeAnswer
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getInputNumber(): String {
        val number: String = Console.readLine()

        number.userWrongTypeAnswer()
        number.userWrongSizeAnswer()
        number.userWrongDuplicationAnswer()

        return number
    }

    fun getInputBaseballRestart(): String = Console.readLine()

}