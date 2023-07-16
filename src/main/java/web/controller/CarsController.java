package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarDao carDao;

    @Autowired
    public CarsController(CarDao carDao) {
        this.carDao = carDao;

    }


    @GetMapping("/{id}")
    public String showOneCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carDao.show(id));
        //получим один автомобиль по его ID из Dao, и передадим его на отображение
        return "show";
    }
//ѕри запросе /cars выводить весь список. ѕри запросе /cars?count=2 должен
// отобразитьс€ список из 2 машин, при /cars?count=3 - из 3, и тд. ѕри count ? 5 выводить весь список машин.
    @GetMapping()
    public String showSomeCars(@RequestParam(value = "count",required = false) String count,
                               Model model){
        if(count==null){
            model.addAttribute("someCars",carDao.showSome(5));
        }else {
            model.addAttribute("someCars", carDao.showSome(Integer.parseInt(count)));
        }
        return "some";
    }
}

