package SimonRandomTasks.education_system.course;

public class CourseScore {

    private Course course;
    private Double score;

    public CourseScore(Course course, Double score) {
        this.course = course;
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
