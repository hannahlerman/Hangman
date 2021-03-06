package hangman;

import list.Node;

public class LinkedListGameModel implements GameModel {
	
	private String word;
	private int state;
	private int counter;
	private Node board;
	private Node guesses;
	
	public LinkedListGameModel(String word) {
		state = 0;
		this.word = word;
		counter = 0;
		Node head = new Node('_');
		board = head;
		for(int i=1; i<word.length();i++){
			head.setNext(new Node('_'));
			head=head.getNext();
		}
	}

	/**
	 * Returns true if the character `guess` is a prior guess. That
	 * is, the character has been used in a prior guess. Returns
	 * false otherwise. This method assumes that `guess` is an
	 * uppercase or lowercase letter in A-Za-z.
	 */
	@Override
	public boolean isPriorGuess(char guess) {
		if(guesses==null){
			return false;
		}
		else{
		Node cur = guesses;
		while(cur!=null){
			if((char)cur.getValue()==guess){
				return true;
			}
			cur=cur.getNext();
		}
	 }
		return false;
	}

	/**
	 * Returns the number of guesses guessed so far. This should
	 * only be the number of non-repeated guesses.
	 */
	@Override
	public int numberOfGuesses() {
		// TODO
		return counter;
	}

	/**
	 * Returns true if the character is a correct guess in the
	 * word. A correct guess is a character that is in the word
	 * but has not been guessed yet. Returns false otherwise.
	 * This method assumes that `guess` is an uppercase or lowercase 
	 * letter in A-Za-z. 
	 */
	@Override
	public boolean isCorrectGuess(char guess) {
		for(int i=0; i<word.length(); i++){
			if(word.charAt(i)==guess){
				return true;
			}
		}
		return false;
	}

	/**
	 * doMove will play the character `guess` on the hangman
	 * game board if it is a character that has not already
	 * been guessed. It will replace each '_' on the game board
	 * that corresponds to a correct guess with the actual letter.
	 * 
	 * Returns true if the character was able to be placed on the
	 * game board and false if the letter was guessed previously.
	 * 
	 * To be more specific, it returns true if and only if the character 
	 * guessed revealed a hidden character in the word. Otherwise, 
	 * returns false:
	 * 
	 *	Example:
	 *  Hidden word: hello
	 *  Guess: e
	 *    returns true
	 *  Guess: e
	 *    returns false
	 *  Guess: f
	 *    returns false
	 *  Guess: l
	 *    returns true
	 *  Guess: l
	 *   returns false
	 *   
	 *  Any time the user guesses a character that is not in the 
	 *  hidden word (unless it has been previously guessed), 
	 *  the state of the board should increment.
	 *  
	 *  Example:
	 *  Hidden word: Zigzag
	 *   State: 0
	 *  Guess: g
	 *   State: 0
	 *  Guess: g
	 *   State 0
	 *  Guess: n
	 *   State: 1
	 *  Guess: n
	 *   State: 1
	 *  Guess: n
	 *   State: 1
	 *  Guess: z
	 *   State: 1
	 *  Guess: Z
	 *   State: 1
	 * 
	 * Any time the user guesses a character that was not previously guessed, 
	 * it should be appended to the list returned by previousGuessString().
	 * 
	 * Example:
	 * Hidden word: snow
	 *  Guess: u
	 *  previousGuessString(): [u]
	 *  Guess: u
	 *  previousGuessString(): [u]
	 *  Guess: n
	 *  previousGuessString(): [u, n]
	 *  Guess: n
	 *  previousGuessString(): [u, n]
	 *  Guess: s
	 *  previousGuessString(): [u, n, s]
	 *  
	 * Notice that the elements listed are in the order they were entered. 
	 * This means you will not be able to keep track of the guessed letters 
	 * using only an array of booleans; you must remember the order they 
	 * were guessed.
	 * 
	 * This method assumes that `guess` is an uppercase or lowercase 
	 * letter in A-Za-z.
	 */
	
