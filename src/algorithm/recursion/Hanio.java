package algorithm.recursion;

import java.util.Scanner;

/**
 * @author kehao
 * 汉诺塔递归求解分析
 */
public class Hanio {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		hanio(scan.nextInt(),'A','B','C');
		scan.close();
	}
	public static void hanio(int n,char x,char y,char z){
		if(n==1){
			System.out.println("m1:"+n+x+y+z+"-"+x+n+z+"弹栈");
			move(x,n,z);
		}else{
			System.out.println("h1:"+n+x+y+z+"压栈");
			hanio(n-1,x,z,y);
			System.out.println("m2:"+n+x+y+z+"-"+x+n+z+"弹栈");
			move(x,n,z);
			System.out.println("h2:"+n+x+y+z+"压栈");
			hanio(n-1,y,x,z);
		}
	}
	public static void move(char x,int n,char y){
		System.out.println("Move "+n+" from "+x+" to "+y);
	}
}
