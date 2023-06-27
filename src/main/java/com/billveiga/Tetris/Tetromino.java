package com.billveiga.Tetris;

public class Tetromino {
    private TetrominoType type;
    private boolean[][] shape;
    private int width;
    private int height;

    public Tetromino(TetrominoType type, boolean[][] newShape) {
        this.type = type;
        this.shape = type.getShape();
        this.width = shape.length;
        this.height = shape[0].length;
    }

    public TetrominoType getType() {
        return type;
    }

    public boolean[][] getShape() {
        return shape;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tetromino rotate() {
        boolean[][] newShape = new boolean[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newShape[j][width - 1 - i] = shape[i][j];
            }
        }
        return new Tetromino(type, newShape);
    }
}
