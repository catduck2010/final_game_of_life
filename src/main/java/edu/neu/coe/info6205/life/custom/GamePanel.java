/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.custom;

import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Point;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import sun.security.acl.WorldGroupImpl;

/**
 *
 * @author lihangzhou
 */
public class GamePanel extends JPanel {

    Color backGroundColor = Color.white;
    Color fillingColor = Color.orange;
    JPanel[][] cell;
    Point origin;
    int row;
    int col;
    int edge = 10;
    World world;

    public GamePanel(int row, int col) {
        this.row = 2 * row;
        this.col = 2 * col;
        this.cell = new JPanel[this.row][this.col];
        this.origin = new Point(row, col);

        setLayout(new GridLayout(this.row, this.col));
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                JPanel jp = new JPanel();
                jp.setSize(2, 2);
//                jp.setBorder(new LineBorder(Color.BLACK));
                this.add(jp);
                this.cell[i][j] = jp;
            }
        }
        this.setSize(this.row * 3, this.col * 3);
    }

    public GamePanel(int row, int col, List<Point> points) {
        this(row, col);
        this.world = new World(this.row + 2 * edge, this.col + 2 * edge, points, this.origin);

        refreshPanel(relocatePoints(points));

    }

    private List<Point> relocatePoints(List<Point> points) {
        List<Point> result = new ArrayList<>();
        for (Point p : points) {
            result.add(p.move(origin));
        }
        return result;
    }

    private void refreshPanel(List<Point> points) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                cell[i][j].setBackground(backGroundColor);
            }
        }

        for (Point p : points) {
            int x = p.getX() - edge, y = p.getY() - edge;
            if (x < 0 || x >= this.row || y < 0 || y >= this.col) {
                continue;
            }
            cell[x][y].setBackground(fillingColor);
        }
    }

    public int tick() {
        world.tick();
        refreshPanel(world.getPoints());
        return world.getTicks();
    }

}
