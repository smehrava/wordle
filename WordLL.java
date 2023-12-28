public class WordLL {
    private Word mysteryWord;
    private LinearNode<Word> history;

    public WordLL(Word mystery){
        history = null;
        this.mysteryWord = mystery;
    }

    public boolean tryWord(Word guess){
        boolean myTrue = guess.labelWord(mysteryWord);
        LinearNode guessNode = new LinearNode<Word>(guess);
        guessNode.setNext(history);
        history = guessNode;
        return myTrue;
    }
    public String toString(){
        LinearNode<Word> current = history;
        String str = "";
        while(current != null){
            str += current.getElement().toString() + "\n";
            current = current.getNext();
        }
        return str;
    }
}

