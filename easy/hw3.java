package easy;
import java.util.Scanner;
public class hw3 {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans=0;
        int M=in.nextInt();
        int V=in.nextInt();
        int N=in.nextInt();
        int[]matrix=new int[N];
        for(int i=0;i<N;i++){
            matrix[i]=in.nextInt();
        }
        //ans=f(M,V,N,matrix);
        System.out.println(ans);
        /*
        public static int f(int n,int vi,int ti;int[]matix){
            ArrayList<Integer> ep = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                ep.add(new Integer(buffer.readLine()));
            }
            Collections.sort(ep);
            int total = 0;
            while (ep.size() > 0) {
                Integer max = ep.remove(ep.size() - 1);
                total++;
                for (int index = 0; index < ep.size(); index++) {
                    if (index == ep.size() -1) {
                        if (ep.get(index) + max <= w) {
                            ep.remove(index);
                            break;
                        }
                    } else {
                        Integer min = ep.get(index);
                        Integer minMore = ep.get(index + 1);
                        if (min + max <= w && minMore + max > w) {
                            ep.remove(index);
                            break;
                        }
                    }
                }
            }*/
            
        }
     
}