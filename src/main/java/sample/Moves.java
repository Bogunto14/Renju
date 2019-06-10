package sample;

class Moves {
    private int[][] board = new int[15][15];
    private int firstPlayer = 1;
    private int secondPlayer;
    private boolean victory = false;

    int[][] getBoard() {
        return board;
    }

    boolean isVictory() {
        return victory;
    }

    int getFirstPlayer() {
        return firstPlayer;
    }

    void point(int x, int y) {
        board[x][y] = firstPlayer;
    }

    boolean emptyPoint(int x, int y) {
        return board[x][y] == 0;
    }

    void changePlayer() {
        if (firstPlayer == 1) {
            firstPlayer = 2;
            secondPlayer = 1;
        } else {
            firstPlayer = 1;
            secondPlayer = 2;
        }
    }

    void winGame(int x, int y) {
        // Победа по горизонтали
        int count = 1;
        int pointX = x;
        int pointY = y;
        while (pointX >= 0 && pointX < 15 && pointY + 1 >= 0 && pointY + 1 < 15 &&
                board[pointX][pointY + 1] != 0 && board[pointX][pointY + 1] != secondPlayer) {
            pointY++;
            count++;
        }
        pointY = y;
        while (pointX >= 0 && pointX < 15 && pointY - 1 >= 0 && pointY - 1 < 15 &&
                board[pointX][pointY - 1] != 0 && board[pointX][pointY - 1] != secondPlayer) {
            pointY--;
            count++;
        }
        if (count >= 5) {
            victory = true;
        }
        // Победа по вертикали
        count = 1;
        pointX = x;
        pointY = y;
        while (pointX + 1 >= 0 && pointX + 1 < 15 && pointY >= 0 && pointY < 15 &&
                board[pointX + 1][pointY] != 0 && board[pointX + 1][pointY] != secondPlayer) {
            pointX++;
            count++;
        }
        pointX = x;
        while (pointX - 1 >= 0 && pointX - 1 < 15 && pointY >= 0 && pointY < 15 &&
                board[pointX - 1][pointY] != 0 && board[pointX - 1][pointY] != secondPlayer) {
            pointX--;
            count++;
        }
        if (count >= 5) {
            victory = true;
        }
        // победа по диагонали
        count = 1;
        pointX = x;
        pointY = y;
        while (pointX + 1 >= 0 && pointX + 1 < 15 && pointY + 1 >= 0 && pointY + 1 < 15
                && board[pointX + 1][pointY + 1] != 0 && board[pointX + 1][pointY + 1] != secondPlayer) {
            pointX++;
            pointY++;
            count++;
        }
        pointX = x;
        pointY = y;
        while (pointX - 1 >= 0 && pointX - 1 < 15 && pointY - 1 >= 0 && pointY - 1 < 15 &&
                board[pointX - 1][pointY - 1] != 0 && board[pointX - 1][pointY - 1] != secondPlayer) {
            pointX--;
            pointY--;
            count++;
        }
        if (count >= 5) {
            victory = true;
        }
        // победа по второй диагонали
        count = 1;
        pointX = x;
        pointY = y;
        while (pointX + 1 >= 0 && pointX + 1 < 15 && pointY - 1 >= 0 && pointY - 1 < 15 &&
                board[pointX + 1][pointY - 1] != 0 && board[pointX + 1][pointY - 1] != secondPlayer) {
            pointX++;
            pointY--;
            count++;
        }
        pointX = x;
        pointY = y;
        while (pointX - 1 >= 0 && pointX - 1 < 15 && pointY + 1 >= 0 && pointY + 1 < 15 &&
                board[pointX - 1][pointY + 1] != 0 && board[pointX - 1][pointY + 1] != secondPlayer) {
            pointX--;
            pointY++;
            count++;
        }
        if (count >= 5) {
            victory = true;
        }
    }
}