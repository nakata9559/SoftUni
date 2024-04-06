package _23_PastExams._2023_04_April_18.vehicleShop.models.worker;

import _23_PastExams._2023_04_April_18.vehicleShop.models.tool.Tool;

import java.util.Collection;

public interface Worker {
    void working();

    void addTool(Tool tool);

    boolean canWork();

    String getName();

    int getStrength();

    Collection<Tool> getTools();
}
