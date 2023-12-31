package by.training.module3.service;

import by.training.module3.entity.Device;
import by.training.module3.repository.DeviceRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class DeviceService {

    private DeviceRepositoryImpl repository;

    public DeviceService(DeviceRepositoryImpl repository) {
        this.repository = repository;
    }

    public void create(Device item) {
        repository.create(item);
    }

    public Optional<Device> get(long id) {
        return repository.get(id);
    }

    public void update(Device item) {
        repository.update(item);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public List<Device> getAll() {
        return repository.getAll();
    }

}
