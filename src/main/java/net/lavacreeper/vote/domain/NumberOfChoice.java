package net.lavacreeper.vote.domain;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.domain
 * @className: NumberOfChoice
 * @author: LavaCreeper
 * @description:
 * @date: 11/10/23 9:44 PM
 * @version: 1.0
 */

//一个专用的对象，用来存储choices id和对应的票数
public class NumberOfChoice {
    Integer choice_id;
    Integer number;

    String choice_description;

    @Override
    public String toString() {
        return "NumberOfChoice{" +
                "choice_id=" + choice_id +
                ", number=" + number +
                ", choice_description='" + choice_description + '\'' +
                '}';
    }

    public NumberOfChoice(Integer choice_id, Integer number, String choice_description) {
        this.choice_id = choice_id;
        this.number = number;
        this.choice_description = choice_description;
    }


    public Integer getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(Integer choice_id) {
        this.choice_id = choice_id;
    }

    public Integer getNumber() {
        return number;
    }

    public String getChoice_description() {
        return choice_description;
    }

    public void setChoice_description(String choice_description) {
        this.choice_description = choice_description;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
