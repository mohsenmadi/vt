class Node {
    String n
    Node l
    Node r
}

def l = new Node(n:'r1 ', 
                 l:new Node(n:'b2 '), 
                 r:new Node(n:'b3 ', 
                            l:new Node(n:'r4 '), 
                            r:new Node(n:'r5 ', 
                                       r:new Node(n:'r6 ',
                                                  l:new Node(n:'b7 '),
                                                  r:new Node(n:'r8 ')))))
def r = new Node(n:'r9 ', 
                 l:new Node(n:'r10 '), 
                 r:new Node(n:'b11 '))

def root = new Node(n:"r0 ", l:l, r:r)

def pt(node) {
    if (node == null) return
    print "$node.n"
    pt(node.l)
    pt(node.r)
}

def tt(node) {
    if (node == null) return

    if (node?.l?.n?.startsWith(node.n[0])) {
        tt(node?.l)
    } else {
        node?.l?.r?.r = null
    }
    
    if (node?.r?.n?.startsWith(node.n[0])) {
        tt(node?.r)
    } else {
        node?.r?.r?.r = null
    }
}

def ct(node) {
    if (node == null) return
    if (node?.l) {
        node.l.t = node.n + node.t
    }
    if (node?.r) {
        node.r.t = node.n + node.t
    }
    ct(node.l)
    ct(node.r)
}

def jpt(node) {
    if (node == null) return
    println "$node.n :: $node.t"
    jpt(node.l)
    jpt(node.r)
}

pt(root)
println ""
tt(root)
pt(root)
jpt(root)