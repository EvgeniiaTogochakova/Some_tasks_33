package toys;

public class BarbieDoll extends Toy {
    public BarbieDoll(int frequency) {
        super(frequency);
        this.name = getName();
    }

    private String getName() {
        return "Кукла Барби" + id;
    }

}
