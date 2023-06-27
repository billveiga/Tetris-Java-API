package com.billveiga.Tetris;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TetrisController {
    private TetrisGame tetrisGame;
    @GetMapping("/tetris")
    public String showTetrisPage() {
        return "tetris.html";
    }
    public TetrisController() {
        tetrisGame = new TetrisGame(10, 20); // Tamanho do tabuleiro: 10 colunas x 20 linhas
        tetrisGame.spawnPiece(); // Gerar a primeira peça
    }

    @GetMapping("/board")
    public boolean[][] getBoard() {
        return tetrisGame.getBoard();
    }

    @PostMapping("/left")
    public void moveLeft() {
        tetrisGame.moveLeft();
    }

    @PostMapping("/right")
    public void moveRight() {
        tetrisGame.moveRight();
    }

    @PostMapping("/down")
    public void moveDown() {
        tetrisGame.moveDown();
    }

    @PostMapping("/rotate")
    public void rotate() {
        tetrisGame.rotate();
    }

    // Outros métodos conforme necessário
}
