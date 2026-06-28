import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i=0; i<N;i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
            case "push_back":
                arr.add(Integer.parseInt(input[1]));
                break;
            case "pop_back":
                arr.remove(arr.size()-1);
                break;
            case "size":
                System.out.println(arr.size());
                break;
            case "get":
                System.out.println(arr.get(Integer.parseInt(input[1])-1));
                break;
            default:
                break;
            }
            
        }
    }
    
}
