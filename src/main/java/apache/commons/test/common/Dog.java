/*
 * Copyright (c)  by pi.chen. All right reserved.
 */
package apache.commons.test.common;

/******************************
 * <p>创建日期:2017年5月9日 上午10:14:41</p>
 * <p>创建作者：pi.chen</p>
 * <p>功　　能：</p>
 ******************************/
public class Dog extends Pet{

	public String name;

	/**
	 * 
	 */
	public Dog(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
