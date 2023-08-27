package toys;
public class RobotBumblebee extends Toy{
    public RobotBumblebee(int frequency){
        super(frequency);
        this.name = getName();

    }

    private String getName(){
        return "Робот-трансформер Бамблби" + id;

    }
}
