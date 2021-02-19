package HomeWork4.courses;

public class CourseScore {
    private Course course;
    private double score;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public CourseScore(Course course, double score) {
        this.course = course;
        this.score = score;
    }

    public CourseScore(Course course) {
        this(course, 0.0d);
    }

    @Override
    public String toString() {
        return "CourseScore{" +
                "course=" + course +
                ", score=" + score +
                '}';
    }
}
