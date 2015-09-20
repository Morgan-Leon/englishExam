/**
 * 
 */
package com.sexylion.englishExam.service.exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sexylion.englishExam.dto.exam.SingleChoiceDTO;
import com.sexylion.englishExam.model.exam.SingleChoice;
import com.sexylion.englishExam.repository.exam.SingleChoiceRepository;

/**
 * @author Morgan-Leon
 * @Date 2015年9月19日
 * 
 */
@Service
public class SingleChoiceRepositoryService implements SingleChoiceService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SingleChoiceRepositoryService.class);
	private SingleChoiceRepository singleChoiceRepo;
	
    @Autowired
    public SingleChoiceRepositoryService(SingleChoiceRepository singleChoiceRepo)
    {
    	this.singleChoiceRepo = singleChoiceRepo;
    }
	
	/* (non-Javadoc)
	 * @see com.sexylion.englishExam.service.exam.SingleChoiceService#add(com.sexylion.englishExam.dto.exam.SingleChoiceDTO)
	 */
    @Transactional
	@Override
	public SingleChoice add(SingleChoiceDTO dto) {
		// TODO Auto-generated method stub
		SingleChoice model  = new SingleChoice();
		
		model = SingleChoice.getBuilder(dto.getName(), dto.getIssue(), dto.getOptionA(), dto.getOptionB(), dto.getOptionC(), dto.getOptionD()
						, dto.getMp3(), dto.getPoint(),dto.getPaper(), dto.getAnswer()).description(dto.getDescription()).build();
		
		return singleChoiceRepo.save(model);
	}

	/* (non-Javadoc)
	 * @see com.sexylion.englishExam.service.exam.SingleChoiceService#update(com.sexylion.englishExam.dto.exam.SingleChoiceDTO, java.lang.Long)
	 */
	@Override
	public SingleChoiceDTO update(SingleChoiceDTO singleChoiceDTO,
			Long singleChoiceID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sexylion.englishExam.service.exam.SingleChoiceService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public SingleChoice findById(Long id) {
		// TODO Auto-generated method stub
        LOGGER.debug("Finding a SingleChoice entry with id: {}", id);
        SingleChoice model = singleChoiceRepo.findOne(id);
		return model;
	}

	/* (non-Javadoc)
	 * @see com.sexylion.englishExam.service.exam.SingleChoiceService#deleteById(java.lang.Long)
	 */
	@Override
	public SingleChoice deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sexylion.englishExam.service.exam.SingleChoiceService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<SingleChoice> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
