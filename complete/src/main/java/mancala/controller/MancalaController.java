package mancala.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import mancala.service.MancalaService;
import mancala.model.Mancala;
import mancala.model.Move;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/")
public class MancalaController {
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Mancala index() {
        return MancalaService.getInstance().initMancala();
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Mancala updateScore(@RequestBody(required=true) Move move) {
        return MancalaService.getInstance().updateMancala(move);
    }
    
}
