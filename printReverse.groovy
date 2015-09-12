class Node {
    String n
    Node c
}

def nd = new Node(n:'d')
def nc = new Node(n:'c')
def nb = new Node(n:'b')
def na = new Node(n:'a')

def root = na
na.c = nb
nb.c = nc
nc.c = nd

def printPathR(node) {
    if (!node) {
        return ""
    }
    return node.n + printPathR(node.c)
}

def rg(node) {
    if (!node || !node.c) return node
    def reverse = rg(node.c)
    node.c.c = node
    node.c = null
    return reverse
    
//    def nextNode = node.c
//    node.c = null;
//    def reverseRest = rg(nextNode)
//    nextNode.c = node
//    return reverseRest
}

printPathR(root)
root = rg(root)
println root.c.n
printPathR(root)