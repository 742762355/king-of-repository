package com.lixin.demo.test.swing.gluttonous_snake;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author lixin
 * @date 2021/12/16 17:17
 * @describe 委托的key处理者
 */
public class DelegateKeyHandler extends KeyAdapter {

    private final static int RESET = 10;
    private final static int STOP = 27;
    private final static int SHANG = 37;
    private final static int XIA = 39;
    private final static int ZUO = 38;
    private final static int YOU = 40;
    private final static int SAFE_STOP = 32;

    private GameDrawingBoard gameDrawingBoard;

    public DelegateKeyHandler(GameDrawingBoard gameDrawingBoard) {
        this.gameDrawingBoard = gameDrawingBoard;
    }

    public void handle(int keyCode, GameDrawingBoard gameDrawingBoard) {
        //todo 根据键盘key来实现操作
        Timer timer = gameDrawingBoard.timer;
        Snake snake = gameDrawingBoard.getSnake();
        if (keyCode == 10) {
            gameDrawingBoard.resetGame();
        } else if (keyCode == 27) {
            timer.stop();
            if (JOptionPane.showConfirmDialog(null, "你确定退出吗？") == 0) {
                System.exit(0);
            }
            timer.start();
        } else if (keyCode == 37 && snake.snakeDirection != 2) {
            gameDrawingBoard.setDirection(4);
        } else if (keyCode == 39 && snake.snakeDirection != 4) {
            gameDrawingBoard.setDirection(2);
        } else if (keyCode == 38 && snake.snakeDirection != 3) {
            gameDrawingBoard.setDirection(1);
        } else if (keyCode == 40 && snake.snakeDirection != 1) {
            gameDrawingBoard.setDirection(3);
        } else if (keyCode == 32) {
            if (!gameDrawingBoard.isHasStoped()) {
                if (!gameDrawingBoard.isMark()) {
                    timer.stop();
                    gameDrawingBoard.setMark(true);
                } else {
                    timer.start();
                    gameDrawingBoard.setMark(false);
                }
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        handle(e.getKeyCode(), gameDrawingBoard);
    }
}
