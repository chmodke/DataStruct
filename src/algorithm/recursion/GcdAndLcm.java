package algorithm.recursion;

import org.junit.Test;

/**
 * @author kehao
 * 最小公倍数和最大公约数算法
 */
public class GcdAndLcm {
	/**
	 * 非递归算法
	 * @param m
	 * @param n
	 * @return
	 */
	public int gcd01(int m,int n){
		int a=Math.max(m, n);
		int b=Math.min(m, n);
		int r;
		while(a%b!=0){
			r=a%b;
			a=b;
			b=r;
		}
		return b;
	}
	/**
	 * 递归算法
	 * @param m
	 * @param n
	 * @return
	 */
	public int gcd02(int m,int n){
		int a=Math.max(m, n);
		int b=Math.min(m, n);
		if(a%b==0){
			return b;
		}else{
			return gcd02(b,a%b);
		}
	}
	/**
	 * 最小公倍数
	 * @param m
	 * @param n
	 * @return
	 */
	public int lcm(int m,int n){
		return m*n/gcd02(m,n);
	}
	@Test
	public void testGcd01(){
		System.out.println(gcd01(60,24));
		System.out.println(gcd01(24,60));
	}
	@Test
	public void testGcd02(){
		System.out.println(gcd02(60,24));
		System.out.println(gcd02(24,60));
	}
	@Test
	public void testLcm(){
		System.out.println(lcm(60,24));
		System.out.println(lcm(24,60));
	}
}
