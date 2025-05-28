package ejercicio16b.ejercicio16b.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ejercicio16b.ejercicio16b.models.likes;
import ejercicio16b.ejercicio16b.services.LikeService;

@Controller
public class HomeController {

    @Autowired
    private LikeService likeService;

    @GetMapping("/")
    public String home(Model model) {
        likes datos = likeService.obtenerLikes();
        model.addAttribute("likes", datos);
        return "index";
    }

    @PostMapping("/like/{imagen}")
    public String aumentarLike(@PathVariable int imagen) {
        likeService.aumentarLike(imagen);
        return "redirect:/";
    }
}
