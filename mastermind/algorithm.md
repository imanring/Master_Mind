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


**clone**

Goals - return a copy of a Row object at a new reference because copies of object references are passed to methods instead copies of the object data in java.

Input - nothing.

Output - a copied row object at a new reference in memory.

Steps - create a new Row object with a copy of guess of the original.


**equals**

Goals - check if the data in the Row object is equal to the data in object that called this method. It will not check if the references are the same in memory.

Input - an object to be checked

Ouput - boolean that represents equality.

Steps - if the guesses of the two objects are the same return true.


**hashCode**

Goals - return a unique integer for each possible Row.

Input - the calling object.

Output - a unique integer representing the row.

Steps - turn the guess into a base 10 number.


## Game

**setKey**

Goals - randomly set a key.

Input - nothing

Ouput - a random key.

Steps - generate a random int for each index of key.


## Solver - inherits from Game

**setKeyValues**

Goals - set keyValues to a set of all posible keys when we have no information about the actual key.

Steps - do four loops each from 0 to 6 inclusive and set keyValues to the indices.

**Solve**

Goals - figure out a hidden key.

Input - scores from the guesses that the computer gives. These scores will be scoring the guesses against the actual score.

Output - It will print the guess and the scores.

Steps - loop until the keyValues has only one element in it. Each time randomly pick an from keyValues to score. Then remove all elements of keyValues that do not score the guess the same.


**recursiveSolve**

**shuffleSolve**

Goals - solve the key. This time, however, after 3 guesses the key will be shuffled. The values will stay the  same, but their positions will be shuffled.

Input - nothing.

Output - the guesses that the computer makes.

Steps - Solver the same way the regular solver does it, but this time add a counter and after 3 guesses call shuffleKey. Then update keyValues to have all possible permutations of the elements in keyValues currently. I will add the permutations using a method called permutations. 


**shuffleKey**

Goals - shuffle the key.

Input - nothing.

Output - nothing.

Steps - Randomly swap elements several times.


**Permutations**

Goals - find all the permutations of an array and add them to keyValues if it is not already in keyValues.

Input - the array to find the permutations of after an index (i). Also the length of the array will be passed.

Output - possibly new elements of keyValues.

Steps - recursively go through the permutations according the the figure provided by GeeksforGeeks each time swap an element in the array (sometimes swap with itself).

**swap** - swap two elements of the guess of a Row. The elements are given by parameters a and b.

## Player - inherits from Game

**Constructor**

Goals - initialize and set up the Jlabels that will represent the board.

Input - nothing

Output - nothing

Steps - loop through the Jlabels. Initialize each one, set the text for each one, and give it an empty border.

**GUIsetUp**

Goals - set the GUI up for the game

Input - nothing

Output - an ugly GUI

Steps - create a Jframe and add a border layout container to it. Add a grid container of buttons to the main container. Also add a grid container of Jlabels to the main container. Also add an actionListener to each button. Player will take care of the actionListener.

**ActionListener**

Goals - perform the correct actions for each button.

Input - which button was pushed

Output - If a color button was pressed change the color of the current Jlabel. If the submit button is pressed output the score.

Steps - When the submit button is pressed if it is ready to be submitted increase the currentRow index and set the Jlable index to 0. Then set the last Jlabel to the score. If a color button is pressed set the guess at currentRow and Jlabel index to an integer corresponding to the color. Increase the Jlable index or set it to 0 if the index would get too high. If the index is high enough set submittable to true.

## TwoPlayer - inherits from Player

**SetKey**

Goals - allow the user to set the key.

Input - The user will push color buttons to set the key.

Output - set the key for the game.

Steps - Use a similar set up to the GUIsetUp that Player had. I will have a row of buttons and a row of JLabels.

**actionPerformed**

Goals - set an number in the key or submit the key and move on to the solving part of the game that was already created in Player.java.

Input - an indication of which button was pressed.

Output - Change the color of a JLable and set part of the key or move on to the next part of the game.

Steps - this will be very similar to the actionPerformed in Player.java. It will have to have all of the code from actionPerformed and some for setting the key. The submit for setting the key will dispose of the current JFrame and call GUIsetUP from Player if indeed the key has been set.


**Node - will have getters and setters for it payload and single Node pointer**


## LinkedList - single linked list.

**append**
- iterate to the end of the linked list and set the next of the tail to the new Row.

**get(int n)**
- iterate in the linked list n times and then return the Row at that position. If the list is not that long return null.

**get(Row r)** 
- iterate through the linkedlist checking for equality with r. If one of the elements in the linked is equal to r return the position of that element, otherwise return -1.

**delete**
- iterate through the linkedlist keeping track of the current Row and the previous Row. When the current Row's index is equal to the input index, set previous' next to the next of current.

**size**
- iterate through the linkedlist. Return the number of iterations.

**clear**
- set head to null. This will hopefully delete the rest of the Nodes.
