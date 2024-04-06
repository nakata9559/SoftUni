package _23_PastExams._2022_04_April_09.fairyShop.models;

import java.util.Iterator;

public class ShopImpl implements Shop{

    @Override
    public void craft(Present present, Helper helper) {
        Iterator<Instrument> instrumentsIterator = helper.getInstruments()
                .stream()
                .filter(instrument -> !instrument.isBroken())
                .iterator();
        Instrument currentInstrument = null;

        while (helper.canWork() && !present.isDone()) {
            if (currentInstrument == null || currentInstrument.isBroken()) {
                if (instrumentsIterator.hasNext()) {
                    currentInstrument = instrumentsIterator.next();
                } else {
                    break;
                }
            }

            helper.work();
            currentInstrument.use();
            present.getCrafted();
        }
    }
}
