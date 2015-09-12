class Node {
    boolean v = false
    String n
    Node c
}

def nf = new Node(n:'f')
def ne = new Node(n:'e')
def nd = new Node(n:'d')
def nc = new Node(n:'c')
def nb = new Node(n:'b')
def na = new Node(n:'a')

def root = na
na.c = na
//nb.c = na
//nc.c = nd
//nd.c = ne
//ne.c = nf
//nf.c = nc

def hasCycle(node) {
    if (!node) return false
    if (node.v) {
        node.v = false
        return node
    }
    node.v = true
    hasCycle(node.c)
}

def printPathR(node) {
    if (!node.v) {
        return ""
    }
    return node.n + printPathR(node.c)
}

def printPath(node) {
    while (node?.v) {
        node = node.c
    } 
    def cycle = node?.n
    node = node?.c
    while (node?.v) {
        cycle += node.n
        node = node.c
    }
    println "path: $cycle"
}

def node = hasCycle(root)
printPath(root)
def cycle = 
    node?.n + 
    printPathR(node?.c)
println cycle