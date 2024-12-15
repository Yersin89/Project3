package kz.spring.springboot.project3.controllers;
import kz.spring.springboot.project3.db.DbManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final DbManager dbManager;

    @GetMapping("/")
    public String homePage(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 5;
        var allTasks = dbManager.getTasks();
        int totalTasks = allTasks.size();
        int totalPages = (int) Math.ceil((double) totalTasks / pageSize);

        int start = Math.min(page * pageSize, totalTasks);
        int end = Math.min(start + pageSize, totalTasks);
        var tasksPage = allTasks.subList(start, end);

        model.addAttribute("tasks", tasksPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        String previousPage = (page > 0) ? "/?page=" + (page - 1) : null;
        String nextPage = (page < totalPages - 1) ? "/?page=" + (page + 1) : null;

        List<String> pages = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pages.add("/?page=" + i);
        }

        model.addAttribute("pages", pages);
        model.addAttribute("previousPage", previousPage);
        model.addAttribute("nextPage", nextPage);

        return "index";
    }

    @PostMapping(value = "/add")
    public String addTask(@RequestParam String name, @RequestParam String deadlineDate,
                          @RequestParam Boolean isCompleted, @RequestParam String details) {
        dbManager.addTask(name, deadlineDate, isCompleted, details);
        return "redirect:/";
    }

}
