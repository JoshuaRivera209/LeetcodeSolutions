import java.util.ArrayList;
import java.util.List;

public class stringEncodeAndDecode_271 {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strs.size(); i++) {
            sb.append(strs.get(i).length()+"#"+strs.get(i));
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i<str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.valueOf(str.substring(i,j));
            i = j + length + 1;
            res.add(str.substring(j+1, i));
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("neet");
        test.add("code");
        test.add("love");
        test.add("you");
        decode(encode(test));
    }
}
