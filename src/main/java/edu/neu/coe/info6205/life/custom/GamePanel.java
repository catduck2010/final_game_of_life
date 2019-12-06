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
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author lihangzhou
 */
public class GamePanel extends JPanel {

    Color backGroundColor = Color.white;
    Color fillingColor = Color.orange;
    JPanel[][] cell;
    Point origin;
    Game game;
    int row;
    int col;

    public GamePanel(int row, int col) {
        this.row = 2 * row;
        this.col = 2 * col;
        this.origin = new Point(row, col);
        this.cell = new JPanel[this.row][this.col];
        setLayout(new GridLayout(this.row, this.col));
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                JPanel jp = new JPanel();
                this.add(jp);
                this.cell[i][j] = jp;
            }
        }
        this.setSize(this.row * 3, this.col * 3);
    }

    public GamePanel(int row, int col, List<Point> points) {
        this(row, col);
        refreshPanel(points);
        this.game = Game.create(0L, points);
        doTick();
    }

    private void refreshPanel(List<Point> points) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                cell[i][j].setBackground(backGroundColor);
            }
        }

        for (Point p : points) {
            Point c = p.move(origin);
            cell[c.getX()][c.getY()].setBackground(fillingColor);
        }
    }
    
    private void doTick(){
        tick();
    }

    public void tick() {
        game = game.generation((t, u) -> {
            
            refreshPanel(u.getGroup().getAbsolutePoints());
        });
    }

}
