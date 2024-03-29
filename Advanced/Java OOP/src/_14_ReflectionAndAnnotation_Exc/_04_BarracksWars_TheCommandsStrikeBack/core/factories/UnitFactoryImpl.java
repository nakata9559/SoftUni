package _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.core.factories;

import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.Unit;
import _14_ReflectionAndAnnotation_Exc._04_BarracksWars_TheCommandsStrikeBack.interfaces.UnitFactory;

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
