package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch03StacksandQueues.Q3_06_Animal_Shelter1;

public abstract class Animal {
    protected String name;
    private int order;

    public Animal(String n) {
        name = n;
    }

    public abstract String name();

    public int getOrder() {
        return order;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}
