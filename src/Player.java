public class Player {
    private int x; //Позиция по X
    private int y; //Позиция по Y

    private char sym; //Символ, который его обозначает

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getSym() {
        return sym;
    }

    public void setSym(char sym) {
        this.sym = sym;
    }

    public Player(int x, int y, char sym) {
        this.x = x;
        this.y = y;
        this.sym = sym;
    }
}
