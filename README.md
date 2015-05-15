# Spell Checker


The second invidual project for CS3345(Data Structures and Introduction to Algorithmic Analysis).

This project implemented a Trie data structure that would act as a spell checker. It performs intsertions, deletions and checks to see if the word is spelled corrected against current words in the Trie. 

The program was created with the specifications required by the instructor so it will not function without the proper commands and structure. It also does not perform input validation, so invalid input will cause the program to crash/break(See below for examples of proper input).

```
Command | Arguments | What Happens
---------------------------------------------------------------------------------------------------
N       |           | Print your name followed by a newline.
A       | Word      | Insert the word.
        |           | Print one of the strings "Word inserted" or "Word already exists"
D       | Word      | Delete a word.
        |           | Print "Word deleted" or "Word not present" followed by a newline.
S       | Word      | Search for word.
        |           | Print "Word found" or "Word not found" followed by a newline.
M       |           | Print "Membership is ####" where #### is the number of words in the Trie
C       | wa wb wc..| Check the space separated sequence of words wa, wb, wc, ... till end of line
        |           | and list any that are not present, one per line, 
        |           | each preceded by the phrase "Spelling mistake".
L       |           | Print a list of the elements of the Trie in alphabetical order, one word per line.
E       |           | The end of the input file.
```
Here is a sample input/output:
```
Sample Input                     Sample Output
------------                    -----------------
N                                 Jacob Evans
A ant                             Word inserted
A goat                            Word inserted
A frog                            Word inserted
A art                             Word inserted
A goad                            Word inserted
A antler                          Word inserted
A go                              Word inserted
A from                            Word inserted
A part                            Word inserted
A past                            Word inserted
A arts                            Word inserted
A part                            Word already exists
A frond                           Word inserted
A fries                           Word inserted
A text                            Word inserted
A message                         Word inserted
A mess                            Word inserted
A mean                            Word inserted
A goal                            Word inserted
A interpretation                  Word inserted
A coat                            Word inserted
M                                 Membership is 20
D art                             Word deleted
D art                             Word not present
D mess                            Word deleted
S art                             Word not found
M                                 Membership is 18
S antler                          Word found
S part                            Word found
S text                            Word found
S freis                           Word not found
C pert post past text             Spelling mistake pert
C coat frond interpretacion       Spelling mistake post
C anteler massage cat mouse goal  Spelling mistake interpretacion
L                                 Spelling mistake anteler
E                                 Spelling mistake massage
                                  Spelling mistake cat
                                  Spelling mistake mouse
                                  ant
                                  antler
                                  arts
                                  coat
                                  fries
                                  frog
                                  from
                                  frond
                                  go
                                  goad
                                  goal
                                  goat
                                  interpretation
                                  mean
                                  message
                                  part
                                  past
                                  text
```
