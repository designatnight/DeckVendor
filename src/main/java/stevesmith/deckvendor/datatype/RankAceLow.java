package stevesmith.deckvendor.datatype;

public enum RankAceLow implements RankInterface{
	ACE("A", "Ace"), 
	TWO("2", "Two"), 
	THREE("3", "Three"), 
	FOUR("4", "Four"), 
	FIVE("5", "Five"), 
	SIX("6", "Six"), 
	SEVEN("7", "Seven"), 
	EIGHT("8", "Eight"), 
	NINE("9","Nine"), 
	TEN("10", "Ten"), 
	JACK("J", "Jack"), 
	QUEEN("Q", "Queen"), 
	KING("K", "King");

	private String shortName;
	private String fullName;

	private RankAceLow(String shortName, String fullName) {
		this.shortName = shortName;
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public String getFullName() {
		return fullName;
	}

}
