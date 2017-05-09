package apache.commons.test.beanutils;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import apache.commons.test.common.Dog;
import apache.commons.test.common.User;

/*****************************
 * <p>创建日期:2017年5月9日 上午9:50:57</p>
 * <p>创建作者：pi.chen</p>
 * <p>功　　能：PropertyUtils类功能测试</p>
 *****************************/
public class PropertyUtilsTest {
	/**
	 * 对象拷贝(浅拷贝,对象拷贝的是引用)
	 */
	@Test
	public void copyPropertiesTest() {
		try {
			User cp = new User("cp", 28, 60.0);
			cp.setVIP(true);
			Dog xiaoHei = new Dog("xiaoHei");
			cp.setPet(xiaoHei);

			User cp2 = new User();
			PropertyUtils.copyProperties(cp2, cp);

			cp.setName("newcp");
			//xiaoHei.setName("xiaohuang");

			assertEquals(cp2.getAge(), 28);
			assertEquals(cp2.getName(), "cp");
			assertEquals(cp2.getWeight(), 60.0, 0.01);
			assertEquals(cp2.isVIP(), true);
			assertEquals(cp2.getPet().getName(), "xiaoHei");
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 运行期间动态给bean实例设置/修改属性值
	 */
	@Test
	public void getAndsetPropertyTest() {
		try {
			User cp = new User("cp", 28, 60.0);
			PropertyUtils.setProperty(cp, "name", "chenpi");
			String value = (String) PropertyUtils.getProperty(cp, "name");

			assertEquals("chenpi", value);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * bean列表属性修改ArrayList
	 */
	@Test
	public void getAndsetIndexedPropertyTest() {
		try {
			User cp = new User("cp", 28, 60.0);
			List<String> list = new ArrayList<String>(10);
			list.add("xiaoChen");
			list.add("xiaoLi");
			cp.setFriendNameList(list);

			PropertyUtils.setIndexedProperty(cp, "friendNameList[0]", "new_xiaoChen");

			assertEquals("new_xiaoChen", cp.getFriendNameList().get(0));
			assertEquals("new_xiaoChen", PropertyUtils.getIndexedProperty(cp, "friendNameList[0]"));
			assertEquals("new_xiaoChen", PropertyUtils.getIndexedProperty(cp, "friendNameList", 0));

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	/**
	 * bean属性对象修改
	 */
	@Test
	public void getAndsetNestedProperty() {

		try {
			User cp = new User("cp", 28, 60.0);
			Dog xiaoHei = new Dog("xiaoHei");
			cp.setPet(xiaoHei);

			assertEquals("xiaoHei", PropertyUtils.getNestedProperty(cp, "pet.name"));
			
			PropertyUtils.setNestedProperty(cp, "pet.name", "xiaoHuang");
			
			assertEquals("xiaoHuang", cp.getPet().getName());
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}