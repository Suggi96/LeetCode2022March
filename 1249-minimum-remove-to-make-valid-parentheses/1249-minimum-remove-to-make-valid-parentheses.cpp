class Solution {
public:
    string minRemoveToMakeValid(string s) {
        stack<pair<char, int>> st;
        string ans = "";
        int n = s.size();
        for(int i=0;i<n;i++) {
            if(s[i]=='(' || s[i]== ')') {
                if(st.empty()) {
                    st.push({s[i], i});
                }
                else if(s[i]==')' && st.top().first=='(') {
                    st.pop();
                } 
                else {
                    st.push({s[i], i});
                }  
            }
        }
        set<int> hs;
        while(!st.empty()) {
            int ind = st.top().second;
            st.pop();
            hs.insert(ind);
        }
        for(int i=0;i<n;i++) {
            if(hs.find(i)==hs.end()) {
                ans += s[i];
            }
        }
        return ans;
    }
};