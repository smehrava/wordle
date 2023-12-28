public class Letter {
    private char letter;
    private int label;
    private int UNSET = -1;
    private int UNUSED = 0;
    private int USED = 1;
    private int CORRECT = 2;
    public Letter(char c){
        label = UNSET;
        letter = c;
    }
    public boolean equals(Object otherObject) {
        boolean myEquals = false;
        if (!(otherObject instanceof Letter)) {
            myEquals = false;}
        else{
        if (this.letter == ((Letter) otherObject).letter) {
                myEquals = true;
            }
        }
        return myEquals;
    }
    public String decorator(){

        if (label == USED){ return "+";}
        if (label == UNUSED){ return "-";}
        if (label == CORRECT){return "!";}
        else {return " ";}
    }
    public String toString() {
        return (decorator()+letter+decorator());
    }
    public void setUnused(){
        label = UNUSED;}
    public void setUsed(){
        label = USED;
    }
    public void setCorrect(){
        label = CORRECT;
    }
    public boolean isUnused(){
        if(label == UNUSED){
          return true;
        }
        else{return false;}
    }
    public static Letter[] fromString(String S){
        Letter[] array = new Letter[S.length()];
        for(int i = 0; i <S.length(); i++){
            array[i] = new Letter(S.charAt(i));
        }
        return array;
    }
}
