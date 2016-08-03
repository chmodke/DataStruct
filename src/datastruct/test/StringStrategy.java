package datastruct.test;

import datastruct.interfaces.Strategy;

/**
 * @author KeHao 
 * String实体类比较规则
 */
public class StringStrategy implements Strategy {

	@Override
	public boolean equal(Object o1, Object o2) {
		if (o1 instanceof String && o2 instanceof String) {
			String s1 = (String) o1;
			String s2 = (String) o2;
			return s1.equals(s2);
		}
		return false;
	}

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof String && o2 instanceof String) {
			String s1 = (String) o1;
			String s2 = (String) o2;
			if (s1.equals(s2)) {
				return 0;
			}
		}
		return -1;
	}
}
