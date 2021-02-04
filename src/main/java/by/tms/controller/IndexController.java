package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping(path = "/")              // обрабатываю тут гет-запросы
    public String index(Model model){   // секция, которая варьируется (Variable)
        model.addAttribute("name","Test");   // сюда запихиваем аттрибуты
        return "index";          // указываем какую страницу будет выкидывать (index.jsp)
    }

    @GetMapping(path = "/index2")     // localhost:8080/index2    уточняем второй индекс
    public String index2(@RequestParam String name, Model model){   // требуем и принимаем name, выведет через index2?name=test
        model.addAttribute("name", name);
        return "index";
    }
}

