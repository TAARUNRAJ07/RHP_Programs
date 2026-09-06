import java.util.Scanner;

class ChangeSchools {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[k+1];
        for(int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arr[val]++;
        }
        int max = 0;
        for(int i = 1; i <= k; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        int ans = 0;
        for(int i = 1; i <= k; i++) {
            if(arr[i] + 1 >= max)
                ans++;
        }
        System.out.println(ans);
    }
}