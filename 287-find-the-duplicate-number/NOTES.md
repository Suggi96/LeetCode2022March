floyd cycle detection method
1. slow = nums[0] fast = nums[0]
2. move slow by 1 position ie slow = nums[slow]
3. move fast by 2 positions ie fast = fast[nums[fast]]
4. do above ops in loop until slow!=fast.
5. when they meet loop break.
6. now reset slow to nums[0] ie slow = nums[0]
7. now run loop until slow!=fast and also move slow and fast by 1 position
8. whenever slow = fast the duplicate element is found
​