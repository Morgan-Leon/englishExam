package com.sexylion.englishExam.service.exam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sexylion.englishExam.dto.exam.SingleChoiceDTO;
import com.sexylion.englishExam.model.exam.SingleChoice;


/**
 * @author Morgan-Leon
 * @Date 2015年9月19日
 * 
 */

public interface SingleChoiceService {
	
    public SingleChoiceDTO add(SingleChoiceDTO singleChoiceDTO);

    public SingleChoiceDTO update(SingleChoiceDTO singleChoiceDTO,Long singleChoiceID);

    public SingleChoice findById(Long id);

    public SingleChoice deleteById(Long id);

    Page<SingleChoice> findAll(Pageable pageable);

}
