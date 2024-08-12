package cs2.game;

import java.util.ArrayList;
import java.util.TreeSet;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Columns {
    protected boolean[][] grid;
    protected double stack = 0;
    protected int score;
    protected int completedLines = 0;

    public Columns() {
        score = 0;
        completedLines = 0;
        grid = new boolean[20][10];
        for(int i = 0; i<10; i++) {
            for(int j = 0; j<20; j++) {
                grid[j][i] = false;
            }
        }
    }

    public void updateCubes(Cube b) {
        int col = 10-((500-(int) b.r.getX())/20);
        int row = (((600-(int) b.r.getY()))/20)-1;
        grid[row][col] = true;
    }

    public void moveDown(Block b) {
        int count = 0;
        for(int i = 0; i<b.posArray.size(); i++) {
            int col = 10-((500-(int) b.posArray.get(i).getX())/20);
            int row = ((600-(int) b.posArray.get(i).getY())/20)-1;
            if(row<=19) { 
                if(row == 0) {b.timer = 39;}
                if(b.timer !=39 && grid[row-1][col] == true) {count++;}
            }
        }
        if(count > 0) {b.timer = 39;}
        else if(b.timer == 0) {
            b.timer = 20;
            for(int a = 0; a<b.ys.length; a++) {b.ys[a] = b.ys[a]+20;}
            for(int x = 0; x<4; x++) {b.posArray.get(x).addThis(new Vec2(0,20));}
            b.pos.addThis(new Vec2(0,20));
        }
    }

    public ArrayList<Integer> checkLine(ArrayList<Cube> cubes) {
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Integer> cubeRet = new ArrayList<Integer>();
        int count = 0;
        int line = 0;

        for(int i = 0; i<20; i++) {
            for(int j = 0; j<10; j++) {
                if(grid[i][j] == true) {count++;}
                line = i;
            }
            if(count == 10) {lines.add(line);}
            count = 0;
        }
        if(lines.size() > 0) {
            for(int i = 0; i<cubes.size(); i++) {
                for(int j = 0; j<lines.size(); j++) {   
                    int row = ((600-(int) cubes.get(i).r.getY())/20)-1;
                    if(row == lines.get(j)) {cubeRet.add(i);}
                }
            }
        }
        if(cubeRet.size() > 0) {
            for (int i = 0; i < cubeRet.size() - 1; i++) {
                for (int j = 0; j < cubeRet.size() - i - 1; j++) {
                if (cubeRet.get(j) > cubeRet.get(j + 1)) {  
                    int temp = cubeRet.get(j); 
                    cubeRet.set(j, cubeRet.get(j+1)); 
                    cubeRet.set(j+1, temp);
                    }
                }
            }
        }
        return cubeRet;
    }

    public void updateMatrix(ArrayList<Cube> c, TreeSet<Double> s) {
        for(Double d : s) {
            int startIndex = 20 - ((d.intValue() - 200)/20)-1;
            for(int j = 0; j<10; j++) {
                for(int i = startIndex; i<20; i++) {
                    if(19-i > 0) {grid[i][j] = grid[i+1][j];}
                    else {grid[i][j] = false;}
                }
            }
        }
    }

    public void matrix(GraphicsContext g) {
        for(int i = 0; i<10; i++) {
            for(int j = 0; j<20; j++) {
                if(grid[j][i] == true) {g.setFill(Color.GREEN);}
                if(grid[j][i] == false) {g.setFill(Color.RED);}
                g.fillOval(300+(i*20), 180+((20-j)*20), 5, 5);
            }
        }
    }

    public void checkGameOver(ArrayList<Cube> cubes, int[] gameStatus) {
        for(int i = 0; i<cubes.size(); i++) {
            int row = ((600-(int) cubes.get(i).r.getY())/20)-1;
            if(row == 19) {
                gameStatus[0] = 2;
            }
        }
    }

    public void clear() {
        for (int i = 0; i<10; i++) {
            for (int j = 0; j<20; j++) {
                grid[j][i] = false;
            }
        }
    }
    
}