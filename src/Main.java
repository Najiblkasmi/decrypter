import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        {
            try {
                BufferedReader   reader = new BufferedReader(new FileReader("C:\\"));
               int AnzahlNummer = Integer.parseInt(reader.readLine());
                reader.close();
                // create an array to store Menshen Objects
                Mensch[] menshen= new Mensch[AnzahlNummer];
                // Read the data records from the file
                BufferedReader dataReader = new BufferedReader(new FileReader("C:\\"));

                // Skip the first line
                dataReader.readLine();

                for(int i=0;i <AnzahlNummer;i++){
                    //read the data from each record
                    String name = dataReader.readLine();
                    double height = Double.parseDouble(dataReader.readLine());
                    int age = Integer.parseInt(dataReader.readLine());

                    //Create a Mensh object and insert into the Array
                    menshen[i] = new Mensch(name,height,age);
                }
                dataReader.close();
                // print all the stored values to the screen
                for(Mensch mensch: menshen){
                    mensch.showMensch();
                }
                // Serialize the array and write it to the "daten2" file

                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("daten2"));
                outputStream.writeObject(menshen);
                outputStream.close();
                // Deserialize the content of "daten2" into a second array
                ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream("daten2"));
                Mensch[] menschen2 = (Mensch[]) inputStream.readObject();
                inputStream.close();
                //print the content of the second array to the screen
                for (Mensch mensch : menschen2){
                    mensch.showMensch();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
