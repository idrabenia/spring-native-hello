package com.idrabenia.springnative.infrastructure.api;

import com.idrabenia.springnative.infrastructure.api.dto.CustomerMapper;
import com.idrabenia.springnative.service.CustomerService;
import com.idrabenia.springnative.infrastructure.api.dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	private final CustomerMapper customerMapper;

	@PostMapping("/customer")
	public CustomerDto create(@RequestBody CustomerDto payload) {
		var curCustomer = customerMapper.mapFromDto(payload);
		var result = customerService.save(curCustomer);
		return customerMapper.mapToDto(result);
	}

	@GetMapping("/customer")
	public List<CustomerDto> findAll() {
		var customers = customerService.findAll();
		return customerMapper.mapToDtoList(customers);
	}

}
