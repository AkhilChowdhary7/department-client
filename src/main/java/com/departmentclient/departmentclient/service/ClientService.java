package com.departmentclient.departmentclient.service;

import com.departmentclient.departmentclient.model.RequestModel;
import com.departmentclient.departmentclient.model.ResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ClientService {

    ResponseModel getData(int id);

    public ResponseModel postData(RequestModel requestModel) throws JsonProcessingException;

}
