package _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.core.commands;

import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = getData()[1];

        getRepository().removeUnit(unitType);

        return unitType + " retired!";
    }
}
