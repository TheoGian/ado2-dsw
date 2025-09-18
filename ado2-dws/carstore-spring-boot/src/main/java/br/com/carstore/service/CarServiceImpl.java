package br.com.carstore.service;

import br.com.carstore.model.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private List<CarDTO> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
    }

    @Override
    public List<CarDTO> findAll() {
        return this.cars;
    }

    @Override
    public void save(CarDTO carDTO) {
        if (carDTO.getId() == null || carDTO.getId().isEmpty()) {
            carDTO.setId(UUID.randomUUID().toString());
        }
        cars.add(carDTO);
    }

    @Override
    public void deleteById(String id) {
        if (id == null) return;
        cars.removeIf(car -> id.equals(car.getId()));
    }

    @Override
    public void update(String id, CarDTO carDTO) {
        if (id == null) return;
        for (CarDTO existing : cars) {
            if (id.equals(existing.getId())) {
                // Atualiza apenas os campos que interessam
                existing.setName(carDTO.getName());
                existing.setColor(carDTO.getColor());
                return;
            }
        }

    }

}

