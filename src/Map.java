public class Map {
    private int width; //Ширина
    private int height; //Высота

    private char[][] matrix; //Массив символов карты

    //Конструктор
    public Map(int width, int height, char[][] matrix) {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    //Геттеры и сеттеры
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
