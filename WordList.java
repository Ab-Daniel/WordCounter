public class WordList 
{
	public WordList()
	{
		wList = new ArrayList<Word>();
		
		class WordComparator implements Comparator<Word>
		{
			public int compare(Word first, Word second)
			{
				if(first.getWord().compareTo(second.getWord()) < 0)
					return -1;
				else if(first.getWord().compareTo(second.getWord()) > 0)
					return 1;
				return 0;
			}
		}
		comp = new WordComparator();
	}
	public ArrayList<Word> returnArray()
	{
		return wList;
	}
	public void add(Word word)
	{
		Word newW = trim(word);
		if(!newW.getWord().equals(""))
		{
			Word newWord = new Word(newW.getWord().toUpperCase());
			int k = Collections.binarySearch(wList, newWord, comp);
			if(k >= 0)
				wList.get(k).incrementCount();
			else
				wList.add((-k - 1), newWord);
		}
	}
	private Word trim(Word word)
	{
		String name = word.getWord();
		
		char test1 = name.charAt(0);
		if(PUNCTUTATIONS.contains(test1 + ""))
				name = name.substring(1, name.length());
		
		if(!name.equals(""))
		{
			char test2 = name.charAt(name.length() - 1);
			if(PUNCTUTATIONS.contains(test2 + ""))
				name = name.substring(0, name.length() - 1);
		}
			
		Word newWord = new Word(name);
		return newWord;
	}
	private ArrayList<Word> wList;
	private Comparator<Word> comp;
	private static final String PUNCTUTATIONS = ".,?;:!-_";
}
