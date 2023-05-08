package blocks;

/**
 *
 * @author Vasco
 */
public class Empty extends Block {

    public Empty() {
        super('.');
    }

    @Override
    public Block getClone() {
        return new Empty();
    }
}
