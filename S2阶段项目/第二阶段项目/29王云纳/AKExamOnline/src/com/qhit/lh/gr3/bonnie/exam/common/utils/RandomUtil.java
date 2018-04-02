/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.common.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * @author ������
 *2018��1��11������4:32:16
 * TODO
 */
public class RandomUtil {
	
	/** 
	 * ���ָ����Χ��N�����ظ����� 
	 * ���������ķ��� 
	 * @param min ָ����Χ��Сֵ ,����
	 * @param max ָ����Χ���ֵ ,������
	 * @param n ��������� 
	 */  
	public static int[] randomCommon(int min, int max, int n){
		if (n > (max - min + 1) || max < min) {  
			return null;  
		}  
		int[] result = new int[n];  
		int count = 0;  
		while(count < n) {  
			int num = (int) (Math.random() * (max - min)) + min;  
			boolean flag = true;  
			for (int j = 0; j < n; j++) {  
				if(num == result[j]){  
					flag = false;  
					break;  
				}  
			}  
			if(flag){  
				result[count] = num;  
				count++;  
			}  
		}  
		return result;  
	}  

	/** 
	 * ���ָ����Χ��N�����ظ����� 
	 * ����HashSet��������ֻ�ܴ�Ų�ͬ��ֵ 
	 * @param min ָ����Χ��Сֵ 
	 * @param max ָ����Χ���ֵ 
	 * @param n ��������� 
	 * @param HashSet<Integer> set ���������� 
	 */  
	public static void randomSet(int min, int max, int n, HashSet<Integer> set) {
		if (n > (max - min + 1) || max < min) {  
			return;  
		}  
		for (int i = 0; i < n; i++) {  
			// ����Math.random()����  
			int num = (int) (Math.random() * (max - min)) + min;  
			set.add(num);// ����ͬ��������HashSet��  
		}  
		int setSize = set.size();  
		// ����������С��ָ�����ɵĸ���������õݹ�������ʣ�����������������ѭ����ֱ���ﵽָ����С  
		if (setSize < n) {  
			randomSet(min, max, n - setSize, set);// �ݹ�  
		}  
	}

	/** 
	 * ���ָ����Χ��N�����ظ����� 
	 * �ڳ�ʼ�������ظ���ѡ�������������һ�����������У� 
	 * ����ѡ���鱻������������ô�ѡ����(len-1)�±��Ӧ�����滻 
	 * Ȼ���len-2�����������һ���������������� 
	 * @param max  ָ����Χ���ֵ 
	 * @param min  ָ����Χ��Сֵ 
	 * @param n  ��������� 
	 * @return int[] ���������� 
	 */  
	public static int[] randomArray(int min,int max,int n){  
		int len = max-min+1;  

		if(max < min || n > len){  
			return null;  
		}  

		//��ʼ��������Χ�Ĵ�ѡ����  
		int[] source = new int[len];  
		for (int i = min; i < min+len; i++){  
			source[i-min] = i;  
		}  

		int[] result = new int[n];  
		Random rd = new Random();  
		int index = 0;  
		for (int i = 0; i < result.length; i++) {  
			//��ѡ����0��(len-2)���һ���±�  
			index = Math.abs(rd.nextInt() % len--);  
			//�������������������  
			result[i] = source[index];  
			//����ѡ�����б�������������ô�ѡ����(len-1)�±��Ӧ�����滻  
			source[index] = source[len];  
		}  
		return result;  
	}
}
