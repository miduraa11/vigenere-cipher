package code;


public class TransformCode extends EncryptOrDecrypt  {
	
	// VARIABLE DECLARATION
	
	private char[] charKey;
	private char[] transformedSentence;
	private char[] transformedKey;
	private int keyNumber;
	private int charFromKey;
	private String reversedKey;
	
	// GETTERS AND SETTERS
	
	public char[] getCharKey() {
		return charKey;
	}

	public void setCharKey(char[] charKey) {
		this.charKey = charKey;
	}

	public char[] getTransformedSentence() {
		return transformedSentence;
	}

	public void setTransformedSentence(char[] transformedSentence) {
		this.transformedSentence = transformedSentence;
	}

	public char[] getTransformedKey() {
		return transformedKey;
	}

	public void setTransformedKey(char[] transformedKey) {
		this.transformedKey = transformedKey;
	}

	public int getKeyNumber() {
		return keyNumber;
	}

	public void setKeyNumber(int keyNumber) {
		this.keyNumber = keyNumber;
	}

	public int getCharFromKey() {
		return charFromKey;
	}

	public void setCharFromKey(int charFromKey) {
		this.charFromKey = charFromKey;
	}

	public String getReversedKey() {
		return reversedKey;
	}

	public void setReversedKey(String reversedKey) {
		this.reversedKey = reversedKey;
	}
	
	// METHOD RETURNS A SENTENCE THAT IS COMPOSED OF A KEY
	
	public char[] transformSentence(String sentence, String key) {
		
		setCharSentence(sentence.toCharArray()); 
		setCharKey(key.toCharArray());
		setTransformedSentence(new char[sentence.length()]);
		
		setKeyNumber(0); 
		
		for(int i = 0; sentence.length() > i; i++ ) {
			if(getKeyNumber() + 1 > key.length() && getCharSentence()[i]!=' ') { 
				setKeyNumber(0);
				getTransformedSentence()[i]=getCharKey()[getKeyNumber()];
				setKeyNumber(getKeyNumber() + 1);
			}
			else if(getCharSentence()[i]==' ') {
				getTransformedSentence()[i]=' ';
			}
			else {
				getTransformedSentence()[i]=getCharKey()[getKeyNumber()];
				setKeyNumber(getKeyNumber() + 1);
			}
			
		}
		return getTransformedSentence();
	}
	
	// METHOD RETURND TRANSFORMED KEY WHICH IS NEEDED TO DECODE OUR MESSAGE
	
	public String transformKey(String key) {
		
		setCharKey(key.toCharArray());
		setTransformedKey(new char[key.length()]);
		for(int i = 0; i < key.length(); i++) {
			setCharFromKey((int) getCharKey()[i]-97);
			setNumberOfCharInAlfabet(26);
			setCodedSymbol((getNumberOfCharInAlfabet() - getCharFromKey())%getNumberOfCharInAlfabet()+97);
			getTransformedKey()[i]=(char)getCodedSymbol();
		}
		setReversedKey(String.valueOf(getTransformedKey()));
		return getReversedKey();
	}




}

