package com.studentmanagement.model;

public class Student {
    private String name;
    private int roll;
    private String grade;

    public Student() {
    }

    public Student(String name, int roll, String grade) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return roll + "," + name + "," + grade;
    }

    public static Student fromString(String line) {
        try {
            if (line == null || line.trim().isEmpty())
                return null;
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                return new Student(parts[1].trim(), Integer.parseInt(parts[0].trim()), parts[2].trim());
            }
            return null;
        } catch (Exception e) {
            System.err.println("Error parsing student line: " + line + " - " + e.getMessage());
            return null;
        }
    }
}
