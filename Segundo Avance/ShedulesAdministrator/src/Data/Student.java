package Data;



/**
 *
 * @author Ricardo
 */
public class Student extends User {

    private String studentCard;

    public Student(String studentCard, String name, String id, String password) {
        super(name, id, password);
        this.studentCard = studentCard;
    }

    public String getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(String studentCard) {
        this.studentCard = studentCard;
    }
        
        
    /**
     *
     * @return
     */
    @Override
   public  int getType()
   {
       return 0;
   }

}
