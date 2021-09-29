package task2;

public class Snake {
    private static Snake snake;

    public static Snake getSnake() {
        if (snake == null) {
            snake = new Snake();
        }
        return snake;
    }

    private Snake() {

    } 

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];
        //String plog = "";
        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
            //plog += ranks[i] + " ";
        }
        //System.out.println(plog);

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step,line);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step,Line line) {
        String[] couple = step.split("<->");
        line.swapPosition(line.getByRank(Integer.parseInt(couple[0])),
                        line.getByRank(Integer.parseInt(couple[1])));
    }

}
