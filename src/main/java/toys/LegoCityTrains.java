package toys;
public class LegoCityTrains extends Toy{
    public LegoCityTrains(int frequency){
        super(frequency);
        this.name = getName();
    }

    private String getName(){
        return "Конструктор Lego Рельсы" + id;

    }
}
