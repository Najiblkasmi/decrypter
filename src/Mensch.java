import java.io.Serializable;

public class Mensch implements Serializable {
    private String name;
    private double groesse;
    private int alter;
    public Mensch( String name,double groesse,int alter){
       this.alter=alter;
       this.groesse=groesse;
       this.name=name;
    }
    public void showMensch(){
        System.out.println(  name+" is "+alter+" years old and measures "+groesse+" m");

    }
}
