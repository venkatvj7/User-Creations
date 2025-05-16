package com.example.crud.service;

import com.example.crud.dto.CrudDto;
import com.example.crud.entity.Crud;
import com.example.crud.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrudService {
    @Autowired
    CrudRepository crudRepository;
    public String addUser(CrudDto create) {
        Crud crud = new Crud();
        crud.setName(create.getName());
        crud.setAge(create.getAge());
        crud.setEmail(create.getEmail());
        crudRepository.save(crud);
        return "user created successfully";
    }

    public CrudDto getUser(Integer id) {
  Crud crud = crudRepository.findById(id).get();
  CrudDto dto = new CrudDto();
  dto.setId(crud.getId());
  dto.setName(crud.getName());
  dto.setAge(crud.getAge());
  dto.setEmail(crud.getEmail());
  return dto;
    }

    public List<CrudDto> getAllUsers() {
        List<Crud> crudList = crudRepository.findAll();
        List<CrudDto> dtoList = new ArrayList<>();

        for (Crud crud : crudList) {
            CrudDto dto = new CrudDto();
            dto.setId(crud.getId());
            dto.setName(crud.getName());
            dto.setAge(crud.getAge());
            dto.setEmail(crud.getEmail());
            dtoList.add(dto);
        }

        return dtoList;
    }

}
