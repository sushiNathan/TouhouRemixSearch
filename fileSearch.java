import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class fileSearch {
	public static void main(String[] args)throws IOException{
		if (args[0].equals("new")){
			newFile();
		}
		
		else if (args[0].equals("search")){
			String tag = args[1];
		}
	}
	
	public static void newFile() throws IOException{
		System.out.println(System.getProperty("user.dir")); //Displays the current directory
		File f = new File("."); // current directory
		File[] files = f.listFiles(); //Creates an array of the files of the current directory
		FileWriter text = new FileWriter("songs.txt");
		for (File file : files) {//Iterates over the files
			if (file.isFile()) {//Prints the file name if the file is a valid file
				String filename = file.getName();
				String extension = filename.substring(filename.lastIndexOf(".")+1, filename.length());
				if (extension.equals("mp3")){
					System.out.println(file.getName());
					text.write(file.getName() + System.getProperty( "line.separator" ));
				}
			}
		}
		text.close();
	}
	
	public static void tagSearch(String tag) throws IOException{
		
	}

}
