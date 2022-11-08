package com.gdu.app11.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app11.domain.EmpDTO;

@Mapper
public interface EmpMapper {

	public int selectAllEmployeesCount();
	public List<EmpDTO> selectEmployeesByPage(int begin, int end);//해당처럼 파라미터값을 두 개이상 보낼 경우 xml에 파라미터 x
}
