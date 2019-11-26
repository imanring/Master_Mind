## Row

**ScoreGuess**

Goals - score the guess given the key parameter.
Input - An arrayList of length four, representing the key to score the guess by.
Output - A string representing the score. A 'b' will be add for every peg in the guess that is right in the right spot. A 'w' will be added for every peg in the guess that is right in the wrong spot. For further explaination, see the game rules that I provided in the project proposal.
Steps - I will have arraylists (called usedWhite and usedBlack) of arrays of length two that represent the positions in the key and guess that gained a specific score. I will have one for black score and one for white score. 
I will use nested loops to compare each element of the key to each element guess. If elements from the key and guess have the same value and the same positions add an array of the positions to usedBlack. If the elements from the key and guess have the same value but the positions are not equal, add an array of the positions ([index of value from key, index of value from guess]).
Once I have usedBlack and usedWhite, I will concatinate usedWhite to the end of usedBlack to make a new arraylist called used. I will then remove the elements from the later part of used that share key index or guess index with an earlier element in the arraylist. This will be done in a method called removeDuplicate.
I will create a string that will represent the score. I will add a 'b' to the score for every element in used that is the same as one in usedBlack and a 'w' for every element in used that is the same as one in usedWhite.

For example, suppose the key is [1,3,1,4] and the guess is [3,1,3,4]. usedBlack should be [[3,3]] because of the 4 in the guess and key. usedWhite should be [[0,1],[1,0],[1,2],[2,1]]. The first array in usedWhite is from the 1s, the next 2 are from the 3s, and the last array is from the 1s again. used will then be [[3,3],[0,1],[1,0],[1,2],[2,1]]. After removeDuplicate is called used will be [[3,3],[0,1],[1,0]]. The score will be "bww".

**removeDuplicate**

Goals - this method is only used by the method score and its goal is described in the documentation for score.

Input - an arraylist of length 2 arrays (used).

Output - an arraylist that is shortened.

Steps - using the sentry variable i loop from 0 to the length of used minus one (I could go til the length of used but it is not necessary). Inside that loop go from i+1 (so as not to do unnecessary checks) to the length of used. If the key indices or the guess indicies of the two elements in used under consideration are the same remove the later element.


## Game

**setKey**

Goals - randomly set a key.

Input - nothing

Ouput - a random key.

Steps - generate a random int for each index of key.


## Solver

**setKeyValues**
