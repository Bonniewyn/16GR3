/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam;

import org.junit.Test;

import com.qhit.lh.gr3.bonnie.exam.common.utils.RandomUtil;

/**
 * @author 王云纳
 *2018年1月11日下午4:29:28
 * TODO
 */
public class RandomTest {
	
	@Test
	public void getRandom(){
		int[] qs = RandomUtil.randomCommon(1,2,1);
		for (int i = 0; i < qs.length; i++) {
			System.out.println(qs[i]);
		}
	}

}
