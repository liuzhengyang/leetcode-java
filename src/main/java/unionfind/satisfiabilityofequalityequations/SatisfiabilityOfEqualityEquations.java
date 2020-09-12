package unionfind.satisfiabilityofequalityequations;

import common.datastructure.UnionFind;

/**
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * @author liuzhengyang
 */
public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations satisfiabilityOfEqualityEquations = new SatisfiabilityOfEqualityEquations();
        System.out.println(satisfiabilityOfEqualityEquations.equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(satisfiabilityOfEqualityEquations.equationsPossible(new String[]{"b==a","a==b"}));
        System.out.println(satisfiabilityOfEqualityEquations.equationsPossible(new String[]{"a==b","b==c","a==c"}));
        System.out.println(satisfiabilityOfEqualityEquations.equationsPossible(new String[]{"a==b","b!=c","c==a"}));
        System.out.println(satisfiabilityOfEqualityEquations.equationsPossible(new String[]{"c==c","b==d","x!=z"}));
    }

    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) {
            return true;
        }
        UnionFind uf = new UnionFind(26);
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            int first = chars[0] - 'a';
            int second = chars[3] - 'a';
            boolean isEquals = chars[1] == '=';
            if (isEquals) {
                uf.union(first, second);
            }
        }
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            int first = chars[0] - 'a';
            int second = chars[3] - 'a';
            boolean isEquals = chars[1] == '=';
            if (!isEquals) {
                if (uf.getParent(first) == uf.getParent(second)) {
                    return false;
                }
            }
        }
        return true;
    }

}
