package dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDto {
	
	
	private Long id;
	@NotBlank(message = "First name is mandatory")
	private String firstName;
	@NotBlank(message = "Last name is mandatory")
	private String lastName;
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;
	private String position;
	
	@JsonIgnore
	private LocalDateTime createdDate;
	
	@JsonIgnore
	private LocalDateTime modifiedDate;
	
	public EmployeeDto() {
		
	}
	
	public EmployeeDto(Long id, String firstName, String lastName, String email, String position) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.position = position;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public LocalDateTime getCreatedDate() {
        return createdDate;
    }
	
	public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
	
	public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
	
	public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

	
