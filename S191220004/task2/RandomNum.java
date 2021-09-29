package task2;
import java.util.Random;

public class RandomNum {
    private int length;
    private boolean[] visit;
    private Random random;
    private int count;
    RandomNum(int length){
        this.length = length;//0 - 255
        this.visit = new boolean[this.length];
        for(boolean v: visit){
            v = false;
        }
        this.random = new Random();
        this.count = 0;
    }
    public int uniqueNum(){
        int num = this.random.nextInt(this.length);
        while(this.visit[num] != false && count != this.length){
            num = this.random.nextInt(this.length);
        }
        this.visit[num] = true;
        this.count += 1;
        //System.out.println(num);
        return num;
    } 
}