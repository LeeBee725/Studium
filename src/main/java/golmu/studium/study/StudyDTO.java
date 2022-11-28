package golmu.studium.study;

import golmu.studium.user.User;

import java.util.List;

public class StudyDTO {
    private String subject;

    public StudyDTO(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
