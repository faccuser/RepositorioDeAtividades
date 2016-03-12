package br.com.repositoriodeatividades.domains.vo.exercise;

import br.com.repositoriodeatividades.domains.interfaces.ExerciseItem;

public class MultipleChoiceExerciseItem implements ExerciseItem {

    public Long id;
    public String label;

    public MultipleChoiceExerciseItem(Long id) {
        this.id = id;
        this.label = "";
    }

    public MultipleChoiceExerciseItem(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
