#include <iostream>
#include <vector>
#include <algorithm>

#define ll long long int
#define INF 2e9

using namespace std;

// Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *rotateRight(ListNode *head, int k)
    {
        int n = 0;
        ListNode *root = head, *tail;
        while (root)
        {
            tail = root;
            root = root->next;
            n++;
        }
        if (n == 0)
        {
            return nullptr;
        }
        k = k % n;
        if (k == 0)
        {
            return head;
        }
        int d = n - k;
        ListNode *newHead = head, *x;
        while (d--)
        {
            x = newHead;
            newHead = newHead->next;
        }
        tail->next = head;
        x->next = nullptr;
        return newHead;
    }
};

void solve()
{
    ListNode *head = nullptr, *newNode;
    int n, val;
    cin >> n;
    cin >> val;
    head = new ListNode(val);
    n--;
    while (n--)
    {
        cin >> val;
        newNode = new ListNode(val);
        head->next = newNode;
    }
    int k;
    cin >> k;
    Solution obj;
    ListNode *result = obj.rotateRight(head, k);

    while (result)
    {
        cout << result->val;
        result = result->next;
    }
    return;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--)
    {
        solve();
    }
}