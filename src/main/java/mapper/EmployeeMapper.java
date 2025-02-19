package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.demo.employeemanagementbackend.model.Employee;

import dtos.EmployeeDto;

@Mapper
public interface EmployeeMapper {
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	@Mapping(target = "id", source = "id")
	EmployeeDto toDto(Employee employee);
	
	@Mapping(target = "id", source = "id")
	Employee toEntity(EmployeeDto employeeDto);

	void updateEmployeeFromDto(EmployeeDto employeeDto, @MappingTarget Employee entity);
}
