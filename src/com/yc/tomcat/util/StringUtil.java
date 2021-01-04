package com.yc.tomcat.util;

/**
 * 
 * company 源辰信息
 * @author 沈观清
 * @data 2020年10月25日
 * Email 1198865589@qq.com
 */
public class StringUtil {
	/**
	 * 空判断
	 * @param strs
	 * @return
	 */
	public static boolean checkNull(String...strs) {
		if(strs==null||strs.length<=0) {
			return true;
		}
		for(String str:strs) {
			if(str==null||"".equals(str)) {
				return true;
			}
		}
		return false;
	}
}
