/**
 * 
 */
package com.qhit.lh.gr3.bonnie.sbm.util;

import java.util.UUID;


public class IDUtil {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
