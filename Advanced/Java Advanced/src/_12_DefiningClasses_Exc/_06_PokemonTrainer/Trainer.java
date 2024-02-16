package _12_DefiningClasses_Exc._06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
        this.pokemons.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public void addPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void checkElement(String element) {
        if (this.pokemons.isEmpty()) {
            return;
        }

        boolean takesDamage = true;

        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                takesDamage = false;
                break;
            }
        }

        if (takesDamage) {
            this.pokemons.forEach(e1 -> {
                if (!e1.stillAlive()) {
                    this.pokemons = this.pokemons
                            .stream()
                            .filter(e2 -> !e2.equals(e1))
                            .collect(Collectors.toList());
                }
            });
        } else {
            this.badges = this.badges + 1;
        }
    }

    public int getBadges() {
        return badges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",
                this.name,
                this.badges,
                this.pokemons.size());
    }
}
