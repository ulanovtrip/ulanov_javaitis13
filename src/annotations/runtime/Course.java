package annotations.runtime;

@Model(tableName = "course_table")
public class Course {

    @Id // собственная аннотация
    private Long id;

    @ColumnTable(length = 20, name = "title_of_course")
    private String title;

    @ColumnTable(length = 0, name = "duration_of_course")
    private Integer duration;

    @ColumnTable(name = "is_active")
    private Boolean isActive;
}
