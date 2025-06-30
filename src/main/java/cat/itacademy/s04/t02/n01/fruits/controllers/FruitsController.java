package cat.itacademy.s04.t02.n01.fruits.controllers;

import cat.itacademy.s04.t02.n01.fruits.model.Fruit;
import cat.itacademy.s04.t02.n01.fruits.services.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitsController {
    private final FruitsService fruitService;

    @Autowired
    public FruitsController(FruitsService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody @Valid Fruit fruit) {
        return ResponseEntity.ok(fruitService.addFruit(fruit));
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody @Valid Fruit fruit) {
        return ResponseEntity.ok(fruitService.updateFruit(fruit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable int id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable int id) {
        return ResponseEntity.ok(fruitService.getFruitById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        return ResponseEntity.ok(fruitService.getAllFruits());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
