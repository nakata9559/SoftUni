package _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack;

import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.core.Engine;
import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.core.factories.UnitFactoryImpl;
import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.data.UnitRepository;
import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.Repository;
import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
