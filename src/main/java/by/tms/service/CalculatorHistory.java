package by.tms.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/history")
public class CalculatorHistory {
    Calculator calculator = new Calculator(); // maybe it's not the best practice


    @GetMapping
    public String calculatorHistory(){
        return "historyCalc";
    }

    @PostMapping
    public String calculatorHistory(List<Double> results, Model model){
        model.addAttribute("results", calculator.results);
     //   model.addAttribute("results", results);
        return "historyCalc";
    }
}
