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

    @GetMapping("/temp")
    public String temp() {
        return "temp";
    }

    @PostMapping("/temp")
    public String temp(@RequestParam double temp, @RequestParam String temperature, Model model) {
        double convertedTemp = getTempConversion(temp, temperature);
        model.addAttribute("result", convertedTemp);
        return "temp";
    }

    @GetMapping("/length")
    public String length() {
        return "length";
    }

    @PostMapping("/length")
    public String length(@RequestParam double length, @RequestParam String unit, Model model) {
        double convertedLength = getLengthConversion(length, unit);
        model.addAttribute("result", convertedLength);
        return "length";
    }

    private double getLengthConversion(double length, String unit) {
        return switch (unit) {
            case "meters" -> length / 100;
            case "kilometers" -> length / 1000;
            case "inches" -> length / 2.54;
            default -> 1;
        };
    }

    @GetMapping("/weight")
    public String weight() {
        return "weight";
    }

    @PostMapping("weight")
    public String weight(@RequestParam double weight, @RequestParam String unit, Model model) {
        double convertedWeight = getWeightConversion(weight, unit);
        model.addAttribute("result", convertedWeight);
        return "weight";
    }

    private double getWeightConversion(double weight, String unit) {
        return switch (unit) {
            case "kilograms" -> weight / 2.20462;
            case "pounds" -> weight * 2.205;
            case "grams" -> weight / 1000;
            default -> 1;
        };
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
