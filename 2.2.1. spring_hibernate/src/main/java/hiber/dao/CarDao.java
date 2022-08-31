package hiber.dao;

import hiber.model.Car;

public interface CarDao {

    Car getCarByModelSeries(String model, int series);

}
