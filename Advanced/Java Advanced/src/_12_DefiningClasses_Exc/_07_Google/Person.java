package _12_DefiningClasses_Exc._07_Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setParents(Parent parent) {
        if (this.parents == null) {
            this.parents = new ArrayList<>();
            this.parents.add(parent);
        } else {
            this.parents.add(parent);
        }
    }

    public void setChildren(Child child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
            this.children.add(child);
        } else {
            this.children.add(child);
        }
    }

    public void setPokemons(Pokemon pokemon) {
        if (this.pokemons == null) {
            this.pokemons = new ArrayList<>();
            this.pokemons.add(pokemon);
        } else {
            this.pokemons.add(pokemon);
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                "Company: %s%n" +
                "Car: %s%n" +
                "Pokemon: %s%n" +
                "Parents: %s%n" +
                "Children: %s",
                this.name != null ? this.name : "",
                this.company != null ? this.company : "",
                this.car != null ? this.car : "",
                this.pokemons != null ? String.join("", this.pokemons.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())) : "",
                this.parents != null ? String.join("", this.parents.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())) : "",
                this.children != null ? String.join("", this.children.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())) : "");
    }
}
