package tasks.tasks;

import com.google.common.base.Preconditions;

import java.util.*;

public class DifferentTasks {

    public static int playDice(int diceQuantity, int sideQuantity) {
        if (diceQuantity <= 0 || sideQuantity <= 0) {
            throw new IllegalArgumentException("Please pass the number of dices or sides");
        }
        int totalSum = 0;
        for (int i = 1; i <= diceQuantity; i++) {
            System.out.println("dice number is " + i);
            int diceSide = new Random().nextInt(sideQuantity) + 1;
            System.out.println("side is " + diceSide);
            totalSum += diceSide;
        }
        return totalSum;
    }

    public static int closestToKey(List<Integer> list, int key) {
        Preconditions.checkNotNull(list);
        Collections.sort(list);
        int insertionPoint = Collections.binarySearch(list, key);
        if (insertionPoint >= 0) {
            return list.get(insertionPoint);
        }
        insertionPoint = Math.abs(insertionPoint) - 1;
        if (insertionPoint == list.size()) {
            return list.get(list.size() - 1);
        }
        if (insertionPoint == 0) {
            return list.get(0);
        }
        return findCorrectInsertionPoint(list.get(insertionPoint), list.get(insertionPoint - 1), key);

    }

    public static int findCorrectInsertionPoint(int currentVal, int prevValue, int key) {
        return (currentVal - key) < (key - prevValue) ? currentVal : prevValue;
    }

    public static int closestToKeyViaSet(List<Integer> list, int key) {
        Set<Integer> set = new TreeSet<>(list);
        Collections.sort(list);
        int otherwiseValue = list.get(list.size() - 1) < key ? list.get(list.size() - 1) : list.get(0);
        return Optional.ofNullable(((TreeSet<Integer>) set).lower(key)).orElse(otherwiseValue);
    }


    public static void rotateMatrixWithNewMatrixCreation(int[][] matrix) {
        int[][] matrixNew = new int[matrix.length][matrix[0].length];

        for (int i = matrix[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                matrixNew[matrix[0].length - 1 - i][j] = matrix[j][i];
            }
        }
        printMatrix(matrixNew);
    }


    public static void setAndRotateMatrixLevel(int[][] matrix, int initialStart, int initialEnd) {
        int currentStart = initialStart;
        int currentEnd = initialEnd;
        while (currentStart <initialEnd && currentEnd>initialStart) {
            int temp = matrix[initialStart][currentStart];//temp=1
            matrix[initialStart][currentStart] = matrix[currentStart][initialEnd];//1=2
            matrix[currentStart][initialEnd] = matrix[initialEnd][currentEnd];//2=3
            matrix[initialEnd][currentEnd] = matrix[currentEnd][initialStart];//3=4
            matrix[currentEnd][initialStart] = temp;//4=temp
            currentStart++;
            currentEnd--;
        }
    }

    public static void rotateMatrix(int[][] matrix){
        int initialStart = 0;
        int initialEnd = matrix.length-1;
        while (initialStart<=initialEnd){
            setAndRotateMatrixLevel(matrix,initialStart,initialEnd);
            initialStart++;
            initialEnd--;
        }
        printMatrix(matrix);
    }


    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>(Arrays.asList(4, 10, 13, 18, 11));
        System.out.println(closestToKeyViaSet(list, -1));*/
        //int[][] matrix = {{1, 2,3,4,5,6,7}, {8,9,10,11,12,13,14},{15,16,17,18,19,20,21},{22,23,24,25,26,27,28},{29,30,31,32,33,34,35},{36,37,38,39,40,41,42},{43,44,45,46,47,48,49}};

        int [][] mat = {{1,2,3},{4,5,6}, {7,8,9}};
        printMatrix(mat);
        System.out.println("Rotated");
        rotateMatrix(mat);
    }


}
