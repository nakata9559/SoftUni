package _23_PastExams._2021_12_December_20.christmasRaces.io;

import _23_PastExams._2021_12_December_20.christmasRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
