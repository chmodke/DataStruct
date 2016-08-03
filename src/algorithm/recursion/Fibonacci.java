package algorithm.recursion;

import org.junit.Test;

/**
 * @author kehao
 * 斐波那契数列
 */
public class Fibonacci {
	/**
	 * 简单递归方式
	 * @param n
	 * @return
	 */
	public int fib01(int n){
		System.out.println("f("+n+")压栈");
		if(n==1||n==2){
			System.out.println("f("+n+")弹栈");
			return n;
		}else{
			int k=fib01(n-1)+fib01(n-2);
			System.out.println("f("+n+")弹栈");
			return k; 
		}
	}
	/**
	 * 备忘录法
	 * @param n
	 * @return
	 */
	public int fib02(int n){
		if(n==1||n==2){
			return n;
		}else{
			int arr[]=new int [n+1];
			arr[1]=1;arr[2]=2;
			return dfs(n,arr);
		}
		
	}
	public int dfs(int n,int [] arr){
		if(arr[n]!=0){
			return arr[n];
		}else{
			arr[n]=dfs(n-1,arr)+dfs(n-2,arr);
		}
		return arr[n];
	}
	/**
	 * 动态规划法
	 * @param n
	 * @return
	 */
	public int fib03(int n){
		if(n==1||n==2){
			return n;
		}else{
			int arr[]=new int [n+1];
			arr[1]=1;arr[2]=2;
			for(int i=3;i<=n;i++){
				arr[i]=arr[i-1]+arr[i-2];
			}
			return arr[n];
		}
	}
	/**
	 * 状态压缩法
	 * @param n
	 * @return
	 */
	public int fib04(int n){
		if(n==1||n==2){
			return n;
		}else{
			int a1=1;int a2=2;int a3=0;
			for(int i=3;i<=n;i++){
				a3=a1+a2;
				a1=a2;
				a2=a3;
			}
			return a3;
		}
	}
	/**
	 * 通项公式法
	 * @param n
	 * @return
	 */
	public int fib05(int n){
		if(n==1||n==2){
			return n;
		}else{
			n++;
			//通项公式结果是1,1,2,3,5,8,13
			//斐波那契序列是1,2,3,5,8,13	所以需要n+1
			double sqrtFive=Math.sqrt(5.0);
			double a=Math.pow((1+sqrtFive)/2, n);
			double b=Math.pow((1-sqrtFive)/2, n);
			return (int)Math.floor(1/sqrtFive*(a-b));
		}
	}
	@Test
	public void testFib01(){
		System.out.println(fib01(5));
	}
	@Test
	public void testFib02(){
		System.out.println(fib02(20));
	}
	@Test
	public void testFib03(){
		System.out.println(fib03(20));
	}
	@Test
	public void testFib04(){
		System.out.println(fib04(20));
	}
	@Test
	public void testFib05(){
		System.out.println(fib05(20));
	}
}
