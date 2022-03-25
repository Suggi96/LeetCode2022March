//nth catlan number approach
![](https://wikimedia.org/api/rest_v1/media/math/render/svg/e7129009cd8ec8d4715d8bfdeeaa5d4bfb7dafa1)
​
C2 = C0C1 + C1C0 //START FROM CO AND CN-1 GRADUALLY INCREMENT FIRST
SUBSCRIPT AND DECREMENT SECOND SUBSCRIPT
C3 = C0C2 + C1C1 + C2C0 //3 MEANS 3 SUM TERMS ON RHS
C4 = C0C3 + C1C2 + C2C1 + C3CO //4 MEANS 4 SUM TERMS ON RHS
​
​
base case
when n==0 or n==1 return 1 as **c0=1 and c1=1**
​
our goal is to find total ways.
initialise ways = 0
run for loop from i = 0 to n
ways = ways + fn(i) * fn(n-i-1)
return ways