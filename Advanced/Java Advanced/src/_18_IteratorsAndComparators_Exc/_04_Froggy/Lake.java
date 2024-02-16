package _18_IteratorsAndComparators_Exc._04_Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> numbers;
    private boolean lastElement = false;

    public Lake(int[] numbers) {
        this.numbers = new ArrayList<>();
        for (int num : numbers) {
            this.numbers.add(num);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog(numbers);
    }

    public boolean isLastElement() {
        return lastElement;
    }

    public void setLastElement(boolean lastElement) {
        this.lastElement = lastElement;
    }

    public class Frog implements Iterator<Integer> {
        private int evenCounter;
        private int oddCounter;
        private List<Integer> numbers;

        public Frog(List<Integer> numbers) {
            this.evenCounter = -2;
            this.oddCounter = -1;
            this.numbers = numbers;
        }

        @Override
        public boolean hasNext() {
            if (this.numbers.size() == 1) {
                setLastElement(true);
                return this.evenCounter < 0;
            }
            return this.oddCounter < numbers.size() - 2;
        }

        @Override
        public Integer next() {
            this.evenCounter += 2;
            if (this.evenCounter < this.numbers.size()) {
                return this.numbers.get(evenCounter);

            }

            this.oddCounter += 2;
            if (this.oddCounter < this.numbers.size()) {
                if (this.oddCounter == this.numbers.size() - 1
                || this.oddCounter == this.numbers.size() - 2) {
                    setLastElement(true);
                }
                return this.numbers.get(oddCounter);
            }


            return 0;
        }
    }
}
