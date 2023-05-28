package com.departmentclient.departmentclient.controller;

import com.departmentclient.departmentclient.model.RequestModel;
import com.departmentclient.departmentclient.model.ResponseModel;
import com.departmentclient.departmentclient.service.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department-client")
public class Controller {

    @Autowired
    ClientService service;
    @GetMapping("/hello")
    public String Hello(){
        return "Hello World";
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseModel> getData(@PathVariable int id){
        ResponseModel responseModel = service.getData(id);
        if(responseModel == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<ResponseModel> createDepartment(@Valid @RequestBody RequestModel requestModel) throws JsonProcessingException {
        ResponseModel responseModel = service.postData(requestModel);

        if(responseModel == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}
