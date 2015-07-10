package comp.formation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class CarouselView implements Serializable {
     

	private static final long serialVersionUID = 1L;

	private List<Car> cars;
     
    private Car selectedCar;
     
    @ManagedProperty(value="#{carService}")
    private CarService service;
     
    @PostConstruct
    public void init() {
        cars = service.createCars(9);
    }
 
    public List<Car> getCars() {
        return cars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}