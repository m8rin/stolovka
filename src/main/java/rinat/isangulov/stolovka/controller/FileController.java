package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rinat.isangulov.stolovka.entity.Dish;
import rinat.isangulov.stolovka.entity.FileEntity;
import rinat.isangulov.stolovka.repository.DishRepository;
import rinat.isangulov.stolovka.service.FileService;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class FileController {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

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

    @ResponseBody
    @RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Optional<FileEntity> fileEntityOptional = fileService.getFile(id);

        if (fileEntityOptional.isEmpty()) {
            return ResponseEntity.notFound()
                    .build();
        }

        FileEntity fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .contentType(MediaType.valueOf(fileEntity.getContentType()))
                .body(fileEntity.getData());
    }

}
