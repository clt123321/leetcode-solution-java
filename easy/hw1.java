package easy;
import java.security.Signature;

import org.omg.CORBA.PUBLIC_MEMBER;

public class hw1 {
	public static int f(int X, int n, int m, int...xs) {
		int[][]	binaryXs=new int[X][32];	
		for(int i=0;i<X;i++) {
			binaryXs[i]=changetoBinary(xs[i]);
		}
		//show(binaryXs[0]);
		//1 提取m bit
		int[][] tmp=new int[X][m];
		for(int i=0;i<X;i++) {
			for(int j=0;j<m;j++) {
				tmp[i][j]=binaryXs[i][n+j];
			}
		}
		//2移动m+n之前的bits
		for(int i=0;i<X;i++) {
			for(int j=0;j<32-m-n;j++) {
				binaryXs[i][n+j]=binaryXs[i][n+m+j];
			}
		}
		//3 前m位赋值
		for(int i=0;i<X;i++) {
			for(int j=0;j<m;j++) {
				binaryXs[i][32-m+j]=tmp[i][j];
			}
		}
		//4 计算出现最多的行
		/*
		show(binaryXs[0]);
		System.out.println("\n");
		show(binaryXs[1]);
		System.out.println(judge(binaryXs[0],binaryXs[1]));
		*/
		
		int[]Acc=new int[X];
		for(int k=0;k<X;k++) {
			for(int x=0;x<X;x++) {
				if(judge(binaryXs[x],binaryXs[k])) {
					Acc[x]++;
				}
			}
		}
		//show(Acc);
		
		int Max=1;
		int position=-1;
		for(int i=0;i<X;i++) {
			if(Acc[i]>Max) {
				Max=Acc[i];
				position=i;
			}
		}
		
		//System.out.println(position);
		//show(binaryXs[position]);
		
		//5 返回int
		if(position!=-1) {
			int ans=0;
			for(int i=0;i<16;i++) {
				ans=(int) (ans+Math.pow(2,i)*binaryXs[position][16+i]);
			}
			return ans;
		}
		else {
		return -1;
		}
	}
	public static boolean judge(int[]a,int[]b) {
		boolean ans;
		ans=true;
		for(int i=0;i<16;i++) {
			ans=ans&&(a[16+i]==b[16+i]);
		}
		return ans;
	}
	public static int[] changetoBinary(int x) {
		int[] binary= new int[32];
		int tmp;
		for(int i=0;i<32;i++) {
			tmp=x%2;
			binary[i]=tmp;
			x=x>>1;
		}
		return binary;
	}
	public static void show(int[] arr) {
		for (int i = arr.length-1; i >=0; i--) {
			System.out.print(arr[i]+",");
		}
	}
	public static void main(String[] args) {
		int a=5;
		int[] b= new int[32];
		//b=changetoBinary(a);
		//show(b);
		
		int X=4;
		int n=4;
		int m=4;
		int x1=16;
		int x2=1;
		int x3=273;
		int x4=22;
		
		int ans=0;
		ans=f(X,n,m,x1,x2,x3,x4);
	    System.out.println(ans);
		
		
	}
	

}
