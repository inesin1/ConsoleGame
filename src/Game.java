public class Game {
    //Игровые объекты
    private Map map; //Игровая карта
    private Player player; //Игрок

    private char[][] screenBuffer; //Буфер экрана
    private int screenWidth = 16; //Ширина экрана
    private int screenHeight = 16; //Высота экрана

    public Game(){
        Initialize();
    }

/*    //Ввод
    private void keyPressedRight(){
        System.out.println("Right");
    }
    private void keyPressedLeft(){
        System.out.println("Left");
    }*/

    //Запуск игры
    public void run(){
        long startTime = System.currentTimeMillis(); //Время старта таймера
        long elapsedTime = System.currentTimeMillis() - startTime; //Разница между текущим временем и временем когда запустили таймер
        long elapsedSeconds = elapsedTime / 1000; //Тоже самое, что выше, но в секундах, а не в миллисекундах

        //Игровой цикл
        while (true) {
            Update();

            //Если прошла секунда
            if (elapsedSeconds >= 1) {
                startTime = System.currentTimeMillis(); //Обнуляем таймер

                //Очистка консоли (Отступаем 3 строки)
                for(int i = 0; i < 3; i++) {
                    System.out.println();
                }

                //Отрисовываем все объекты игры
                Draw();
            }

            //Обновляем значения времени
            elapsedTime = System.currentTimeMillis() - startTime;
            elapsedSeconds = elapsedTime / 1000;

        }
    }

    //Инициализация
    public void Initialize(){
        screenBuffer = new char[screenHeight][screenWidth];
        map = new Map(
                16, 16,
                new char[][]{
                        {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#',},
                        {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
                    }
                );

        player = new Player(3, 3, 'P');
    }

    //Обновление
    public void Update(){
        //Обновляем карту на экране
        for (int y = 0; y < screenHeight; y++){
            for (int x = 0; x < screenWidth; x++){
                screenBuffer[y][x] = map.getMatrix()[y][x];
            }
        }

        //Обновляем позицию игрока на экране
        screenBuffer[player.getY()][player.getX()] = player.getSym();
    }

    //Отрисовка
    public void Draw(){
        for (int y = 0; y < screenHeight; y++){
            for (int x = 0; x < screenWidth; x++){
                System.out.print(screenBuffer[y][x] + "  ");
            }
            System.out.println();
        }
    }
}