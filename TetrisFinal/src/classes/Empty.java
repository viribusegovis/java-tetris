package classes;

public class Empty extends Block{
    public Empty() {
        super('.');
    }

    public Empty getClone(){
        return new Empty();
    }
}
