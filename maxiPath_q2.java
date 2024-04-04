import java.util.ArrayList;
import java.util.List;

public class maxiPath_q2{
    
    static class Pair {
        int value;
        List<Integer> path;

        Pair(int value, List<Integer> path) {
            this.value = value;
            this.path = path;
        }
        
    }

    public static Pair maxSumPath(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        int i = 0, j = 0;
        int sumX = 0, sumY = 0;
        int result = 0;
        List<Integer> maxPath = new ArrayList<>();

        while (i < m && j < n) {
            if (X[i] == Y[j]) {
                if (sumX > sumY) {
                    result += sumX + X[i];
                    maxPath.add(X[i]);
                } else {
                    result += sumY + Y[j];
                    maxPath.add(Y[j]);
                }
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            } else if (X[i] < Y[j]) {
                sumX += X[i];
                maxPath.add(X[i]);
                i++;
            } else {
                sumY += Y[j];
                maxPath.add(Y[j]);
                j++;
            }
        }

        while (i < m) {
            sumX += X[i];
            maxPath.add(X[i]);
            i++;
        }

        while (j < n) {
            sumY += Y[j];
            maxPath.add(Y[j]);
            j++;
        }

        result += Math.max(sumX, sumY);

        return new Pair(result, maxPath);
    }

    public static void main(String[] args) {
        int[] X = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] Y = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};

        Pair result = maxSumPath(X, Y);
        System.out.println("Maximum sum path: " + result.value);
        System.out.println("Path: " + result.path);
    }
}