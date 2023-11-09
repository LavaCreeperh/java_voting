package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPollsById {
    @Autowired
    PollsService pollsService;

    @PostMapping("/api/getPollsById")
    public List<Polls> getPollsById(@RequestBody IdJson id) {
        return pollsService.getPollsByUserId(id.getId());
    }
}
