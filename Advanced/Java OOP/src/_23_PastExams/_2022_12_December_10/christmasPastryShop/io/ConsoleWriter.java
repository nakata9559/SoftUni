package _23_PastExams._2022_12_December_10.christmasPastryShop.io;

import _23_PastExams._2022_12_December_10.christmasPastryShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
