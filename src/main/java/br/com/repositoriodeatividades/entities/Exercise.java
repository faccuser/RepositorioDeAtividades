package br.com.repositoriodeatividades.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exercise")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@jsonId")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private Date created = Calendar.getInstance().getTime();

    @Column(nullable = true)
    private String type = "";

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private String level = "";

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "exercise", targetEntity = ExerciseOption.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExerciseOption> exerciseOption;

    @OneToMany(mappedBy = "exercise", targetEntity = ExerciseOption.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tag> tag;

    public Exercise() {}

    public Exercise(String label, List<ExerciseOption> exerciseOptionList) {
        this.label = label;
        this.exerciseOption = exerciseOptionList;

        for(ExerciseOption exerciseOption : exerciseOptionList) {
            exerciseOption.setExercise(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ExerciseOption> getExerciseOptions() {
        return exerciseOption;
    }

    public void setExerciseOptions(List<ExerciseOption> questionOption) {
        this.exerciseOption = questionOption;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<ExerciseOption> getExerciseOption() {
        return exerciseOption;
    }

    public void setExerciseOption(List<ExerciseOption> exerciseOption) {
        this.exerciseOption = exerciseOption;
    }
}
