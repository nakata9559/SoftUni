package _23_PastExams._2022_04_April_18.petStore;

import _23_PastExams._2022_04_April_18.petStore.Animal;
import _23_PastExams._2022_04_April_18.petStore.PetStore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PetStoreTests {
    private static final Animal ANIMAL1 = new Animal("Rat", 5, 59.99);
    private static final Animal ANIMAL2 = new Animal("Mouse", 3, 79.99);
    private PetStore petStore;

    @Before
    public void setUp(){
        this.petStore = new PetStore();
    }

    @Test
    public void test_Get_Animals_Returns_Correct_Animal(){
        this.petStore.addAnimal(ANIMAL1);
        Animal animal = this.petStore.getAnimals().get(0);

        Assert.assertEquals(animal.getAge(), ANIMAL1.getAge());
        Assert.assertEquals(animal.getPrice(), ANIMAL1.getPrice(), 0.0);
        Assert.assertEquals(animal.getMaxKilograms(), ANIMAL1.getMaxKilograms());
        Assert.assertEquals(animal.getPrice(), ANIMAL1.getPrice(), 0.0);
    }

    @Test
    public void test_Get_Count_Returns_Correct_Amount(){
        this.petStore.addAnimal(ANIMAL1);

        Assert.assertEquals(1, this.petStore.getCount());
    }

    @Test
    public void test_Find_All_Animals_With_Max_Kilograms_Returns_Correct_Animals(){
        this.petStore.addAnimal(ANIMAL1);
        this.petStore.addAnimal(ANIMAL2);

        Animal animal = this.petStore.findAllAnimalsWithMaxKilograms(4).get(0);

        Assert.assertEquals(animal, ANIMAL1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_Null_Animal() {
        this.petStore.addAnimal(null);
    }

    @Test
    public void test_Get_Most_Expensive_Animal_Returns_Correct_Animal(){
        this.petStore.addAnimal(ANIMAL1);
        this.petStore.addAnimal(ANIMAL2);

        Animal animal = this.petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals(animal, ANIMAL2);
    }

    @Test
    public void test_Find_All_Animals_By_Specie_Returns_Correct_Animals(){
        this.petStore.addAnimal(ANIMAL1);
        this.petStore.addAnimal(ANIMAL2);

        Animal animal = this.petStore.findAllAnimalBySpecie("Rat").get(0);

        Assert.assertEquals(animal, ANIMAL1);
    }

    @Test
    public void test_Animal_Set_Age_Method(){
        ANIMAL1.setAge(10);

        Assert.assertEquals(10, ANIMAL1.getAge());
    }
}

