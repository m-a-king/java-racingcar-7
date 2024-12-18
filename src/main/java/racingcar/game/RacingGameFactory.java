package racingcar.game;

import racingcar.input.InputHandler;
import racingcar.input.Validator;
import racingcar.output.OutputHandler;
import racingcar.util.RandomValueGenerator;

public class RacingGameFactory {
    public static RacingGame createRacingGame() {
        OutputHandler outputHandler = new OutputHandler();
        InputHandler inputHandler = new InputHandler(outputHandler);
        Validator validator = new Validator();
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

        return new RacingGame(inputHandler, validator, randomValueGenerator, outputHandler);
    }
}