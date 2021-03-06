package com.kt.jspjdbc.gestor.model.grade;

public class GradeWithSubjectName {
    private int gradeId;
    private double value;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GradeWithSubjectName{" +
                "gradeId=" + gradeId +
                ", value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
