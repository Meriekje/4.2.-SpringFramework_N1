package cat.itacademy.s04.t02.n01.fruits.repository;
import cat.itacademy.s04.t02.n01.fruits.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
