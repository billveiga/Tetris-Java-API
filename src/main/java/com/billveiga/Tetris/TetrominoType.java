package com.billveiga.Tetris;

public enum TetrominoType {
    I(new boolean[][] {
            { false, false, false, false },
            { true, true, true, true },
            { false, false, false, false },
            { false, false, false, false }
    }),
    J(new boolean[][] {
            { true, false, false },
            { true, true, true },
            { false, false, false }
    }),
    L(new boolean[][] {
            { false, false, true },
            { true, true, true },
            { false, false, false }
    }),
    O(new boolean[][] {
            { true, true },
            { true, true }
    }),
    S(new boolean[][] {
            { false, true, true },
            { true, true, false },
            { false, false, false }
    }),
    T(new boolean[][] {
            { false, true, false },
            { true, true, true },
            { false, false, false }
    }),
    Z(new boolean[][] {
            { true, true, false },
            { false, true, true },
            { false, false, false }
    });

    private boolean[][] shape;

    TetrominoType(boolean[][] shape) {
        this.shape = shape;
    }

    public boolean[][] getShape() {
        return shape;
    }
}
