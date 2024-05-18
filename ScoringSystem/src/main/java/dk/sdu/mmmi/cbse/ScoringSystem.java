package dk.sdu.mmmi.cbse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoringSystem {

    private int score = 0;

    public static void main(String[] args) {
        SpringApplication.run(ScoringSystem.class, args);
    }

    @PostMapping("/addScore")
    public int addToScore(@RequestParam(value = "points") int point) {
        score += point;
        return score;
    }
    @GetMapping("/score")
    public int getScore() {
        return score;
    }

}