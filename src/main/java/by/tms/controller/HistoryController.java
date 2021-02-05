package by.tms.controller;

import by.tms.service.InMemoryHistoryStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/history")
public class HistoryController {
    private final InMemoryHistoryStorage historyStorage = new InMemoryHistoryStorage();

    @GetMapping
    public String calculatorHistory(Model model){
        model.addAttribute("results", historyStorage.getResults());
        return "historyCalc";
    }

    @PostMapping
    public String calculatorHistory(List<Double> results, Model model){
        return "historyCalc";
    }
}
