package com.lixin.demo.test.swing.gluttonous_snake;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author lixin
 * @date 2021/12/16 15:59
 * @describe 贪吃蛇
 */
public class Snake extends LinkedList<Point> {

    public int snakeDirection = 2;
    public int snakeReDirection = 4;

    public Snake() {
        /**
         * 添加默认节点
         */
        this.add(new Point(3, 3));
        this.add(new Point(4, 3));
        this.add(new Point(5, 3));
    }

    /**
     * 根据方向添加蛇的节点
     *
     * @param temp
     * @param direction
     */
    public void changeDirection(Point temp, int direction) {
        this.snakeDirection = direction;
        switch (direction) {
            case 1://向上
                this.snakeReDirection = 3;
                this.add(new Point(temp.x, temp.y - 1));
                break;
            case 2://向右
                this.snakeReDirection = 4;
                this.add(new Point(temp.x + 1, temp.y));
                break;
            case 3://向下
                this.snakeReDirection = 1;
                this.add(new Point(temp.x, temp.y + 1));
                break;
            case 4://向左
                this.snakeReDirection = 2;
                this.add(new Point(temp.x - 1, temp.y));
                break;
            default:
                break;
        }
    }

    /**
     * 清除
     *
     * @param bean
     * @return
     */
    public boolean checkBeanIn(Point bean) {
        return getLast().equals(bean);
    }

    /**
     * 删除
     */
    public void removeTail() {
        this.remove(0);
    }

    /**
     * 绘制蛇
     *
     * @param g
     * @param x
     * @param y
     */
    public void drawSnake(Graphics g, int x, int y) {
        g.setColor(SnakeFrame.SNAKE_COLOR);
        for (Point p : this) {
            g.fillRect(x * p.x + 1, y * p.y + 1, x - 2, y - 2);
        }
    }

    /**
     * 清除节点
     *
     * @param g
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void clearEndSnakePiece(Graphics g, int x1, int y1, int x2, int y2) {
        g.setColor(SnakeFrame.BG_COLOR);
        g.fillRect(x1 * x2 + 1, y1 * y2 + 1, x2 - 2, y2 - 2);

    }
}
