import java.util.*;
class MyObject7 extends Main {
    protected void e() throws CloneNotSupportedException {}
    public static void main(String[] args)  {
        Main test = new Main();
       // test.te(); // Compile Error   ----- (1)
    }
}

public class Main {
    protected  void te() throws CloneNotSupportedException {super.clone();}
    static public  ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] check = new boolean [m][n];

        int num = 0;
        int i = 0,j=0;
        int d = 0;
        while(i>=0 && i < m && j>=0 && j < n && !check[i][j]) {
            list.add(matrix[i][j]);
            check[i][j] = true;
            while( i + dir[d][0] >= 0 && i +  i + dir[d][0] < m
                    && j + dir[d][1] >= 0 && j + dir[d][1] < n
                    && !check[i + dir[d][0]][j + dir[d][1]]){
                i = i + dir[d][0];
                j = j + dir[d][1];
                list.add(matrix[i][j]);
                check[i][j] = true;
            }



            d =(d+1) %4;
            i = i + dir[d][0];
            j = j + dir[d][1];

        }
        return list;
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);

        Stack<Integer> stack1 = new Stack<Integer>();
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer> e : entries) {
        }

        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        list.add(0,14);
        System.out.println(list);
    }
}
