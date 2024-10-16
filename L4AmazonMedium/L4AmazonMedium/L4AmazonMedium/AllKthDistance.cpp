#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node *left;
    Node *right;

    Node(int item) : data(item), left(nullptr), right(nullptr) {}
};

class KthDistances
{
public:
    static void printKdistanceNodeDown(Node *root, int k)
    {
        if (root == nullptr || k < 0)
        {
            return;
        }
        if (k == 0)
        {
            cout << root->data << " ";
            return;
        }
        printKdistanceNodeDown(root->left, k - 1);
        printKdistanceNodeDown(root->right, k - 1);
    }

    static int printKdistanceNode(Node *root, Node *target, int k)
    {
        if (root == nullptr)
        {
            return -1;
        }

        if (root == target)
        {
            printKdistanceNodeDown(root, k);
            return 0;
        }

        int dl = printKdistanceNode(root->left, target, k);
        if (dl != -1)
        {
            if (dl == k - 1)
            {
                cout << root->data << " ";
            }
            else
            {
                printKdistanceNodeDown(root->right, k - dl - 1);
            }
            return dl + 1;
        }

        int dr = printKdistanceNode(root->right, target, k);
        if (dr != -1)
        {
            if (dr == k - 1)
            {
                cout << root->data << " ";
            }
            else
            {
                printKdistanceNodeDown(root->left, k - dr - 1);
            }
            return dr + 1;
        }

        return -1; // Target not found in this subtree
    }

    static void main()
    {
        // Create a sample binary tree
        Node *root = new Node(3);
        root->left = new Node(5);
        root->right = new Node(1);
        root->left->left = new Node(6);
        root->left->right = new Node(2);
        root->right->left = new Node(7);
        root->right->right = new Node(4);
        root->left->right->left = new Node(0);
        root->left->right->right = new Node(8);

        // Find nodes at distance k from a given target node
        Node *target = root->left; // Example target node
        int k = 2;

        cout << "Nodes at distance " << k << " from target node:" << endl;

        // Call the function to find and print nodes at distance k
        printKdistanceNode(root, target, k);

        cout << endl; // New line for clarity
    }
};

int main()
{
    KthDistances::main();
    return 0;
}
