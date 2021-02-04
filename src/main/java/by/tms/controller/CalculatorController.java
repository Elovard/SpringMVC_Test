package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/calc")
public class CalculatorController {
    List<Double> results = new ArrayList<>();

    @GetMapping
    public String calculator() {
        return "calculator";
    }

    @PostMapping
    public String calculator(double num1, double num2, String operation, Model model) {
        double result = 0.0;
        switch (operation) {
            case "sum":
                result=sum(num1, num2);
                results.add(result);
                break;
            case "minus":
                result=minus(num1, num2);
                results.add(result);
                break;
            case "div":
                result=div(num1, num2);
                results.add(result);
                break;
            case "multiply":
                result=multiply(num1, num2);
                results.add(result);
                break;

        }
        model.addAttribute("result", result);
        return "calculator";
    }



    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private double minus(double num1, double num2) {
        return num1 - num2;
    }

    private double div(double num1, double num2) {
        return num1 / num2;
    }

    private double multiply(double num1, double num2) {
        return num1 * num2;
    }
}