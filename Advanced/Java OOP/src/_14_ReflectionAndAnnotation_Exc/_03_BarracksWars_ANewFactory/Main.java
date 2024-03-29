package _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory;

import _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.interfaces.Repository;
import _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.interfaces.Runnable;
import _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.interfaces.UnitFactory;
import _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.core.Engine;
import _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.core.factories.UnitFactoryImpl;
import _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
