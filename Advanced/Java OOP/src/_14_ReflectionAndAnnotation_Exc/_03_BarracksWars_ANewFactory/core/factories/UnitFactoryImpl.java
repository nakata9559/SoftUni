package _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.core.factories;

import _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.interfaces.Unit;
import _14_ReflectionAndAnnotation_Exc._03_BarracksWars_ANewFactory.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String className = UNITS_PACKAGE_NAME + unitType;

		Class<?> unitClass = Class.forName(className);

		Constructor<?> constructor = unitClass.getDeclaredConstructor();

		return (Unit) constructor.newInstance();
	}
}
