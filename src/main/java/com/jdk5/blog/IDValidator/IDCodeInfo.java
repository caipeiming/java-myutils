package com.jdk5.blog.IDValidator;

/**
 * 身份证信息
 *
 */
public class IDCodeInfo {
	private String body;
	private int type;

	private boolean valid;
	private String addrCode;
	private String addr;
	private String birthCode;
	private String birth;
	private int sex;
	private String checkBit;
	private int order;

	public IDCodeInfo(String body, String checkBit, int type){
		this.body = body;
		this.checkBit = checkBit;
		this.type = type;
	}
	
	public IDCodeInfo(String body, int type) {
		super();
		this.body = body;
		this.type = type;
	}

	public String getBirthCode() {
		return birthCode;
	}

	public void setBirthCode(String birthCode) {
		this.birthCode = birthCode;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getAddrCode() {
		return addrCode;
	}

	public void setAddrCode(String addrCode) {
		this.addrCode = addrCode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCheckBit() {
		return checkBit;
	}

	public void setCheckBit(String checkBit) {
		this.checkBit = checkBit;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String str = "addrCode:" + addrCode + " addr:" + addr + " birthCode:"
				+ birthCode + " birth:" + birth + " order:" + order
				+ " checkBit:" + checkBit + " sex:" + sex + " type:" + type;
		return str;
	}
}