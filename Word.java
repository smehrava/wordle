import java.util.LinkedList;

public class Word {

    private LinearNode<Letter> firstLetter = null;
    public Word(Letter[] letters){
        LinearNode<Letter> front = null;
        LinearNode<Letter> node;
        for(int i = letters.length -1; i >= 0; i--) {
            node = new LinearNode<Letter>(letters[i]);
            node.setNext(front);
            front = node;
            if(i == 0) {
                firstLetter = node;
            }
        }
    }
    private boolean contains(LinearNode<Letter> letter){
        LinearNode<Letter> currentNode = firstLetter;
        while(currentNode != null){
            if(letter.getElement().equals(currentNode.getElement())){
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }
    public String toString(){
        String str = "Word: ";
        LinearNode<Letter> currentNode = firstLetter;
        int count = 0;
        LinearNode<Letter> temp = currentNode;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        for (int i =1; i <= count; i++) {
            str = str + currentNode.getElement().toString() + " ";
            currentNode = currentNode.getNext();
        }
        return str;
    }

    public boolean labelWord(Word mystery){
        LinearNode<Letter> otherNode = mystery.firstLetter;
        LinearNode<Letter> thisNode = this.firstLetter;
        boolean isEqual = true;
        while(thisNode != null && otherNode != null){
            if(thisNode.getElement().equals(otherNode.getElement())){
                thisNode.getElement().setCorrect();
            } else {
                if (mystery.contains(thisNode)) {
                    thisNode.getElement().setUsed();
                    isEqual = false;
                }else{
                    thisNode.getElement().setUnused();
                    isEqual = false;
                }
            }
            thisNode = thisNode.getNext();
            otherNode = otherNode.getNext();
        }
        while (thisNode != null && otherNode == null) {
            if(mystery.contains(thisNode)) {
                thisNode.getElement().setUsed();
                isEqual = false;
            }else{
                thisNode.getElement().setUnused();
                isEqual = false;
            }
            thisNode = thisNode.getNext();
        }
        return isEqual;
    }
}


