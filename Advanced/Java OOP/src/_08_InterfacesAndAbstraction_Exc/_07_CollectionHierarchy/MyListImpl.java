package _08_InterfacesAndAbstraction_Exc._07_CollectionHierarchy;

public class MyListImpl extends Collection implements MyList{
    @Override
    public String remove() {
        return super.items.remove(0);
    }

    @Override
    public int add(String string) {
        super.items.add(0, string);
        return 0;
    }

    @Override
    public int getUsed() {
        return super.items.size();
    }
}
