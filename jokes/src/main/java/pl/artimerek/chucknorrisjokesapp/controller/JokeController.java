package pl.artimerek.chucknorrisjokesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artimerek.chucknorrisjokesapp.service.JokeService;

@Controller
public class JokeController {

    JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping("/")
    public String getJoke(Model model){
        model.addAttribute("joke",jokeService.getJoke());
        return "jokes";
    }

}
