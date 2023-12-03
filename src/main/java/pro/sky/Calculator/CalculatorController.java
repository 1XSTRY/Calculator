package pro.sky.Calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/calculator/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.calculate("plus", num1, num2);
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.calculate("minus", num1, num2);
    }

    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.calculate("multiply", num1, num2);
    }

    @GetMapping("/calculator/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.calculate("divide", num1, num2);
    }
}