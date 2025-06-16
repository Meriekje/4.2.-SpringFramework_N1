package cat.itacademy.s04.t02.n01.fruits.services;

import cat.itacademy.s04.t02.n01.fruits.exception.NotFoundException;
import cat.itacademy.s04.t02.n01.fruits.model.Fruit;
import cat.itacademy.s04.t02.n01.fruits.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitsService {
    private final FruitRepository fruitRepository;

    public FruitsService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Fruit fruit) {
        if (!fruitRepository.existsById(fruit.getId())) {
            throw new NotFoundException("Fruit with ID " + fruit.getId() + " not found.");
        }
        return fruitRepository.save(fruit);

    }

    public void deleteFruit(int id) {
        if (!fruitRepository.existsById(id)) {
            throw new NotFoundException("Fruit with ID " + id + " not found.");
        }
        fruitRepository.deleteById(id);
    }

    public Fruit getFruitById(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fruit with ID " + id + " not found."));
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}
