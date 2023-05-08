package blocks;

/**
 * This class represents a block in the Tetris System
 *
 * @author Vasco
 */
public class Block {

    /**
     * Character of the block
     */
    private char txt;

    /**
     * Constructor with a character
     *
     * @param txt character of the block
     */
    public Block(char txt) {
        this.txt = txt;
    }

    /**
     * Copy constructor
     *
     * @param b Original block
     */
    public Block(Block b) {
        this(b.txt);
    }

    /**
     * returns character text
     *
     * @return character of the block
     */
    public char getTxt() {
        return txt;
    }

    /**
     * Defines Block character
     *
     * @param txt new character
     */
    public void setTxt(char txt) {
        this.txt = txt;
    }

    /**
     * Returns Block converted to String
     *
     * @return text of block in String
     */
    @Override
    public String toString() {
        return txt + "";
    }

    /**
     * Makes a deep clone of the object
     *
     * @return deep clone
     */
    public Block getClone() {
        return new Block(this);
    }
}
