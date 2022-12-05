package golmu.studium.study;

import golmu.studium.user.User;

import java.util.Collections;
import java.util.List;

public class Study {
    private Long id;
    private String subject;
    private List<User> participants;

    public Study(Long id, String subject) {
        this.id = id;
        this.subject = subject;
        participants = Collections.emptyList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
