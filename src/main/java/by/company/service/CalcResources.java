package by.company.service;

import by.company.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcResources {
    @Autowired
    List<Operation> operationList;

    public double calculate(double a,double b,String operation) {
        double result = 0;
        switch (operation) {
            case "sum":
                result = sum(a,b);
                Operation operation1 = new Operation(a, b, result, operation);
                operationList.add(operation1);
                break;
            case "sub":
               result = sub(a,b);
                Operation operation2 = new Operation(a, b, result, operation);
                operationList.add(operation2);
                break;
            case "mult":
                result = mult(a,b);
                Operation operation3 = new Operation(a, b, result, operation);
                operationList.add(operation3);
                break;
            case "div":
                result = div(a,b);
                Operation operation4 = new Operation(a, b, result, operation);
                operationList.add(operation4);
                break;
        }
        return result;
    }

    private static double sum(double digit1,double digit2){
        return digit1+digit2;
    }

    private static double sub(double digit1,double digit2){
        return digit1-digit2;
    }

    private static double mult(double digit1,double digit2){
        return digit1*digit2;
    }

    private static double div(double digit1,double digit2){
        return digit1/digit2;
    }
}
