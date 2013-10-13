package Data;


public class ScheduleGeneral {

	private Course course;
	private ClassRoom room;
	private Professor professor;
        private ScheduleBlock shedule;
        
    public ScheduleGeneral(Course course,Professor professor) {
        this.course = course;
        this.room = null;
        this.professor = professor;
        this.shedule=null;
    }

    public ScheduleGeneral(Course course, ClassRoom room, Professor professor, ScheduleBlock shedule) {
        this.course = course;
        this.room = room;
        this.professor = professor;
        this.shedule = shedule;
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

    public ScheduleBlock getShedule() {
        return shedule;
    }

    public void setShedule(ScheduleBlock shedule) {
        this.shedule = shedule;
    }
    
    

}
