package com.lixin.demo.test.swing.gluttonous_snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author lixin
 * @date 2021/12/16 16:04
 * @describe
 */
public class SnakeFrame extends JFrame {

    public static final Color BG_COLOR = Color.BLACK;

    public static final Color SNAKE_COLOR = Color.GREEN;

    public static final Color FOOD_COLOR = Color.RED;

    private static final JLabel TIPS_LAB = new JLabel("请使用键盘上的<上下左右>按钮控制方向-空格暂停-ESC退出") {{
        setBounds(10, 320, 400, 30);
    }};

    public static JLabel SCORE_LAB = new JLabel("得分:0") {{
        setBounds(10, 10, 400, 300);
    }};

    private JButton startButton = new JButton("开始游戏") {{
        setBounds(430, 150, 100, 50);
    }};

    private GameDrawingBoard gameDrawingBoard = new GameDrawingBoard() {{
        setBounds(10, 10, 400, 300);
    }};

    public SnakeFrame() {
        JPanel panel = new JPanel(null);

        startButton.addActionListener((actionEvent) -> {
            gameDrawingBoard.resetGame();
            startButton.setFocusable(false);
            gameDrawingBoard.setFocus(true);
        });

        panel.add(startButton);
        panel.add(TIPS_LAB);
        panel.add(gameDrawingBoard);
        panel.add(createMenuTab());
//        setTitle("-贪吃蛇v1.0.0-");
        setIconImage(new ImageIcon("E:\\save\\pictures\\1639551996596.jpg").getImage());
        setSize(650, 400);
        setContentPane(panel);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private Component createMenuTab() {
        //TODO 设置配置的菜单
        JMenu jMenu = new JMenu("操作");
        jMenu.setSize(80,20);

        return new JMenu();
    }


}
