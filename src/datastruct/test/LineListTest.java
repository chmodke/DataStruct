package datastruct.test;

import java.util.Scanner;

import datastruct.implement.LineList;

/**
 * @author KeHao
 * 线性表测试
 */
public class LineListTest {

	public static void main(String[] args) {
		StudentStrategy strategy=new StudentStrategy();
		LineList<Student> students=new LineList<Student>(strategy);
		Scanner scan =new Scanner(System.in);
		System.out.print("输入序列长度");
		int t=scan.nextInt();
		System.out.println("输入序列");
		scan(students,t);
		printList(students);
		//-----------------测试获取
		System.out.print("要获取的序号");
		print(students.get(scan.nextInt()));
		
		//-----------------测试插入
		System.out.print("插入元素位置");
		t=scan.nextInt();
		System.out.println("输入序列");
		Student s=new Student();
		s.setId(scan.nextInt());
		s.setName(scan.next());
		s.setAge(scan.nextInt());
		s.setAddress(scan.next());
		students.insert(t, s);
		s=null;
		printList(students);
		
		
		scan.close();
	}
	public static void scan(LineList<Student> students ,int n){
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
	public static void printList(LineList<Student> students){
		int temp =students.getSize();//长度动态变化，需要提前保存
		for(int i=0;i<temp;i++){
			Student s=(Student) students.get(i);
			System.out.println(s.toString());
		}
	}
	public static void print(Object o){
			Student s=(Student)o;
			System.out.println(s.toString());
	}
}
