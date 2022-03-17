houseRobber approach : we have two choices, robHouse or noRobHouse
maxMoney(0) => 0 is curindex
//base case
if(curIdx>n-1)
return 0;
robHouse = nums[curIdx] + maxMoney(curIdx+2)
noRobHouse = maxMoney(curIdx+1)
return max(robHouse, noRobHouse)
**Add memoisations using hashmap to make it dp solutions
curKey = curIndex
memo.put(curKey, (robHouse, noRobHouse))**