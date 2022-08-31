package hiber.service;

import hiber.model.Car;

public interface CarService {

    Car getCarByModelSeries(String model, int series);

}
