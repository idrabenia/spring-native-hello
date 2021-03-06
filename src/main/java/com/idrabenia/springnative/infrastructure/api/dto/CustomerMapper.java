package com.idrabenia.springnative.infrastructure.api.dto;

import com.idrabenia.springnative.domain.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer mapFromDto(CustomerDto dto);

    List<CustomerDto> mapToDtoList(Iterable<Customer> list);

    CustomerDto mapToDto(Customer customer);

}
