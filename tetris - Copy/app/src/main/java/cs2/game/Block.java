package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class Block {
    //Fields
    protected Polygon block;
    protected Vec2 pos;
    protected ArrayList<Vec2> posArray;
    protected int timer = 20;
    protected int index;
    protected int form = 1;
    protected int height;
    protected int width;
    protected double[] xs;
    protected double[] ys;
    protected int points;
    
    //Constructor
    public Block(int input, Vec2 p) {
        posArray = new ArrayList<Vec2>();
        pos = p.clone();
        index = input;

        if(index == 0 /*oBlock*/) {
            xs = new double[]{pos.getX(), pos.getX()+40, pos.getX()+40,  pos.getX()};
            ys = new double[]{pos.getY(), pos.getY(), pos.getY()+40, pos.getY()+40};
            points = 4;
            height = 40;
            width = 40;
            posArray.add(new Vec2(xs[0], ys[0]));
            posArray.add(new Vec2(xs[0]+20, ys[0]));
            posArray.add(new Vec2(xs[0], ys[0]+20));
            posArray.add(new Vec2(xs[0]+20, ys[0]+20));
        }
        else if(index == 1 /*iBlock*/) {
            xs = new double[]{pos.getX(), pos.getX()+80, pos.getX()+80,  pos.getX()};
            ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20};
            points = 4;
            height = 20;
            width = 80;
            posArray.add(new Vec2(xs[0]+60, ys[0]));
            posArray.add(new Vec2(xs[0]+40, ys[0]));
            posArray.add(new Vec2(xs[0]+20, ys[0]));
            posArray.add(new Vec2(xs[0], ys[0]));
        } 
        else if(index == 2 /*sBlock*/) {
            xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20,  pos.getX()+60, pos.getX()+60, pos.getX()+40, pos.getX()+40, pos.getX()};
            ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40};
            points = 8;
            height = 40;
            width = 60;
            posArray.add(new Vec2(xs[0], ys[0]));
            posArray.add(new Vec2(xs[0]+20, ys[0]));
            posArray.add(new Vec2(xs[0]+20, ys[0]-20));
            posArray.add(new Vec2(xs[0]+40, ys[0]-20));
        }
        else if(index == 3 /*zBlock*/) {
            xs = new double[]{pos.getX(), pos.getX()+40, pos.getX()+40,  pos.getX()+60, pos.getX()+60, pos.getX()+20, pos.getX()+20, pos.getX()};
            ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40, pos.getY()+20, pos.getY()+20};
            points = 8;
            height = 40;
            width = 60;
            posArray.add(new Vec2(xs[0], ys[0]));
            posArray.add(new Vec2(xs[0]+20, ys[0]));
            posArray.add(new Vec2(xs[0]+20, ys[0]+20));
            posArray.add(new Vec2(xs[0]+40, ys[0]+20));
        }
        else if(index == 4 /*tBlock*/) {
            xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()+60, pos.getX()+60, pos.getX()};
            ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40};
            points = 8;
            height = 40;
            width = 60;
            posArray.add(new Vec2(xs[0], ys[0]));
            posArray.add(new Vec2(xs[0]+20, ys[0]));
            posArray.add(new Vec2(xs[0]+40, ys[0]));
            posArray.add(new Vec2(xs[0]+20, ys[0]-20));
        }
        else if(index == 5 /*jBlock*/) {
            xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+60, pos.getX()+60, pos.getX()};
            ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40};
            points = 6;
            height = 40;
            width = 60;
            posArray.add(new Vec2(xs[0]+40, ys[0]+20));
            posArray.add(new Vec2(xs[0]+20, ys[0]+20));
            posArray.add(new Vec2(xs[0], ys[0]+20));
            posArray.add(new Vec2(xs[0], ys[0]));
        }
        else if(index == 6 /*lBlock*/) {
            xs = new double[]{pos.getX(), pos.getX()+40, pos.getX()+40, pos.getX()+60, pos.getX()+60, pos.getX()};
            ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+40, pos.getY()+40};
            points = 6;
            height = 60;
            width = 40;
            posArray.add(new Vec2(xs[0], ys[0]+20));
            posArray.add(new Vec2(xs[0]+20, ys[0]+20));
            posArray.add(new Vec2(xs[0]+40, ys[0]+20));
            posArray.add(new Vec2(xs[0]+40, ys[0]));
        }
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

    public void display(GraphicsContext g) {
        checkColor(g);
        g.fillPolygon(xs, ys, points);
    }

    public Block clone() {return new Block(index, pos);}

    public void moveRight(Columns c) {
        int count = 0;
        if(pos.getX()<500-width) {
            for(int i = 0; i<posArray.size(); i++) {
                int col = 10-((500-(int) posArray.get(i).getX())/20);
                int row = ((600-(int) posArray.get(i).getY())/20)-1;
                if(c.grid[row][col+1] == false) {count++;}
            }
        }
        if(count == 4) {
            pos.addThis(new Vec2 (20,0));
            for(int x = 0; x<4; x++) {posArray.get(x).addThis(new Vec2 (20,0));}
            for(int a = 0; a<xs.length; a++) {xs[a] = xs[a]+20;}         
        }
        if(timer<15) {timer+=5;}
    }
    
    public void moveLeft(Columns c) {
        int count = 0;
        if(pos.getX() > 300) {
            for(int i = 0; i<posArray.size(); i++) {
                int col = 10-((500-(int) posArray.get(i).getX())/20);
                int row = ((600-(int) posArray.get(i).getY())/20)-1;
                if(c.grid[row][col-1] == false) {count++;}
            }
        }
        if(count == 4) {
            pos.addThis(new Vec2 (-20,0));
            for(int x = 0; x<4; x++) {posArray.get(x).addThis(new Vec2 (-20,0));}
            for(int a = 0; a<xs.length; a++) {xs[a] = xs[a]-20;}       
        }
        if(timer<15) {timer+=5;}
    }
    

    public void rotate(Columns c) {
        int row = 20 - ((((int)pos.getY()+20)-200)/20);
        int col = ((int) pos.getX()-300)/20;

        if((col-1 < 0 || c.grid[row][col-1] == false) && (col+(width/20) > 9 || c.grid[row][col+(width/20)] == false) && (row > 19 || c.grid[row+1][col] == false) && (row-(height/20) < 0 || c.grid[row-(height/20)][col] == false)) {
        if(index !=0) {
            if(height > 20 && pos.getX() == 300) {
                for(int i = 0; i<4; i++) {posArray.get(i).addThis(new Vec2 (20,0));}
                pos.addThis(new Vec2(20,0));
            }
            if(height > 20 && pos.getX() == 500-width) {
                for(int i = 0; i<4; i++) {posArray.get(i).addThis(new Vec2 (-20,0));}
                pos.addThis(new Vec2(-20,0));
            }
            if(width > 20 && pos.getY() == 600-height) {
                for(int i = 0; i<4; i++) {posArray.get(i).addThis(new Vec2 (0,-20));}
                pos.addThis(new Vec2(0,-20));
            }
            if(width > 20 && pos.getY() == 200) {
                for(int i = 0; i<4; i++) {posArray.get(i).addThis(new Vec2 (0,20));}
                pos.addThis(new Vec2(0,20));
            }
        }
        if(index == 1) {
            if(form == 1) {
                height = 80;
                width = 20;
                posArray.get(0).addThis(new Vec2(-20,-20));
                //posArray.get(1).addThis(new Vec2(0,0));
                posArray.get(2).addThis(new Vec2(20,20));
                posArray.get(3).addThis(new Vec2(40, 40));
                pos.addThis(new Vec2(40,-20));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+80, pos.getY()+80};
                form++;
            }
            else if (form == 2) {
                height = 20;
                width = 80;
                posArray.get(0).addThis(new Vec2(-40,20));
                posArray.get(1).addThis(new Vec2(-20,0));
                posArray.get(2).addThis(new Vec2(0,-20));
                posArray.get(3).addThis(new Vec2(20, -40));
                pos.addThis(new Vec2(-40,20));
                xs = new double[]{pos.getX(), pos.getX()+80, pos.getX()+80, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20};
                form++;
            }
            else if(form == 3) {
                height = 80;
                width = 20;
                posArray.get(0).addThis(new Vec2(20,40));
                posArray.get(1).addThis(new Vec2(0,20));
                posArray.get(2).addThis(new Vec2(-20,0));
                posArray.get(3).addThis(new Vec2(-40, -20));
                pos.addThis(new Vec2(20,-20));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+80, pos.getY()+80};
                form++;
            }
            else if(form == 4) {
                height = 20;
                width = 80;
                posArray.get(0).addThis(new Vec2(40,-40));
                posArray.get(1).addThis(new Vec2(20,-20));
                //posArray.get(2).addThis(new Vec2(0,0));
                posArray.get(3).addThis(new Vec2(-20, 20));
                pos.addThis(new Vec2(-20,20));
                xs = new double[]{pos.getX(), pos.getX()+80, pos.getX()+80, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20};
                form = 1;
            }
            
        }   
        if(index == 2) {
            if (form == 1) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(20,0));
                posArray.get(1).addThis(new Vec2(0,-20));
                posArray.get(2).addThis(new Vec2(-20,0));
                posArray.get(3).addThis(new Vec2(-40, -20));
                pos.addThis(new Vec2(0,-20));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+60, pos.getY()+60, pos.getY()+40, pos.getY()+40};
                form++;
            }
            else if(form == 2) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(0,-20));
                posArray.get(1).addThis(new Vec2(-20,0));
                posArray.get(2).addThis(new Vec2(0,20));
                posArray.get(3).addThis(new Vec2(-20, 40));
                pos.addThis(new Vec2(-20,20));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20,  pos.getX()+60, pos.getX()+60, pos.getX()+40, pos.getX()+40, pos.getX()};
                ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40};
                form++;
            }
            else if(form == 3) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(-20,0));
                posArray.get(1).addThis(new Vec2(0,20));
                posArray.get(2).addThis(new Vec2(20,0));
                posArray.get(3).addThis(new Vec2(40, 20));
                pos.addThis(new Vec2(20,0));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+60, pos.getY()+60, pos.getY()+40, pos.getY()+40};
                form++;
            }
            else if(form == 4) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(0,20));
                posArray.get(1).addThis(new Vec2(20,0));
                posArray.get(2).addThis(new Vec2(0,-20));
                posArray.get(3).addThis(new Vec2(20, -40));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20,  pos.getX()+60, pos.getX()+60, pos.getX()+40, pos.getX()+40, pos.getX()};
                ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40};
                form = 1;
            }
        }   
        if(index == 3) {
            if (form == 1) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(20,40));
                posArray.get(1).addThis(new Vec2(0,20));
                posArray.get(2).addThis(new Vec2(20,0));
                posArray.get(3).addThis(new Vec2(0, -20));
                pos.addThis(new Vec2(20,0));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+40, pos.getY()+40, pos.getY()+60, pos.getY()+60};
                form++;
            }
            else if(form == 2) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(40,-20));
                posArray.get(1).addThis(new Vec2(20,0));
                posArray.get(2).addThis(new Vec2(0,-20));
                posArray.get(3).addThis(new Vec2(-20, 0));
                xs = new double[]{pos.getX(), pos.getX()+40, pos.getX()+40,  pos.getX()+60, pos.getX()+60, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40, pos.getY()+20, pos.getY()+20};
                form++;
            }
            else if(form == 3) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(-20,-40));
                posArray.get(1).addThis(new Vec2(0,-20));
                posArray.get(2).addThis(new Vec2(-20,0));
                posArray.get(3).addThis(new Vec2(0, 20));
                pos.addThis(new Vec2(0,-20));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+40, pos.getY()+40, pos.getY()+60, pos.getY()+60};
                form++;
            }
            else if(form == 4) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(-40,20));
                posArray.get(1).addThis(new Vec2(-20,0));
                posArray.get(2).addThis(new Vec2(0,20));
                posArray.get(3).addThis(new Vec2(20, 0));
                pos.addThis(new Vec2(-20,20));
                xs = new double[]{pos.getX(), pos.getX()+40, pos.getX()+40,  pos.getX()+60, pos.getX()+60, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40, pos.getY()+20, pos.getY()+20};
                form = 1;
            }        
        } 
        if(index == 4) {
            if (form == 1) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(20,0));
                posArray.get(1).addThis(new Vec2(0,-20));
                posArray.get(2).addThis(new Vec2(-20,-40));
                posArray.get(3).addThis(new Vec2(-20, 0));
                //pos.addThis(new Vec2(0,0));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()-20, pos.getY()-20, pos.getY()+40, pos.getY()+40, pos.getY()+20, pos.getY()+20};
                form++;
            }
            else if(form == 2) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(0,-20));
                posArray.get(1).addThis(new Vec2(-20,0));
                posArray.get(2).addThis(new Vec2(-40,20));
                posArray.get(3).addThis(new Vec2(0, 20));
                pos.addThis(new Vec2(-20,0));
                xs = new double[]{pos.getX(), pos.getX()+60, pos.getX()+60,  pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40, pos.getY()+20, pos.getY()+20};
                form++;
            }
            else if(form == 3) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(-20,-20));
                //posArray.get(1).addThis(new Vec2(0,0));
                posArray.get(2).addThis(new Vec2(20,20));
                posArray.get(3).addThis(new Vec2(20, -20));
                pos.addThis(new Vec2(20,-20));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40, pos.getY()+60, pos.getY()+60};
                form++;
            }
            else if(form == 4) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(0,40));
                posArray.get(1).addThis(new Vec2(20,20));
                posArray.get(2).addThis(new Vec2(40,0));
                ///posArray.get(3).addThis(new Vec2(0, 0));
                pos.addThis(new Vec2(0,-20));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()+60, pos.getX()+60, pos.getX()};
                ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40};
                form = 1;
            }        
        } 
        if(index == 5) {
            if(form == 1) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(0,-20));
                posArray.get(1).addThis(new Vec2(20,0));
                posArray.get(2).addThis(new Vec2(40,20));
                posArray.get(3).addThis(new Vec2(20, 40));
                pos.addThis(new Vec2(20,0));
                xs = new double[]{pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX(), pos.getX(), pos.getX()+20};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+60, pos.getY()+60, pos.getY()+40, pos.getY()+40};
                form++;
            }   
            else if (form == 2) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(-20,0));
                posArray.get(1).addThis(new Vec2(0,-20));
                posArray.get(2).addThis(new Vec2(20,-40));
                posArray.get(3).addThis(new Vec2(40, -20));
                //pos.addThis(new Vec2(0,0));
                xs = new double[]{pos.getX(), pos.getX()+60, pos.getX()+60, pos.getX()+40, pos.getX()+40, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+40, pos.getY()+40, pos.getY()+20, pos.getY()+20};
                form++;
            }
            else if(form == 3) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(0,20));
                posArray.get(1).addThis(new Vec2(-20,0));
                posArray.get(2).addThis(new Vec2(-40,-20));
                posArray.get(3).addThis(new Vec2(-20, -40));
                pos.addThis(new Vec2(0,-20));
                xs = new double[]{pos.getX(), pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+60, pos.getY()+60};
                form++;
            }
            else if(form == 4) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(20,0));
                posArray.get(1).addThis(new Vec2(0,20));
                posArray.get(2).addThis(new Vec2(-20,40));
                posArray.get(3).addThis(new Vec2(-40, 20));
                pos.addThis(new Vec2(-20,20));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+60, pos.getX()+60, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40};
                form = 1;
            }     
        } 
        if(index == 6) {
            if(form == 1) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(20,0));
                posArray.get(1).addThis(new Vec2(0,-20));
                posArray.get(2).addThis(new Vec2(-20,-40));
                posArray.get(3).addThis(new Vec2(-40, -20));
                pos.addThis(new Vec2(0,-20));
                xs = new double[]{pos.getX(), pos.getX()+40, pos.getX()+40, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+60, pos.getY()+60, pos.getY()+20, pos.getY()+20};
                form++;
            }
            else if(form == 2) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(0,-20));
                posArray.get(1).addThis(new Vec2(-20,0));
                posArray.get(2).addThis(new Vec2(-40,20));
                posArray.get(3).addThis(new Vec2(-20, 40));
                pos.addThis(new Vec2(-20,20));
                xs = new double[]{pos.getX(), pos.getX()+60, pos.getX()+60, pos.getX()+20, pos.getX()+20, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+20, pos.getY()+20, pos.getY()+40, pos.getY()+40};
                form++;
            }
            else if(form == 3) {
                height = 60;
                width = 40;
                posArray.get(0).addThis(new Vec2(-20,0));
                posArray.get(1).addThis(new Vec2(0,20));
                posArray.get(2).addThis(new Vec2(20,40));
                posArray.get(3).addThis(new Vec2(40, 20));
                pos.addThis(new Vec2(20,0));
                xs = new double[]{pos.getX(), pos.getX()+20, pos.getX()+20, pos.getX()+40, pos.getX()+40, pos.getX()};
                ys = new double[]{pos.getY(), pos.getY(), pos.getY()+40, pos.getY()+40, pos.getY()+60, pos.getY()+60};
                form++;
            }       
            else if (form == 4) {
                height = 40;
                width = 60;
                posArray.get(0).addThis(new Vec2(0,20));
                posArray.get(1).addThis(new Vec2(20,0));
                posArray.get(2).addThis(new Vec2(40,-20));
                posArray.get(3).addThis(new Vec2(20, -40));
                //pos.addThis(new Vec2(0,0));
                xs = new double[]{pos.getX(), pos.getX()+40, pos.getX()+40, pos.getX()+60, pos.getX()+60, pos.getX()};
                ys = new double[]{pos.getY()+20, pos.getY()+20, pos.getY(), pos.getY(), pos.getY()+40, pos.getY()+40};
                form++;
            } 
        } 
        this.rotateCorrect(c);
    }
    }

    public void speed(Columns c) {
        int count = 0;
        for(int i = 0; i<4; i++) {
            int row = 20 - ((((int)posArray.get(i).getY()+20)-200)/20);
            int col = ((int) posArray.get(i).getX()-300)/20;
            if(row > 0 && c.grid[row-1][col] == false) {count++;}

        }
        if(count == 4) {
            timer = 0;
            for(int a = 0; a<ys.length; a++) {ys[a] = ys[a]+20;}
            for(int x = 0; x<4; x++) {posArray.get(x).addThis(new Vec2(0,20));}
            pos.addThis(new Vec2(0,20));
            c.score++;
        }
    }

    public void blockConverter(GraphicsContext g, ArrayList<Cube> r) {
        checkColor(g);
        for(int i = 0; i<4; i++) {r.add(new Cube(posArray.get(i).getX(), posArray.get(i).getY(), 20, 20, index));}
    }   

    public void rotateCorrect(Columns c) {
        int count = 0;
        ArrayList<double[]> corrections = new ArrayList<double[]>();
        for(int i = 0; i<4; i++) {
            int row = 20 - ((((int)posArray.get(i).getY()+20)-200)/20);
            int col = ((int) posArray.get(i).getX()-300)/20;
            if (c.grid[row][col] == true) {count++;}
            else{corrections.add(new double[]{row, col, i});}

        }
        if(count < 4) {     
            for(int j = 0; j<corrections.size(); j++) {
                int row = 20 - ((((int)posArray.get((int)corrections.get(j)[2]).getY()+20)-200)/20);
                int col = ((int) posArray.get((int)corrections.get(j)[2]).getX()-300)/20;
                if(corrections.get(j)[0] > row) {
                    for(int a = 0; a<ys.length; a++) {ys[a] = ys[a]+20;}
                    for(int x = 0; x<4; x++) {posArray.get(x).addThis(new Vec2(0,20));}
                    pos.addThis(new Vec2(0,20));
                }
                else if(corrections.get(j)[0] < row) {
                    for(int a = 0; a<ys.length; a++) {ys[a] = ys[a]-20;}
                    for(int x = 0; x<4; x++) {posArray.get(x).addThis(new Vec2(0,-20));}
                    pos.addThis(new Vec2(0,-20));
                }
                else if(corrections.get(j)[1] > col) {
                    for(int a = 0; a<xs.length; a++) {xs[a] = xs[a]+20;}
                    for(int x = 0; x<4; x++) {posArray.get(x).addThis(new Vec2(20,0));}
                    pos.addThis(new Vec2(20,0));
                }
                else if(corrections.get(j)[0] > col) {
                    for(int a = 0; a<xs.length; a++) {xs[a] = xs[a]-20;}
                    for(int x = 0; x<4; x++) {posArray.get(x).addThis(new Vec2(-20,0));}
                    pos.addThis(new Vec2(-20,0));
                }
            }
        }
    }
}
