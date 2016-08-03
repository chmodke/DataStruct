package algorithm.recursion;

import org.junit.Test;

/**
 * @author kehao
 * 猴子吃桃问题
 * 第一天摘了一些桃子，每天吃了一半零一个(当天就吃了一次),第十天只吃了一个
 * 通项公式An=2A(n-1)+2
 */
public class MonkeyEatFruit {
	/**
	 * 递推算法
	 * @param n
	 * @return
	 */
	public int eat01(int n){
		int a=1;
		for(int i=2;i<=n;i++){
			a=2*a+2;
		}
		return a;
	}
	/**
	 * 递归算法
	 * @param n
	 * @return
	 */
	public int eat02(int n){
		System.out.println("f("+n+")压栈");
		if(n==1){
			System.out.println("函数栈达到最大深度");
			System.out.println("f("+n+")弹栈");
			return n;
		}else{
			int a=2*eat02(n-1)+2;
			System.out.println("f("+n+")弹栈");
			return a;
		}
	}
	@Test
	public void test01(){
		System.out.println(eat01(10));
	}
	@Test
	public void test02(){
		System.out.println(eat02(10));
	}
}
