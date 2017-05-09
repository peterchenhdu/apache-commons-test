/*
 * Copyright (c)  by pi.chen. All right reserved.
 */
package apache.commons.test.beanutils;

import static org.junit.Assert.assertEquals;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.junit.Test;

/******************************
 * <p>创建日期:2017年5月9日 上午10:54:41</p>
 * <p>创建作者：pi.chen</p>
 * <p>功　　能：动态bean测试</p>
 ******************************/
public class DynaBeanTest {

	public static final String USER_NAME_PROPERTY = "name";

	/**
	 * 动态类，动态属性
	 */
	@Test
	public void runExample() {
		DynaClass dynaClass = new BasicDynaClass("User", null,
				new DynaProperty[] { new DynaProperty(USER_NAME_PROPERTY, String.class) });

		try {
			DynaBean user = dynaClass.newInstance();
			user.set(USER_NAME_PROPERTY, "cp");

			assertEquals(user.get(USER_NAME_PROPERTY), "cp");
			assertEquals(user.getDynaClass().getName(), "User");

		} catch (IllegalAccessException | InstantiationException ex) {
			System.err.println(ex.getMessage());
		}

	}
}
