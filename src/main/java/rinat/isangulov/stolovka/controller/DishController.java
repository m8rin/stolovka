package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rinat.isangulov.stolovka.entity.Dish;
import rinat.isangulov.stolovka.entity.FileEntity;
import rinat.isangulov.stolovka.entity.FileResponse;
import rinat.isangulov.stolovka.repository.DishRepository;
import rinat.isangulov.stolovka.service.FileService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private final FileService fileService;

    public DishController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/dishesList")
    public String dishesList(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());

        return "dishesList";
    }

    @GetMapping("/")
    public String menu(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());
        return "dishesList";
    }

    @GetMapping("/editDishes")
    public String menuForEdit(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());

        return "dishesListForEdit";
    }

    @GetMapping("/dish/{dish}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String dishEditForm(@PathVariable Dish dish, Model model) {
        if (dish.getCategory() == null) {
            dish.setCategory("");
            dishRepository.save(dish);
        }

        model.addAttribute("dish", dish);
        return "dishEdit";
    }

    @PostMapping("/dish")
    public String dishSave(
            @RequestParam String name,
            @RequestParam String price,
            @RequestParam String category,
            @RequestParam("file") MultipartFile file,
            @RequestParam("dishId") Dish dish
    ) {

        dish.setName(name);
        dish.setPrice(price);
        dish.setCategory(category);
        dish.setCount(1);

        try {
            fileService.save(file);
            dish.setImg(file.getOriginalFilename());
            dish.setImgURL(mapToFileResponse(fileService.getLast()).getUrl());

        } catch (Exception ignored) {
            System.out.println("Не удалось загрузить файл: " + file.getOriginalFilename());
        }

        dishRepository.save(dish);
        return "redirect:/dish/"+ dish.getId();
    }

    private FileResponse mapToFileResponse(FileEntity fileEntity) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(fileEntity.getId())
                .toUriString();

        FileResponse fileResponse = new FileResponse();
        fileResponse.setId(fileEntity.getId());
        fileResponse.setName(fileEntity.getName());
        fileResponse.setContentType(fileEntity.getContentType());
        fileResponse.setSize(fileEntity.getSize());
        fileResponse.setUrl(downloadURL);

        return fileResponse;
    }

}
