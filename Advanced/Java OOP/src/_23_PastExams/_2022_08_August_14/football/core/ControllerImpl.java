package _23_PastExams._2022_08_August_14.football.core;

import _23_PastExams._2022_08_August_14.football.repositories.SupplementRepositoryImpl;
import _23_PastExams._2022_08_August_14.football.entities.field.Field;
import _23_PastExams._2022_08_August_14.football.entities.player.Player;
import _23_PastExams._2022_08_August_14.football.entities.supplement.Supplement;
import _23_PastExams._2022_08_August_14.football.factory.Factory;
import _23_PastExams._2022_08_August_14.football.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static _23_PastExams._2022_08_August_14.football.common.ConstantMessages.*;
import static _23_PastExams._2022_08_August_14.football.common.ExceptionMessages.NO_SUPPLEMENT_FOUND;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        this.fields.add(Factory.createNew(fieldType, fieldName));

        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        this.supplement.add(Factory.createNew(type));

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = this.supplement.findByType(supplementType);

        if (null == supplement) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field field = getFieldByName(fieldName);
        field.addSupplement(supplement);

        this.supplement.remove(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player = Factory.createNew(playerType, playerName, nationality, strength);

        Field field = getFieldByName(fieldName);
        field.addPlayer(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = getFieldByName(fieldName);

        assert field != null;
        field.drag();

        int numOfPlayers = field.getPlayers().size();

        return String.format(PLAYER_DRAG, numOfPlayers);    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getFieldByName(fieldName);

        assert field != null;
        int totalStrength = field.getPlayers()
                .stream()
                .mapToInt(Player::getStrength)
                .sum();

        return String.format(STRENGTH_FIELD,
                fieldName,
                totalStrength);
    }

    @Override
    public String getStatistics() {
        return String.join(System.lineSeparator(),
                this.fields.stream()
                        .map(Field::getInfo)
                        .toArray(String[]::new));
    }

    private Field getFieldByName(String fieldName) {
        return this.fields.stream()
                .filter(field1 -> field1.getName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }
}
