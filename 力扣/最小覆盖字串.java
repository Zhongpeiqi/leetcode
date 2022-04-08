package 力扣;

public class 最小覆盖字串 {
    public String minWindow(String s, String t) {
        int[] hash = new int[128];
        for (char c : t.toCharArray()) {
            hash[c]--;
        }
        String res = "";
        int count = 0;
        int len = s.length()+1;
        char ch;
        for (int i = 0,j = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            hash[ch]++;
            if(hash[ch]<=0){
                count++;
            }
            while (j<i&&hash[s.charAt(j)]>0){
                hash[s.charAt(j++)]--;
            }
            if(count==t.length()&&len>i-j+1){
                len = i-j+1;
                res = s.substring(j,i+1);
            }
        }
        return res;
    }
}
