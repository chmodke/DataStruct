package datastruct.test;

import java.util.Scanner;

import datastruct.implement.LinkedListSLNode;

/**
 * @author KeHao
 * 单链表测试
 */
public class LinkedListTest {

	public static void main(String[] args) {
		StudentStrategy strategy=new StudentStrategy();
		LinkedListSLNode<Student> students=new LinkedListSLNode<Student>(strategy);
		Scanner scan =new Scanner(System.in);
		System.out.print("输入序列长度");
		int t=scan.nextInt();
		System.out.println("输入序列");
		scan(students,t);
		printList(students);
		//-----------------测试获取
		System.out.print("要获取的序号");
		Student st=(Student) students.get(scan.nextInt());
		print(st);
		
		//-----------------测试插入
//		System.out.print("插入元素位置");
//		t=scan.nextInt();
		System.out.println("输入序列");
		Student s=new Student();
		s.setId(scan.nextInt());
		s.setName(scan.next());
		s.setAge(scan.nextInt());
		s.setAddress(scan.next());
		students.insertAfter(st, s);
		s=null;
		st=null;
		printList(students);
		
		
		scan.close();
	}
	public static void scan(LinkedListSLNode<Student> students ,int n){
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<n;i++){
			Student s=new Student();
			s.setId(scan.nextInt());
			s.setName(scan.next());
			s.setAge(scan.nextInt());
			s.setAddress(scan.next());
			students.insert(i,s);
			s=null;
		}
	}
	public static void printList(LinkedListSLNode<Student> students){
		for(int i=0;i<students.getSize();i++){
			Student s=(Student) students.get(i);
			System.out.println(s.toString());
		}
	}
	public static void print(Object o){
			Student s=(Student)o;
			System.out.println(s.toString());
	}
}
