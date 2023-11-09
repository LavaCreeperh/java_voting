package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetChoicesById {
    @Autowired
    ChoiceService choiceService;

    @PostMapping("/api/getChoicesById")
    public List<Choices> getChoicesById(@RequestBody IdJson id) {
        return choiceService.getByPollsId(id.getId());
    }

}
