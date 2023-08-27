package toys;
public class RobotSportscar extends Toy{
    public RobotSportscar(int frequency){
        super(frequency);
        this.name = getName();

    }

    private String getName(){
        return "Робот-трансформер Спорткар" + id;

    }
}
