package kz.spring.springboot.project3.entities;

import lombok.*;

    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Task {
        private Long id;
        private String name;
        private String deadlineDate;
        private Boolean isCompleted;
        private String details;
}
