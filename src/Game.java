class Game {
    private static boolean isX = true; // to keep track if it's X or O to be placed

    Game() {
         new MainFrame();
    }

    static boolean getIsX() {
        return isX;
    }

    static void setIsX(boolean isX) {
        Game.isX = isX;
    }
}
