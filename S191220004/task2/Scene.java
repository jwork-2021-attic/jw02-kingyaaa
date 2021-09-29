package task2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {

        int length = 256;
        Line line = new Line(length);
        
        Linable[] monsters = new Monster[length];
        
        RandomNum random = new RandomNum(length);

        for(int i = 0;i < length;i++){
            int num = random.uniqueNum();
            monsters[i] = new Monster(num);
            line.put(monsters[i],i);
        }

        Snake snake = Snake.getSnake();
        
        //两种排序方法任选一种运行
        //Sorter sorter = new QuickSorter();
        Sorter sorter = new SelectSorter();

        snake.setSorter(sorter);

        String log = snake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}

