class Solution {
public:
    bool isSubsequence(string s, string t) {
        // if(t.size()==0)
        //     return false;
        if(s.size()==0 && t.size()==0)
            return true;
        int j = 0;
        for(int i=0;i<t.size();i++) {
            if(s[j]==t[i]) {
                j++;
            }
        }
        if(j==s.size())
            return true;
        return false;
    }
};