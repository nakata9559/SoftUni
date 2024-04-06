package _23_PastExams._2022_12_December_19.magicGame.core;

import _23_PastExams._2022_12_December_19.magicGame.common.OutputMessages;
import _23_PastExams._2022_12_December_19.magicGame.models.magicians.BlackWidow;
import _23_PastExams._2022_12_December_19.magicGame.models.magicians.Magician;
import _23_PastExams._2022_12_December_19.magicGame.models.magicians.Wizard;
import _23_PastExams._2022_12_December_19.magicGame.models.magics.BlackMagic;
import _23_PastExams._2022_12_December_19.magicGame.models.magics.Magic;
import _23_PastExams._2022_12_December_19.magicGame.models.magics.RedMagic;
import _23_PastExams._2022_12_December_19.magicGame.models.region.Region;
import _23_PastExams._2022_12_December_19.magicGame.models.region.RegionImpl;
import _23_PastExams._2022_12_December_19.magicGame.repositories.MagicRepositoryImpl;
import _23_PastExams._2022_12_December_19.magicGame.repositories.MagicianRepositoryImpl;
import _23_PastExams._2022_12_December_19.magicGame.repositories.interfaces.MagicRepository;
import _23_PastExams._2022_12_December_19.magicGame.repositories.interfaces.MagicianRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static _23_PastExams._2022_12_December_19.magicGame.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private MagicRepository<Magic> magics;
    private MagicianRepository<Magician> magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl<>();
        this.magicians = new MagicianRepositoryImpl<>();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        switch (type) {
            case "RedMagic":
                this.magics.addMagic(new RedMagic(name, bulletsCount));
                break;

            case "BlackMagic":
                this.magics.addMagic(new BlackMagic(name, bulletsCount));
                break;

            default:
                throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = this.magics.findByName(magicName);

        if (magic == null) {
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }

        switch (type) {
            case "Wizard":
                this.magicians.addMagician(new Wizard(username, health, protection, magic));
                break;

            case "BlackWidow":
                this.magicians.addMagician(new BlackWidow(username, health, protection, magic));
                break;

            default:
                throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return this.region.start(
                this.magicians.getData()
                        .stream()
                        .filter(Magician::isAlive)
                        .collect(Collectors.toList()));
    }

    @Override
    public String report() {
        Collection<Magician> sortedMagicians =
                this.magicians.getData()
                .stream()
                .sorted(Comparator.comparing(Magician::getHealth)
                        .thenComparing((magician1, magician2) -> magician1.getUsername().compareToIgnoreCase(magician2.getUsername())))
                .collect(Collectors.toList());

        return String.join(System.lineSeparator(),
                sortedMagicians
                        .stream()
                        .map(Object::toString)
                        .toArray(String[]::new));
    }
}
