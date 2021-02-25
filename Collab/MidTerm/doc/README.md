#READ ME PLEASE

If any issues rise up with the program, please contact Kali in the Data Structures discord for debugging. He wrote the program drunk...

This program WILL be updated over the semester and will be refined as well for runtime purposes. If you would like to clone the repo and pull every time something is updated, ask permission from a developer.

Running the file:
    -First you are going to be asked for the size of the array, type that in.
    -Second, it will be ask you for the array given. When prompted, enter each integer and press ENTER. Enter the next element and so on so forth.
    -Third, select which algorithm you specifically want

----- Explanation of the Algorithms---

- Quick Sort:
    - It will first give you the medians. The cutoff can be adjusted if needed, but it will need to be hard coded in. You can finaggle this varibale at the top on `line: 12: private static final int CUTOFF = 4;`. Change that to what you need the cutoff to be.
    Now the format for the printing may be weird, if it is, try enlarging your terminal (I use VS Code which has a decently large terminal space), then rerun the program while keeping the window large. This will make the spacing be less awkward and more understandable. READ LINE BY LINE... it will make sense.

- Merge Sort:
    - It will show you the process of it sorting, then print out all the sorts for the last few lines.

- Insertion Sort:
    - It was originally made for quicksort and quicksort only. Decided it was useful. Shows you the number of passes it does along with the swaps it does in that particular line. (Really useful honestly, kinda proud, made ego large to see it work.)

- Shell Sort:
    - Gotta give credit to my collab partner on this one, refined the code to allow users to type the number of passes the user wants.
    Next line will ask "Enter increments in decending order:" - at this line, enter from largest to smallest number (i.e 7 3 1).
    Prints out the intial array, then the amount of passes the user asked for, then the incremements of those passes. (Number of passes MUST EQUAL the number of incremementations wanted)

- Inversion Count:
    - Gives you the list of inversions that can happen within the given array. Also (thankfully) gives you the count of how many said inversions are the total. If you swap elements in the array, you can definitely notice a decent change.


I've already started working on heap (heapify), in which I hope it works... That should be coming out in the next version or so of this program.