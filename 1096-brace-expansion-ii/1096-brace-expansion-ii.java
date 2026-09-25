import java.util.*;

class Solution {
    private int pos; // Position tracker
    
    public List<String> braceExpansionII(String expression) {
        pos = 0;
        Set<String> result = parse(expression);
        List<String> sorted = new ArrayList<>(result);
        Collections.sort(sorted);
        return sorted;
    }
    
    /**
     优先级 3 (最低): 处理逗号 (Union)
     */
    private Set<String> parse(String s) {
        Set<String> union = new HashSet<>();
        Set<String> concatRes = new HashSet<>();
        
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (c == ',') {
                // End of this term chunk, accumulate to union
                union.addAll(concatRes);
                concatRes = new HashSet<>();
                pos++;
            } else if (c == '}') {
                break;
            } else {
                // Concatenation level (Handle adjacency like a{b})
                Set<String> term = parseConcat(s);
                
                if (concatRes.isEmpty()) {
                    concatRes = term;
                } else {
                    // Cartesian product for adjacency
                    Set<String> newConcat = new HashSet<>();
                    for (String t : concatRes) {
                        for (String v : term) {
                            newConcat.add(t + v);
                        }
                    }
                    concatRes = newConcat;
                }
            }
        }
        
        union.addAll(concatRes); // Add last chunk
        return union;
    }
    
    /**
     优先级 2 (中): 处理相邻项连接
     */
    private Set<String> parseConcat(String s) {
        Set<String> result = new HashSet<>();
        result.add(""); // Start with empty identity
        
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (c == ',' || c == '}') break;
            
            Set<String> atom = parseAtom(s);
            Set<String> merged = new HashSet<>();
            
            // Multiply current result by new atom
            for (String r : result) {
                for (String a : atom) {
                    merged.add(r + a);
                }
            }
            result = merged;
        }
        
        return result;
    }
    
    /**
     优先级 1 (最高): 处理原子 (字母 或 花括号表达式)
     */
    private Set<String> parseAtom(String s) {
        char c = s.charAt(pos);
        
        // Case 1: Letters/Digits
        if (Character.isLetterOrDigit(c)) {
            StringBuilder sb = new StringBuilder();
            while (pos < s.length() && Character.isLetterOrDigit(s.charAt(pos))) {
                sb.append(s.charAt(pos++));
            }
            return new HashSet<>(Arrays.asList(sb.toString()));
        }
        // Case 2: Nested Brace
        else if (c == '{') {
            pos++; // skip '{'
            Set<String> res = parse(s); // recurse for nested content
            if (pos < s.length()) pos++; // skip '}'
            return res;
        }
        
        return new HashSet<>();
    }
}