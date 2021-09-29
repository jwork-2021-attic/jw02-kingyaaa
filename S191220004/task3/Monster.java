package task3;
import task3.Matrix.Position;
import java.util.Random;

public class Monster implements Linable{
    private Position position;
    
    private int r;
    private int g;
    private int b;
    private int random;
    private Random rgbRandom;
    Monster(int num){
        rgbRandom = new Random();
        this.random = num;
        if(num < 64){
            this.g = rgbRandom.nextInt(256);
            this.r = num;
            this.b = 255 - rgbRandom.nextInt(256);
        }
        else if(num >= 64 && num < 128){
            this.r = rgbRandom.nextInt(256);
            this.g = num;
            this.b = 255 - rgbRandom.nextInt(256);
        }
        else{
            this.r = rgbRandom.nextInt(256);
            this.b = num;
            this.g = 255 - rgbRandom.nextInt(256);
        }
    }

    /*
    public Monster getMonsterByRank(int rank) {
        if(rank == this.random)
            return this;
        return null;

    }
    */

    public int rank(int r) {
        return this.random;
    }

    @Override
    public String toString() {
        if(this.getValue() < 10){
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m" + this.getValue() + "      \033[0m" + "\t";
        }
        else if(this.getValue() >= 10 && this.getValue() < 100){
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m" + this.getValue() + "     \033[0m" + "\t";
        }
        else{
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m" + this.getValue() + "    \033[0m" + "\t";
        }
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    /*
    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }
    */

    @Override
    public int getValue() {
        return this.random;
    }
}
