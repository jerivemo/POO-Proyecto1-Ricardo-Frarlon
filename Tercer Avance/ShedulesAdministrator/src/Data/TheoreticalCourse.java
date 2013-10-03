package Data;



public class TheoreticalCourse extends Course {

	private String webNotes;

    public TheoreticalCourse(String webNotes, String name, String courseID, int credits, int weekHours) {
        super(name, courseID, credits, weekHours);
        this.webNotes = webNotes;
    }

    public String getWebNotes() {
        return webNotes;
    }

    public void setWebNotes(String webNotes) {
        this.webNotes = webNotes;
    }
        
    @Override
    public  int getType(){
        return 0;
    }

}
