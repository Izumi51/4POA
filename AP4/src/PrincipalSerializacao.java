import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrincipalSerializacao {
	public static void main(String[] args) {
		Cinema c = new Cinema("Vingadores", 344, 54, 39.99);
		try {
			File f = new File("c:/cinemaList/");
			if(!f.exists()) {
				f.mkdir();
			}
			FileOutputStream arqOSer = new FileOutputStream("c:/cinemaList/cinema.info");
			ObjectOutputStream oOSer = new ObjectOutputStream(arqOSer);
			oOSer.writeObject(c);
			oOSer.close();
			System.out.println("Antes de alterar idade----------------------------");
			System.out.println(c);
			c.setQuantidadeCadeiras(40);
			System.out.println("\nDepois de alterar idade----------------------------");
			System.out.println(c);
			FileInputStream arqISer = new FileInputStream("c:/cinemaList/cinema.info");
			ObjectInputStream iOSer = new ObjectInputStream(arqISer);
			c = (Cinema) iOSer.readObject();
			iOSer.close();
			System.out.println("\nDepois de recuperar os valores----------------------------");
			System.out.println(c);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


