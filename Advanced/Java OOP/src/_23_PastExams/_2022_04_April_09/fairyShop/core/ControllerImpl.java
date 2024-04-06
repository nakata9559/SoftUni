package _23_PastExams._2022_04_April_09.fairyShop.core;

import _23_PastExams._2022_04_April_09.fairyShop.models.*;
import _23_PastExams._2022_04_April_09.fairyShop.repositories.Repository;
import _23_PastExams._2022_04_April_09.fairyShop.repositories.HelperRepository;
import _23_PastExams._2022_04_April_09.fairyShop.repositories.PresentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import static _23_PastExams._2022_04_April_09.fairyShop.common.ConstantMessages.*;
import static _23_PastExams._2022_04_April_09.fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private Repository<Helper> helpers;
    private Repository<Present> presents;

    public ControllerImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        //this.helpers.add(HelperFactory.createHelper(type, helperName));

        switch (type) {
            case "Happy":
                this.helpers.add(new Happy(helperName));
                break;

            case "Sleepy":
                this.helpers.add(new Sleepy(helperName));
                break;

            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = this.helpers.findByName(helperName);

        if (null == helper) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        helper.addInstrument(new InstrumentImpl(power));

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        this.presents.add(new PresentImpl(presentName, energyRequired));

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Collection<Helper> helpers = this.helpers.getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        if (helpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        Present present = this.presents.findByName(presentName);

        helpers.forEach(helper -> {
            ShopImpl shop = new ShopImpl();
            shop.craft(present, helper);
        });

        String presentCondition = present.isDone() ? "done" : "not done";
        long brokenInstruments = 0;

        for (Helper helper : helpers) {
            brokenInstruments += helper.getInstruments()
                    .stream()
                    .filter(Instrument::isBroken)
                    .count();
        }

        return String.format(PRESENT_DONE, presentName, presentCondition) + String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d presents are done!",
                this.presents.getModels()
                        .stream()
                        .filter(Present::isDone)
                        .count()));
        sb.append(System.lineSeparator());

        sb.append("Helpers info:");
        sb.append(System.lineSeparator());

        sb.append(String.join(System.lineSeparator(),
                this.helpers.getModels()
                        .stream()
                        .map(helper -> String.format("Name: %s%n" +
                                "Energy: %d%n" +
                                "Instruments: %d not broken left",
                                helper.getName(),
                                helper.getEnergy(),
                                helper.getInstruments().stream()
                                        .filter(instrument -> !instrument.isBroken())
                                        .count()))
                        .toArray(String[]::new)));

        return sb.toString();
    }
}
