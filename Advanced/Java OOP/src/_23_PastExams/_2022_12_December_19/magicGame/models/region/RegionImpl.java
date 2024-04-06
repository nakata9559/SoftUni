package _23_PastExams._2022_12_December_19.magicGame.models.region;

import _23_PastExams._2022_12_December_19.magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.stream.Collectors;

public class RegionImpl implements Region{

    @Override
    public String start(Collection<Magician> magicians) {
        Collection<Magician> wizards = magicians.stream()
                .filter(magician -> magician.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());

        Collection<Magician> blackWidows = magicians.stream()
                .filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());


        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            Collection<Magician> finalBlackWidows = blackWidows;

            wizards.forEach(wizard -> {
                finalBlackWidows.forEach(blackWidow ->
                        blackWidow.takeDamage(wizard.getMagic().fire()));
            });

            blackWidows = blackWidows.stream()
                    .filter(Magician::isAlive)
                    .collect(Collectors.toList());

            Collection<Magician> finalWizards = wizards;

            blackWidows.forEach(blackWidow -> {
                finalWizards.forEach(wizard ->
                        wizard.takeDamage(blackWidow.getMagic().fire()));
            });

            wizards = wizards.stream()
                    .filter(Magician::isAlive)
                    .collect(Collectors.toList());
        }

        if (blackWidows.isEmpty()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
