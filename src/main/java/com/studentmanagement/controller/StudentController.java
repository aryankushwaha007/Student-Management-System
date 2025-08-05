package com.studentmanagement.controller;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        try {
            List<Student> students = studentService.getAllStudents();
            if (students == null) {
                students = new ArrayList<>();
            }
            model.addAttribute("students", students);
            model.addAttribute("student", new Student());
        } catch (IOException e) {
            model.addAttribute("error", "Error loading students: " + e.getMessage());
            model.addAttribute("students", new ArrayList<>());
            model.addAttribute("student", new Student());
        } catch (Exception e) {
            model.addAttribute("error", "Unexpected error: " + e.getMessage());
            model.addAttribute("students", new ArrayList<>());
            model.addAttribute("student", new Student());
        }
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        try {
            if (student.getName() == null || student.getName().trim().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "Student name is required!");
                return "redirect:/add";
            }
            studentService.addStudent(student);
            redirectAttributes.addFlashAttribute("success", "Student added successfully!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Error adding student: " + e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Unexpected error: " + e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{roll}")
    public String showEditForm(@PathVariable int roll, Model model, RedirectAttributes redirectAttributes) {
        try {
            Student student = studentService.findByRoll(roll);
            if (student != null) {
                model.addAttribute("student", student);
                return "edit-student";
            } else {
                redirectAttributes.addFlashAttribute("error", "Student not found!");
                return "redirect:/";
            }
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Error finding student: " + e.getMessage());
            return "redirect:/";
        }
    }

    @PostMapping("/edit")
    public String updateStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        try {
            boolean updated = studentService.updateStudent(student);
            if (updated) {
                redirectAttributes.addFlashAttribute("success", "Student updated successfully!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Student not found!");
            }
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Error updating student: " + e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{roll}")
    public String deleteStudent(@PathVariable int roll, RedirectAttributes redirectAttributes) {
        try {
            boolean deleted = studentService.deleteByRoll(roll);
            if (deleted) {
                redirectAttributes.addFlashAttribute("success", "Student deleted successfully!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Student not found!");
            }
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Error deleting student: " + e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam int roll, Model model) {
        try {
            Student student = studentService.findByRoll(roll);
            if (student != null) {
                model.addAttribute("student", student);
                model.addAttribute("searchResult", true);
            } else {
                model.addAttribute("error", "Student with roll number " + roll + " not found!");
            }
        } catch (IOException e) {
            model.addAttribute("error", "Error searching student: " + e.getMessage());
        }
        return "search-result";
    }
}
