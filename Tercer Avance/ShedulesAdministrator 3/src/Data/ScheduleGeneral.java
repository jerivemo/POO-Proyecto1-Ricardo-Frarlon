package Data;


public class ScheduleGeneral {

	private Course course;
	private ClassRoom room;
	private Professor professor;

    public ScheduleGeneral(Course course, ClassRoom room, Professor professor) {
        this.course = course;
        this.room = room;
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ClassRoom getRoom() {
        return room;
    }

    public void setRoom(ClassRoom room) {
        this.room = room;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    

}
