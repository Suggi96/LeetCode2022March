class Solution {
public:
    string minRemoveToMakeValid(string s) {
        stack<pair<int, char>> st;
        int n = s.length();
       for(int i=0;i<n;i++) {
           if(s[i]==')' || s[i]=='(') {
               if(st.empty()) {
                   st.push({i, s[i]});
               }
               else if(s[i]==')' && st.top().second=='(') {
                   st.pop();
               }
               else {
                   st.push({i, s[i]});
               }
           }
       }
        set<int> hs;
        while(!st.empty()) {
            int index = st.top().first;
            hs.insert(index);
            st.pop();
        }
        string ans = "";
        for(int i=0;i<n;i++) {
            if(hs.find(i)==hs.end())
                ans += s[i];
        }
        return ans;
    } 
};