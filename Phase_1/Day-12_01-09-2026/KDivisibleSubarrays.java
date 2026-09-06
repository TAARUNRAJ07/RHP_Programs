import java.util.*;
class KDivisibleSubarrays {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int rem =0;
        Map<Integer,Integer> m = new HashMap<>();
        int arr[] = new int[n+1];
        m.put(0, 0);
        for (int i=1;i<=n;i++){
            int c = sc.nextInt();
            rem = (rem + c) % k;
            arr[i] = arr[i-1];
            if(m.containsKey(rem)){
                int prev = m.get(rem);
                arr[i] = Math.max(arr[i-1],1+arr[prev]);
            }
            m.put(rem,  i);
        }
        System.out.println(arr[n]);

    }
}