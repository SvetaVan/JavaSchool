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
        if(insertionPoint==list.size()){
            return list.get(list.size()-1);
        }
        if(insertionPoint==0){
            return list.get(0);
        }
        return findCorrectInsertionPoint(list.get(insertionPoint),list.get(insertionPoint-1),key);

    }

    public static int findCorrectInsertionPoint(int currentVal, int prevValue, int key){
        return (currentVal-key)<(key-prevValue)?currentVal:prevValue;
    }

    public static int closestToKeyViaSet(List<Integer> list, int key){
        Set<Integer> set = new TreeSet<>(list);
        Collections.sort(list);
        int otherwiseValue = list.get(list.size()-1)<key?list.get(list.size()-1):list.get(0);
        return Optional.ofNullable(((TreeSet<Integer>) set).lower(key)).orElse(otherwiseValue);
    }


    public static void rotateMatrix(int [][] matrix){






    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 10, 13, 18, 11));
        System.out.println(closestToKeyViaSet(list, -1));
    }


}
