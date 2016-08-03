package datastruct.test;

import java.util.Scanner;

import datastruct.implement.LinkedListDLNode;
import datastruct.interfaces.Iterator;
import datastruct.myUtil.Log;

/**
 * @author KeHao
 * 双向链表测试
 */
public class DLLinkedListTest {

	public static void main(String[] args) {
		LinkedListDLNode<Student> students=new LinkedListDLNode<Student>();
		Scanner scan =new Scanner(System.in);
		System.out.print("输入序列长度");
		int t=scan.nextInt();
		System.out.println("输入序列");
		scan(students,t);
		System.out.println("isEmpty:"+students.isEmpty());
		System.out.println("size:"+students.getSize());
		System.out.println("first:"+students.first().getData().toString());
		System.out.println("last:"+students.last().getData().toString());
		printList(students);
		
		//-----------------测试插入
		System.out.println("输入序列");
		Student s=new Student();
		s.setId(scan.nextInt());
		s.setName(scan.next());
		s.setAge(scan.nextInt());
		s.setAddress(scan.next());
		students.insertLast(s);
		s=null;
		printList(students);
		
		scan.close();
	}
	public static void scan(LinkedListDLNode<Student> students ,int n){
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<n;i++){
			Student s=new Student();
			s.setId(scan.nextInt());
			s.setName(scan.next());
			s.setAge(scan.nextInt());
			s.setAddress(scan.next());
			students.insertLast(s);
			s=null;
		}
	}
	public static void printList(LinkedListDLNode<Student> sl){
		Iterator<Student> it=sl.elements();
		while(!it.isDone()){
			Student s=(Student)it.currentItem();
			Log.logOut("printList:"+s.toString());
			System.out.println(s.toString());
			it.next();
		}
	}
}
