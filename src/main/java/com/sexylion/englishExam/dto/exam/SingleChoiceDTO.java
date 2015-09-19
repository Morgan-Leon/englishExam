package com.sexylion.englishExam.dto.exam;

import com.sexylion.englishExam.model.exam.SingleChoice;
import com.sexylion.englishExam.model.exam.SingleOption;

/**
 * @author Morgan-Leon
 * @Date 2015年9月19日
 * 
 */
public class SingleChoiceDTO {
	
	 private String description;
	
	 private String name;

     private String issue;
     
     private String optionA;
     
     private String optionB;
     
     private String optionC;
     
     private String optionD;
     
     private String mp3;
     
     private SingleOption answer;
     
     private int point = SingleChoice.DEFAULT_POINT;
     
     private long paper;
     
     private String paperName;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getMp3() {
		return mp3;
	}

	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}

	public SingleOption getAnswer() {
		return answer;
	}

	public void setAnswer(SingleOption answer) {
		this.answer = answer;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public long getPaper() {
		return paper;
	}

	public void setPaper(long paper) {
		this.paper = paper;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
     
    
}
