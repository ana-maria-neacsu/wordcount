# 1 - Dominik

## Sample
Enter text: Mary had a little lamb
Number of words: 5

## Assumptions:
- the user always get the "Enter text:" label.
- will the user always type at least one word? 
    - no. if this is case, print 0.
- only count a-z,A-Z
- we assume that the input field is small enough to fit in the memory

## Sample inputs:
- Enter text: Mary had a little lamb - 5
- Enter text:  - 0
- Enter text: Mary had a little lamb# - 4

## Steps:
- create a test to validate the count
- implement the real code

# 2 - Berhnard

## Sample text file
the
a
on
off

## Sample input
$ wordcount
Enter text: Mary had a little lamb
Number of words: 4
$

## Assumptions
- The words in the file also follow the same patter of valid words.[a-z][A-Z]
- They must be identical / exact matches
- The file could possibly be empty
- The stopwords file will be provided to the user, and they should be able to replace it, without having to 
  regenerate the whole jar.
  
# 3 - Jakub

## Sample input
$ wordcount mytext.txt
Number of words: 4
$

### with my text being
Mary had
a little
lamb

## Assumptions
- The app should start with a file as the user input.
- The user should provide the file name as an arg.
- If no arg is provided, then the app request a manual input from the user.
- The user will always provide the file name as the first argument.
- THe user will provide the file name with the extension. (eg. input.txt)
