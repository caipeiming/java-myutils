package com.jdk5.blog.IDValidator;

import java.util.Map;

public class Utils {
	private static Map<String, String> gb2260 = GB2260.getInstance();

	/**
	 * 检查参数
	 * 
	 * @param id
	 *            身份证号
	 * @return {@link IDCodeInfo} 成功返回Code，否则返回null
	 */
	public static IDCodeInfo checkArg(String id) {
		id = id.toUpperCase();
		IDCodeInfo code = null;
		if (id.length() == 18) {
			// 18位
			
			code = new IDCodeInfo(id.substring(0, 17), id.substring(17, 18), 18);
		} else if (id.length() == 15) {
			// 15位
			code = new IDCodeInfo(id, 15);
		}
		return code;
	}

	/**
	 * 地址码检查
	 * 
	 * @return {@link Boolean} 成功返回true，失败返回false
	 */
	public static boolean checkAddr(String addr) {
		String addrInfo = getAddrInfo(addr);
		return (addrInfo == "" ? false : true);
	}

	/**
	 * 取得地址码信息
	 * 
	 * @param addr
	 *            {@link String} 地址码
	 * @return {@link String} 返回地址信息
	 */
	public static String getAddrInfo(String addr) {
		if (!gb2260.containsKey(addr)) {
			// 考虑标准不全的情况，搜索不到时向上搜索
			String tmpAddr = addr.substring(0, 4) + "00";
			if (!gb2260.containsKey(tmpAddr)) {
				tmpAddr = addr.substring(0, 2) + "0000";
				if (!gb2260.containsKey(tmpAddr)) {
					return "";
				} else {
					return gb2260.get(tmpAddr) + "未知地区";
				}
			} else {
				return gb2260.get(tmpAddr) + "未知地区";
			}
		} else {
			return gb2260.get(addr);
		}
	}

	// 生日码检查
	public static boolean checkBirth(String birth) {
		int year, month, day;
		if (birth.length() == 8) {
			year = Integer.valueOf(birth.substring(0, 4), 10);
			month = Integer.valueOf(birth.substring(4, 6), 10);
			day = Integer.valueOf(birth.substring(6), 10);
		} else if (birth.length() == 6) {
			year = Integer.valueOf("19" + birth.substring(0, 2), 10);
			month = Integer.valueOf(birth.substring(2, 4), 10);
			day = Integer.valueOf(birth.substring(4), 10);
		} else {
			return false;
		}
		// 按判断年份
		if (year < 1800) {
			return false;
		}
		// 按按月份检测
		if (month > 12 || month == 0 || day > 31 || day == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 顺序码检查
	 * 
	 * @param order
	 * @return {@link Boolean}
	 */
	public static boolean checkOrder(int order) {
		// 暂无需检测
		return true;
	}

	/**
	 * 加权
	 * 
	 * @param t
	 * @return
	 */
	public static int weight(int t) {
		return (int) (Math.pow(2, t - 1) % 11);
	}

	/**
	 * 随机整数
	 * 
	 * @param max
	 * @param min
	 * @return
	 */
	public static long rand(int max, int min) {
		return Math.round(Math.random() * (max - min)) + min;
	}

	/**
	 * 数字补位
	 * 
	 * @param str
	 *            {@link String}
	 * @param len
	 *            {@link Integer}
	 * @param chr
	 *            {@link Character}
	 * @param right
	 *            {@link Boolean}
	 * @return {@link String}
	 */
	public static String strPad(String str, int len, char chr, boolean right) {
		if (str.length() >= len) {
			return str;
		} else {
			for (int i = 0, j = len - str.length(); i < j; i++) {
				if (right) {
					str = str + chr;
				} else {
					str = chr + str;
				}
			}
			return str;
		}
	}

	public static void parseCode(IDCodeInfo code) {
		String addrCode = code.getBody().substring(0, 6);
		String body = code.getBody();
		String birthCode = (code.getType() == 18 ? body.substring(6, 14) : body
				.substring(6, 12));
		int order = Integer.valueOf(body.substring(body.length() - 3));
		String birth = "";
		if (code.getType() == 18) {
			birth = birthCode.substring(0, 4) + "-" + birthCode.substring(4, 6)
					+ "-" + birthCode.substring(6);
		} else {
			birth = "19" + birthCode.substring(0, 2) + "-"
					+ birthCode.substring(2, 4) + "-" + birthCode.substring(4);
		}
		int sex = (order % 2 == 0 ? 0 : 1);
		String addr = Utils.getAddrInfo(addrCode);
		code.setAddrCode(addrCode);
		code.setAddr(addr);
		code.setBirthCode(birthCode);
		code.setBirth(birth);
		code.setSex(sex);
		code.setOrder(order);
	}
}
