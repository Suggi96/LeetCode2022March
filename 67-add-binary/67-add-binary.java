class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        String res = new String();
        int carry = 0;
        while(i>=0 || j>=0) {
            int sum = carry;
            if(i>=0) {
                sum += a.charAt(i--) - '0';
            }
            if(j>=0) {
                sum += b.charAt(j--) - '0';
            }
            carry = sum > 1 ? 1 : 0;
            res = String.valueOf(sum%2) + res;
        }
        if(carry!=0) 
            res = String.valueOf(carry) + res;
        
        return res;
    }
}