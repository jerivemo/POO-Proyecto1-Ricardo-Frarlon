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

    @Override
    public int getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        


}
