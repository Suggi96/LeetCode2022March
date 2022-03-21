1. create lastSeen[] array which stores last seen index of each char in the string s
2. Use two pointer start and end , set them 0 initially
3. run for loop from i = 0 to n
4. update end as Math.max(end, lastSeen(i))
5. This way end is always set to correct position so all repeating chars come in the range of start to end only.
6. when i == end. we reached endpoint of partition.  we can calculate length by end-start+1 and store it result array
7. update start = i + 1 for processing next words. so start is set to first char in upcoming spilts
​