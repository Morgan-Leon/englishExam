
package com.sexylion.englishExam.controller.exam;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sexylion.englishExam.dto.exam.SingleChoiceDTO;
import com.sexylion.englishExam.model.exam.SingleChoice;
import com.sexylion.englishExam.service.exam.SingleChoiceService;


/**
 * @author Morgan-Leon
 * @Date 2015年9月19日
 * 
 */
@Controller
@RequestMapping(value = "/api")
public class SingleChoiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SingleChoiceController.class);

    private SingleChoiceService service;
    @Autowired
    public SingleChoiceController(SingleChoiceService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/singleChoice", method = RequestMethod.POST)
    @ResponseBody
    public SingleChoiceDTO add(@Valid @RequestBody SingleChoiceDTO dto) {
        LOGGER.debug("Adding a new single choice entry with information: {}", dto);

        SingleChoice added = service.add(dto);
        LOGGER.debug("Added a single choice entry with information: {}", added);

       return added.createDTO();
    }
    
//    @RequestMapping(value = "/api/todo/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public TodoDTO deleteById(@PathVariable("id") Long id) throws TodoNotFoundException {
//        LOGGER.debug("Deleting a single choice entry with id: {}", id);
//
//        Todo deleted = service.deleteById(id);
//        LOGGER.debug("Deleted single choice entry with information: {}", deleted);
//
//        return createDTO(deleted);
//    }
    
//    @RequestMapping(value = "/api/todo", method = RequestMethod.GET)
//    @ResponseBody
//    public List<SingleChoiceDTO> findAll() {
//        LOGGER.debug("Finding all todo entries.");
//
//        List<SingleChoice> models = service.findAll();
//        LOGGER.debug("Found {} single choice entries.", models.size());
//
//        return createDTOs(models);
//    }
    
    @RequestMapping(value = "/singleChoice/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SingleChoiceDTO findById(@PathVariable("id") Long id) throws NotFoundException {
        LOGGER.debug("Finding single choice entry with id: {}", id);

        SingleChoice found = service.findById(id);
        LOGGER.debug("Found single choice entry with information: {}", found);

        return found.createDTO();
    }


}
