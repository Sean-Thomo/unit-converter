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
        return "index"; // Ensure this matches your HTML file name
    }

    @PostMapping("/currency")
    public String currency(@RequestParam double amount, @RequestParam String currency, Model model) {
        double convertedAmount = amount / getConversationalRate(currency);
        model.addAttribute("result", convertedAmount);
        return "index";
    }

    private double getConversationalRate(String currency) {
        return switch (currency) {
            case "USD" -> 17.40;
            case "EUR" -> 19.26;
            default -> 1;
        };
    }
}
