package com.sexylion.englishExam.model.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sexylion.englishExam.common.model.AbstractEntity;
import com.sexylion.englishExam.dto.exam.SingleChoiceDTO;
import com.sexylion.englishExam.utill.DateSerializer;


/**
 * @author Morgan-Leon
 * @Date 2015年9月19日
 * @Discription: 
 * 		单选题，支持两种、三种、四种选项。
 * 
 * @Antributes:
 * 		id
 * 		name
 * 		issue
 * 		optionA、B、C、D
 * 		mp3
 * 		point
 * 		answer 
 * 		paper
 */
@Entity
@Table(name="single_choice")
public class SingleChoice extends AbstractEntity{
	
	public static final int MAX_LENGTH_ISSUE = 1000;
	public static final int MAX_LENGTH_DESCRIPTION = 200;
	public static final int MAX_LENGTH_MP3 = 200;
	public static final int MAX_LENGTH_OPTION = 150;
	public static final int MAX_LENGTH_NAME = 50;
	
	public static final int DEFAULT_POINT = 5;
	
    @Column(nullable = true, length = MAX_LENGTH_DESCRIPTION)
    private String description;
    
    @JsonSerialize(using = DateSerializer.class)
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;
    
    @Column(name="name",nullable = true,length = MAX_LENGTH_NAME)
    private String name;
    
    @Column(name="issue",nullable = false,length = MAX_LENGTH_ISSUE)
    private String issue;
    
    @Column(name="option_a",nullable = false,length = MAX_LENGTH_OPTION)
    private String optionA;
    @Column(name="option_b",nullable = false,length = MAX_LENGTH_OPTION)
    private String optionB;
    @Column(name="option_c",nullable = true,length = MAX_LENGTH_OPTION)
    private String optionC;
    @Column(name="option_d",nullable = true,length = MAX_LENGTH_OPTION)
    private String optionD;
    
    @Column(name="mp3",nullable = true,length = MAX_LENGTH_MP3)
    private String mp3;
    
    private int point = DEFAULT_POINT;
    
    @Enumerated(EnumType.STRING)
    private SingleOption answer;
    
    private  long paper;
    
    
    @PrePersist
    public void prePersist() {
        super.prePersist();
        DateTime now = DateTime.now();
        modificationTime = now;

    }

    @PreUpdate
    public void preUpdate() {
        modificationTime = DateTime.now();
    }

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
	
	public static Builder getBuilder(String name,String issue, String optionA,String optionB,String optionC,String optionD
			,String mp3,int point, long paper,SingleOption answer) {
		return new Builder(name, issue, optionA, optionB, optionC, optionD, mp3, point, paper, answer);
	}
	
	public static class Builder{
		
		private SingleChoice built;
		
		public Builder(String name,String issue, String optionA,String optionB,String optionC,String optionD
				,String mp3,int point, long paper,SingleOption answer) {
			// TODO Auto-generated constructor stub
			built = new SingleChoice();
			built.name = name;
			built.issue = issue;
			built.optionA = optionA;
			built.optionB = optionB;
			built.optionC = optionC;
			built.optionD = optionD;
			built.mp3 = mp3;
			built.point = point;
			built.paper = paper;
			built.answer = answer;
		}
		
		public Builder description(String description) {
            built.description = description;
            return this;
        }

		/**
		 * @return
		 */
		public SingleChoice build() {
			// TODO Auto-generated method stub
			return built;
		}
		
	}//END BUILD

	public SingleChoiceDTO createDTO() {
		// TODO Auto-generated constructor stub
		SingleChoiceDTO dto = new SingleChoiceDTO();
		dto.setDescription(description);
		dto.setName(name);
		dto.setIssue(issue);
		dto.setOptionA(optionA);
		dto.setOptionB(optionB);
		dto.setOptionC(optionC);
		dto.setOptionD(optionD);
		dto.setMp3(mp3);
		dto.setPoint(point);
		dto.setAnswer(answer);
		dto.setDescription(description);
		dto.setPaper(paper);
		return dto;
	}
	
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
