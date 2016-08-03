package algorithm.linkedList;

import datastruct.implement.StackSLinked;

/**
 * @author kehao
 * 获取栈中最小值
 */
public class MinOfStack {
	StackSLinked<Integer> elem;
	StackSLinked<Integer> min;
	public MinOfStack() {
		elem=new StackSLinked<Integer>();
		min=new StackSLinked<Integer>();
	}
	public void push(Integer data){
		elem.push(data);
		if(min.isEmpty()){
			min.push(data);
		}else{
			if(data<=min.peek()){
				min.push(data);
			}
		}
	}
	public int pop(){
		Integer topData=elem.pop();
		if(topData==this.min()){
			min.pop();
		}
		return topData;
	}
	public Integer min(){
		if(min.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return min.peek();
		}
	}
}
