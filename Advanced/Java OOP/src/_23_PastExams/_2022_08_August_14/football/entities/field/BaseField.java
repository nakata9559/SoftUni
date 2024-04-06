package _23_PastExams._2022_08_August_14.football.entities.field;

import _23_PastExams._2022_08_August_14.football.entities.player.Women;
import _23_PastExams._2022_08_August_14.football.entities.player.Men;
import _23_PastExams._2022_08_August_14.football.entities.player.Player;
import _23_PastExams._2022_08_August_14.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;

import static _23_PastExams._2022_08_August_14.football.common.ConstantMessages.FIELD_NOT_SUITABLE;
import static _23_PastExams._2022_08_August_14.football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static _23_PastExams._2022_08_August_14.football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream()
                .mapToInt(Supplement::getEnergy)
                .sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this instanceof ArtificialTurf && player instanceof Women ||
        this instanceof NaturalGrass && player instanceof Men) {

            if (this.capacity > this.players.size()) {
                this.players.add(player);
            } else {
                throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
            }

        } else {
            throw new IllegalArgumentException(FIELD_NOT_SUITABLE);
        }
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() throws NoSuchFieldException, IllegalAccessException {
        for (Player player : this.players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s (%s):",
                this.name,
                this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());

        sb.append("Player: ");
        String players = this.players.isEmpty() ?
                "none" :
                String.join(" ", this.players.stream()
                        .map(Player::getName)
                        .toArray(String[]::new));
        sb.append(players);
        sb.append(System.lineSeparator());

        sb.append(String.format("Supplement: %d",
                this.supplements.size()));
        sb.append(System.lineSeparator());

        sb.append(String.format("Energy: %d",
                this.sumEnergy()));

        return sb.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }
}
