package _23_PastExams._2023_12_December_19.climbers;

import _23_PastExams._2023_12_December_19.climbers.core.Controller;
import _23_PastExams._2023_12_December_19.climbers.core.Engine;
import _23_PastExams._2023_12_December_19.climbers.core.EngineImpl;
import _23_PastExams._2023_12_December_19.climbers.core.ControllerImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
