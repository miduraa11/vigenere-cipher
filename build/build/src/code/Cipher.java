package code;

public class Cipher {
	
	// VARIABLE DECLARATION

	private String encryptedSentence;
	private String reversedKey;
	private String error;

	// GETTERS AND SETTERS
	
	public String getEncryptedSentence() {
		return encryptedSentence;
	}

	public void setEncryptedSentence(String encryptedSentence) {
		this.encryptedSentence = encryptedSentence;
	}
	
	public String getReversedKey() {
		return reversedKey;
	}

	public void setReversedKey(String reversedKey) {
		this.reversedKey = reversedKey;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	// METHOD THAT START CODE OR DECODE OUR SENTENCE DEPENDING ON WHAT OPTION WE CHOOSE
	
	public String runApplication(String sentence, String key, int checkBox) {
		
		EncryptOrDecrypt encryptVigenere = new EncryptOrDecrypt();
		TransformCode transformCode = new TransformCode();
		
		if(checkBox == 1) {
			setEncryptedSentence(encryptVigenere.vigenereOperation(sentence, key));
			return getEncryptedSentence();
		}
		else if(checkBox == 2) {
			setReversedKey(transformCode.transformKey(key));
			setEncryptedSentence(encryptVigenere.vigenereOperation(sentence, getReversedKey()));
			return getEncryptedSentence();
		}
		else {
				setError("Wybierz opcje!");
				return getError();
		}
	}






		

	
}
