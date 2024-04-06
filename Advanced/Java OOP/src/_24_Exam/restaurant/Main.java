package _24_Exam.restaurant;

import _24_Exam.restaurant.core.Controller;
import _24_Exam.restaurant.core.ControllerImpl;
import _24_Exam.restaurant.core.Engine;
import _24_Exam.restaurant.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
