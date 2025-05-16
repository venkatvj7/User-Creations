package com.example.crud.controller;

import com.example.crud.dto.CrudDto;
import com.example.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CrudController {
@Autowired
    CrudService crudService;

@PostMapping("/save")
public String addUser(@RequestBody CrudDto create){
    return crudService.addUser(create);
}
@GetMapping("getById")
    public CrudDto getUser(@RequestParam Integer id){
    return crudService.getUser(id);
}
    @GetMapping("/getAll")
    public List<CrudDto> getAllUser() {
        return crudService.getAllUsers();
    }

}
