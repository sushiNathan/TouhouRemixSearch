import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class fileSearch {
	public static void main(String[] args)throws IOException{
		search();
	}
	public static void search()throws IOException{
		System.out.println("Enter 'new' to create a new text file");
		System.out.println("Enter 'search' to search for songs");
		System.out.println("Enter 'exit' to exit the program");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		if (input.equals("new")){
			newFile();
		}
		else if (input.equals("search")){
			System.out.println("Enter tag: ");
			String tag = sc.next();
			tagSearch(tag);
		}
		else if (input.equals("exit")){
			System.exit(0);
		}
		else{
			System.out.println("Invalid input");
			search();
		}
		sc.close();
	}
	
	public static void newFile() throws IOException{
		System.out.println("Adding the following songs");
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
		System.out.println("Text file created");
		search();
	}
	
	public static void tagSearch(String tag) throws IOException{
		System.out.println("Displaying songs");
		FileReader fr = new FileReader( "songs.txt" );
		BufferedReader br = new BufferedReader( fr );
		String stringRead = br.readLine( );
		while( stringRead != null ){ // test for the end of the file
		// print the line read
			try{
				String endOfName = stringRead.substring(stringRead.lastIndexOf(".")+5, stringRead.length());
			
				if(endOfName.equals(tag)){//Print the song name if its tag is the same as the inputted tag
					System.out.println(stringRead.substring(0, stringRead.lastIndexOf(".")));
				}
				stringRead = br.readLine( ); // read next line
			}
			catch(IndexOutOfBoundsException e){
				stringRead = br.readLine( ); // read next line
			}
		}
		br.close();
		search();
	}
}
