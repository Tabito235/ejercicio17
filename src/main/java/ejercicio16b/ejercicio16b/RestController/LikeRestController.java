package ejercicio16b.ejercicio16b.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicio16b.ejercicio16b.models.likes;
import ejercicio16b.ejercicio16b.services.LikeService;

@RestController
public class LikeRestController {

    @Autowired
    private LikeService likeService;

    @GetMapping("/api/likes")
    public likes obtenerLikes() {
        return likeService.obtenerLikes();
    }

    @PostMapping("/api/likes/{imagen}")
    public likes aumentarLike(@PathVariable int imagen) {
        likeService.aumentarLike(imagen);
        return likeService.obtenerLikes();
    }
}
