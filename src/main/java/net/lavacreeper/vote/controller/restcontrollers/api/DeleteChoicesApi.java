package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteChoicesApi {
    @Autowired
    ChoiceService choiceService;

    @PostMapping("/api/deleteChoices")
    public Message deleteChoices(IdJson id) {
        if (choiceService.deleteByPollsId(id.getId())) {
            return new Message("删除成功", true);
        }
        return new Message("删除失败", false);

    }
}
