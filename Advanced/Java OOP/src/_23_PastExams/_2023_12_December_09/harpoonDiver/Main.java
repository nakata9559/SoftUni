package _23_PastExams._2023_12_December_09.harpoonDiver;

import _23_PastExams._2023_12_December_09.harpoonDiver.core.Controller;
import _23_PastExams._2023_12_December_09.harpoonDiver.core.ControllerImpl;
import _23_PastExams._2023_12_December_09.harpoonDiver.core.Engine;
import _23_PastExams._2023_12_December_09.harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
