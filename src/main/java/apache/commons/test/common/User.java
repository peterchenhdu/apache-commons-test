/*
 * Copyright (c)  by pi.chen. All right reserved.
 */
package apache.commons.test.common;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

/******************************
 * <p>创建日期:2017年5月9日 上午9:45:22</p>
 * <p>创建作者：pi.chen</p>
 * <p>功　　能：</p>
 ******************************/
public class User extends BaseObject {

	private String name;
	private int age;
	private double weight;
	private boolean isVIP;
	private Dog pet;
	private List<String> friendNameList;

	/**
	 * 
	 */
	public User() {

	}

	/**
	 * 
	 */
	public User(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.isVIP = false;
		this.pet = null;
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

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the isVIP
	 */
	public boolean isVIP() {
		return isVIP;
	}

	/**
	 * @param isVIP the isVIP to set
	 */
	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}

	/**
	 * @return the pet
	 */
	public Dog getPet() {
		return pet;
	}

	/**
	 * @param pet the pet to set
	 */
	public void setPet(Dog pet) {
		this.pet = pet;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		try {
			return BeanUtils.describe(this).toString();
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			return e.toString();
		}
	}

	/**
	 * @return the friendNameList
	 */
	public List<String> getFriendNameList() {
		return friendNameList;
	}

	/**
	 * @param friendNameList the friendNameList to set
	 */
	public void setFriendNameList(List<String> friendNameList) {
		this.friendNameList = friendNameList;
	}
}
