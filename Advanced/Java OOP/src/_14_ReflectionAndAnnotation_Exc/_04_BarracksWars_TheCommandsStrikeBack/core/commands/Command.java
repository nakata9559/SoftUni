package _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.core.commands;

import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.Executable;
import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String[] getData() {
        return data;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return null;
    }
}
