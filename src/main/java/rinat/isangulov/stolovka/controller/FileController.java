package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rinat.isangulov.stolovka.entity.Dish;
import rinat.isangulov.stolovka.repository.DishRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class FileController {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/fill")
    public String fillMenu(Model model) {

        String fileName = "src/main/resources/goods2.csv";
        ArrayList<Dish> dishes = new ArrayList<>();
        String name, code, price;
        String line;
        String[] str;

        Pattern pattern = Pattern.compile("^[\\d]{5}");
        Matcher matcher;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "cp1251"))) {
            while ((line = br.readLine()) != null) {
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    str = line.split(";");
                    code = str[0];
                    name = str[2];
                    price = (!str[4].isEmpty()) ? str[4] : "0";

                    dishes.add(new Dish(code, name, price));
                }
            }
        } catch (IOException ex) {
            model.addAttribute("status", false);
            ex.printStackTrace();
        }

        if (!dishes.isEmpty()) {
            model.addAttribute("dishes", dishes);
            saveDishes(dishes);
        }

        return "dishesList";
    }

    @GetMapping("/readFile")
    public String readFile(Model model) {

        String fileName = "src/main/resources/goods1.csv";
        ArrayList<Dish> dishes = new ArrayList<>();
        String name, code, price;
        String line;
        String[] str;

        Pattern pattern = Pattern.compile("^[\\d]{5}");
        Matcher matcher;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "cp1251"))) {
            while ((line = br.readLine()) != null) {
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    str = line.split(";");
                    code = str[0];
                    name = str[2];
                    price = (!str[4].isEmpty()) ? str[4] : "0";

                    dishes.add(new Dish(code, name, price));
                }
            }
        } catch (IOException ex) {
            model.addAttribute("status", false);
            ex.printStackTrace();
        }

        if (!dishes.isEmpty()) {
            model.addAttribute("dishes", dishes);
            saveDishes(dishes);
        }

        return "dishesList";
    }

    public void saveDishes(ArrayList<Dish> dishes) {
        for (Dish dish : dishes) {
            Dish dishFromDb = dishRepository.findDishByCode(dish.getCode());
            if (dishFromDb == null) {
                dishRepository.save(dish);
                System.out.println("Добавлено новое блюдо:\n" + dish);
            }
        }
    }

}
