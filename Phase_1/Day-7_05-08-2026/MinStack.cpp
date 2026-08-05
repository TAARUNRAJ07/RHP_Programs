#include <vector>
#include <algorithm>
using namespace std;

class MinStack
{
public:
    vector<pair<int, int>> st;
    MinStack()
    {
    }

    void push(int value)
    {
        int minVal = value;
        if (!st.empty())
        {
            minVal = min(minVal, getMin());
        }
        st.push_back(make_pair(value, minVal));
    }

    void pop()
    {
        st.pop_back();
    }

    int top()
    {
        return st.back().first;
    }

    int getMin()
    {
        return st.back().second;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(value);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */