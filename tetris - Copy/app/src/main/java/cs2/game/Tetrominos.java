package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;

public class Tetrominos {
    protected ArrayList<Block> standardBlock;

    public Tetrominos() {
        standardBlock = new ArrayList<Block>();
        for(int i = 0; i<7; i++) {
            standardBlock.add(new Block(i, new Vec2(360,200)));
        }
    }

    public Block nextBlock() {
        double randIndex = Math.random()*standardBlock.size();
        int index = (int) randIndex;
        return standardBlock.get(index).clone();
    }
}
