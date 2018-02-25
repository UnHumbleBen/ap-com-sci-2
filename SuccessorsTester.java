public class SuccessorsTester
{
    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        arr[0][0] = 15;
        arr[0][1] = 5;
        arr[0][2] = 9;
        arr[0][3] = 10;
        arr[1][0] = 12;
        arr[1][1] = 16;
        arr[1][2] = 11;
        arr[1][3] = 6;
        arr[2][0] = 14;
        arr[2][1] = 8;
        arr[2][2] = 13;
        arr[2][3] = 7;

        System.out.println("arr");
        System.out.printf("  %2d %2d %2d %2d " , 0,1,2,3);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i);
            System.out.print("[");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println("]");
        }

        Successors a = new Successors();
        System.out.println("findPosition(8, arr))");
        System.out.println(a.findPosition(8, arr));
        System.out.println("findPosition(17, arr))");
        System.out.println(a.findPosition(17, arr));
        System.out.println("getSuccessorArray(arr)");
        
        Position[][] newArr = a.getSuccessorArray(arr);
        System.out.println("newArr");
        System.out.printf("  %5d %5d %5d %5d " , 0,1,2,3);
        System.out.println();
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(i);
            System.out.print("[ ");
            for (int j = 0; j < newArr[0].length; j++) {
                System.out.print(newArr[i][j] + " ");
                if (newArr[i][j] == null) System.out.print(" ");
            }
            System.out.println("]");
        }
    }
}