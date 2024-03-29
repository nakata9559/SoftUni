package _23_PastExams._2022_08_August_22.goldDigger;

import _23_PastExams._2022_08_August_22.goldDigger.core.Controller;
import _23_PastExams._2022_08_August_22.goldDigger.core.ControllerImpl;
import _23_PastExams._2022_08_August_22.goldDigger.core.Engine;
import _23_PastExams._2022_08_August_22.goldDigger.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
