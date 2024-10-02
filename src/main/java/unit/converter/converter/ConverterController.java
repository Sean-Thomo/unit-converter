package unit.converter.converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam double amount, @RequestParam String currency, Model model) {
        double convertedAmount = amount * getConversionalRate(currency);
        model.addAttribute("result", convertedAmount);
        return "index";
    }

    private double getConversionalRate(String currency) {
        switch (currency) {
            case "USD":
                return 17.40;
            case "EUR":
                return 19.26;
            default:
                return 1;
        }
    }
}
