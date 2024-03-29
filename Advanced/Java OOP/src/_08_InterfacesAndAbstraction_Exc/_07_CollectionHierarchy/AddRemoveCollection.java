package _08_InterfacesAndAbstraction_Exc._07_CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public String remove() {
        return super.items.remove(super.items.size() - 1);
    }

    @Override
    public int add(String string) {
        super.items.add(0, string);
        return 0;
    }
}
