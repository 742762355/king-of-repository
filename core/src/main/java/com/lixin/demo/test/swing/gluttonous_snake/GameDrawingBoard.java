package com.lixin.demo.test.swing.gluttonous_snake;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.*;

/**
 * @author     lixin
 * @date       2021/12/16 16:01
 * @describe   游戏画板,用于存放贪吃蛇
 */
public class GameDrawingBoard extends Canvas {

    private int horizontalCount,verticalCount;

    private int x,y;

    private Snake snake;

    private LinkedList<Point> eatedBean=new LinkedList<>();

    private Iterator<Point> snakeSq;

    public Timer timer;

    private int direction=2;

    private int score;

    private Point bean=new Point();

    private boolean mark;

    private boolean hasStoped;

    public GameDrawingBoard() {
        this.horizontalCount=25;
        this.verticalCount=20;
        this.x=400/25;
        this.y=300/20;
        this.addKeyListener(new DelegateKeyHandler(this));
        this.timer=new Timer(180,new TimerHandler());
        this.snake=new Snake();
        this.hasStoped=false;
        this.setBackground(SnakeFrame.BG_COLOR);
    }


    private class TimerHandler implements ActionListener{

        @Override
        public synchronized void actionPerformed(ActionEvent e) {
            Point temp = snake.getLast();
            while (snakeSq.hasNext()) {
                Point tempPoint = snakeSq.next();
                if (temp.equals(tempPoint)&& snakeSq.hasNext()) {
                    timer.stop();
                    stopGame();
                    JOptionPane.showMessageDialog(null,"游戏结束！");
                }
            }
            //判断游戏结束
            if ((temp.x ==0 &&direction==4)||(temp.x==horizontalCount-1 &&direction==2)||(temp.y==0&&direction==1)||(temp.y==verticalCount-1&&direction==3) ) {
                timer.stop();
                stopGame();
                JOptionPane.showMessageDialog(null,"游戏结束！");
            }
            if (direction!=snake.snakeReDirection) {
                moveSnake(direction);
            }
            snake.drawSnake(getGraphics(),x,y);

            drawBeanAndEBean(getGraphics());
        }
    }

    /**
     * 游戏结束
     */
    public void stopGame(){
        this.hasStoped = true;
        this.timer.stop();
        Graphics2D g=(Graphics2D)GameDrawingBoard.this.getGraphics();
        g.setColor(SnakeFrame.BG_COLOR);
        super.paint(g);
    }
    /**
     * 游戏开始
     */
    public void resetGame(){
        System.gc();
        this.hasStoped=false;
        Graphics2D g=(Graphics2D)getGraphics();
        g.setColor(SnakeFrame.BG_COLOR);
        super.paint(g);
        this.snake = new Snake();
        this.createBean(bean);
        this.eatedBean.clear();
        snake.drawSnake(getGraphics(),x,y);
        this.timer.start();
        this.direction=2;
        this.score=0;
    }
    /**
     * 蛇的移动
     * @param direction
     */
    private void moveSnake(int direction){
        //判断是否吃到食物
        if (snake.checkBeanIn(this.bean)) {
            this.score+=100;
            SnakeFrame.SCORE_LAB.setText("得分："+this.score+" ");
            //添加到吃过的食物列表
            this.eatedBean.add(new Point(this.bean));
            //创建一个新的食物
            this.createBean(this.bean);
        }
        //
        snake.changeDirection(snake.get(snake.size()-1),direction);

        Point p=snake.get(0);
        if (eatedBean.size()!=0) {
            if (eatedBean.getFirst().equals(p)) {
                eatedBean.remove(0);
            }else {
                snake.clearEndSnakePiece(getGraphics(),p.x,p.y,x,y);
                snake.removeTail();
            }
        }else {
            snake.clearEndSnakePiece(getGraphics(),p.x,p.y,x,y);
            snake.removeTail();
        }
    }

    /**
     * 绘制食物
     * @param g
     */
    private void drawBeanAndEBean(Graphics g){
        //设置食物的颜色
        g.setColor(SnakeFrame.FOOD_COLOR);
        this.drawPiece(g,this.bean.x,this.bean.y);
        //设置正在吃的食物颜色
//        g.setColor(SnakeFrame.EATEDBEANCOLOR);

        snakeSq =eatedBean.iterator();
        while (snakeSq.hasNext()) {
            Point tempPoint = snakeSq.next();
            this.drawPiece(g,tempPoint.x,tempPoint.y);
        }
    }

    /**
     * 绘制填充的矩形块
     * @param g
     * @param x
     * @param y
     */
    private void drawPiece(Graphics g,int x,int y){
        g.fillRect(this.x*x+1, this.y*y+1, this.x-2, this.y-2);
    }
    /**
     * 随机创建食物
     * @param temp
     */
    private void createBean(Point temp){
        temp.x =(int)(Math.random()*this.horizontalCount);
        temp.y =(int)(Math.random()*this.verticalCount);
        snakeSq =snake.iterator();
        while (snakeSq.hasNext()) {
            if (snakeSq.next().equals(new Point(temp.x,temp.y))) {
                break;
            }
        }
    }

    public void setFocus(boolean focusAble) {
        requestFocus(focusAble);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Snake getSnake() {
        return snake;
    }

    public boolean isHasStoped() {
        return hasStoped;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }
}
