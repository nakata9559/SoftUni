package _04_Encapsulation_Exc._04_PizzaCalories;

import java.util.Map;

public class Dough {
    private static final Map<String, Double> FLOUR_TYPE = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0
    );
    private static final Map<String, Double> BAKING_TECHNIQUE = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0
    );
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public double calculateCalories() {
        return 2 *
                this.weight *
                FLOUR_TYPE.get(this.flourType) *
                BAKING_TECHNIQUE.get(this.bakingTechnique);
    }

    private void setFlourType(String flourType) {
        if (!FLOUR_TYPE.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!BAKING_TECHNIQUE.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
}
