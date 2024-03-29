package _08_InterfacesAndAbstraction_Exc._07_CollectionHierarchy;

public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String string) {
        super.items.add(string);
        return super.items.lastIndexOf(string);
    }
}
