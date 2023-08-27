package toys;

public class TeddyBear extends Toy {
    public TeddyBear(int frequency) {
        super(frequency);
        this.name = getName();
    }

    private String getName() {
        return "Плюшевый медведь" + id;
    }
}
