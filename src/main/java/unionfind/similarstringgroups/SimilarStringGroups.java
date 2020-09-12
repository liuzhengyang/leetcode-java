package unionfind.similarstringgroups;

import common.datastructure.UnionFind;

/**
 * @author liuzhengyang
 */
public class SimilarStringGroups {
    public static void main(String[] args) {
        SimilarStringGroups similarStringGroups = new SimilarStringGroups();
        System.out.println(similarStringGroups.numSimilarGroups(new String[]{"tars","rats","arts","star"}));
    }

    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (uf.getParent(i) != uf.getParent(j)) {
                    if (isSimilar(strs[i], strs[j])) {
                        uf.findAndUnion(i, j);
                    }
                }
            }
        }
        return uf.count();
    }

    private boolean isSimilar(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        if (first.length() != second.length()) {
            return false;
        }
        if (first.equals(second)) {
            return true;
        }
        char[] charsFirst = first.toCharArray();
        char[] charsSecond = second.toCharArray();
        int lastNotEqualsIndex = -1;
        int secondNotEqualsIndex = -1;
        for (int i = 0; i < charsFirst.length; i++) {
            if (charsFirst[i] != charsSecond[i]) {
                if (lastNotEqualsIndex > -1 && secondNotEqualsIndex > -1) {
                    return false;
                }
                if (lastNotEqualsIndex == -1) {
                    lastNotEqualsIndex = i;
                } else {
                    char cFirst = charsFirst[lastNotEqualsIndex];
                    char cSecond = charsSecond[lastNotEqualsIndex];
                    if (charsFirst[i] == cSecond && charsSecond[i] == cFirst) {
                        secondNotEqualsIndex = i;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
