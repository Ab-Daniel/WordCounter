import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class WordCounterList
{
	public static void main(String[ ] args) throws IOException
	{
		class WordCountComparator implements Comparator<Word>
		{
			public int compare(Word first, Word second)
			{
				if(first.getCount() < second.getCount())
					return 1;
				else if(first.getCount() > second.getCount())
					return -1;
				return 0;
			}
		}
		Comparator<Word> compCount = new WordCountComparator();
		
		WordCounterList wcl = new WordCounterList();
		WordList wordList = new WordList();
		
		boolean done = false;
		while(!done)
		{
			String fileName = JOptionPane.showInputDialog("Enter a file name:");
			if(fileName == null || fileName.equals(""))
				done = true;
			else
			{
				BufferedReader reader = wcl.read(fileName);
				String next = null;
				while((next = reader.readLine()) != null)
				{
					if(!next.equals(""))
					{
						String[] a = next.split(" ");
						for(int i = 0; i < a.length; i++)
							wordList.add(new Word(a[i]));
					}
					System.out.println(next);
				}
				reader.close();
				System.out.println();
				ArrayList<Word> countSorted = wordList.returnArray();
				Collections.sort(countSorted, compCount);
				
				System.out.println("Word      Frequency");
				for(int i = 0; i < countSorted.size(); i++)
					System.out.println(countSorted.get(i));
			}
		}
	}
	public BufferedReader read(String fileName) throws FileNotFoundException
	{
		BufferedReader reader = new BufferedReader(getFile(fileName));
		return reader;
	}
	public FileReader getFile(String fileName) throws FileNotFoundException
	{
		ClassLoader classloader = getClass().getClassLoader();
		FileReader file = new FileReader(classloader.getResource(fileName).getFile());
		return file;
	}
}
