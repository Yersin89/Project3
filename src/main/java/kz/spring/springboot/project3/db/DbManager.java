package kz.spring.springboot.project3.db;
import kz.spring.springboot.project3.entities.Task;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Scope
@Component

public class DbManager {
    @Getter
    private static List<Task> tasks = new ArrayList<>(
            List.of(
                    new Task(1L, "Complete Task 7 from Spring Boot till the end of the lesson", "23.10.2020", true, "Details"),
                    new Task(2L, "Clear home and buy foods","2020.10.2020", true, "Details"),
                    new Task(3L, "Complete all home tasks at the weekend", "2020.10.2020", false, "Details"),
                    new Task(4L, "Develop simple project in Spring Boot for the final", "12.12.2020", false, "Details"),
                    new Task(5L, "Learn Italian Language", "01.05.2020", false, "Details")
            ));

    public void addTask(String name, String deadlineDate, Boolean isCompleted, String details) {
        Task newTask = Task
                .builder()
                .name(name)
                .deadlineDate(deadlineDate)
                .isCompleted(isCompleted)
                .details(details)
                .id(tasks.size() + 1L)
                .build();
        tasks.add(newTask);
    }

}

