#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
        if (!headA || !headB) return nullptr;

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Align the start of both lists
        while (lenA > lenB) {
            headA = headA->next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB->next;
            lenB--;
        }

        // Traverse both lists to find the intersection point
        while (headA != headB) {
            headA = headA->next;
            headB = headB->next;
        }

        return headA; // or headB, since they are equal at this point
    }

private:
    int getLength(ListNode* node) {
        int length = 0;
        while (node) {
            length++;
            node = node->next;
        }
        return length;
    }
};

int main() {
    // Example to test
    ListNode* common = new ListNode(8);
    common->next = new ListNode(10);

    ListNode* headA = new ListNode(4);
    headA->next = new ListNode(1);
    headA->next->next = common;

    ListNode* headB = new ListNode(5);
    headB->next = new ListNode(6);
    headB->next->next = new ListNode(1);
    headB->next->next->next = common;

    Solution solution;
    ListNode* intersection = solution.getIntersectionNode(headA, headB);
    if (intersection) {
        cout << "Intersection at node with value: " << intersection->val << endl;
    } else {
        cout << "No intersection." << endl;
    }

    return 0;
}
