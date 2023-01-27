public class WordList {
    String[] words;
    int count;
  
    public WordList() {
        words = new String[]{"",""};
        count = 0;
    }

    public int findWord(String w) {
        for(int i=0; i<this.words.length; i++){
            if(words[i].equals(w)){
                return i;
            }
        }
        return -1; 
    }
  
    public int addWord(String w) {
        Boolean isFull = true;
        for(int i=0; i<this.words.length; i++){
            if(words[i]==""){
                isFull = false;
            }
        }
        if(isFull){
            String[] newArr = new String[this.words.length*2];
            for(int a=0; a<newArr.length; a++){
                newArr[a] = "";
            }
            for(int j=0; j<this.words.length; j++){
                    newArr[j] = this.words[j];
            }
            this.words = newArr;
        }
        if(this.findWord(w)==-1){
            for(int k=0; k<this.words.length; k++){
                if(this.words[k]==""){
                    this.words[k] = w;
                    this.count++;
                    return this.words.length;
                }
            }
        }
        return this.words.length;
    }
  
    public void removeWord(String w) {
        int index = findWord(w);
        if(index!=-1){
            for(int i=index; i<this.words.length-1; i++){
                this.words[i] = this.words[i+1];
            }
            this.count--;
        }
    }

    public boolean equals(WordList other) {
        if (words.length != other.count) {
          return false;
        } else {
          for (int i = 0; i < words.length; i++) {
            if (words[i] != other.words[i]) {
              return false;
            }
          }
        }
        return true;
      }
    
    public String toString() {
    String s = "There are " + count + " word" + ((words.length == 1)?"":"s") + " in the word list:\n";
    for (String w : words) {
        s = s + w + "\n";
    }
    return s;
    }

    public static void main(String[] args) {
    WordList wl = new WordList();
    wl.addWord("Dog");
    System.out.print(wl);
    wl.addWord("Dog");
    System.out.print(wl);
    wl.removeWord("Dog");
    wl.addWord("Cat");
    wl.addWord("Fish");
    wl.addWord("Horse");
    System.out.print(wl);
    if (wl.findWord("Cat") >= 0)
        System.out.println("Cat is in the word list");
    if (wl.findWord("Dog") >= 0)
        System.out.println("Dog is in the word list");
    WordList myList = new WordList();
    myList.addWord("Cat");
    myList.addWord("Horse");
    myList.addWord("Fish");
    if (wl.equals(myList))
        System.out.println("The two lists are the same");
    }
}

    