package edu.neu.coe.info6205.life.custom;

// Files must be named the same as the class they contain
// Files can have multiple classes, but only one public class
import edu.neu.coe.info6205.life.base.Point;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class World {

    private class LocationOccupied extends Exception {
    }

    private int ticks;
    private final int width;
    private final int height;
    private final HashMap<String, Cell> cells = new HashMap<>();
    private final int[][] cached_directions = new int[][]{
        {-1, 1}, {0, 1}, {1, 1}, // above
        {-1, 0}, {1, 0}, // sides
        {-1, -1}, {0, -1}, {1, -1}, // below
    };

    ;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.ticks = 0;

        populateCells();
        prePopulateNeighbors();
    }

    public World(int width, int height, List<Point> points, Point origin) {
        this.width = width;
        this.height = height;
        this.ticks = 0;

        populateCells(points, origin);
        prePopulateNeighbors();
    }

    public void tick() {
        // First determine the action for all cells
        for (Cell cell : cells.values()) {
            int alive_neighbours = aliveNeighborsAround(cell);
            if (!cell.alive && alive_neighbours == 3) {
                cell.next_state = 1;
            } else if (alive_neighbours < 2 || alive_neighbours > 3) {
                cell.next_state = 0;
            }
        }

        // Then execute the determined action for all cells
        for (Cell cell : cells.values()) {
            if (cell.next_state != null && cell.next_state == 1) {
                cell.alive = true;
            } else if (cell.next_state != null && cell.next_state == 0) {
                cell.alive = false;
            }
        }

        ticks++;
    }

    public int getTicks() {
        return ticks;
    }

    // Implement first using string concatenation. Then implement any
    // special string builders, and use whatever runs the fastest
    public String render() {
        StringBuilder rendering = new StringBuilder();
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                Cell cell = cellAt(x, y);
                rendering.append(cell.to_char());
            }
            rendering.append("\n");
        }
        return rendering.toString();
    }

    private void populateCells() {
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                boolean alive = (Math.random() <= 0.2);
                addCell(x, y, alive);
            }
        }
    }

    private void populateCells(List<Point> points, Point origin) {
        for (Point p : points) {
            p = p.move(origin);
            addCell(p.getX(), p.getY(), true);
        }
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                if (cellAt(x, y) == null) {
                    addCell(x, y, false);
                }
            }
        }
    }

    private void prePopulateNeighbors() {
        for (Cell cell : cells.values()) {
            getNeighborsAround(cell);
        }
    }

    // Java doesn't have the concept of optional or default values
    // The workaround is catch all args as an array and disect it
    private Cell addCell(int x, int y, boolean... args) {
        if (cellAt(x, y) != null) { // Must return a boolean
            // Java won't let us throw an error without catching it
            // so emulate a runtime abort by catching and exiting
            try {
                throw new LocationOccupied();
            } catch (LocationOccupied m) {
                System.out.println("Error: World.LocationOccupied " + x + "-" + y + "");
                System.exit(0);
            }
        }

        Cell cell = new Cell(x, y, args[0]);
        cells.put(x + "-" + y, cell);
        return cellAt(x, y);
    }

    private Cell cellAt(int x, int y) {
        return cells.get(x + "-" + y);
    }

    private ArrayList<Cell> getNeighborsAround(Cell cell) {
        if (cell.neighbours == null) { // Must return a boolean
            cell.neighbours = new ArrayList<>();
            for (int[] set : cached_directions) {
                Cell neighbour = cellAt(
                        (cell.x + set[0]),
                        (cell.y + set[1])
                );
                if (neighbour != null) {
                    cell.neighbours.add(neighbour);
                }
            }
        }

        return cell.neighbours;
    }

    public List<Point> getPoints() {
        List<Point> result = new ArrayList<>();
        for (Cell c : cells.values()) {
            if (c.alive) {
                result.add(new Point(c.x, c.y));
            }
        }
        return result;
    }

    // Implement first using filter/lambda if available. Then implement
    // foreach and for. Retain whatever implementation runs the fastest
    private int aliveNeighborsAround(Cell cell) {
        int aliveNeighbors = 0;
        ArrayList<Cell> neighbours = getNeighborsAround(cell);
        for (int i = 0; i < neighbours.size(); i++) {
            Cell neighbour = neighbours.get(i);
            if (neighbour.alive) {
                aliveNeighbors++;
            }
        }
        return aliveNeighbors;
    }

}

class Cell {

    public int x;
    public int y;
    public boolean alive;
    public Integer next_state; // int doesn't allow null values
    public ArrayList<Cell> neighbours;

    // Java doesn't have the concept of optional or default values
    // The workaround is catch all args as an array and disect it
    public Cell(int x, int y, boolean... args) {
        this.x = x;
        this.y = y;
        this.alive = args[0];
        this.next_state = null;
        this.neighbours = null;
    }

    public char to_char() {
        return this.alive ? 'o' : ' ';
    }

}
