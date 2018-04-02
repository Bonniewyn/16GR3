/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.tkgl.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.qhit.lh.gr3.bonnie.exam.common.utils.RandomUtil;
import com.qhit.lh.gr3.bonnie.exam.tkgl.bean.WrittenQuestion;

/**
 * @author ������
 *2018��1��11������4:41:58
 * TODO
 */
public class RandomQuestionsUtils {
private static WrittenQuestion writtenQuestion;
	
	public static Set<WrittenQuestion> randomAllQuestions(
			List<WrittenQuestion> listRE,
			List<WrittenQuestion> listRN,
			List<WrittenQuestion> listRD,
			List<WrittenQuestion> listCE,
			List<WrittenQuestion> listCN,
			List<WrittenQuestion> listCD,
			int radioEasy,int radioNormal,int radioDiff,
			int cbEasy,int cbNormal,int cbDiff
			){
		Set<WrittenQuestion> lisQuestions = new HashSet<>();
		
		randomQuestions(listRE,radioEasy,lisQuestions);
		randomQuestions(listRN,radioNormal,lisQuestions);
		randomQuestions(listRD,radioDiff,lisQuestions);
		randomQuestions(listCE,cbEasy,lisQuestions);
		randomQuestions(listCN,cbNormal,lisQuestions);
		randomQuestions(listCD,cbDiff,lisQuestions);
		
		return lisQuestions;
	}
	
	public static void randomQuestions(List<WrittenQuestion> list, int num, Set<WrittenQuestion> lisQuestions){
		//�����ݼ����������ȡ��ͬ������
		int[] questions = RandomUtil.randomCommon(1, list.size(), num);
		System.out.println(questions.length);
		for(int i=0;i<questions.length;i++){
			System.out.println(list.get(questions[i]-1).getQid());
			//��ȡ����
			writtenQuestion = list.get(questions[i]-1);
			lisQuestions.add(writtenQuestion);
		}
	}
}
