package code;

public class EncryptOrDecrypt {
	
	// VARIABLE DECLARATION

	private char[] sentenceKey;
	private char[] codedSentence;
	private char[] charSentence;
	private int charFromSentence;
	private int charFromSentenceKey;
	private int numberOfCharInAlfabet;
	private int codedSymbol;
	private String encryptedSentence;

	// GETTERS AND SETTERS
	
	public char[] getSentenceKey() {
		return sentenceKey;
	}

	public void setSentenceKey(char[] sentenceKey) {
		this.sentenceKey = sentenceKey;
	}
	
	public char[] getCodedSentence() {
		return codedSentence;
	}


	public void setCodedSentence(char[] codedSentence) {
		this.codedSentence = codedSentence;
	}


	public char[] getCharSentence() {
		return charSentence;
	}


	public void setCharSentence(char[] charSentence) {
		this.charSentence = charSentence;
	}


	public int getCharFromSentence() {
		return charFromSentence;
	}


	public void setCharFromSentence(int charFromSentence) {
		this.charFromSentence = charFromSentence;
	}


	public int getCharFromSentenceKey() {
		return charFromSentenceKey;
	}


	public void setCharFromSentenceKey(int charFromSentenceKey) {
		this.charFromSentenceKey = charFromSentenceKey;
	}


	public int getNumberOfCharInAlfabet() {
		return numberOfCharInAlfabet;
	}


	public void setNumberOfCharInAlfabet(int numberOfCharInAlfabet) {
		this.numberOfCharInAlfabet = numberOfCharInAlfabet;
	}


	public int getCodedSymbol() {
		return codedSymbol;
	}


	public void setCodedSymbol(int codedSymbol) {
		this.codedSymbol = codedSymbol;
	}


	public String getEncryptedSentence() {
		return encryptedSentence;
	}


	public void setEncryptedSentence(String encryptedSentence) {
		this.encryptedSentence = encryptedSentence;
	}
	
	// MAIN METHOD THAT IS CODING OR DECODING OUR MESSAGE
	
	public String vigenereOperation(String sentence, String key) {
		
		TransformCode transformCode = new TransformCode();
		setCodedSentence(new char[sentence.length()]);
		setCharSentence(sentence.toCharArray()); 
		setSentenceKey(transformCode.transformSentence(sentence, key));
		
		for(int i = 0; i < sentence.length(); i++) {
			
			if(getSentenceKey()[i]!=' ') {
				setCharFromSentence((int) getCharSentence()[i]-97);
				setCharFromSentenceKey((int) getSentenceKey()[i]-97);
				setNumberOfCharInAlfabet(26);
				setCodedSymbol((getCharFromSentence() + getCharFromSentenceKey())%getNumberOfCharInAlfabet()+97);
				getCodedSentence()[i]=(char)getCodedSymbol();
			}
			else getCodedSentence()[i]=' ';
		}
		setEncryptedSentence(String.valueOf(getCodedSentence()));
		return getEncryptedSentence();
	}






	
}

