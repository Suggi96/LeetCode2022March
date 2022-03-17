class Solution {
public:
    int scoreOfParentheses(string s) {
        stack<string> st;
        for(int i=0;i<s.length();i++) {
            char c = s[i];
            if(st.empty()) {
                string t;
                t+=c;
                st.push(t);
            }
            else {
                if(c==')') {
                    int curScore = 0;
                    while(!st.empty() && st.top()!="(") {
                        curScore += stoi(st.top());
                        st.pop();
                    }
                    st.pop();
                    if(curScore==0)
                        st.push("1");
                    else 
                        st.push(to_string(2*curScore));
                }
                else {
                    string t;
                    t+=c;
                    st.push(t);
                } 
            }
        }
        int score = 0;
        while(!st.empty()) {
            score += stoi(st.top());
            st.pop();
        }
        return score;
    } 
};