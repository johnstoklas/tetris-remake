package cs2.game;

import java.util.ArrayList;
import java.util.TreeSet;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TetrisGameApp extends Application {

  public static final int WIDTH = 800;
  public static final int HEIGHT = 800;

  public void start(Stage stage) {
    stage.setTitle("Tetris");
    stage.show();
    Canvas canvas = new Canvas(WIDTH,HEIGHT);
    stage.setScene(new Scene(new StackPane(canvas)));
    GraphicsContext g = canvas.getGraphicsContext2D();

    Tetrominos stand = new Tetrominos();
    ArrayList<Block> list = new ArrayList<Block>();
    ArrayList<Cube> cubes = new ArrayList<Cube>();

    Columns columnList = new Columns();
    int[] gameStatus = new int[1];
    gameStatus[0] = 0;

    AnimationTimer timer = new AnimationTimer() {
      public void handle(long t) {

          //displays the board
          g.setFill(Color.LIGHTBLUE);
          g.fillRect(0,0,800,800);
          g.setFill(Color.WHITE);
          g.fillRect(300, 200, 200, 400);
          g.setStroke(Color.BLACK);
          g.strokeRect(300, 200, 200, 400);
          g.setFill(Color.BLACK);
          g.setFont(Font.font("Impact", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 15));
          g.fillText("Score: " + columnList.score, 625, 400);
          g.fillText("Completed Lines: " + columnList.completedLines, 625, 415);

          for(int i = 0; i<list.size(); i++) {
            list.get(i).display(g);
          }

          if(list.size() > 0) {
            if(list.get(list.size()-1).timer > 0) {
              list.get(list.size()-1).timer--;
            } else if (list.get(list.size()-1).timer == 0) {
              columnList.moveDown(list.get(list.size()-1));
            }
          }
          
          for(int i = 0; i<cubes.size(); i++) {
            cubes.get(i).display(g);
          }
          g.setStroke(Color.WHITE);
          g.strokeRect(300, 200, 200, 400);
          for(int i = 0; i<10; i++) {
            g.strokeRect(300+(i*20), 200, 20, 400);
          }
          for(int i = 0; i<20; i++) {
            g.strokeRect(300, 200+(i*20), 200, 20);
          }

          if(gameStatus[0] == 0 /* MAIN MENU*/) {
            g.setFill(Color.LIGHTBLUE);
            g.fillRect(0,0,800,800);
            g.setFill(Color.WHITE);
            g.fillRect(200, 300, 400, 200);
            g.setStroke(Color.BLACK);
            g.strokeRect(200, 300, 400, 200);
            g.setFill(Color.BLACK);
            g.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.REGULAR, 30));
            g.fillText("Press \"Enter\" to Play", 275, 410);
          }


        if(gameStatus[0] == 1 /*GAME IS BEING PLAYED */) {
          //used for testing only
          //columnList.matrix(g);

          //Next Block
          if(list.size() == 0) {
            list.add(stand.nextBlock());
          } 
          else if(list.get(list.size()-1).timer == 39) {
            list.get(list.size()-1).timer++;
            //converts the block to 4 cubes
            list.get(list.size()-1).blockConverter(g, cubes);
            columnList.checkGameOver(cubes, gameStatus);
            for(int x = 1; x<5; x++) {
              //updates the matrix of the board with true/false values
              columnList.updateCubes(cubes.get(cubes.size()-x));
            }
            //checks if a row is complete
            ArrayList<Integer> l = columnList.checkLine(cubes);
            TreeSet<Double> s = new TreeSet<Double>();
            //only happens if a row is complete
            if(l.size() > 0) {
              if(l.size()/10 == 1) {columnList.score+=100; columnList.completedLines++;}
              else if(l.size()/10 == 2) {columnList.score+=300; columnList.completedLines+=2;}
              else if(l.size()/10 == 3) {columnList.score+=500; columnList.completedLines+=3;}
              else if(l.size()/10 == 4) {columnList.score+=800; columnList.completedLines+=4;}

                //removes those cubes from the board
                for(int i = 0; i<l.size(); i++) {
                  s.add(cubes.get(l.get(i)).r.getY());
                  int index = l.get(i);
                  cubes.remove(index);
                  for(int j = 0; j<l.size(); j++) {
                    l.set(j, l.get(j)-1);
                  }
                }

                //updates the visual cubes and the matrix of the board with true/false values
                Cube.cubeDrop(cubes, s);
                columnList.updateMatrix(cubes, s);
              }        
            list.remove(list.size()-1);
          }
        }

        else if(gameStatus[0] == 2 /* GAME OVER */) {
          g.setFill(Color.WHITE);
          g.fillRect(200, 300, 400, 200);
          g.setStroke(Color.BLACK);
          g.strokeRect(200, 300, 400, 200);
          g.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 80));
          g.setFill(Color.RED);
          g.fillText("GAME OVER", 225, 400);
          g.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.REGULAR, 15));
          g.setFill(Color.BLACK);
          g.fillText("Final Score: " + columnList.score, 300, 440);
          g.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.REGULAR, 15));
          g.fillText("press the space bar to continue", 300, 455);
        }
      }
    };
    timer.start();

    canvas.requestFocus();

    canvas.setOnKeyPressed((KeyEvent e) -> { 
      if(list.size() > 0) {
        if(e.getCode() == KeyCode.RIGHT) {
          list.get(list.size()-1).moveRight(columnList);
        }
        if(e.getCode() == KeyCode.LEFT) {
          list.get(list.size()-1).moveLeft(columnList);
        }
        if(e.getCode() == KeyCode.UP) {
          list.get(list.size()-1).rotate(columnList);
        }
        if(e.getCode() == KeyCode.DOWN) {
          list.get(list.size()-1).speed(columnList);
        }
      }
      if(e.getCode() == KeyCode.ENTER && gameStatus[0] == 0) {
        gameStatus[0] = 1;
      }
      if(e.getCode() == KeyCode.SPACE && gameStatus[0] == 2) {
        list.clear();
        cubes.clear();
        columnList.clear();
        gameStatus[0] = 0;
        columnList.score = 0;
        columnList.completedLines = 0;
      }
    });
  }
}
