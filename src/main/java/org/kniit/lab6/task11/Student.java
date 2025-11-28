package org.kniit.lab6.task11;
import java.util.Objects;

public class Student implements Comparable<Student>{
    private final String name;

    public Student(String name) { this.name = name.trim(); }

    public String getName() { return name; }

    @Override
    public int compareTo(Student other) { return this.name.compareTo(other.name); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof Student other)) { return false; }
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name); }

    @Override
    public String toString() { return name; }
}
