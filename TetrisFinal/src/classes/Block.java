package classes;

public class Block {

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    private char id;

    public Block(char id){
        this.id = id;
    }

    public Block(Block b){
        this(b.id);
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public Block getClone(){
        return new Block(this);
    }

}
