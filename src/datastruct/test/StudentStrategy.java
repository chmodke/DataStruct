package datastruct.test;

import datastruct.interfaces.Strategy;

/**
 * @author KeHao
 * Student实体类比较规则
 */
public class StudentStrategy implements Strategy {

	@Override
	public boolean equal(Object o1, Object o2) {
		if (o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			if (s1.getId() == s2.getId()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			if (s1.getId() == s2.getId()) {
				return 0;
			}
			if (s1.getId() < s2.getId()) {
				return -1;
			}
			if (s1.getId() > s2.getId()) {
				return 1;
			}
		}
		return -1;
	}

}
