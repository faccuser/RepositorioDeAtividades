package br.com.repositoriodeatividades.controllers;

import br.com.repositoriodeatividades.usecases.exercise.create.CreateExercise;
import br.com.repositoriodeatividades.usecases.exercise.vo.ExercisePlain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseRestController extends AbstractController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired CreateExercise createExercise;

    @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile(ExercisePlain exercisePlain) {

        HttpStatus status;
        String body = "";
        try {
            User currentUser = getCurrentUser();
            exercisePlain.setUsername(currentUser.getUsername());
            createExercise.saveFileExtractedExercises(exercisePlain);
            status = HttpStatus.CREATED;
        } catch (IllegalArgumentException iae) {
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(body, status);
    }
}
