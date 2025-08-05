package com.studentmanagement.service;

import com.studentmanagement.model.Student;
import com.studentmanagement.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public void addStudent(Student student) throws IOException {
        FileUtil.appendLine(student.toString());
    }

    public List<Student> getAllStudents() throws IOException {
        List<String> lines = FileUtil.readAllLines();
        return lines.stream()
                .filter(line -> line != null && !line.trim().isEmpty())
                .map(line -> {
                    try {
                        return Student.fromString(line);
                    } catch (Exception e) {
                        System.err.println("Error parsing line: " + line + " - " + e.getMessage());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Student findByRoll(int roll) throws IOException {
        return getAllStudents().stream()
                .filter(s -> s.getRoll() == roll)
                .findFirst().orElse(null);
    }

    public boolean deleteByRoll(int roll) throws IOException {
        List<Student> students = getAllStudents();
        boolean removed = students.removeIf(s -> s.getRoll() == roll);
        if (removed) {
            saveAll(students);
        }
        return removed;
    }

    public boolean updateStudent(Student updated) throws IOException {
        List<Student> students = getAllStudents();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRoll() == updated.getRoll()) {
                students.set(i, updated);
                found = true;
                break;
            }
        }

        if (found) {
            saveAll(students);
        }
        return found;
    }

    private void saveAll(List<Student> students) throws IOException {
        List<String> lines = students.stream()
                .map(Student::toString)
                .collect(Collectors.toList());
        FileUtil.writeAllLines(lines);
    }
}
