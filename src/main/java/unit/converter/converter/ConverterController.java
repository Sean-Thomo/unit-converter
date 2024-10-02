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

    @PostMapping("/currency")
    public String currency(@RequestParam double amount, @RequestParam String currency, Model model) {
        double convertedAmount = amount / getConversationalRate(currency);
        model.addAttribute("result", convertedAmount);
        return "index";
    }

    @GetMapping("/temp.html")
    public String temp() {
        return "temp";
    }

    @PostMapping("/temp")
    public String temp(@RequestParam double temp, @RequestParam String temperature, Model model) {
        double convertedTemp = getTempConversion(temp, temperature);
        model.addAttribute("result", convertedTemp);
        return "temp";
    }

    private double getTempConversion(Double temp, String temperature) {
        return switch (temperature) {
            case "celsius" -> (temp * 9 / 5) + 32;
            case "fahrenheit " -> (temp - 32) * 5 / 9;
            default -> 1;
        };
    }

    private double getConversationalRate(String currency) {
        return switch (currency) {
            case "USD" -> 17.40;
            case "EUR" -> 19.26;
            default -> 1;
        };
    }
}
