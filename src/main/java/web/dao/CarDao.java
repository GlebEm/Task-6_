package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
//@Repository
public class CarDao {
    private static int CAR_COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CAR_COUNT, "Mazda3","Black"));
        cars.add(new Car(++CAR_COUNT, "Nissan Almera","White"));
        cars.add(new Car(++CAR_COUNT, "Kia Rio","Red"));
        cars.add(new Car(++CAR_COUNT, "Tesla","Blue"));
        cars.add(new Car(++CAR_COUNT, "Kia Soul","Orange"));
    }
    public Car show(int id) {
        return cars.stream().filter(cars -> cars.getId() == id).findAny().orElse(null);
    }
    public List<Car> index() {
        return cars;
    }
    public List<Car> showSome(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
