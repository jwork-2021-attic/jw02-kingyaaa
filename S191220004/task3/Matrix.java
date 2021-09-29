package task3;

public class Matrix {
    public Matrix(int length) {
        this.positions = new Position[length];
        this.num = 0;
    }
    private int num;
    private Position[] positions;

    public void put(Linable linable,int i) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(linable);
    }

    public int getByRank(int i) {
        int index = -1;
        for(Position p: this.positions){
            index += 1;
            if(p.linable.getValue() == i){
                return index;
            }
        }
        return -1;
    }

    public void swapPosition(int i,int j){
        Position p = this.positions[i];
        this.positions[i] = this.positions[j];
        this.positions[j] = p;
    }

    class Position {

        private Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    @Override
    public String toString() {
        String lineString = "";
        for (Position p : positions) {
            lineString += p.linable.toString();
            num++;
            if(num == 16){
                lineString += "\n";
                num = 0;
            }
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }
}