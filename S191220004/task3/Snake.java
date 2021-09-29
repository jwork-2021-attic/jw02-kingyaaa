package task3;

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

    public String lineUp(Matrix matrix) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = matrix.toArray();
        int[] ranks = new int[linables.length];
        String plog = "";
        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
            plog += ranks[i] + " ";
        }
        System.out.println(plog);

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step,matrix);
            System.out.println(matrix.toString());
            log += matrix.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step,Matrix matrix) {
        String[] couple = step.split("<->");
        matrix.swapPosition(matrix.getByRank(Integer.parseInt(couple[0])),
                        matrix.getByRank(Integer.parseInt(couple[1])));
    }

}
