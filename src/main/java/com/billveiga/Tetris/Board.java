package com.billveiga.Tetris;

public class Board {
    private boolean[][] grid;
    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[width][height];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isOccupied(int x, int y) {
        return grid[x][y];
    }

    public void setOccupied(int x, int y) {
        grid[x][y] = true;
    }

    public void clearLine(int y) {
        for (int x = 0; x < width; x++) {
            grid[x][y] = false;
        }
        shiftLinesDown(y);
    }

    private void shiftLinesDown(int startY) {
        for (int y = startY - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                grid[x][y + 1] = grid[x][y];
            }
        }
    }

    public boolean isLineComplete(int y) {
        for (int x = 0; x < width; x++) {
            if (!grid[x][y]) {
                return false;
            }
        }
        return true;
    }
}
