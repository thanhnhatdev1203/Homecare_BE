package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.ComboDTO;
import com.homecare.Homecare.dto.EmployeeDTO;
import com.homecare.Homecare.entity.ComboEntity;
import com.homecare.Homecare.entity.EmployeeEntity;

@Component
public class EmployeeConvert {
	public EmployeeEntity dtotoEntity(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity() ;
		employeeEntity.setId(employeeDTO.getId());
		employeeEntity.setName(employeeDTO.getName());
		employeeEntity.setPhone(employeeDTO.getPhone());
		employeeEntity.setBirthday(employeeDTO.getBirthday());
		employeeEntity.setCity(employeeDTO.getCity());
		employeeEntity.setDaytowork(employeeDTO.getDaytowork());
		employeeEntity.setDepartment(employeeDTO.getDepartment());
		employeeEntity.setImage(employeeDTO.getImage());
		employeeEntity.setProvince(employeeDTO.getProvince());
		employeeEntity.setGender(employeeDTO.getGender());
		employeeEntity.setEmail(employeeDTO.getEmail());
		return employeeEntity ;
	}
	public EmployeeDTO entitytoDTO(EmployeeEntity employeeEntity) {
		EmployeeDTO employeeDTO = new EmployeeDTO() ;
		employeeDTO.setId(employeeEntity.getId());
		employeeDTO.setName(employeeEntity.getName());
		employeeDTO.setPhone(employeeEntity.getPhone());
		employeeDTO.setBirthday(employeeEntity.getBirthday());
		employeeDTO.setCity(employeeEntity.getCity());
		employeeDTO.setDaytowork(employeeEntity.getDaytowork());
		employeeDTO.setDepartment(employeeEntity.getDepartment());
		employeeDTO.setImage(employeeEntity.getImage());
		employeeDTO.setProvince(employeeEntity.getProvince());
		employeeDTO.setGender(employeeEntity.getGender());
		employeeDTO.setEmail(employeeEntity.getEmail());
		return employeeDTO ;
	}
}