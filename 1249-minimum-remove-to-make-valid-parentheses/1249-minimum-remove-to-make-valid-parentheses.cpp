class Solution {
public:
    string minRemoveToMakeValid(string s) {
        //left to right match ( with )
        //right to left match ) with ( 
        //maintain counter and mark extra parenthesis with # to delete
        int counter = 0;
        int n = s.length();
        for(int i=0;i<n;i++) {
            if(s[i]=='(')
                counter++;
            else if(s[i]==')') {
                if(counter>0) {
                    counter--;
                }
                else {
                    s[i] = '#'; //extra ) is found
                }
            }
        }
        counter = 0;
        for(int i=n-1;i>=0;i--) {
            if(s[i]==')')
                counter++;
            else if(s[i]=='(') {
                if(counter>0) {
                    counter--;
                }
                else {
                    s[i] = '#'; //extra ( is found;
                }
            }
        }
        string ans = "";
        for(int i=0;i<n;i++) {
            if(s[i]!='#')
                ans+=s[i];
        }
        return ans;
        
    } 
};