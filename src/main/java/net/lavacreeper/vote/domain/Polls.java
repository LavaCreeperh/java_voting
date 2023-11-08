package net.lavacreeper.vote.domain;
//id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//                                       `question` TEXT NOT NULL,
//                                       `creator_id` INT UNSIGNED NOT NULL,
//                                       `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
//                                       `end_date` TIMESTAMP NOT NULL,
public class Polls {
    private String question;
    private Integer creator_id;
    private String created_at;
    private String end_date;
    private Integer id;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(Integer creator_id) {
        this.creator_id = creator_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    @Override
    public String toString() {
        return "Polls{" +
                "question='" + question + '\'' +
                ", creator_id=" + creator_id +
                ", created_at='" + created_at + '\'' +
                ", end_date='" + end_date + '\'' +
                ", id=" + id +
                '}';
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Integer getId() {
        if (id!=null){
            return id;
        }
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
