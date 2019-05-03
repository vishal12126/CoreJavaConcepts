public class FibonacciSeries {
    public static void main(String[] args) {

        fiboSeries(0,1);
    }
    static int count = 1;
    public static void fiboSeries(int i, int j){
        int temp =0;
        temp = i + j;
        System.out.print(i + " ");
        i = j;
        j = temp;
        if(count == 11) {
            return;
        }
        count = count +1;
        fiboSeries(i,j);
    }
}
