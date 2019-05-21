public class Word 
{
	public Word(String word)
	{
		this.word = word;
		count = 1;
	}
	public String getWord()
	{
		return word;
	}
	public int getCount()
	{
		return count;
	}
	public void incrementCount()
	{
		count++;
	}
	public String toString()
	{
		int dotNum = NUM_OF_CHARS - (word.length() + (count + "").length());
		String dots = "";
		for(int i = 0; i < dotNum; i++)
			dots += ".";
		return word + dots + count;
	}
	private String word;
	private int count;
	private static final int NUM_OF_CHARS = 16;
}
