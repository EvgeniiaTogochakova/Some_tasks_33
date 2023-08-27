package toys;

public abstract class Toy implements Comparable<Toy> {
    protected static int id = 0;
    protected String name;
    public int frequency;

    public Toy(int frequency) {
        this.frequency = frequency;
        ++id;
    }

    public String getInfo() {
        return this.name + " частота " + this.frequency;
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.frequency, o.frequency);
    }

    public String getToyName() {
        return this.name;
    }
}