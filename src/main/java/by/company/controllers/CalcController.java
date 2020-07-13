package by.company.controllers;

import by.company.entities.Operation;
import by.company.service.CalcResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/calc")
public class CalcController {

    @Autowired
    private List<Operation> operationList;

    @Autowired
    CalcResources calcResources;

    @GetMapping
    public ResponseEntity<List<Operation>> clc(){
        return new ResponseEntity<>(operationList,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> calc(@RequestBody Operation operation){
            double myRes = calcResources.calculate(operation.getNum1(), operation.getNum2(), operation.getOperation());
            return new ResponseEntity<>(" " + myRes,HttpStatus.OK);
    }
}
