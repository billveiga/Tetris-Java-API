package com.billveiga.Tetris;

public class TetrisGame {
    private Board board;
    private Tetromino currentPiece;
    private int currentX;
    private int currentY;

    public TetrisGame(int width, int height) {
        board = new Board(width, height);
        currentPiece = null;
        currentX = 0;
        currentY = 0;
    }

    public boolean[][] getBoard() {
        return board.getGrid();
    }

    public Tetromino getCurrentPiece() {
        return currentPiece;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void moveLeft() {
        if (currentPiece != null && !isCollision(currentPiece, currentX - 1, currentY)) {
            currentX--;
        }
    }

    public void moveRight() {
        if (currentPiece != null && !isCollision(currentPiece, currentX + 1, currentY)) {
            currentX++;
        }
    }

    public void moveDown() {
        if (currentPiece != null && !isCollision(currentPiece, currentX, currentY + 1)) {
            currentY++;
        }
    }

    public void rotate() {
        if (currentPiece != null) {
            Tetromino rotatedPiece = currentPiece.rotate();
            if (!isCollision(rotatedPiece, currentX, currentY)) {
                currentPiece = rotatedPiece;
            }
        }
    }

    public void spawnPiece() {
        TetrominoType[] types = TetrominoType.values();
        TetrominoType randomType = types[(int) (Math.random() * types.length)];
        boolean[][] newShape = new boolean[0][];
        currentPiece = new Tetromino(randomType, newShape);
        currentX = board.getWidth() / 2 - currentPiece.getWidth() / 2;
        currentY = 0;
    }

    public boolean isCollision(Tetromino piece, int x, int y) {
        boolean[][] shape = piece.getShape();
        int width = shape.length;
        int height = shape[0].length;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (shape[i][j] && (x + i < 0 || x + i >= board.getWidth() || y + j >= board.getHeight()
                        || board.isOccupied(x + i, y + j))) {
                    return true;
                }
            }
        }

        return false;
    }

    public void mergePiece() {
        boolean[][] shape = currentPiece.getShape();
        int width = shape.length;
        int height = shape[0].length;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (shape[i][j]) {
                    board.setOccupied(currentX + i, currentY + j);
                }
            }
        }
    }

    public void checkLines() {
        int linesCleared = 0;
        for (int y = 0; y < board.getHeight(); y++) {
            if (board.isLineComplete(y)) {
                board.clearLine(y);
                linesCleared++;
            }
        }
        // Update score and level based on lines cleared
        // ...
    }

    public boolean isGameOver() {
        return isCollision(currentPiece, currentX, currentY);
    }

    // Other methods as needed
}
