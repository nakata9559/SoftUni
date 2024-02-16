package _20_PastExams._2022_06_June._03_Workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exerciseCount > this.exercises.size()) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return this.exercises.removeIf(exercise ->
                exercise.getName().equals(name) && exercise.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream()
                .filter(e -> (e.getName().equals(name) && e.getMuscle().equals(muscle)))
                .findAny()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream()
                .max(Comparator.comparing(Exercise::getBurnedCalories))
                .orElse(null);
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        return String.format("Workout type: %s%n" +
                "%s",
                this.type,
                String.join(System.lineSeparator(),
                        this.exercises.stream()
                                .map(String::valueOf)
                                .toArray(String[]::new)));
    }
}
