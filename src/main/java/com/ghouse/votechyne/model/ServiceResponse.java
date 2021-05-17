package com.ghouse.votechyne.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {
//own service response defined to transfer the data
	private String status;
	private T data;
	
}