	@Override
	public boolean doMove(char guess) {
		// TODO Auto-generated method stub
		if(isPriorGuess(guess)==true){
			return false;
		}
		Node temp=board;
		if(isCorrectGuess(guess)==true){
			int i=0;
			while(temp!=null){
				if(word.charAt(i)==guess)
					temp.setValue(guess);
					i++;
					temp=temp.getNext();
				}
				counter++;
				if(guesses==null){
					guesses = new Node(guess);
				}
				else{
					Node copy = guesses;
					while(copy.getNext()!=null){
						copy=copy.getNext();
					}
					Node correct = new Node(guess);
					copy.setNext(correct);
				}
				return true;
				}
		else
		{
			if(guesses==null){
				guesses = new Node(guess);
			}
			else{
				Node copy = guesses;
				while(copy.getNext()!=null){
					copy=copy.getNext();
				}
				Node correct = new Node(guess);
				copy.setNext(correct);
		}
		}
		counter++;
		state++;
		return false;
	}

	/**
	 * Returns true if the game board is in a winning state. That is,
	 * all the letters have been guessed correctly. Returns false
	 * otherwise.
	 */
	@Override
	public boolean inWinningState() {
		Node temp = board;
		while(temp!=null){
			if((char)temp.getValue()=='_')
				return false;
			temp=temp.getNext();
		}
		return true;
	}

	/**
	 * Returns true if the game board is in a losing state, that is, 
	 * the game board has reached its final state without all letters in the
	 * word having been guessed.
	 */
	@Override
	public boolean inLosingState() {
		if(state==10){
			return true;
		}
			return false;
	}

	/**
	 * Returns the current "hung state". The state of the game can be
	 * one of the following:
	 * 
	 *  0   : the starting state (see HangManConstants.STARTING_STATE.)
	 *  1-9 : each of the corresponding hang man states that you can be
	 *        in after each bad guess (see ConsoleGameOutput).
	 */
	@Override
	public int getState() {
		// TODO
		return state;
	}
	

	/**
	 * Returns a string representation of the previous guesses that have
	 * been made (without repeated guesses). Here is an example of a string
	 * with 9 guesses:
	 * 
	 *  [a, e, i, o, u, m, n, t, s]
	 *  
	 * Note: this will include both correct guesses and incorrect guesses.
	 * 
	 * The returned string must be in the order the characters were played.
	 * It is important that you have spaces after each ',' for the implementation 
	 * to be correct.
	 * 
	 * If no guesses have been made, this method should return a String
	 * consisting of an empty pair of square brackets ("[]"), with no
	 * spaces or commas.
	 */	
	@Override
	public String previousGuessString() {
		String current="[";
		Node head = guesses;
	    while(head.getNext()!=null){
	    	current=current+head.getValue()+", ";
	    	head=head.getNext();
	    }
		return current+head.getValue()+"]";
	}
	
	/**
	 * Returns a string representation of the board. For example, a word
	 * with 5 characters without any correct guesses will return the string:
	 * 
	 *  "_ _ _ _ _"
	 * 
	 * (With the " not being part of the string)
	 * 
	 *  A word with 6 characters with a correct guess of 'n', 'i', and 'r'
	 *  will return the string:
	 *  
	 *  "_ i n n _ r"
	 *  
	 *  Note that the strings must be in this exact format for the tests to
	 *  pass. It is important that you have spaces between each of the
	 *  letters and/or '_' for the implementation to be correct.
	 */	
	@Override
		public String toString(){
			String current="";
			Node head = board;
			while(head.getNext()!=null){
				current=current+head.getValue()+" ";
				head=head.getNext();
			}
			return current+head.getValue();
		}
	
	
	  /**
	 * Returns the word that the player is trying to guess.
	 */
	public String getWord() {
		// TODO
		return word;
	}
}
