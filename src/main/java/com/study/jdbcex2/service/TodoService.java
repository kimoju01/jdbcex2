package com.study.jdbcex2.service;


import com.study.jdbcex2.TodoDTO;
import com.study.jdbcex2.dao.TodoDAO;
import com.study.jdbcex2.domain.TodoVO;
import com.study.jdbcex2.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum TodoService {

    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // TodoDTO를 파라미터로 받아서 TodoVO로 변환하는 과정이 필요하다.
    // ModelMapper로 처리된 TodoVO를 sout을 이용해 확인한다.
    // TodoDAO를 이용해 insert()를 실행하고 TodoVO를 등록한다.
    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        System.out.println("todoVO: " + todoVO);

        // int를 반환하므로 이를 이용해 예외 처리도 가능
        dao.insert(todoVO);
    }

}
