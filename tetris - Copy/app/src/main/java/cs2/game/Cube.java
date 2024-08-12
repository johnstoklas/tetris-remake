package cs2.game;

import java.util.ArrayList;
import java.util.TreeSet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cube {
    //Fields
    protected int index;
    protected Rectangle r;

    public Cube(double x, double y, double w, double h, int i) {
        index = i;
        r = new Rectangle(x, y, 20,20);
    }

    public void display(GraphicsContext g) {
        checkColor(g);
        g.fillRect(r.getX(), r.getY(), 20, 20);
    }

    public void checkColor(GraphicsContext g) {
        if(index == 0) {g.setFill(Color.GOLD);  }
        else if(index == 1) {g.setFill(Color.LIGHTSTEELBLUE); }
        else if(index == 2) {g.setFill(Color.LIGHTSEAGREEN);  }
        else if(index == 3) {g.setFill(Color.DEEPPINK);  }
        else if(index == 4) {g.setFill(Color.PURPLE);  }
        else if(index == 5) {g.setFill(Color.CORNFLOWERBLUE);  }
        else if(index == 6) {g.setFill(Color.DARKSALMON);  }
    }

    public static void cubeDrop(ArrayList<Cube> c, TreeSet<Double> s) {
        for(Double d : s) {
            for(int i = 0; i<c.size(); i++) {
                if(c.get(i).r.getY() < d) {
                    c.get(i).r.setY(c.get(i).r.getY()+20);
                }
            }
        } 
    }
}   
