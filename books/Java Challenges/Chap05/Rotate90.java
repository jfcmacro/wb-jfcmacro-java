import static java.lang.Math.abs;

public class Rotate90 {

    private enum Direction { LEFT, RIGHT };

    public static int[][] rotate90(int[][] array, Direction direction) {
        int[][] tmpArray = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                switch(direction) {
                case RIGHT:
                    tmpArray[j][(array.length - 1) - i] = array[i][j];
                    break;
                case LEFT:
                    tmpArray[(array[0].length - 1) - j][i] = array[i][j];
                    break;
                }
            }
        }

        return tmpArray;
    }

    public static void printArray(int[][] array) {
        StringBuilder sb = new StringBuilder("[");
        sb.append('\n');
        for (int i = 0; i < array.length; i++) {
            sb.append("  [ ");
            for (int j = 0; j < array[0].length; j++) {
                sb.append(array[i][j]).append(j != (array.length -1) ? ',' : ' ');
            }
            sb.append("]").append(i != (array.length - 1) ? ",\n" : "\n");
        }
        sb.append("]").append('\n');
        System.out.println(sb.toString());
    }

    public static int[][] initArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = i + 1;
            }
        }

        return array;
    }

    public static void main(String...args) {

        int[][] array = initArray(4,4);

        printArray(array);

        int[][] result = rotate90(array, Direction.RIGHT);

        printArray(result);

        array = initArray(3,4);

        printArray(array);
        
        result = rotate90(array, Direction.LEFT);

        printArray(result);

        array = initArray(4,2);

        printArray(result);
        result = rotate90(array, Direction.RIGHT);
        result = rotate90(result, Direction.RIGHT);

        printArray(result);
    }
}
