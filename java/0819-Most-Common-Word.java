/*

Problem Statement:

Given a paragraph and a list of banned words, return the most frequent word that is not
in the list of banned words.  It is guaranteed there is at least one word that isn't 
banned, and that the answer is unique.
Words in the list of banned words are given in lowercase, and free of punctuation.  Words 
in the paragraph are not case sensitive.  The answer is in lowercase.

Example:

    Input: 

    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]

    Output: "ball"

    Explanation: 
    "hit" occurs 3 times, but it is a banned word.
    "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
    Note that words in the paragraph are not case sensitive,
    that punctuation is ignored (even if adjacent to words, such as "ball,"), 
    and that "hit" isn't the answer even though it occurs more because it is banned.

*/

/*

Thought Process:

We put banned words in a hashset for an easy and fast way to check if a word is banned.
Then, we split the phrase by "[^A-Za-z]" to get individual words without punctuation.
Create a hashmap to store the word and its occurrance, only when it is not banned.
Lastly, traverse through the hashmap to get the most common word.

*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        for(String s : banned){
            bannedSet.add(s);
        }

        String[] words = paragraph.split("[^A-Za-z]+");

        HashMap<String, Integer> freq = new HashMap<>();

        for(String word : words){
            word = word.toLowerCase();
            if(!bannedSet.contains(word)){
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        int highestFreq = 0;
        String mostCommon = "";
        for(String word : freq.keySet()){
            if(freq.get(word) > highestFreq){
                highestFreq = freq.get(word);
                mostCommon = word;
            }
        }
        return mostCommon;
    }
}

/*

Final thoughts:

n = length of paragraph

Time complexity: O(n)
Space complexity: O(n)

*/