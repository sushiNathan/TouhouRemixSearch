import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class fileSearch {
	public static void main(String[] args)throws IOException{
		System.out.println(System.getProperty("user.dir")); //Displays the current directory
		File f = new File("."); // current directory
		File[] files = f.listFiles(); //Creates an array of the files of the current directory
		for (File file : files) {//Iterates over the files
			if (file.isFile()) {//Prints the file name if the file is a valid file
				String filename = file.getName();
				String extension = filename.substring(filename.lastIndexOf(".")+1, filename.length());
				if (extension.equals("mp3")){
					System.out.print("file:  ");
					System.out.println(file.getCanonicalPath());
				}
			} 
			
		}
	}

}
