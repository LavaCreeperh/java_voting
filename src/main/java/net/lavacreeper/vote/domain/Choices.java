package net.lavacreeper.vote.domain;
//CREATE TABLE IF NOT EXISTS `choices` (
//                                         `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//                                         `poll_id` INT UNSIGNED NOT NULL,
//                                         `description` TEXT NOT NULL,
//                                         FOREIGN KEY (`poll_id`) REFERENCES `polls`(`id`) ON DELETE CASCADE
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
public class Choices {
    private Integer id;
    private Integer poll_id;
    private String description;

    public Choices(Integer id, Integer poll_id, String description) {
        this.id = id;
        this.poll_id = poll_id;
        this.description = description;
    }

    public Choices(Integer poll_id, String description) {
        this.poll_id = poll_id;
        this.description = description;
    }

    public Choices(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Choices{" +
                "id=" + id +
                ", poll_id=" + poll_id +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        if (id!=null){
            return id;
        }
        return null;    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getPoll_id() {
        return poll_id;
    }

    public void setPoll_id(Integer poll_id) {
        this.poll_id = poll_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
